package com.example.voter2

import android.content.ContentValues
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    private lateinit var db: FirebaseFirestore

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        db = Firebase.firestore
        getAllItem()
        val nik = findViewById<EditText>(R.id.editTextTextPersonName)
        val pass = findViewById<EditText>(R.id.editTextTextPersonName2)
        val masuk = findViewById<Button>(R.id.masukButton)

        masuk.setOnClickListener {
            val nik = nik.text
            val pass = pass.text

            if (nik.isEmpty()) {
                Toast.makeText(this, "NIK must be filled!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if(nik.toString().length != 16){
                Toast.makeText(this, "NIK must be 16 characters long!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (pass.isEmpty()) {

                Toast.makeText(this, "Password must be filled!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            val intent = Intent(this, HomeActivity::class.java)
            startActivity(intent)
        }

    }
    private fun getAllItem() {
        db.collection("items").get()
            .addOnSuccessListener { items ->
                for (item in items) {
                    val id = item.get("id").toString()
                    val name = item.get("name").toString()
                    val value = item.get("value").toString()

                    val newItem = Item(
                        id = id,
                        name = name,
                        value = value,
                    )
                    ItemController.addItem(newItem)
                }
            }
            .addOnFailureListener { e ->
                Log.w(ContentValues.TAG, "Error getting ALL items", e)
            }
    }
}