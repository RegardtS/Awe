package com.regi.awe.ui.detail

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.regi.awe.model.Pic

class ImagePagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {

    var items: List<Pic> = emptyList()

    fun LoadItems(newItems: List<Pic>){
        items = newItems
    }

    override fun getItem(position: Int): Fragment {
        return ImageholderFragment.newInstance(items.get(position))
    }

    override fun getCount(): Int = items.size

}