package com.essamheshmey.simplewebbrowser

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.Settings.Global
import android.util.Patterns
import android.webkit.URLUtil
import android.webkit.WebView
import android.widget.EditText
import android.widget.ImageButton
import com.essamheshmey.simplewebbrowser.databinding.ActivityMainBinding
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.net.URL


class MainActivity : AppCompatActivity() {
 lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
       // val url_text:EditText=findViewById(R.id.url_text)
        //val return_btn:ImageButton=findViewById(R.id.return_btn)
      //  val search_btn:ImageButton=findViewById(R.id.search_btn)
      //  val webview:WebView=findViewById(R.id.webview)

       binding.webview.loadUrl("https://github.com/essamheshmy")
        binding.webview.settings.javaScriptEnabled = true
        binding.webview.canGoBack()
        binding.webview.webViewClient = WebClient(this)

        binding.searchBtn.setOnClickListener {
            //GlobalScope.launch {
            val URL =binding.urlText.text.toString()
           if (URLUtil.isValidUrl(URL)){ binding.webview.loadUrl(URL)}
          else{ binding.webview.loadUrl("https://www.google.com/search?q=${URL}")}}
     //   }

       binding.returnBtn.setOnClickListener {binding.webview.goBack()}
    }
}