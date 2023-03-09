package com.example.todoapp

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.todoapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        binding.apply {
            addTodo.setOnClickListener {
                startActivity(Intent(this@MainActivity, Addtodo::class.java))
            }

         todoList.setOnClickListener {
             startActivity(Intent(this@MainActivity, Todolist::class.java))
         }

        }


    }
}