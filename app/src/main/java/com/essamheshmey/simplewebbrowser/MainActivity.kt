package com.essamheshmey.simplewebbrowser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.webkit.WebView
import android.widget.EditText
import android.widget.ImageButton


class MainActivity : AppCompatActivity() {
    val url:EditText=findViewById(R.id.url)
    val return_btn:ImageButton=findViewById(R.id.return_btn)
    val search_btn:ImageButton=findViewById(R.id.search_btn)
    val webview:WebView=findViewById(R.id.webview)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}