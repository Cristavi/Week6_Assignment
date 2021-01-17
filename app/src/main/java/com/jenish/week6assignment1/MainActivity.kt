package com.jenish.week6assignment1

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {
    private lateinit var etUsername : TextInputEditText
    private lateinit var etPassword : TextInputEditText
    private lateinit var btnLogin : Button
  //  private lateinit var tvUsername : TextView



    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        etUsername = findViewById(R.id.etUsername)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)
       // tvUsername = findViewById(R.id.tvUsername)


        etUsername.setOnClickListener{
         //   tvUsername.setTextColor(android.R.color.black)
        }

        btnLogin.setOnClickListener{
            login()
        }
    }

    private fun login(){
        if (etUsername.text.toString().toLowerCase().trim() == "softwarica" && etPassword.text.toString() == "coventry"){
            val toast = Toast.makeText(this, "Hello", Toast.LENGTH_SHORT)

            toast.setGravity(android.view.Gravity.CENTER, 0, 0)
            toast.show()


            emptyTextBoxes()

            val intent = Intent(this, SoftwaricaActivity::class.java)
            startActivity(intent)

        }
        else{
            etUsername.error = "Please enter correct username and password"
            etUsername.requestFocus()
            emptyTextBoxes()
        }
    }

    private fun emptyTextBoxes(){
        etUsername.setText("")
        etPassword.setText("")
    }
}