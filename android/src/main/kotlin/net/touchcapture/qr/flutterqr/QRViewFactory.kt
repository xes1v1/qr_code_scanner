package net.touchcapture.qr.flutterqr

import android.content.Context
import io.flutter.embedding.engine.plugins.FlutterPlugin
import io.flutter.embedding.engine.plugins.activity.ActivityPluginBinding
import io.flutter.plugin.common.StandardMessageCodec
import io.flutter.plugin.platform.PlatformView
import io.flutter.plugin.platform.PlatformViewFactory


class QRViewFactory(private val registrar: FlutterPlugin.FlutterPluginBinding,
                    private val activityPluginBinding: ActivityPluginBinding) :
        PlatformViewFactory(StandardMessageCodec.INSTANCE) {

    override fun create(context: Context, id: Int, obj: Any?): PlatformView {
        return QRView(registrar, activityPluginBinding, id)
    }

}