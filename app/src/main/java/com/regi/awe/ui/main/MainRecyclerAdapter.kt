package com.regi.awe.ui.main

import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.regi.awe.model.Pic
import com.regi.awe.R
import com.regi.awe.constants.IntentConstants
import com.regi.awe.constants.URLConstants
import com.regi.awe.ui.detail.ImageActivity
import kotlinx.android.synthetic.main.list_item.view.*

class MainRecyclerAdapter(val fragment: Fragment) : RecyclerView.Adapter<MainRecyclerAdapter.ViewHolder>(){

    var items: List<Pic> = emptyList()

    fun LoadItems(newItems: List<Pic>){
        items = newItems
    }

    override fun getItemCount(): Int = items.size

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        Glide.with(holder.itemView.context)
                .load("${URLConstants.PICSUM_URL}/500/500/?image=${items.get(position).id}")
                .into(holder.itemView.image)

        holder.itemView.setOnClickListener {
            val intent = Intent(fragment.activity, ImageActivity::class.java)
            val bundle = Bundle()

            bundle.putParcelableArrayList(IntentConstants.ITEM_LIST, ArrayList(items))
            bundle.putInt(IntentConstants.INDEX_SELECTED,position)

            intent.putExtras(bundle)

            fragment.startActivity(intent)
        }
    }
}
