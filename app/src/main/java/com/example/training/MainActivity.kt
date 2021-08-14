package com.example.training

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {


    lateinit var etUsername: EditText
    lateinit var etPassword: EditText
    lateinit var btnLogIn: Button
    lateinit var profileName: String

    lateinit var sharedPreferences: SharedPreferences
    override fun onCreate(savedInstanceState: Bundle?) {
        title = "Stark Login"
        val validUsers = arrayOf("Admin1", "Admin2", "Admin3")
        val validPasswords = arrayOf("Admin1", "Admin2", "Admin3")
        super.onCreate(savedInstanceState)

        sharedPreferences = getSharedPreferences("AlphaLog", Context.MODE_PRIVATE)
        val isLoggedIn = sharedPreferences.getBoolean("isLoggedIn", false)
        if (isLoggedIn) {
            val intent = Intent(this@MainActivity, NewActivity::class.java)
            startActivity(intent)
            finish()
        } else {
            setContentView(R.layout.stark_linear) }


            //setContentView(R.layout.stark_linear.xml)
            println("oncreate called")
            etUsername = findViewById(R.id.etUsername)
            etPassword = findViewById(R.id.etPassword)
            btnLogIn = findViewById(R.id.btnLogIn)

            btnLogIn.setOnClickListener {
                val intent = Intent(this@MainActivity, NewActivity::class.java)
                val username = etUsername.text.toString()
                val password = etPassword.text.toString()
                if (!(validUsers.contains(username) && validPasswords.contains(password)))
                    Toast.makeText(
                        this@MainActivity,
                        "Incorrect Username or Password!",
                        Toast.LENGTH_LONG
                    ).show()
                else {
                    if (password == validPasswords[0] && username == validUsers[0]) {
                        profileName = username
                        savePreferences(profileName)
                        //  intent.putExtra("Name",profileName)
                        startActivity(intent)

                    } else if (password == validPasswords[1] && username == validUsers[1]) {
                        profileName = username
                        savePreferences(profileName)
                        //intent.putExtra("Name",profileName)
                        startActivity(intent)

                    } else if (password == validPasswords[2] && username == validUsers[2]) {

                        profileName = username
                        savePreferences(profileName)
                        //intent.putExtra("Name",profileName)
                        startActivity(intent)

                    } else
                        Toast.makeText(
                            this@MainActivity,
                            "Incorrect Username or Password!",
                            Toast.LENGTH_LONG
                        ).show()

                }
            }

    }

    override fun onPause() {
        super.onPause()
        finish()
    }

    fun savePreferences(title: String) {
        sharedPreferences.edit().putBoolean("isLoggedIn", true).apply()
        sharedPreferences.edit().putString("Title", title).apply()
    }
}

    /*  override fun onStart() {
          super.onStart()
          println("onstart called")
      }

      override fun onResume() {
          super.onResume()
          println("onresume called")
      }

      override fun onPause() {
          super.onPause()
          println("onpause called")
      }

      override fun onStop() {
          super.onStop()
          println("onstop called")
      }

      override fun onRestart() {
          super.onRestart()
          println("onrestart called")
      }

      override fun onDestroy() {
          super.onDestroy()
          println("ondestroy called")
      }*/
