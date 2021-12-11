package com.kkk.librartpractice_20211204

import android.Manifest
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.gun0912.tedpermission.PermissionListener
import com.gun0912.tedpermission.normal.TedPermission
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupEvents()
        setValues()
    }


    fun setupEvents() {

        btnCall.setOnClickListener {

//            전화 연결 해도되는지? 권환 확인 -> OK일때만 전화연결.

//            권한 여부에 따른 행동방침 변수

            val pl = object : PermissionListener {
                override fun onPermissionGranted() {

//                    권한 승인 됐을 때
                    
                    //            010-2211-1111 에 실제 전화 연결
                    val myUri = Uri.parse("tel:010-2211-1111")
                    val myIntent = Intent(Intent.ACTION_CALL,myUri)
                    startActivity(myIntent)


                }

                override fun onPermissionDenied(deniedPermissions: MutableList<String>?) {

                    Toast.makeText(this@MainActivity, "권한이 없어서 전화연결이 불가능합니다.", Toast.LENGTH_SHORT).show()
                    
                }

            }

            TedPermission.create()
                .setPermissionListener(pl)
                .setPermissions(Manifest.permission.CALL_PHONE)
                .check()



        }




        imgProfile.setOnClickListener {

            val mIntent = Intent(this,ViewPhotoActivity::class.java)
            startActivity(mIntent)

        }

    }

    fun setValues() {

        val imageURL = "https://dimg.donga.com/wps/NEWS/IMAGE/2021/01/17/104953245.2.jpg"
       Glide.with(this).load(imageURL).into(imageInternet)


    }

}