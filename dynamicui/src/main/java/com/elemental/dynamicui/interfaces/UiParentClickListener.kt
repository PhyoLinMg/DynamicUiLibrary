package com.elemental.dynamicui.interfaces

import android.view.View

interface UiParentClickListener {
    fun onViewClicked(v: View, position:Int,value:String)
    fun sendErrorView(v:View?,position: Int)
}