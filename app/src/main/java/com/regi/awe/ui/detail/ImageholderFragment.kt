package com.regi.awe.ui.detail

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.widget.CircularProgressDrawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.regi.awe.model.Pic
import com.regi.awe.R
import com.regi.awe.constants.IntentConstants
import com.regi.awe.constants.URLConstants
import kotlinx.android.synthetic.main.fragment_image.view.*

class ImageholderFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val rootView = inflater.inflate(R.layout.fragment_image, container, false)

        val pic: Pic = arguments!!.getParcelable(IntentConstants.ITEM_SELECTED)

        val circularProgressDrawable = CircularProgressDrawable(rootView.context)
        circularProgressDrawable.strokeWidth = 5f
        circularProgressDrawable.centerRadius = 30f
        circularProgressDrawable.start()

        Glide.with(rootView.imageView.context)
                .load("${URLConstants.PICSUM_URL}/${pic.width}/${pic.height}/?image=${pic.id}")
                .thumbnail(0.2f)
                .apply(RequestOptions.placeholderOf(circularProgressDrawable))
                .into(rootView.imageView)

        return rootView
    }

    companion object {

        fun newInstance(pic: Pic): ImageholderFragment {
            val fragment = ImageholderFragment()
            val args = Bundle()
            args.putParcelable(IntentConstants.ITEM_SELECTED,pic)
            fragment.arguments = args
            return fragment
        }
    }
}