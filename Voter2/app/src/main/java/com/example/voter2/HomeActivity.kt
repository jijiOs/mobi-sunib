package com.example.voter2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HomeActivity : AppCompatActivity(), ItemAdapter.OnItemClickListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        val recyclerView: RecyclerView = findViewById(R.id.itemRV)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ItemAdapter(ItemController.getItems(), this)
    }

     override  fun onItemClicked() {
         Toast.makeText(this, "Thanks for Voting", Toast.LENGTH_SHORT).show()
         val intent = Intent(this, MainActivity::class.java)
         startActivity(intent)
    }
}