package com.angad.intent

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.angad.intent.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    //    Creating instance of view binding
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

//        Initialised binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(binding.main) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

//        On click open web page button to Open web page
        onClickWebPageButton()

//        On click open phone call button to open phone call
        onClickPhoneCallButton()

//        On click open camera button to open camera
        onCLickOpenCameraButton()

//        On click share message button to share message with various messaging app
        onClickShareMessageButton()

//        On click Go to profile page i.e., showing the use of explicit intent
        onClickGoToProfileButton()
    }

    //    Function that open web page or application of provided link
    private fun onClickWebPageButton() {
        binding.openWebPage.setOnClickListener {
            val intent = Intent(
                Intent.ACTION_VIEW,
                Uri.parse("https://www.youtube.com/watch?v=7AckvzGj_vI&list=PLUhfM8afLE_NQbVaoIEhceR9npbY57Pdg&index=60")
            )
            startActivity(intent)
        }
    }

//    Function that open phone call
    private fun onClickPhoneCallButton() {
        binding.openPhoneCall.setOnClickListener {
            val intent = Intent(Intent.ACTION_DIAL)
            intent.data = Uri.parse("tel: 8400175672")
            startActivity(intent)
        }
    }

//    Function that open camera to click photo
    private fun onCLickOpenCameraButton() {
        binding.openCamera.setOnClickListener {
            //    For open camera or photo, video we use MediaStone
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivity(intent)
        }
    }

//    Function that share the message
    private fun onClickShareMessageButton() {
        binding.shareMessage.setOnClickListener {
            //    Getting message from editText
            val message = binding.message.text.toString()
            val intent = Intent(Intent.ACTION_SEND)
            intent.type = "text/plain"
            intent.putExtra(Intent.EXTRA_TEXT, message)
            if (message.isEmpty()){
                Toast.makeText(this, "Please enter the message", Toast.LENGTH_SHORT).show()
            }
            else{
                startActivity(Intent.createChooser(intent, "Share Via"))
            }
        }
    }

//    Explicit Intent
    private fun onClickGoToProfileButton() {
        binding.profile.setOnClickListener {
            startActivity(Intent(this, ProfileActivity::class.java))
        }
    }
}