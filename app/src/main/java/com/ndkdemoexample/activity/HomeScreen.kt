package com.ndkdemoexample.activity
import android.content.DialogInterface
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import com.ndkdemoexample.R
import com.ndkdemoexample.databinding.HomeScreenBinding


class HomeScreen : AppCompatActivity()
{

    private lateinit var binding: HomeScreenBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportActionBar?.hide()
        binding = HomeScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnJniCallBack.setOnClickListener {
            val intent = Intent(this, JNICallBackScreen::class.java)
            intent.flags = (Intent.FLAG_ACTIVITY_NEW_TASK)
            intent.flags = ( Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
            finish()
        }
        binding.btnNdkCal.setOnClickListener {

            val intent = Intent(this, MainActivity::class.java)
            intent.flags = (Intent.FLAG_ACTIVITY_NEW_TASK)
            intent.flags = ( Intent.FLAG_ACTIVITY_CLEAR_TOP)
            startActivity(intent)
            finish()
        }

    }

}
