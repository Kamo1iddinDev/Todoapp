package com.example.todoapp

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.todoapp.Models.Todo
import com.example.todoapp.catche.MySharepreference
import com.example.todoapp.databinding.ActivityTodolistBinding
import com.example.todoapp.`object`.ToDoList

class Todolist : AppCompatActivity() {
    private val binding by lazy { ActivityTodolistBinding.inflate(layoutInflater) }
    lateinit var map: HashMap<String, ArrayList<Todo>>
    lateinit var groupList: ArrayList<String>
    lateinit var myExpendibleAdapter: MyExpendibleAdapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }
    override fun onResume() {
        super.onResume()
        binding.apply {

            groupList = ArrayList()

            groupList.add("Open")
            val openList = ArrayList<Todo>()
            groupList.add("Development")
            val developmentList = ArrayList<Todo>()
            groupList.add("Uploading")
            val uploadingList = ArrayList<Todo>()
            groupList.add("Reject")
            val rejectList = ArrayList<Todo>()
            groupList.add("Closed")
            val closedList = ArrayList<Todo>()
            MySharepreference.init(this@Todolist)
            ToDoList.todoList = MySharepreference.obektString
            ToDoList.todoList.forEach {
                when (it.checkboxId) {
                    "0" -> openList.add(it)
                    "1" -> developmentList.add(it)
                    "2" -> uploadingList.add(it)
                    "3" -> rejectList.add(it)
                    "4" -> closedList.add(it)
                }
            }
            map = HashMap()
            map[groupList[0]] = openList
            map[groupList[1]] = developmentList
            map[groupList[2]] = uploadingList
            map[groupList[3]] = rejectList
            map[groupList[4]] = closedList
            myExpendibleAdapter = MyExpendibleAdapter(map, groupList)
            expendibleLv.setAdapter(myExpendibleAdapter)
            val inten = Intent(this@Todolist, MainActivity2::class.java)
            expendibleLv.setOnChildClickListener { parent, v, groupPosition, childPosition, id ->
                inten.putExtra("name", map[groupList[groupPosition]]?.get(childPosition)?.name)
                startActivity(inten)
                finish()
                true
            }
        }
    }
}