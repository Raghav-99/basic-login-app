package com.example.training

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main_relative_layout.*

class NewActivity : AppCompatActivity() {
    var titleName : String?="NULL"
    lateinit var sharedPreferences: SharedPreferences
    lateinit var btnLogOut: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPreferences= getSharedPreferences("AlphaLog", Context.MODE_PRIVATE)

        titleName=sharedPreferences.getString("Title",null)
        setContentView(R.layout.activity_main_relative_layout)
        /*if (this.intent !=null)
            titleName=intent.getStringExtra("Name")*/
        title = titleName

        btnLogOut=findViewById(R.id.btnLogOut)

        btnLogOut.setOnClickListener {
            val intent= Intent(this@NewActivity, MainActivity::class.java)
            sharedPreferences.edit().clear().apply()
            startActivity(intent)
            finish()
        }

    }
}
