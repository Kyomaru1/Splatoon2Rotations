package com.kyostudios.splatoon2rotations

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

class FragmentLeague : Fragment() {

    companion object {
        fun newInstance() : FragmentLeague{
            var fragmentLeague = FragmentLeague()
            var args = Bundle()
            fragmentLeague.arguments = args
            return fragmentLeague
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater!!.inflate(R.layout.fragment_league, container, false)
    }
}