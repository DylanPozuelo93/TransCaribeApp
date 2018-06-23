package com.example.dylanpozuelo.maps_actvts.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.view.View
import android.widget.Toast
import com.example.dylanpozuelo.maps_actvts.R
import com.example.dylanpozuelo.maps_actvts.activities.fragments_trip.FragmentMap
import com.example.dylanpozuelo.maps_actvts.activities.fragments_trip.FragmentPlaces
import com.example.dylanpozuelo.maps_actvts.activities.fragments_trip.FragmentStations
import com.example.dylanpozuelo.maps_actvts.adapter.ViewPagerAdapter
import kotlinx.android.synthetic.main.activity_trips_activitie.*
import kotlinx.android.synthetic.main.appbar_trips.*
import android.content.Intent
import kotlinx.android.synthetic.main.collaspsible_trips_map.*
import android.view.animation.AnimationUtils


class TripsActivity : AppCompatActivity() {
        var pagerAdapter : ViewPagerAdapter? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_trips_activitie)
        //setSupportActionBar(toolbar_trips)
        //actionBar.title = "Viajes"
        //toolbar_trips = supportActionBar!!
        toolbar_trips.title = "Viajes"
        pagerAdapter = ViewPagerAdapter(supportFragmentManager)
        pagerAdapter!!.addFragments(FragmentMap(),"Mapa")
        pagerAdapter!!.addFragments(FragmentPlaces(),"Sitios")
        pagerAdapter!!.addFragments(FragmentStations(),"Estaciones")
        viewPager_trips.adapter = pagerAdapter
        tab_trips.setupWithViewPager(viewPager_trips)
        collapsible_bar.visibility = View.GONE
        fab_to_show.setOnClickListener({ v ->
            val animation = AnimationUtils.loadAnimation(this@TripsActivity, R.anim.slide_down_show)
            collapsible_bar.clearAnimation()
            collapsible_bar.startAnimation(animation)
            collapsible_bar.visibility = View.VISIBLE
            val animation2 = AnimationUtils.loadAnimation(this@TripsActivity,R.anim.abc_popup_exit)
            fab_to_show.clearAnimation()
            fab_to_show.startAnimation(animation2)
            fab_to_show.visibility = View.GONE
        })
        fab_to_find.setOnClickListener({ v ->
            val animation = AnimationUtils.loadAnimation(this@TripsActivity, R.anim.slide_up_hide)
            collapsible_bar.clearAnimation()
            collapsible_bar.startAnimation(animation)
            collapsible_bar.visibility = View.GONE
            val animation2 = AnimationUtils.loadAnimation(this@TripsActivity,R.anim.abc_popup_enter)
            fab_to_show.clearAnimation()
            fab_to_show.startAnimation(animation2)
            fab_to_show.visibility = View.VISIBLE
        })
        //if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //val w = window // in Activity's onCreate() for instance
            //w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS)
        //}
        val navView = findViewById<View>(R.id.bottom_nav_view) as BottomNavigationView
        navView.selectedItemId = R.id.action_Trips
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
    }


    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.action_Cards ->
            {
                toolbar_trips.title = "Tarjetas"
                startActivity(Intent(this, CardsActivity::class.java))
                Toast.makeText(application,"Tarjetas", Toast.LENGTH_SHORT).show()
                return@OnNavigationItemSelectedListener true
            }
            R.id.action_Trips ->
            {
                //toolbar_trips.title = "Viajes"

                Toast.makeText(application,"Viajes", Toast.LENGTH_SHORT).show()
                return@OnNavigationItemSelectedListener true
            }
            R.id.action_RTFeed ->
            {
                toolbar_trips.title = "Noticias"
                startActivity(Intent(this, RTFeedActivity::class.java))
                Toast.makeText(application,"Noticias", Toast.LENGTH_SHORT).show()
                return@OnNavigationItemSelectedListener true
            }
            R.id.action_Profile ->
            {
                toolbar_trips.title = "Perfil"
                startActivity(Intent(this, ProfileActivity::class.java))
                Toast.makeText(application,"Perfil", Toast.LENGTH_SHORT).show()
                return@OnNavigationItemSelectedListener true
            }
        }
        return@OnNavigationItemSelectedListener false

    }
}


