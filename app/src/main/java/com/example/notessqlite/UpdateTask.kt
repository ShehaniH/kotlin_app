package com.example.notessqlite

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.notessqlite.databinding.ActivityUpdateTaskBinding

class UpdateTask : AppCompatActivity() {

    private lateinit var binding:ActivityUpdateTaskBinding
    private lateinit var db:TaskDatabase
    private var taskId:Int=-1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityUpdateTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db=TaskDatabase(this)

        taskId=intent.getIntExtra("task_id",-1)
        if (taskId==-1)
        {
            finish()
            return
        }

        val task=db.getTaskById(taskId )
        binding.edittitleText.setText(task.title)
        binding.edittimeText.setText(task.time)
        binding.editnotetext.setText(task.note)
        binding.editprioritytext.setText(task.priority)

        binding.updatesaveBtn.setOnClickListener{
            val newtitle=binding.edittitleText.text.toString()
            val newtime=binding.edittimeText.text.toString()
            val newnote=binding.editnotetext.text.toString()
            val newpriority=binding.editprioritytext.text.toString()
            val updatetask=Task(taskId,newtitle,newtime,newnote,newpriority)
            db.updateTask(updatetask)
            finish()
            Toast.makeText(this,"Changes Saved",Toast.LENGTH_SHORT).show()
        }
    }
}