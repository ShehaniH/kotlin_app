package com.example.notessqlite

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.notessqlite.databinding.ActivityMain2Binding

class Main2Activity : AppCompatActivity() {

    private lateinit var binding:ActivityMain2Binding
    private lateinit var db:TaskDatabase
    private lateinit var taskAdapter:TaskAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        db= TaskDatabase(this)
        taskAdapter= TaskAdapter(db.getAllTasks(),this)

        binding.taskrecyclerview.layoutManager=LinearLayoutManager(this)
        binding.taskrecyclerview.adapter=taskAdapter


        binding.addButton.setOnClickListener{
            val intent = Intent(this,AddTasks::class.java)
            startActivity(intent)
            
        }
    }
    override fun onResume() {
        super.onResume()
        taskAdapter.refreshData(db.getAllTasks())
    }

}