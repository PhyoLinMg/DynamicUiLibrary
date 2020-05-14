package com.elemental.dynamicui.utils

import android.app.Activity
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.text.InputType
import android.text.TextUtils
import android.util.Log
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.widget.*
import androidx.appcompat.widget.LinearLayoutCompat
import androidx.core.widget.addTextChangedListener
import com.elemental.dynamicui.builder.ViewBuilder
import com.elemental.dynamicui.interfaces.UiParentClickListener


object DynamicUtility {
    fun createTextView(layoutResId: Int, context: Context,text:String,isSingleLine:Boolean=false): TextView {
        return (LayoutInflater.from(context).inflate(layoutResId, null) as TextView).apply {
            setPadding(0,0,0,0)
            setTextSize(TypedValue.COMPLEX_UNIT_SP,18f)
            this.text=text
            if(isSingleLine){
                maxLines=1
                setSingleLine(true)
            }
            ellipsize=TextUtils.TruncateAt.END
        }
    }
    fun createImageView(layoutResId: Int,url:String,context: Context):ImageView{
        val imageView= (LayoutInflater.from(context).inflate(layoutResId,null) as ImageView).apply {
            adjustViewBounds=true
            loadUrl(url)
        }
        return imageView
    }


    fun createEditText(layoutResId:Int, isSingleLine: Boolean=false, hint:String, context:Context, type:String?, refParentClickListener:UiParentClickListener?, itemView: View, adapterPosition:Int):EditText{
        return (LayoutInflater.from(context).inflate(layoutResId,null) as EditText).apply {
            if(isSingleLine){
                this.isSingleLine=true
                this.maxLines=1
            }
            when(type){
                DynamicEnum.EditTextInputEmailType.keyType()->{
                    this.inputType=InputType.TYPE_TEXT_VARIATION_EMAIL_ADDRESS
                }
                DynamicEnum.EditTextInputNumberType.keyType()->{
                    this.inputType=InputType.TYPE_CLASS_NUMBER
                }
                DynamicEnum.EditTextInputPhoneType.keyType()->{
                    this.inputType=InputType.TYPE_CLASS_PHONE
                }
            }
            this.addTextChangedListener{
                refParentClickListener?.onViewClicked(
                    v = itemView,
                    position = adapterPosition,
                    value = it.toString()
                )
            }
        }
    }
    fun createButton(layoutResId: Int,context:Context,text: String,isAllCaps:Boolean=false,viewBuilder: ViewBuilder):Button{
        return (LayoutInflater.from(context).inflate(layoutResId,null) as Button).apply {
            this.isAllCaps=isAllCaps
            this.text=text
            this.setOnClickListener {
                viewBuilder.dynamicButton.onClickListener?.onClick(it)
            }
        }
    }
    fun createSpace(
        context: Context, dp: Int
    ): RelativeLayout {
        val relativeLayout = RelativeLayout(context)
        relativeLayout.layoutParams = LinearLayoutCompat.LayoutParams(
            LinearLayoutCompat.LayoutParams.MATCH_PARENT,
            (context.resources.displayMetrics.density * dp).toInt()
        )
//        relativeLayout.setBackgroundColor(ContextCompat.getColor(context, R.color.divider))
        return relativeLayout
    }







}