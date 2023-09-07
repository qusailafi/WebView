package com.example.technicalassigment.utils

import android.graphics.Bitmap
import android.webkit.WebResourceRequest
import android.webkit.WebView
import android.webkit.WebViewClient
import com.example.technicalassigment.listener.UrlStateListener

class CustomWebViewClient(var listener: UrlStateListener) : WebViewClient() {
    var listen=listener
    override fun shouldOverrideUrlLoading(view: WebView?, url: String): Boolean {
        view?.loadUrl(url)
        return false
    }

    override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
        super.onPageStarted(view, url, favicon)
        listen.onUrlLoading()

    }
    override fun onPageFinished(view: WebView?, url: String?) {
        super.onPageFinished(view, url)
        listen.onUrlLoaded(url.toString())
    }
}