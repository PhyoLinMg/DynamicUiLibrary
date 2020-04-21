package com.elemental.dynamicui.view

import com.elemental.dynamicui.interfaces.OnClickListener

data class DynamicImageView(
    val layoutResId:Int,
    val link:String?,
    val onClickListener: OnClickListener?
)