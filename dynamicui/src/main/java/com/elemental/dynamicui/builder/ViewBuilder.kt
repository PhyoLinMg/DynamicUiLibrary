package com.elemental.dynamicui.builder

import android.app.Activity
import com.elemental.dyanmicui.R
import com.elemental.dynamicui.DynamicAdapter
import com.elemental.dynamicui.view.DynamicButton
import com.elemental.dynamicui.view.DynamicEditText
import com.elemental.dynamicui.view.DynamicImageView
import com.elemental.dynamicui.view.DynamicTextView

class ViewBuilder private constructor(
    val dynamicTextView: DynamicTextView,
    val dynamicEditText: DynamicEditText,
    val dynamicButton: DynamicButton,
    val dynamicImageView: DynamicImageView,
    val dynamicInnerAdapter: Any
) {
    data class Builder(
        var dynamicTextView: DynamicTextView = DynamicTextView(R.layout.dynamic_text_view, null),
        var dynamicEditText: DynamicEditText = DynamicEditText(
            R.layout.dynamic_edit_text,
            null,
            null
        ),
        var dynamicButton: DynamicButton = DynamicButton(R.layout.dynamic_button, null, null),
        var dynamicImageView: DynamicImageView = DynamicImageView(
            R.layout.dynamic_image,
            null,
            null
        ),
        var dynamicInnerAdapter: Any = DynamicAdapter(null, null, null),
        var activity:Activity?=null

    ) {
        fun setTextView(dynamicTextView: DynamicTextView) =
            apply { this.dynamicTextView = dynamicTextView }

        fun setEditText(dynamicEditText: DynamicEditText) =
            apply { this.dynamicEditText = dynamicEditText }

        fun setButton(dynamicButton: DynamicButton) = apply { this.dynamicButton = dynamicButton }
        fun setImageView(dynamicImageView: DynamicImageView) =
            apply { this.dynamicImageView = dynamicImageView }

        fun setInnerAdapter(dynamicInnerAdapter: Any) =
            apply { this.dynamicInnerAdapter = dynamicInnerAdapter }



        fun build() = ViewBuilder(
            dynamicTextView,
            dynamicEditText,
            dynamicButton,
            dynamicImageView,
            dynamicInnerAdapter
        )


    }


}