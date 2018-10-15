package com.regi.awe.ui.main

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.regi.awe.R
import kotlinx.android.synthetic.main.main_fragment.*

class MainFragment : Fragment() {

    companion object {
        fun newInstance() = MainFragment()
    }

    private lateinit var viewModel: MainViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View {
        return inflater.inflate(R.layout.main_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        val adapter = MainRecyclerAdapter(this)

        recyclerView.adapter = adapter

        viewModel.initLoad()
        viewModel.picList().observe(this, Observer {
            adapter.LoadItems(it ?: emptyList())
            adapter.notifyDataSetChanged()
            progress_circular.visibility = if(it == null) View.VISIBLE else View.GONE
        })
        viewModel.error().observe(this, Observer {
            error.text = it
        })
    }
}

