package com.angad.intent

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.angad.intent.databinding.ActivityBundleBinding

class BundleActivity : AppCompatActivity() {

//    Creating an instance of binding
    private lateinit var binding: ActivityBundleBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

//        Initialised the binding
        binding = ActivityBundleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //    creating an object of intent
        val intent = intent

//        Getting the data from profile activity and display into the BundleActivity using bundle
        binding.showName.text = "Name: ${intent.getStringExtra("name")}"
        binding.showFatherName.text = "Father Name: ${intent.getStringExtra("fname")}"
        binding.showRollNo.text = "Roll No: ${intent.getStringExtra("rollNo")}"
        binding.showPhoneNo.text = "Phone Number: ${intent.getStringExtra("phoneNo")}"
    }
}