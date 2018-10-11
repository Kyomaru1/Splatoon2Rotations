package com.kyostudios.splatoon2rotations

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kyostudios.splatoon2rotation.Rotation
import kotlinx.android.synthetic.main.fragment_rotation.*
import kotlinx.android.synthetic.main.fragment_rotation.view.*
import org.json.JSONObject
import java.util.*
import kotlin.collections.ArrayList

class FragmentRotation : Fragment() {

    var rotationdata : MutableList<JSONObject> = ArrayList()
    var splatMapRotations : MutableList<Rotation> = ArrayList()

    companion object {
        fun newInstance(data: MutableList<JSONObject>, title: String) : FragmentRotation{
            var fragmentRotation = FragmentRotation()
            var args = Bundle()
            fragmentRotation.arguments = args
            fragmentRotation.rotationdata = data
            return fragmentRotation
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        for (i in 0 until rotationdata.size){
            val startTime = Calendar.getInstance()
            val endTime = Calendar.getInstance()
            val currentTime = Calendar.getInstance()
            startTime.time = Date((rotationdata[i]["start_time"] as Int).toLong() * 1000)
            endTime.time = Date((rotationdata[i]["end_time"] as Int).toLong() * 1000)
            val mapA = SplatMap(((rotationdata[i]["stage_a"] as JSONObject).get("id") as String).toInt())
            val mapB = SplatMap(((rotationdata[i]["stage_b"] as JSONObject).get("id") as String).toInt())
            if(currentTime in startTime..endTime){
                splatMapRotations.add(Rotation(mapA, mapB, startTime, endTime, rotationdata[i]["game_mode"].toString(), isCurrent = true))
            }
            else{
                splatMapRotations.add(Rotation(mapA, mapB, startTime, endTime, rotationdata[i]["game_mode"].toString()))
            }
        }



    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_rotation, container, false)
        rootView.rotation_recycler.layoutManager = LinearLayoutManager(this.context)
        rootView.rotation_recycler.adapter = CardAdapter(splatMapRotations as ArrayList<Rotation>)
        return rootView
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}