package net.touchcapture.qr.flutterqr

import io.flutter.embedding.engine.plugins.FlutterPlugin
import io.flutter.embedding.engine.plugins.activity.ActivityAware
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding
import io.flutter.plugin.common.MethodCall
import io.flutter.plugin.common.MethodChannel.MethodCallHandler
import io.flutter.plugin.common.MethodChannel.Result
import io.flutter.plugin.common.PluginRegistry.Registrar

class FlutterQrPlugin : FlutterPlugin, ActivityAware, MethodCallHandler {
    companion object {
        lateinit var flutterPluginBinding: FlutterPlugin.FlutterPluginBinding
        lateinit var activityPluginBinding: ActivityPluginBinding
    }

    override fun onMethodCall(call: MethodCall, result: Result) {
        when {
            call.method == "getPlatformVersion" -> result.success("Android ${android.os.Build.VERSION.RELEASE}")
            else -> result.notImplemented()
        }
    }

    override fun onAttachedToEngine(binding: FlutterPlugin.FlutterPluginBinding) {
        flutterPluginBinding = binding
    }

    override fun onDetachedFromEngine(binding: FlutterPlugin.FlutterPluginBinding) {
    }

    override fun onDetachedFromActivity() {
    }

    override fun onReattachedToActivityForConfigChanges(binding: ActivityPluginBinding) {
    }

    override fun onAttachedToActivity(binding: ActivityPluginBinding) {
        activityPluginBinding = binding
        flutterPluginBinding.platformViewRegistry.registerViewFactory("net.touchcapture.qr.flutterqr/qrview",
                QRViewFactory(flutterPluginBinding, activityPluginBinding))
    }

    override fun onDetachedFromActivityForConfigChanges() {
    }
}
