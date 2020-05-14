package com.elemental.dynamicuilibrary

import android.graphics.Bitmap
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.elemental.dynamicui.DynamicAdapter
import com.elemental.dynamicui.ViewData.UiCollectionList
import com.elemental.dynamicui.interfaces.UiParentClickListener
import com.elemental.dynamicui.view.DynamicView
import com.elemental.dynamicuilibrary.utils.Utils
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.reflect.Type
import com.elemental.dynamicuilibrary.R
import com.elemental.dynamicui.builder.ViewBuilder
import com.elemental.dynamicui.interfaces.OnClickListener
import com.elemental.dynamicui.view.DynamicButton


class MainActivity : AppCompatActivity() {
    var bitmap:Bitmap?=null
    lateinit var dynamicView:DynamicView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val jsonFileString: String =
            Utils.getJsonFromAssets(applicationContext, "testing.json")!!
        Log.d("data", jsonFileString)

        val gson = Gson()

        val list=gson.fromJson(jsonFileString,UiCollectionList::class.java)

        val viewBuilder=ViewBuilder.Builder().setButton(DynamicButton(R.layout.btn,null,onClickListener = object: OnClickListener{
            override fun onClick(v: View) {
                Toast.makeText(this@MainActivity,"This is sample testing",Toast.LENGTH_SHORT).show()
            }

        })).build()


        val adapter=DynamicAdapter(list.uiCollection,onclick = object: UiParentClickListener{
            override fun onViewClicked(v: View, position: Int, value: String) {
                list.uiCollection[position].refValue=value
            }

            override fun sendErrorView(v: View?, position: Int) {
                Toast.makeText(this@MainActivity,"Render Error",Toast.LENGTH_SHORT).show()
            }

        },viewBuilder = viewBuilder)

        dynamic_testing.apply {
            this.adapter=adapter
        }


    }


}
