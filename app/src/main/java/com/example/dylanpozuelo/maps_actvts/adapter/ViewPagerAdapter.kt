package com.example.dylanpozuelo.maps_actvts.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import java.text.ParsePosition
import java.util.ArrayList

class ViewPagerAdapter(fm : FragmentManager) : FragmentPagerAdapter(fm) {
    var mFm = fm
    var mFragmentItems : ArrayList<Fragment> = ArrayList()
    var mFragmentTitles : ArrayList<String> = ArrayList()
    fun addFragments(fragmentItem : Fragment, fragmentTitle : String ){
        mFragmentItems.add(fragmentItem)
        mFragmentTitles.add(fragmentTitle)
    }

    override fun getCount(): Int {
        return mFragmentItems.size
    }

    override fun getItem(position: Int): Fragment? {
        return mFragmentItems[position]
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return mFragmentTitles[position]
    }

}