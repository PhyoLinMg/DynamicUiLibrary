package com.elemental.dynamicui

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.elemental.dynamicui.ViewData.UiCollection
import com.elemental.dynamicui.builder.ViewBuilder
import com.elemental.dynamicui.interfaces.UiParentClickListener
import com.elemental.dynamicui.view.DynamicView

class DynamicAdapter(private var list:ArrayList<UiCollection?>?,private var onclick:UiParentClickListener?,private val viewBuilder: ViewBuilder?):RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {

    }

    override fun getItemCount(): Int {

    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

    }

}