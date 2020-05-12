package com.elemental.dynamicui


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.recyclerview.widget.RecyclerView
import com.elemental.dyanmicui.R
import com.elemental.dynamicui.ViewData.UiCollection
import com.elemental.dynamicui.builder.ViewBuilder
import com.elemental.dynamicui.interfaces.UiParentClickListener


class DynamicAdapter(private var list:ArrayList<UiCollection?>?,private var onclick:UiParentClickListener?,private val viewBuilder: ViewBuilder?):RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater=LayoutInflater.from(parent.context)
        return DynamicViewHolder( inflater.inflate(R.layout.viewholder_dynamic_ui, parent, false),onclick)
    }

    override fun getItemCount(): Int {
        return list?.size ?: 0
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {

    }
    internal class DynamicViewHolder(itemView: View, refParentClickListener: UiParentClickListener?):RecyclerView.ViewHolder(itemView){

        fun bindData(data:UiCollection,position: Int,refParentClickListener: UiParentClickListener?){
            itemView.apply {
                (this as LinearLayoutCompat)

            }
        }

    }

}