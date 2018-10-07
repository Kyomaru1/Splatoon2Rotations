package com.kyostudios.splatoon2rotations

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class FragmentRanked : Fragment() {

    companion object {
        fun newInstance() : FragmentRanked{
            var fragmentRanked = FragmentRanked()
            var args = Bundle()
            fragmentRanked.arguments = args
            return fragmentRanked
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        var rootView = inflater!!.inflate(R.layout.fragment_ranked, container, false)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}