package com.angad.intent

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.angad.intent.databinding.ActivityProfileBinding

class ProfileActivity : AppCompatActivity() {

//    Creating an instance of binding
    private lateinit var binding: ActivityProfileBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

//        Initialised binding
        binding  = ActivityProfileBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

//        On click go to next activity
        onClickGoToNextButton()
    }

    private fun onClickGoToNextButton() {
        binding.nextActivityBtn.setOnClickListener {
            val name = binding.name.text.toString()
            val fname = binding.fatherName.text.toString()
            val rollNo = binding.rollNo.text.toString()
            val phoneNo = binding.phoneNo.text.toString()

            val intent = Intent(this, BundleActivity::class.java)
            intent.putExtra("name", name)
            intent.putExtra("fname", fname)
            intent.putExtra("rollNo", rollNo)
            intent.putExtra("phoneNo", phoneNo)

            if (name.isEmpty() || fname.isEmpty() ||rollNo.isEmpty() || phoneNo.isEmpty()){
                Toast.makeText(this, "Please enter full details", Toast.LENGTH_SHORT).show()
            }
            else{
                startActivity(intent)
            }
        }
    }
}