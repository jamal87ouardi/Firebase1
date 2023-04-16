package com.example.firebase

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Add : AppCompatActivity() {
    private lateinit var edNom : EditText
    private lateinit var edPrix : EditText
    private lateinit var edImg : EditText
    private lateinit var btn : Button
    private lateinit var dbRef : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)

        edNom = findViewById(R.id.edNom)
        edPrix = findViewById(R.id.edPrix)
        edImg = findViewById(R.id.edImg)

        btn = findViewById(R.id.button3)

        dbRef = FirebaseDatabase.getInstance().getReference("Produits")
        btn.setOnClickListener {

            saveProductData(edNom.text.toString(),edPrix.text.toString().toFloat(),edImg.text.toString())

        }

    }

    private fun saveProductData(nom:String,prix:Float,url:String) {
        val id = dbRef.push().key !!
        val pr = Product(id,nom,prix,url)
        dbRef.child(id).setValue(pr)
            .addOnCompleteListener {
                Toast.makeText(this,"Insert Success",Toast.LENGTH_LONG).show()
            }


    }
}