package com.kyostudios.splatoon2rotations

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.widget.FrameLayout
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.google.android.gms.common.internal.ImagesContract.URL
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONArray
import org.json.JSONException
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_turf -> {
                val fragment = FragmentTurf()
                addFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_ranked -> {
                val fragment = FragmentRanked()
                addFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_league -> {
                val fragment = FragmentLeague()
                addFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_salmon->{
                val fragment = FragmentSalmon()
                addFragment(fragment)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    private fun addFragment(fragment: Fragment){
        supportFragmentManager
                .beginTransaction()
                .setCustomAnimations(R.anim.design_bottom_sheet_slide_in, R.anim.design_bottom_sheet_slide_out)
                .replace(R.id.frame, fragment, fragment.javaClass.simpleName)
                .addToBackStack(fragment.javaClass.simpleName)
                .commit()
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val queue : RequestQueue? = Volley.newRequestQueue(this)
        val url = getString(R.string.battleScheduleURL)
        var data : String
        val leagueData : MutableList<JSONObject> = ArrayList()
        val rankedData : MutableList<JSONObject> = ArrayList()
        val regularData : MutableList<JSONObject> = ArrayList()
        val stringRequest = StringRequest(Request.Method.GET, url,
                Response.Listener<String>{
                    response ->
                    try {
                        queue?.cancelAll(url)
                        val json = JSONObject(response)
                        var array = json.getJSONArray("league")
                        for (i in 0 until array.length()) {
                            leagueData.add(array.getJSONObject(i))
                        }
                        array = json.getJSONArray("gachi")
                        for(i in 0 until array.length() ){
                            rankedData.add(array.getJSONObject(i))
                        }
                        array = json.getJSONArray("regular")
                        for(i in 0 until array.length()){
                            regularData.add(array.getJSONObject(i))
                        }
                    }catch(e:JSONException){
                        e.printStackTrace()
                    }
                },
                Response.ErrorListener { throw Exception() })

        queue?.add(stringRequest)


        var content = findViewById<FrameLayout>(R.id.frame)
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

        val fragment = FragmentTurf.newInstance(regularData)
        addFragment(fragment)



    }

    override fun onStop() {
        super.onStop()

    }
}
