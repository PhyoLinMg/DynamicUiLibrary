package com.elemental.dynamicui.utils

enum class DynamicEnum(private val keyType:String){
    //TextView
    TextViewType("text_view"),
    //EditText
    EditTextType("edit_text"),
    EditTextInputPhoneType("phone_no"),
    EditTextInputNumberType("number"),
    EditTextInputEmailType("email"),


    //Button

    ButtonType("button"),

    //ImageView
    ImageViewType("image_view"),

    //Spinner Type
    SpinnerType("spinner"),
    //Radio Type
    RadioType("radio");

    fun keyType():String{
        return keyType
    }



}