package com.regi.awe.ui.detail

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.regi.awe.R
import com.regi.awe.constants.IntentConstants
import com.regi.awe.model.Pic
import kotlinx.android.synthetic.main.activity_image.*

class ImageActivity : AppCompatActivity() {

    private var mSectionsPagerAdapter: ImagePagerAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_image)

        mSectionsPagerAdapter = ImagePagerAdapter(supportFragmentManager)
        container.adapter = mSectionsPagerAdapter

        var list: List<Pic>
        list=intent.getParcelableArrayListExtra(IntentConstants.ITEM_LIST)

        mSectionsPagerAdapter!!.LoadItems(list)
        mSectionsPagerAdapter!!.notifyDataSetChanged()
        container.currentItem = intent.getIntExtra(IntentConstants.INDEX_SELECTED,0)
    }
}
