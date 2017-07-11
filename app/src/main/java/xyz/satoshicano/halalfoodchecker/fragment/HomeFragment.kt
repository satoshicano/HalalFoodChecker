package xyz.satoshicano.halalfoodchecker.fragment

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import xyz.satoshicano.halalfoodchecker.R
import xyz.satoshicano.halalfoodchecker.activity.FindHalalCameraActivity

class HomeFragment : Fragment(), View.OnClickListener {
    override fun onClick(v: View) {
        startActivity(Intent(context, FindHalalCameraActivity::class.java))

    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val v = inflater!!.inflate(R.layout.fragment_home, container, false)
        val fab = v.findViewById<FloatingActionButton>(R.id.fab)
        fab.setOnClickListener(this)
        return v
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
    }

    override fun onDetach() {
        super.onDetach()
    }

}
