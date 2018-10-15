package com.regi.awe.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Pic(
        val width: Int,
        val height: Int,
        val id: Int) : Parcelable