
var exec = require('cordova/exec');

var PLUGIN_NAME = 'MyCordovaPlugin';

var MyCordovaPlugin = {
  echo: function(phrase, cb) {
    exec(cb, null, PLUGIN_NAME, 'echo', [phrase]);
  },
  getDate: function(cb) {
    exec(cb, null, PLUGIN_NAME, 'getDate', []);
  },
  start: function (message, completeCallback, errorCallback) {
		exec(completeCallback, errorCallback,PLUGIN_NAME, "start", (typeof message === 'string') ? [message] : message);
	},
  escanearCedula: function (message, completeCallback, errorCallback) {
		exec(completeCallback, errorCallback,PLUGIN_NAME, "escanearCedula", (typeof message === 'string') ? [message] : message);
	},
  testExcel: function (message, completeCallback, errorCallback) {
		exec(completeCallback, errorCallback,PLUGIN_NAME, "testExcel", (typeof message === 'string') ? [message] : message);
	},
  initExcel: function (message, completeCallback, errorCallback) {
		exec(completeCallback, errorCallback,PLUGIN_NAME, "initExcel", (typeof message === 'string') ? [message] : message);
	}
};

module.exports = MyCordovaPlugin;
