package com.example.luckynumberapp

import android.content.Intent
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.luckynumberapp.databinding.ActivityMainBinding
import com.example.luckynumberapp.ui.theme.LuckyNumberAppTheme

class MainActivity : ComponentActivity() {

    companion object {
        const val KEY= "name"
    }

   private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {

            val userName = binding.editTextText.text

            intent = Intent(this, LuckyNumber::class.java)

            intent.putExtra(KEY, userName)

            startActivity(intent)
        }
    }
}