/**
 * 
 */
package com.example;


public  class Constante {

	/* Expresiones regulares fecha */
	public static final String REGEX_FORMATO_FECHA_YYYYMMDD = "yyyyMMdd";
	public static final String REGEX_FORMATO_FECHA_ESTANDAR = "yyyy-MM-dd HH:mm:ss";
	public static final String REGEX_FORMATO_FECHA_VISUALIZACION = "dd-MMM-yyyy";
	public static final String REGEX_FORMATO_FECHA_CORTA = "yyyy-MM-dd";

	/* OnTrack Tools */
	public static final int REQUEST_CODE_NITIDEZ_IMAGEN = 0;
	public static final int REQUEST_CODE_CAPTURA_HUELLA = 1001;
	public static final int REQUEST_CODE_LECTURA_CODIGO_BARRAS = 1002;

	// Captura de huella
	public static final int OPERATION_CAPTURE = 1;
	public static final int OPERATION_CREATE = 2;
	public static final int OPERATION_VERIFY = 3;
	public static final int OPERATION_IDENTIFY = 4;
	public static final int INT_CALIDAD_CAPTURA_HUELLA_LOW = 0;
	public static final int INT_CALIDAD_CAPTURA_HUELLA_LOW_MEDIUM = 1;
	public static final int INT_CALIDAD_CAPTURA_HUELLA_MEDIUM = 2;
	public static final int INT_CALIDAD_CAPTURA_HUELLA_HIGH_MEDIUM = 3;
	public static final int INT_CALIDAD_CAPTURA_HUELLA_HIGH = 4;
	public static final int INT_CALIDAD_CAPTURA_HUELLA_VERY_HIGH = 5;;
	public static final int INT_CAMARA_RESOLUCION_FOTO_WIDTH_1024 = 1024;
	public static final int INT_CAMARA_RESOLUCION_FOTO_HEIGHT_768 = 768;
	public static final int INT_CAMARA_CALIDAD_FOTO = 90;
	public static final int INT_HUELLA_INDICE_IZQUIERDO = 1;
	public static final int INT_HUELLA_INDICE_DERECHO = 2;

	// OJO!!!! Tiene espacios
	public static final String KEY_TIPO_F = "F ";
	public static final String KEY_TIPO_N = "N ";
	public static final String KEY_TIPO_T = "T ";
	public static final String KEY_TIPO_B = "B ";
	public static final String KEY_TIPO_L = "L ";
	public static final String KEY_TIPO_FI = "FI";
	public static final String KEY_TIPO_ML = "ML";
	public static final String KEY_TIPO_MP = "MP";
	public static final String KEY_TIPO_U = "U ";
	public static final String KEY_TIPO_M = "M ";
	public static final String KEY_TIPO_M1 = "M1";
	public static final String KEY_TIPO_MS = "MS";

	// Viene de PrecargasContenedor
	public static final int TIPO_LISTA = 0;
	public static final int TIPO_FIRMA = 1;
	public static final int TIPO_FECHA = 2;
	public static final int TIPO_MUNICIPIOPRECARGADO = 3;
	public static final int TIPO_PRESTADORPRECARGADO = 4;
	public static final int TIPO_USUARIO = 5;
	public static final int TIPO_TEXTOLARGO = 6;
	public static final int TIPO_MAILSINENVIO = 7;
	public static final int TIPO_MAILCONENVIO = 8;
	public static final int TIPO_BOOLEANO = 9;
	public static final int TIPO_NUMERICO = 10;
	public static final int TIPO_TEXTOCORTO = 11;
	public static final int TIPO_COORDENADAS = 12;
	public static final int TIPO_HORA = 13;
	public static final int TIPO_LISTAMULTIPLESERVICIOSPRESTADOR = 14;
	public static final int TIPO_LISTASERVICIOSPRESTADOR = 15;
	public static final int TIPO_TEXTOPRECARGADO = 16;
	public static final int TIPO_GRAFICO = 17;
	public static final int TIPO_MULTIPLE = 18;
	public static final int TIPO_ARCHIVOADJUNTO = 19;
	public static final int TIPO_REVISIONPENDIENTE = 20;
	public static final int TIPO_TITULO = 21;
	public static final int TIPO_PRESENTACION = 22;
	public static final int TIPO_ENVIOFORMULARIO = 23;
	public static final int TIPO_VERIFICARCORREO = 24;
	public static final int TIPO_LISTASALTO = 25;
	public static final int TIPO_LISTAENCADENADA = 26;
	public static final int TIPO_NUMERICOCONTROL = 27;

	// // Lectura c�digo de barras PDF417
	// public static final int PDF417_TIPO_DOCUMENTO = 0;
	// public static final int PDF417_CODIGO_VERIFICACION_1 = 1;
	// public static final int PDF417_CODIGO_VERIFICACION_2 = 2;
	// public static final int PDF417_CODIGO_VERIFICACION_3 = 3;
	// public static final int PDF417_NUMERO_DOCUMENTO = 4;
	// public static final int PDF417_APELLIDO_1 = 5;
	// public static final int PDF417_APELLIDO_2 = 6;
	// public static final int PDF417_NOMBRE_1 = 7;
	// public static final int PDF417_NOMBRE_2 = 8;
	// public static final int PDF417_GENERO = 9;
	// public static final int PDF417_FECHA_NACIMIENTO = 10;
	// public static final int PDF417_CODIGO_VERIFICACION_4 = 11;
	// public static final int PDF417_GRUPO_SANGUINEO_RH = 12;

	// Lectura c�digo de barras PDF417
	public static final int PDF417_TIPO_DOCUMENTO = 0;
	public static final int PDF417_CODIGO_VERIFICACION_1 = 1;
	public static final int PDF417_CODIGO_VERIFICACION_2 = 2;
	public static final int PDF417_CODIGO_VERIFICACION_3 = 3;
	public static final int PDF417_NUMERO_DOCUMENTO = 4;
	public static final int PDF417_APELLIDO_1 = 5;
	public static final int PDF417_APELLIDO_2 = 6;
	public static final int PDF417_NOMBRE_1 = 7;
	public static final int PDF417_NOMBRE_2 = 8;
	public static final int PDF417_GENERO = 9;
	public static final int PDF417_FECHA_NACIMIENTO = 10;
	public static final int PDF417_LUGAR_NACIMIENTO = 11;
	public static final int PDF417_GRUPO_SANGUINEO = 12;
	public static final int PDF417_RH = 13;
	
	// C�digos de env�o
	/* Actualizar tambi�n el archivo /res/values/mensajes.xml */
	public final static int INT_MSG_ENVIO_VACIO = -1;
	public final static int INT_MSG_ENVIO_GPSERVICE_EXITOSO = 400;
	public final static int INT_MSG_ENVIO_COLA_LLENA = 401;
	public final static int INT_MSG_ENVIO_ERROR_CREACION_XML = 402;
	public final static int INT_MSG_ENVIO_ADJUNTOS_FALTANTES = 403;
	public final static int INT_MSG_ENVIO_ERROR_ZIP_INTERNO = 404;
	public final static int INT_MSG_ENVIO_ERROR_CALCULO_SHA1 = 405;
	public final static int INT_MSG_ENVIO_ERROR_ARCHIVO_SHA1 = 406;
	public final static int INT_MSG_ENVIO_ERROR_ZIP_EXTERNO = 407;
	
	
	public final static String codigosIetdhExcluir = "( "
			+" 5285	,"
			+" 973	,    "
			+" 4608	,"
			+" 4341	,"
			+" 4559	,"
			+" 7136	,"
			+" 4449	,"
			+" 4912	,"
			+" 7339	,"
			+" 1858	,"
			+" 1860	,"
			+" 4657	,"
			+" 4989	,"
			+" 4914	,"
			+" 1869	,"
			+" 4696	,"
			+" 2942	,"
			+" 4925	,"
			+" 2909	,"
			+" 2911	,"
			+" 4922	,"
			+" 2913	,"
			+" 1882	,"
			+" 1883	,"
			+" 1887	,"
			+" 1891	,"
			+" 1898	,"
			+" 4437	,"
			+" 6554	,"
			+" 4482	,"
			+" 3697	,"
			+" 1325	,"
			+" 813	,    "
			+" 762	,    "
			+" 760	,    "
			+" 666	,    "
			+" 617	,    "
			+" 591	,    "
			+" 5443	,"
			+" 614	,    "
			+" 3697	,"
			+" 579	,    "
			+" 3953	,"
			+" 4413	,"
			+" 4089	,"
			+" 4957	,"
			+" 5012	,"
			+" 4088	,"
			+" 2863	,"
			+" 3980	,"
			+" 1730	,"
			+" 4877	,"
			+" 2515	,"
			+" 4650	,"
			+" 3871	,"
			+" 1877	,"
			+" 1594	,"
			+" 2177	,"
			+" 1276	,"
			+" 3249	,"
			+" 1275	,"
			+" 1278	,"
			+" 1297	,"
			+" 3252	,"
			+" 4488	,"
			+" 1016	,"
			+" 1013	,"
			+" 5692	,"
			+" 3011	,"
			+" 3842	,"
			+" 3013	,"
			+" 3873	,"
			+" 3838	,"
			+" 5049	,"
			+" 6475	,"
			+" 2256	,"
			+" 4183	,"
			+" 2770	,"
			+" 4185	,"
			+" 2796	,"
			+" 2217	,"
			+" 4459	,"
			+" 4126	,"
			+" 7492	,"
			+" 4121	,"
			+" 7057	,"
			+" 81	,    "
			+" 105	,    "
			+" 166	,    "
			+" 325	,    "
			+" 340	,    "
			+" 349	,    "
			+" 354	,    "
			+" 367	,    "
			+" 398	,    "
			+" 420	,    "
			+" 975	,    "
			+" 1134	,"
			+" 1145	,"
			+" 1149	,"
			+" 1195	,"
			+" 1230	,"
			+" 1234	,"
			+" 1618	,"
			+" 1639	,"
			+" 4003	,"
			+" 4043	,"
			+" 4065	,"
			+" 4556	,"
			+" 4557	,"
			+" 4581	,"
			+" 4585	,"
			+" 4587	,"
			+" 4589	,"
			+" 4595	,"
			+" 4603	,"
			+" 4751	,"
			+" 4896	,"
			+" 5158	,"
			+" 5166	,"
			+" 5172	,"
			+" 5378	,"
			+" 5384	,"
			+" 6404	,"
			+" 6569	,"
			+" 119	,    "
			+" 123	,    "
			+" 176	,    "
			+" 283	,    "
			+" 362	,    "
			+" 396	,    "
			+" 2009	,"
			+" 3986	,"
			+" 4865	,"
			+" 4867	,"
			+" 7657	,"
			+" 7917	,"
			+" 3933	,"
			+" 4540	,"
			+" 4511	,"
			+" 4527	,"
			+" 5699	,"
			+" 1792	,"
			+" 4154	,"
			+" 1579	,"
			+" 5634	,"
			+" 4507	,"
			+" 629	,    "
			+" 644	,    "
			+" 3925	,"
			+" 4756	,"
			+" 4368	,"
			+" 7254	,"
			+" 3564	,"
			+" 5260	,"
			+" 6110	,"
			+" 8026	,"
			+" 2026	,"
			+" 2033	,"
			+" 3226	,"
			+" 3225	,"
			+" 3599	,"
			+" 3174	,"
			+" 3209	,"
			+" 3603	,"
			+" 3617	,"
			+" 2110	,"
			+" 5861	,"
			+" 3207	,"
			+" 3236	,"
			+" 3198	,"
			+" 1532	,"
			+" 4019	,"
			+" 7841	,"
			+" 1560	,"
			+" 4801	,"
			+" 4965	,"
			+" 534	,    "
			+" 719	,    "
			+" 3739	,"
			+" 4716	,"
			+" 5290	,"
			+" 5314	,"
			+" 7221	,"
			+" 7236	,"
			+" 7258	,"
			+" 7860	,"
			+" 6728	,"
			+" 3774	,"
			+" 4953	,"
			+" 7845	,"
			+" 2558	,"
			+" 2651	,"
			+" 4441	,"
			+" 6355	,"
			+" 7186	,"
			+" 2592	,"
			+" 7669	,"
			+" 6108	,"
			+" 2347	,"
			+" 4295	,"
			+" 7352	,"
			+" 7406	,"
			+" 652	,    "
			+" 655	,    "
			+" 774	,    "
			+" 5054	,"
			+" 5057	,"
			+" 7275	,"
			+" 7846	,"
			+" 502	,    "
			+" 549	,    "
			+" 969	,    "
			+" 4478	,"
			+" 4298	,"
			+" 6807	,"
			+" 7004	,"
			+" 7091	,"
			+" 7102	,"
			+" 4781	,"
			+" 4798	,"
			+" 5917	,"
			+" 7578	,"
			+" 3855	,"
			+" 5310	,"
			+" 7948	,"
			+" 2663	,"
			+" 2663	,"
			+" 2674	,"
			+" 2701	,"
			+" 3295	,"
			+" 3329	,"
			+" 3661	,"
			+" 3673	,"
			+" 3700	,"
			+" 3716	,"
			+" 3755	,"
			+" 3800	,"
			+" 6437	,"
			+" 6791	,"
			+" 7511	,"
			+" 3655	,"
			+" 3799	,"
			+" 7273	,"
			+" 1518	,"
			+" 1849	,"
			+" 3322	,"
			+" 5889	,"
			+" 3860	,"
			+" 4118	,"
			+" 8019	,"
			+" 2284	)";
	
	public final static String codigosDaneSedeExcluir = " 123660002256 "
			+" ,223660000690 "
			+" ,123660000903 "
			+" ,223660001238 "
			+" ,223660001254 "
			+" ,223660000011 " 
			+" ,223660000657 "
			+" ,219001001801 ";
	

}
