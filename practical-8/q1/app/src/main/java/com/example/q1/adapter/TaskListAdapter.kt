package com.example.q1.adapter

import android.content.Context
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.q1.R
import com.example.q1.model.TaskListModel

class TaskListAdapter(tasklist:List<TaskListModel>,internal var context: Context)
    :RecyclerView.Adapter<TaskListAdapter.TaskViewHolder>()
{

    internal var tasklist: List<TaskListModel> = ArrayList()
    init {
        this.tasklist = tasklist
    }

    inner class TaskViewHolder(view :View) :RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.recycler_task_list,parent,false)
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        TODO("Not yet implemented")
    }
}