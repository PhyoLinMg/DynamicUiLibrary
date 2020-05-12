package com.elemental.dynamicuilibrary

import android.app.Activity
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.ImageView
import com.elemental.dynamicui.utils.DynamicUtility
import com.elemental.dynamicui.utils.DynamicUtility.createImageView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import java.io.BufferedInputStream
import java.io.IOException
import java.io.InputStream
import java.net.URL
import java.net.URLConnection

class MainActivity : AppCompatActivity() {
    var bitmap:Bitmap?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val url =
            "https://vignette.wikia.nocookie.net/haikyuu/images/3/3c/Shimizu_S4.png/revision/latest?cb=20200114005140&path-prefix=es"

        val imageView=createImageView(R.layout.image,url,this)
        linearlayout.addView(imageView)

    }


}
