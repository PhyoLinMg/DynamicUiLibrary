package com.elemental.dynamicui.view

import android.content.Context
import android.util.AttributeSet
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class DynamicView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : RecyclerView(context, attrs, defStyleAttr){
    init {
        layoutManager=LinearLayoutManager(context)
        isNestedScrollingEnabled=false
        ViewCompat.setNestedScrollingEnabled(rootView,false)
    }
}

