package com.kyostudios.splatoon2rotations

import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
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
                addFragment(fragment, "turf")
                clearBackstack(arrayOf("ranked", "league", "salmon"))
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_ranked -> {
                val fragment = FragmentRanked()
                addFragment(fragment, "ranked")
                clearBackstack(arrayOf("turf", "league", "salmon"))
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_league -> {
                val fragment = FragmentLeague()
                addFragment(fragment, "league")
                clearBackstack(arrayOf("turf", "ranked", "salmon"))
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_salmon->{
                val fragment = FragmentSalmon()
                addFragment(fragment, "salmon")
                clearBackstack(arrayOf("turf", "ranked", "league"))
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    private fun addFragment(fragment: Fragment, fragmentTag: String){
        if(supportFragmentManager.findFragmentByTag(fragmentTag) == null) {
            supportFragmentManager
                    .beginTransaction()
                    .setCustomAnimations(R.anim.design_bottom_sheet_slide_in, R.anim.design_bottom_sheet_slide_out)
                    .add(R.id.frame, fragment, fragmentTag)
                    .commit()
        }
        else{
            supportFragmentManager
                    .beginTransaction()
                    .setCustomAnimations(R.anim.design_bottom_sheet_slide_in, R.anim.design_bottom_sheet_slide_out)
                    .show((supportFragmentManager.findFragmentByTag(fragmentTag)) as Fragment)
                    .commit()
        }
    }

    private fun clearBackstack(tags: Array<String>){
        for(i in tags){
            supportFragmentManager.popBackStack(i, FragmentManager.POP_BACK_STACK_INCLUSIVE)
        }
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val queue : RequestQueue? = Volley.newRequestQueue(this)
        val url = getString(R.string.battleScheduleURL)
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

                        var content = findViewById<FrameLayout>(R.id.frame)
                        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)

                        val fragment = FragmentTurf.newInstance(regularData)
                        addFragment(fragment, "turf")

                    }catch(e:JSONException){
                        e.printStackTrace()
                    }
                },
                Response.ErrorListener { throw Exception() })

        queue?.add(stringRequest)
    }

    override fun onDestroy() {
        super.onDestroy()
        when {
            supportFragmentManager.findFragmentByTag("turf") != null -> {
                supportFragmentManager.beginTransaction()
                        .remove(supportFragmentManager.findFragmentByTag("turf") as Fragment)
                        .commit()
            }
            supportFragmentManager.findFragmentByTag("ranked") != null -> {
                supportFragmentManager.beginTransaction()
                        .remove(supportFragmentManager.findFragmentByTag("ranked") as Fragment)
                        .commit()
            }
            supportFragmentManager.findFragmentByTag("league") != null -> {
                supportFragmentManager.beginTransaction()
                        .remove(supportFragmentManager.findFragmentByTag("league") as Fragment)
                        .commit()
            }
            supportFragmentManager.findFragmentByTag("salmon") != null -> {
                supportFragmentManager.beginTransaction()
                        .remove(supportFragmentManager.findFragmentByTag("salmon") as Fragment)
                        .commit()
            }
        }

    }
}
