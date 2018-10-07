package com.kyostudios.splatoon2rotations

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import org.json.JSONObject

class FragmentTurf : Fragment() {

    var rotationdata : MutableList<JSONObject> = ArrayList()

    companion object {
        fun newInstance(data: MutableList<JSONObject>) : FragmentTurf{
            var fragmentTurf = FragmentTurf()
            var args = Bundle()
            fragmentTurf.arguments = args
            fragmentTurf.rotationdata = data
            return fragmentTurf
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var rootView = inflater!!.inflate(R.layout.fragment_turf, container, false)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}