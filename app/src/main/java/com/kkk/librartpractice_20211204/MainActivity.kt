package com.kkk.librartpractice_20211204

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupEvents()
        setValues()
    }


    fun setupEvents() {

        imgProfile.setOnClickListener {

            val mIntent = Intent(this,ViewPhotoActivity::class.java)
            startActivity(mIntent)

        }

    }

    fun setValues() {

    }

}