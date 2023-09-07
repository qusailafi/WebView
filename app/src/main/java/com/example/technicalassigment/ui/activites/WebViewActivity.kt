package com.example.technicalassigment.ui.activites
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.appcompat.app.AppCompatActivity

import com.example.technicalassigment.R
 import com.example.technicalassigment.listener.UrlStateListener
import com.example.technicalassigment.utils.Constants
import com.example.technicalassigment.utils.CustomWebViewClient
class WebViewActivity : AppCompatActivity(), View.OnClickListener, UrlStateListener {
    var forWardImg:ImageView?=null
    var backWardImg:ImageView?=null
    var refreshImg:ImageView?=null
    var closeImg:ImageView?=null
    var  webView:WebView?=null
    var loading:ProgressBar?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView( R.layout.activity_web_view)
        initViews()
        loadUrlIntoWebView()

    }

    fun initViews() {
        forWardImg=findViewById(R.id.forWardImg)
        backWardImg=findViewById(R.id.backWardImg)
        refreshImg=findViewById(R.id.refreshImg)
        closeImg=findViewById(R.id.closeImg)
        webView=findViewById(R.id.webView)
        loading=findViewById(R.id.loading)
        forWardImg?.setOnClickListener(this)
        backWardImg?.setOnClickListener(this)
        refreshImg?.setOnClickListener(this)
        closeImg?.setOnClickListener(this)

    }


    fun loadUrlIntoWebView() {
       webView?.webViewClient = CustomWebViewClient(this)
       webView?.getSettings()?.setBuiltInZoomControls(true);
       webView?.getSettings()?.setDomStorageEnabled(true);
       webView?.settings?.javaScriptEnabled = true
       webView?.loadUrl(Constants.WEB_VIEW_URL)


    }

    fun refreshWebView() {
       webView?.loadUrl(webView?.getUrl().toString());

    }

    override fun onBackPressed() {
backWard()    }
    fun backWard() {
        if (webView!!.canGoBack()) {
           webView?.goBack()
        } else {
            finish()
        }
    }

    fun forWard() {
        if (webView!!.canGoForward()) {
           webView?.goForward()
        }
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.backWardImg -> {
                backWard()
            }
            R.id.forWardImg -> {
                forWard()
            }
            R.id.refreshImg -> {
                refreshWebView()
            }
            R.id.closeImg -> {
                finish()
            }
        }
    }

    override fun onUrlLoading() {
       loading?.visibility = View.VISIBLE
     }

    override fun onUrlLoaded(newUrlLoaded: String) {
       loading?.visibility = View.GONE



    }
}
