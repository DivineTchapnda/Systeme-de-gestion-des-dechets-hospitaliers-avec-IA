package com.example.todolistapp.Data

import com.example.todolistapp.Data.Task
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener

object Repository {
    private val db = FirebaseDatabase.getInstance().getReference("TodoApp355")

    fun addTask(task: Task) {
        val id = db.push().key!!
        db.child(id).setValue(task)
    }

    fun deleteTask(id: String) {
        db.child(id).removeValue()
    }

    fun getTask(onDataChange: (List<Pair<String, Task>>) -> Unit) {
        db.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(snapshot: DataSnapshot) {
                val taskList = mutableListOf<Pair<String, Task>>()
                snapshot.children.forEach { child ->
                    child.getValue(Task::class.java)?.let { task ->
                        taskList.add(child.key!! to task)
                    }
                }
                onDataChange(taskList)
            }

            override fun onCancelled(error: DatabaseError) {

            }

        })

    }
}