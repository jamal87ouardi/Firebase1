package com.example.firebase

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity : AppCompatActivity() {

    private lateinit var addbtn : Button
    private lateinit var listbtn : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addbtn = findViewById(R.id.button)
        listbtn = findViewById(R.id.button2)

        addbtn.setOnClickListener{
            val i = Intent(this,Add::class.java)
            startActivity(i)

        }

        listbtn.setOnClickListener {



        }

        val firebase:DatabaseReference = FirebaseDatabase.getInstance().getReference()
    }
}