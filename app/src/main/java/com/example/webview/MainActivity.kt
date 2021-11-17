package com.example.webview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.MotionEvent
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val web = findViewById<View>(R.id.WebView) as WebView
        web.loadUrl("https://youtube.com")

        val websetting = web.settings
        websetting.javaScriptEnabled = true

        web.webViewClient = WebViewClient()
        web.canGoBack()
        web.setOnKeyListener(View.OnKeyListener{v,keycode,event ->
            if(keycode == KeyEvent.KEYCODE_BACK
                && event.action == MotionEvent.ACTION_UP
                && web.canGoBack()){
                web.goBack()
                return@OnKeyListener true
            }
            false
        })
    }
}