package com.example.luckynumberapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.luckynumberapp.databinding.ActivityLuckyNumberBinding
import com.example.luckynumberapp.databinding.ActivityMainBinding
import java.util.Random

class LuckyNumber : AppCompatActivity() {

    private lateinit var binding: ActivityLuckyNumberBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLuckyNumberBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val username = receiveUsername()
        val randomNumber = generateRandomNumber()
        binding.textView3.text = ""+randomNumber

        binding.button2.setOnClickListener {

            shareData(username, randomNumber)

        }
    }
    private fun receiveUsername():String {
        val receiveData= intent.getStringExtra(MainActivity.KEY).toString()
        return receiveData
    }
    private fun generateRandomNumber():Int {
        val random = Random().nextInt(100)
        return random
    }
    private fun shareData(username:String, num:Int){
        intent = Intent(Intent.ACTION_SEND)
        intent.type = "text/plain"
        intent.putExtra(Intent.EXTRA_SUBJECT, "$username is lucky today")
        intent.putExtra(Intent.EXTRA_TEXT, "his lucky number is $num")
        startActivity(intent)
    }
}