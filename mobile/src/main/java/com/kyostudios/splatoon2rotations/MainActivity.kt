package com.kyostudios.splatoon2rotations

import android.app.Activity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.widget.FrameLayout
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_main.*
import org.json.JSONException
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    private val leagueData : MutableList<JSONObject> = ArrayList()
    private val rankedData : MutableList<JSONObject> = ArrayList()
    private val regularData : MutableList<JSONObject> = ArrayList()

    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_turf -> if(item.itemId != navigation.selectedItemId) {
                val fragment = FragmentRotation.newInstance(regularData, "Turf War")
                addFragment(fragment, "turf")
                clearBackstack(arrayOf("ranked", "league", "salmon"))
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_ranked -> if(item.itemId != navigation.selectedItemId) {
                val fragment = FragmentRotation.newInstance(rankedData, "Ranked")
                addFragment(fragment, "ranked")
                clearBackstack(arrayOf("league", "salmon"))
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_league -> if(item.itemId != navigation.selectedItemId) {
                val fragment = FragmentRotation.newInstance(leagueData, "League")
                addFragment(fragment, "league")
                clearBackstack(arrayOf("ranked", "salmon"))
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_salmon-> if(item.itemId != navigation.selectedItemId) {
                val fragment = FragmentRotation.newInstance(ArrayList(), "")
                addFragment(fragment, "salmon")
                clearBackstack(arrayOf("ranked", "league"))
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
                    .replace(R.id.frame, fragment, fragmentTag)
                    .addToBackStack(fragmentTag)
                    .commit()
        }
        else{
            supportFragmentManager
                    .beginTransaction()
                    .setCustomAnimations(R.anim.design_bottom_sheet_slide_in, R.anim.design_bottom_sheet_slide_out)
                    .show((supportFragmentManager.findFragmentByTag(fragmentTag)) as Fragment)
                    .commit()
        }
        progressBar.setVisibility(View.GONE)
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

                        val fragment = FragmentRotation.newInstance(regularData, "Turf War")
                        addFragment(fragment, "turf")

                    }catch(e:JSONException){
                        e.printStackTrace()
                    }
                },
                Response.ErrorListener { throw Exception() })

        queue?.add(stringRequest)
    }

    override fun onBackPressed() {
        var bottomNavigationView: BottomNavigationView = findViewById(R.id.navigation)
        var selectedItem: Int = bottomNavigationView.selectedItemId
        if(selectedItem != R.id.navigation_turf)
            navigation.selectedItemId = R.id.navigation_turf
        else
            System.exit(0)

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
