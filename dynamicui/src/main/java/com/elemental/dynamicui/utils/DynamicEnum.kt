package com.elemental.dynamicui.utils

enum class DynamicEnum(private val keyType:String){
    //TextView
    TextViewType("textview"),
    //EditText
    EditTextType("edittext"),
    EditTextInputPhoneType("phone_no"),
    EditTextInputNumberType("number"),
    EditTextInputEmailType("email"),

    //ImageView
    ImageViewType("image"),

    //Spinner Type
    SpinnerType("spinner"),
    //Radio Type
    RadioType("radio");

    fun keyType():String{
        return keyType
    }



}