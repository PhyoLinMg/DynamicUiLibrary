package com.elemental.dynamicui.view

import com.elemental.dynamicui.interfaces.OnClickListener

data class DynamicTextView(
    val layoutResId:Int,
    val onClickListener: OnClickListener?
)