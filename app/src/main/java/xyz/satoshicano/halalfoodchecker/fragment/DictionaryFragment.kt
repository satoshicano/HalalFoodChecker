package xyz.satoshicano.halalfoodchecker.fragment

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient

import xyz.satoshicano.halalfoodchecker.R

class DictionaryFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val v = inflater!!.inflate(R.layout.fragment_dictionary, container, false)
        val url = "https://find-halal.herokuapp.com/words"
        val myWebView = v.findViewById<WebView>(R.id.webView)
        myWebView.webViewClient = WebViewClient()
        myWebView.loadUrl(url)
        return v
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
    }

    override fun onDetach() {
        super.onDetach()
    }

}
