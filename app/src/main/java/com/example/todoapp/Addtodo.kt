package com.example.todoapp

import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.todoapp.Models.SpinnerItem
import com.example.todoapp.Models.Todo
import com.example.todoapp.catche.MySharepreference
import com.example.todoapp.databinding.ActivityAddtodoBinding
import com.example.todoapp.`object`.ToDoList

class Addtodo : AppCompatActivity() {
    private val binding by lazy { ActivityAddtodoBinding.inflate(layoutInflater) }
    private lateinit var listspinner:ArrayList<SpinnerItem>
    private lateinit var spinnerAdapter: SpinnierAdapter
    private lateinit var mySharepreference:MySharepreference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        listspinner = ArrayList()
        listspinner.add(SpinnerItem("To do degree ", -1))
        listspinner.add(SpinnerItem("Urgent", R.drawable.reg_flag))
        listspinner.add(SpinnerItem("High", R.drawable.yellow_flag))
        listspinner.add(SpinnerItem("Normal", R.drawable.blue_flag))
        listspinner.add(SpinnerItem("Low", R.drawable.gray_flag))

        spinnerAdapter = SpinnierAdapter(listspinner)
        binding.spinner.adapter = spinnerAdapter

        val name  = binding.edt1.text
        val desciption  = binding.edt2.text
        val createdata  = binding.edt3.text
        val deadline  = binding.edt4.text
        val checboxid  = 0
        var degree  = ""
        var degreeImage  = 0

        binding.spinner.onItemSelectedListener = object :AdapterView.OnItemSelectedListener{
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long,
            ) {
                degree = listspinner[position].degree
                degreeImage = listspinner[position].image
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }
        MySharepreference.init(this)

        binding.btnSave.setOnClickListener {
            if (name.isEmpty()|| createdata.isEmpty() || deadline.isEmpty() || degree.isEmpty() || desciption.isEmpty() || degreeImage == -1  ){
                Toast.makeText(this, "Maydoni to'ldiring!", Toast.LENGTH_SHORT).show()
            }else{
                ToDoList.todoList.add(
                Todo(
                    "$name",
                    "$desciption",
                    "$degree",
                    "$degreeImage",
                    "$createdata",
                    "$deadline",
                    "$checboxid",
                )
                )
                MySharepreference.obektString = ToDoList.todoList
                finish()
            }
        }
    }
}