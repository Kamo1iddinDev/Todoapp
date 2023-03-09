package com.example.todoapp

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.todoapp.catche.MySharepreference
import com.example.todoapp.databinding.ActivityMain2Binding

class MainActivity2 : AppCompatActivity() {
    private val binding by lazy { ActivityMain2Binding.inflate(layoutInflater)}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    @SuppressLint("SetTextI18n")
    override fun onStart() {
        super.onStart()
        binding.apply {
            MySharepreference.init(this@MainActivity2)
            val list  = MySharepreference.obektString
            val name = intent.getStringExtra("name")
            var index = -1
            for (i in 0 until list.size){
                if (list[i].name == name){
                index = i
                when(list[index].checkboxId.toInt()) {
                    0->radOpen.isChecked = true
                    1->radDevelopment.isChecked = true
                    2->radUploading.isChecked = true
                    3->radReject.isChecked = true
                    4->radClosed.isChecked = true
                }

                    description.text = "${description.text} \n ${list[i].description}"
                    createDate.text = "${createDate.text} \n ${list[i].createDate}"
                    deadline.text = "${deadline.text} \n ${list[i].deadline}"
                    degreeImg.setImageResource(list[i].degresPictures.toInt())
                    degree.text= list[index].degres
                }
            }

            btn1.setOnClickListener {
                var chIndex = ""
                if (radOpen.isChecked)chIndex= "0"
                if (radDevelopment.isChecked)chIndex= "1"
                if (radUploading.isChecked)chIndex= "2"
                if (radReject.isChecked)chIndex= "3"
                if (radClosed.isChecked)chIndex= "4"
                finish()
                list[index].checkboxId = chIndex
                MySharepreference.obektString = list
             }
        }
    }
}