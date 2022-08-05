package com.example.bankofthebest.event

import android.os.Bundle
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.bankofthebest.R

class WebViewActivity : AppCompatActivity() {

    lateinit var webView: WebView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.event_webview)

        webView=findViewById(R.id.webView)

        webView.apply{
            settings.javaScriptEnabled=true
            webViewClient= WebViewClient()
        }

        var link=intent.getStringExtra("link").toString()
        Toast.makeText(this, "홈페이지로 연결", Toast.LENGTH_SHORT).show()
        webView.loadUrl(link)

    }
}