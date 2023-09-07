package com.example.technicalassigment.ui.activites

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.technicalassigment.R
import com.example.technicalassigment.utils.Utils

class MainActivity : AppCompatActivity(),View.OnClickListener {
    var openBrowserBtn:Button?=null
     override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
     setContentView(  R.layout.activity_main)
         initView()
    }
    fun initView(){
        openBrowserBtn=findViewById(R.id.openBrowserBtn)
        openBrowserBtn?.setOnClickListener(this)

    }

    override fun onClick(view: View?) {
         when(view?.id){
             R.id.openBrowserBtn ->{
                 Utils.goToActivity(this, WebViewActivity::class.java)
             }
         }
    }
}