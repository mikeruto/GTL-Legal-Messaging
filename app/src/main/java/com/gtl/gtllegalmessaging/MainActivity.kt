package com.gtl.gtllegalmessaging

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.webkit.WebView
import com.example.gtllegalmessaging.databinding.ActivityMainBinding
import android.webkit.WebViewClient
import com.gtl.gtllegalmessaging.Constants.EIE_URL


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setWebView()
    }

    private fun setWebView(){
        val myWebView: WebView = binding.gtlLegalMessagingWebView
        when {
            Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP -> {
                myWebView.settings.mixedContentMode = 0;
                myWebView.setLayerType(View.LAYER_TYPE_HARDWARE, null);
            }
            Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT -> {
                myWebView.setLayerType(View.LAYER_TYPE_HARDWARE, null);
            }
            else -> {
                myWebView.setLayerType(View.LAYER_TYPE_SOFTWARE, null);
            }
        }
        myWebView.settings.javaScriptEnabled = true
        myWebView.settings.allowContentAccess = true
        myWebView.settings.domStorageEnabled = true
        myWebView.webViewClient = WebViewClient()
        myWebView.loadUrl(EIE_URL)
    }

}