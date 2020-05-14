package com.elemental.dynamicui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.recyclerview.widget.RecyclerView
import com.elemental.dyanmicui.R
import com.elemental.dynamicui.ViewData.UiCollectionList
import com.elemental.dynamicui.builder.ViewBuilder
import com.elemental.dynamicui.interfaces.UiParentClickListener
import com.elemental.dynamicui.utils.DynamicEnum
import com.elemental.dynamicui.utils.DynamicUtility
import com.elemental.dynamicui.view.DynamicView

class DynamicAdapter(
    private var list: List<UiCollectionList.UiCollection?>?,
    private var onclick: UiParentClickListener?,
    private val viewBuilder: ViewBuilder?
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return DynamicViewHolder(
            inflater.inflate(R.layout.viewholder_dynamic_ui, parent, false),
            onclick
        )
    }

    override fun getItemCount(): Int {
        return list?.size ?: 0
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as DynamicViewHolder).bindData(list?.get(position), position, onclick, viewBuilder)
        holder.setIsRecyclable(false)
    }

    internal class DynamicViewHolder(
        itemView: View,
        refParentClickListener: UiParentClickListener?
    ) : RecyclerView.ViewHolder(itemView) {


        fun bindData(
            data: UiCollectionList.UiCollection?,
            position: Int,
            refParentClickListener: UiParentClickListener?,
            viewBuilder: ViewBuilder?
        ) {
            itemView.apply {
                (this as LinearLayoutCompat)
                var labelView: TextView? = null
                when (data?.refType) {
                    DynamicEnum.TextViewType.keyType() -> {
                        labelView = DynamicUtility.createTextView(
                            viewBuilder?.dynamicTextView!!.layoutResId,
                            this.context,
                            data.refLabel!!,
                            false
                        )
                        this.addView(labelView)
                        this.addView(DynamicUtility.createSpace(this.context, 3))
                        this.addView(
                            DynamicUtility.createTextView(
                                viewBuilder?.dynamicTextView!!.layoutResId,
                                this.context,
                                data.refValue!!,
                                false
                            )
                        )
                    }
                    DynamicEnum.EditTextType.keyType() -> {
                        labelView = DynamicUtility.createTextView(
                            viewBuilder?.dynamicTextView!!.layoutResId,
                            this.context,
                            data.refLabel!!,
                            false
                        )
                        this.addView(labelView)
                        this.addView(
                            DynamicUtility.createEditText(
                                viewBuilder.dynamicEditText.layoutResId,
                                false,
                                data.refValue!!,
                                this.context,
                                data.refDataType,
                                refParentClickListener,
                                itemView,
                                adapterPosition
                            )
                        )
                        this.addView(DynamicUtility.createSpace(this.context, 8))
                    }
                    DynamicEnum.ButtonType.keyType() -> {
                        labelView = DynamicUtility.createTextView(
                            viewBuilder?.dynamicTextView!!.layoutResId,
                            this.context,
                            data.refLabel!!,
                            false
                        )
                        this.addView(labelView)
                        this.addView(
                            DynamicUtility.createButton(
                                viewBuilder.dynamicButton.layoutResId,
                                this.context,
                                data.refValue!!,
                                false,
                                viewBuilder
                            )

                        )
                    }
                    DynamicEnum.ImageViewType.keyType() -> {
                        labelView = DynamicUtility.createTextView(
                            viewBuilder?.dynamicTextView!!.layoutResId,
                            this.context,
                            data.refLabel!!,
                            false
                        )
                        this.addView(labelView)
                        this.addView(
                            DynamicUtility.createImageView(
                                viewBuilder.dynamicImageView.layoutResId,
                                data.refValue!!,
                                this.context
                            )
                        )
                    }

                }
            }
        }

    }

}