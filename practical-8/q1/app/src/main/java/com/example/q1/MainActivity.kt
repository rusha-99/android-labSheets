package com.example.q1

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.q1.adapter.TaskListAdapter
import com.example.q1.database.DatabaseHelper
import com.example.q1.model.TaskListModel

class MainActivity : AppCompatActivity() {

    lateinit var recycler_task : RecyclerView
    lateinit var btn_add: Button
    var tasklistAdapter : TaskListAdapter ?= null
    var dbHandler:DatabaseHelper ?= null
    var tasklist : List<TaskListModel> = ArrayList<TaskListModel>()
    var linearlayoutManager: LinearLayoutManager ?= null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recycler_task = findViewById(R.id.rv_list)
        btn_add = findViewById(R.id.bt_add_items)

        dbHandler = DatabaseHelper(this)
        fetchlist()

        btn_add.setOnClickListener {
            val i = Intent(applicationContext,AddTask::class.java)
            startActivity(i)
        }




    }
    @SuppressLint("NotifyDataSetChanged")
    private fun fetchlist(){
        tasklist = dbHandler!!.getAllTask()
        tasklistAdapter = TaskListAdapter(tasklist,applicationContext)
        linearlayoutManager = LinearLayoutManager(applicationContext)
        recycler_task.layoutManager = linearlayoutManager
        recycler_task.adapter = tasklistAdapter
        tasklistAdapter ?.notifyDataSetChanged()
    }
}