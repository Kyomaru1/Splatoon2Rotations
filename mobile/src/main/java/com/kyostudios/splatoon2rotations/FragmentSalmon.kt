package com.kyostudios.splatoon2rotations

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class FragmentSalmon : Fragment() {

    companion object {
        fun newInstance() : FragmentSalmon{
            var fragmentSalmon = FragmentSalmon()
            var args = Bundle()
            fragmentSalmon.arguments = args
            return fragmentSalmon
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_salmon, container, false)
    }
}