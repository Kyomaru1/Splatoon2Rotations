package com.kyostudios.splatoon2rotations

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kyostudios.splatoon2rotation.Rotation
import org.json.JSONArray
import org.json.JSONObject
import java.util.*

class FragmentTurf : Fragment() {

    var rotationdata : MutableList<JSONObject> = ArrayList()
    var splatMapRotations : MutableList<Rotation> = ArrayList()

    private lateinit var recyclerView: RecyclerView
    private lateinit var recyclerViewAdapter: RecyclerView.Adapter<*>
    private lateinit var viewManager: RecyclerView.LayoutManager

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
        viewManager = LinearLayoutManager(this.context)
        recyclerViewAdapter = CardAdapter(splatMapRotations.toTypedArray())
        var currentTime: Date = Date()

        for (i in 0 until rotationdata.size - 1){
            val startTime = Calendar.getInstance()
            val endTime = Calendar.getInstance()
            val currentTime = Calendar.getInstance()
            startTime.setTimeInMillis((rotationdata[i]["start_time"] as Int).toLong() * 1000)
            endTime.setTimeInMillis((rotationdata[i]["end_time"] as Int).toLong() * 1000)
            val mapA = SplatMap(((rotationdata[i]["stage_a"] as JSONObject).get("id") as String).toInt())
            val mapB = SplatMap(((rotationdata[i]["stage_b"] as JSONObject).get("id") as String).toInt())
            if(currentTime in startTime..endTime){
                splatMapRotations.add(Rotation(mapA, mapB, startTime, endTime, isCurrent = true))
            }
            else{
                splatMapRotations.add(Rotation(mapA, mapB, startTime, endTime))
            }
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val rootview = inflater!!.inflate(R.layout.fragment_turf, container, false)
        //add cards to view for each rotation

        //return View after cards have been added
        return rootview

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}