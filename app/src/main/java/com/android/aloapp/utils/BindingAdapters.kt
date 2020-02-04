package com.android.aloapp.utils

import android.widget.ImageView
import android.widget.MediaController
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

object BindingAdapters {
    @JvmStatic
    @BindingAdapter("loadImage")
    fun loadImage(v: ImageView?, url: String?) {
        Picasso.get().load(url).into(v)
    }
}