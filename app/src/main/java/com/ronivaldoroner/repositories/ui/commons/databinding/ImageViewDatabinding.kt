package com.ronivaldoroner.repositories.ui.commons.databinding

import android.net.Uri
import android.widget.ImageView
import androidx.annotation.DrawableRes
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide

@BindingAdapter("setImageByUrl")
fun ImageView.setImage(image: String?){
    image?.let{
        Glide.with(this.context)
            .load(it)
            .into(this)
    }
}

@BindingAdapter("setImageByUri")
fun ImageView.setImage(image: Uri?){
    image?.let {
        Glide.with(this.context)
            .load(it)
            .into(this)
    }
}

@BindingAdapter("setImageByRes")
fun ImageView.setImage(@DrawableRes image: Int){
    Glide.with(this.context)
        .load(image)
        .into(this)
}


