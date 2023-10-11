package com.gonzalez.blanchard.weatherapp.ui.views.compose.components.webview

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView

@SuppressLint("SetJavaScriptEnabled")
@Composable
fun WebViewComposable(htmlContent: String) {
    val context = LocalContext.current

    val webViewClient = rememberUpdatedState(object : WebViewClient() {
        override fun shouldOverrideUrlLoading(view: WebView?, request: WebResourceRequest?): Boolean {
            request?.let {
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(it.url.toString()))
                context.startActivity(intent)
                return true
            }
            return super.shouldOverrideUrlLoading(view, request)
        }
    })

    AndroidView(
        factory = { ctx ->
            WebView(ctx).apply {
                this.webViewClient = webViewClient.value
                loadData(htmlContent, "text/html", "UTF-8")
                this.settings.javaScriptEnabled = true
            }
        },
        update = { view ->
            view.loadData(htmlContent, "text/html", "UTF-8")
        },
    )
}
