package com.example.notessqlite

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class launching : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launching)
    }

    fun open(view: View) {
        val intent =Intent(this,Main2Activity::class.java)
        startActivity(intent)

    }
}