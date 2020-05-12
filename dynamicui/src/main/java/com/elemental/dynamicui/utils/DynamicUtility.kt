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
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

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
    fun createImageView(layoutResId: Int,url:String,activity:Activity):ImageView{
        val imageView= (LayoutInflater.from(activity).inflate(layoutResId,null) as ImageView).apply {
            adjustViewBounds=true
        }

        GlobalScope.launch {
            updateUI(imageView, Utils.getImageBitmap(url),activity)
        }
        return imageView

    }
    private fun updateUI(imageView:ImageView,bitmap: Bitmap?,activity:Activity){
        activity.runOnUiThread(java.lang.Runnable {
            imageView.setImageBitmap(bitmap)
        })
    }

    fun createEditText(layoutResId:Int,isSingleLine: Boolean=false,hint:String,context:Context,type:String?):EditText{
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
        }
    }
    fun createButton(layoutResId: Int,context:Context,text: String,isAllCaps:Boolean=false):Button{
        return (LayoutInflater.from(context).inflate(layoutResId,null) as Button).apply {
            this.isAllCaps=isAllCaps
            this.text=text
        }
    }





}