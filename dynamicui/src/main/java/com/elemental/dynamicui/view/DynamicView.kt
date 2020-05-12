package com.elemental.dynamicui.view

import android.content.Context
import android.widget.LinearLayout
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class DynamicView(context: Context) : RecyclerView(context) {
    init {
        layout()
    }
    private fun layout(){
        layoutManager=LinearLayoutManager(context)
        isNestedScrollingEnabled=false
        ViewCompat.setNestedScrollingEnabled(rootView,false)
    }
}