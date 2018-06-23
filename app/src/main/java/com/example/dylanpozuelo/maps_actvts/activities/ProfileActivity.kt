package com.example.dylanpozuelo.maps_actvts.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v7.app.ActionBar
import android.view.View
import android.widget.Toast
import com.example.dylanpozuelo.maps_actvts.R
import kotlinx.android.synthetic.main.appbar_trips.*

class ProfileActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile_activitie)
        toolbar_trips.title = "Perfil"
        val navView = findViewById<View>(R.id.bottom_nav_view) as BottomNavigationView
        navView.selectedItemId = R.id.action_Profile
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
                toolbar_trips.title = "Viajes"
                startActivity(Intent(this, TripsActivity::class.java))
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
                //toolbar_trips.title = "Perfil"

                Toast.makeText(application,"Perfil", Toast.LENGTH_SHORT).show()
                return@OnNavigationItemSelectedListener true
            }
        }
        return@OnNavigationItemSelectedListener false

    }
}
