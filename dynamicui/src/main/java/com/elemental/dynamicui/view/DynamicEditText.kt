package com.elemental.dynamicui.view

import com.elemental.dynamicui.interfaces.OnClickListener

data class DynamicEditText (
    val layoutResId:Int,
    val hint:String?,
    val onClickListener: OnClickListener?
)