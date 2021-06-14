package com.ronivaldoroner.repositories.ui.commons.extensions

import android.view.View

fun View.gone(){
    visibility = View.GONE
}

fun View.visibility(){
    visibility = View.VISIBLE
}

fun View.invisible(){
    visibility = View.INVISIBLE
}

fun View.toggleVisibility(){
    visibility = takeIf { visibility == View.VISIBLE }?.run { View.GONE }?: View.VISIBLE
}