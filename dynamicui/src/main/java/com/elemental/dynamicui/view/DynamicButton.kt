package com.elemental.dynamicui.view

import com.elemental.dynamicui.interfaces.OnClickListener

data class DynamicButton(
    val layoutResId:Int,
    val text:String?,
    val onClickListener: OnClickListener?
)