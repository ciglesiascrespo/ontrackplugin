/**
 */
package com.example;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaInterface;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CordovaWebView;
import org.apache.cordova.PluginResult;
import org.apache.cordova.PluginResult.Status;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.LOG;
import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;

import android.content.Context;
import android.content.Intent;
import android.app.Activity;
import android.os.Bundle;
import android.content.ComponentName;
import android.content.pm.PackageManager;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import android.widget.Toast;

import java.util.Iterator;

import android.net.Uri;
import android.util.Log;

import android.util.Log;

import java.util.Date;

import com.aspose.cells.Cell;
import com.aspose.cells.Cells;
import com.aspose.cells.Chart;
import com.aspose.cells.ChartCollection;
import com.aspose.cells.ChartType;
import com.aspose.cells.Label;
import com.aspose.cells.PasteOptions;
import com.aspose.cells.PasteType;
import com.aspose.cells.Range;
import com.aspose.cells.SeriesCollection;
import com.aspose.cells.Worksheet;
import com.aspose.cells.WorksheetCollection;
import com.aspose.cells.Workbook;
import com.aspose.cells.FileFormatType;
import java.util.Locale;


public class MyCordovaPlugin extends CordovaPlugin {
    private static final String TAG = "MyCordovaPlugin";
    public CallbackContext callbackResult;

    private static final int SCAN_REQUEST_CODE = 1;

    public final String STR_KEY_TIPO_DOCUMENTO = "tipo_documento";
    public final String STR_KEY_NUMERO_DOCUMENTO = "num_documento";
    public final String STR_KEY_NOMBRE1 = "nombre1";
    public final String STR_KEY_NOMBRE2 = "nombre2";
    public final String STR_KEY_NOMBRES = "nombres";
    public final String STR_KEY_APELLIDO1 = "apellido1";
    public final String STR_KEY_APELLIDO2 = "apellido2";
    public final String STR_KEY_APELLIDOS = "apellidos";
    public final String STR_KEY_NOMBRE_COMPLETO = "nombre_completo";
    public final String STR_KEY_GENERO = "genero";
    public final String STR_KEY_FECHA_NACIMIENTO = "fecha_nacimiento";
    public final String STR_KEY_LUGAR_NACIMIENTO = "lugar_nacimiento";
    public final String STR_KEY_GRUPO_SANGUINEO = "grupo_sanguineo";
    public final String STR_KEY_RH = "rh";
    public final String STR_KEY_GRUPO_SANGUINEO_RH = "grupo_sanguineo_rh";

    public Workbook libro;
    public String ruta= "";

    public void initialize(CordovaInterface cordova, CordovaWebView webView) {
        super.initialize(cordova, webView);

        Log.d(TAG, "Initializing MyCordovaPlugin");
    }

    public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
        this.callbackResult = callbackContext;
        if (action.equals("echo")) {
            String phrase = args.getString(0);

            Log.d(TAG, phrase);
        } else if (action.equals("getDate")) {

            final PluginResult result = new PluginResult(PluginResult.Status.OK,
                    (new Date()).toString() + "fecha de hoy");
            callbackResult.sendPluginResult(result);
        } else if (action.equals("start")) {
            this.start(args, 0);
        } else if (action.equals("escanearCedula")) {
            start(args, SCAN_REQUEST_CODE);
        } else if (action.equals("testExcel")) {
            testExcel(args);
        } else if (action.equals("initExcel")) {
            initExcel(args);
        }
        return true;
    }

    public void start(JSONArray args, int requestCode) {

        String com_name = null;
        String activity = null;
        Intent LaunchIntent;

        try {
            if (args.get(0) instanceof JSONArray) {
                com_name = args.getJSONArray(0).getString(0);
                activity = args.getJSONArray(0).getString(1);
            } else {
                com_name = args.getString(0);
            }
            if (activity != null) {
                if (com_name.equals("action")) {
                    if (activity.indexOf(".") > 0) {
                        LaunchIntent = new Intent(activity);
                    } else {
                        LaunchIntent = new Intent("android.intent.action." + activity);
                    }
                } else {
                    LaunchIntent = new Intent();
                    LaunchIntent.setComponent(new ComponentName(com_name, activity));
                }
            } else {
                LaunchIntent = this.cordova.getActivity().getPackageManager().getLaunchIntentForPackage(com_name);
            }

            if (args.length() > 1) {
                JSONArray params = args.getJSONArray(1);
                JSONObject key_value;
                String key;
                String value;

                for (int i = 0; i < params.length(); i++) {
                    if (params.get(i) instanceof JSONObject) {
                        Iterator<String> iter = params.getJSONObject(i).keys();

                        while (iter.hasNext()) {
                            key = iter.next();
                            try {
                                value = params.getJSONObject(i).getString(key);

                                LaunchIntent.putExtra(key, value);
                            } catch (JSONException e) {
                                final PluginResult result = new PluginResult(PluginResult.Status.ERROR,
                                        ("json params: " + e.toString()));
                                callbackResult.sendPluginResult(result);

                            }
                        }
                    } else {
                        LaunchIntent.setData(Uri.parse(params.getString(i)));
                    }
                }
            }

            PluginResult r = new PluginResult(PluginResult.Status.NO_RESULT);
            r.setKeepCallback(true);
            callbackResult.sendPluginResult(r);

            this.cordova.startActivityForResult((CordovaPlugin) this, LaunchIntent, requestCode);

        } catch (JSONException e) {
            callbackResult.error("json: " + e.toString());
        } catch (Exception e) {
            callbackResult.error("intent: " + e.toString());
        }
    }

    public void initExcel(JSONArray args) {

        try {
            ruta = args.getJSONArray(0).getString(0);
            libro = new Workbook(ruta);
            libro.getSettings().setLocale(new Locale("es"));

            PluginResult resultado = new PluginResult(PluginResult.Status.OK);
            callbackResult.sendPluginResult(resultado);
        } catch (JSONException e) {
            callbackResult.error("json: " + e.toString());
        } catch (Exception e) {
            callbackResult.error("intent: " + e.toString());
        }

    }

    public void testExcel(JSONArray args) {

        try {

            Log.d(TAG, "A3: " + args.getJSONArray(0).getString(2));
            libro.getWorksheets().get(0).getCells().get("A1").putValue(new Double(args.getJSONArray(0).getString(0)));
            libro.getWorksheets().get(0).getCells().get("A2").putValue(new Double(args.getJSONArray(0).getString(1)));
            libro.getWorksheets().get(0).getCells().get("A3").setFormula(args.getJSONArray(0).getString(2).toUpperCase());
            libro.getWorksheets().get(0).getCells().get("A4").setFormula("=SUM(A1:A2)");
            libro.calculateFormula();
            libro.save(ruta, FileFormatType.XLSX);
            
            PluginResult resultado = new PluginResult(PluginResult.Status.OK,
                    libro.getWorksheets().get(0).getCells().get("A3").getStringValue());
            callbackResult.sendPluginResult(resultado);
        } catch (JSONException e) {
            callbackResult.error("json: " + e.toString());
        } catch (Exception e) {
            callbackResult.error("intent: " + e.toString());
        }

    }

    public void onActivityResult(final int requestCode, final int resultCode, final Intent data) {
        //callbackResult.sendPluginResult(new PluginResult(PluginResult.Status.OK,"Lo hizo, por fin"));

        if (resultCode == cordova.getActivity().RESULT_OK) {
            switch (requestCode) {
            case SCAN_REQUEST_CODE:
                PluginResult resultado = new PluginResult(PluginResult.Status.OK, getCedula(data));
                callbackResult.sendPluginResult(resultado);
                break;
            }

            return;
        } else if (resultCode == cordova.getActivity().RESULT_CANCELED) {
            PluginResult resultado = new PluginResult(PluginResult.Status.OK,
                    "canceled action, process this in javascript");
            resultado.setKeepCallback(true);
            callbackResult.sendPluginResult(resultado);
            return;
        }
        // Handle other results if exists.
        super.onActivityResult(requestCode, resultCode, data);
    }

    public JSONObject getCedula(Intent data) {
        byte[] rawResult = data.getByteArrayExtra("resultado");
        HashMap<String, String> mapa = new HashMap<String, String>();

        Log.e("ActivityCapture", "Longitud del byte[]: " + rawResult.length);

        ArrayList<String> datos = new ArrayList<String>();
        // Posiciones de los datos en la cadena obtenida:
        int[] posicion = { 2, 20, 18, 8, 10, 23, 23, 23, 23, 2, 8, 5, 2, 1 };
        int a = 0;
        int b = 0;

        try {
            for (int i = 0; i < posicion.length; i++) {
                a = b;
                b = b + posicion[i];

                byte[] tipoId = Arrays.copyOfRange(rawResult, a, b);

                String datotipoId = Arrays.toString(tipoId);
                String strTipoId = new String(tipoId, "UTF-8");
                Log.i("ActivityCapture", i + ": " + strTipoId.trim());
                datos.add(strTipoId.trim());
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        // *** Número de documento ***
        String numDocumento = datos.get(Constante.PDF417_NUMERO_DOCUMENTO);
        try {
            numDocumento = Integer.valueOf(numDocumento).toString();
        } catch (Exception e) {
            e.printStackTrace();
        }
        Log.d(TAG, "num cedula: " + numDocumento);

        // *** Nombres ***
        String nombre1 = datos.get(Constante.PDF417_NOMBRE_1).toUpperCase().trim();
        String nombre2 = datos.get(Constante.PDF417_NOMBRE_2).toUpperCase().trim();
        String nombres = (nombre1 + " " + nombre2).trim();
        if (nombre2.isEmpty()) {
            nombre2 = "NULL";
        }

        // *** Apellidos ***
        String apellido1 = datos.get(Constante.PDF417_APELLIDO_1).toUpperCase().trim();
        String apellido2 = datos.get(Constante.PDF417_APELLIDO_2).toUpperCase().trim();
        String apellidos = (apellido1 + " " + apellido2).trim();
        if (apellido2.isEmpty()) {
            apellido2 = "NULL";
        }

        String nombreCompleto = nombres + " " + apellidos;
        String genero = datos.get(Constante.PDF417_GENERO);

        // *** Fecha de nacimiento ***
        String fechaNacimiento = Util.darFormatoFecha(datos.get(Constante.PDF417_FECHA_NACIMIENTO),
                Constante.REGEX_FORMATO_FECHA_YYYYMMDD, Constante.REGEX_FORMATO_FECHA_ESTANDAR);

        // *** Lugar de nacimiento ***
        String lugarNacimiento = datos.get(Constante.PDF417_LUGAR_NACIMIENTO);

        // *** Grupo Sanguíneo ***
        String grupoSanguineo = datos.get(Constante.PDF417_GRUPO_SANGUINEO);
        String rh = datos.get(Constante.PDF417_RH);
        String grupoSanguineoRh = grupoSanguineo + rh;

        Toast.makeText(cordova.getActivity(), "Cedula: " + numDocumento + "\nNombres: " + nombre1 + " " + nombre2.trim()
                + " " + apellido1.trim() + " " + apellido2.trim(), Toast.LENGTH_LONG).show();

        mapa.put(STR_KEY_TIPO_DOCUMENTO, "0");
        mapa.put(STR_KEY_NUMERO_DOCUMENTO, numDocumento);
        mapa.put(STR_KEY_NOMBRE1, nombre1);
        mapa.put(STR_KEY_NOMBRE2, nombre2);
        mapa.put(STR_KEY_NOMBRES, nombres);
        mapa.put(STR_KEY_APELLIDO1, apellido1);
        mapa.put(STR_KEY_APELLIDO2, apellido2);
        mapa.put(STR_KEY_APELLIDOS, apellidos);
        mapa.put(STR_KEY_NOMBRE_COMPLETO, nombreCompleto);
        mapa.put(STR_KEY_GENERO, "" + genero); // *****
        mapa.put(STR_KEY_FECHA_NACIMIENTO, fechaNacimiento);
        mapa.put(STR_KEY_LUGAR_NACIMIENTO, lugarNacimiento);// *****
        mapa.put(STR_KEY_GRUPO_SANGUINEO, grupoSanguineo);
        mapa.put(STR_KEY_RH, rh);
        mapa.put(STR_KEY_GRUPO_SANGUINEO_RH, grupoSanguineoRh);

        return new JSONObject(mapa);
    }

}
