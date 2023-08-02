package com.ndkdemoexample.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.util.Log
import com.ndkdemoexample.databinding.ActivityJnicallbackBinding
import com.ndkdemoexample.`interface`.JNIListener

class JNICallBackScreen:AppCompatActivity(),JNIListener
{
    private lateinit var binding: ActivityJnicallbackBinding
    var count:Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityJnicallbackBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textView.text = count.toString()

        val myListener: JNIListener = object : JNIListener{
            override fun callBackWithValue(data: Int)
            {
                binding.textView.text = data.toString()
            }

        }
        initCallBack(myListener)

        binding.btnDecrement.setOnClickListener {
            changeValue(count--)
        }

        binding.btnIncrement.setOnClickListener {
            changeValue(count++)
        }

    }


    external fun initCallBack(jniCallBack:JNIListener):Void
    external fun changeValue(value: Int):Void

    companion object {
        init {
            System.loadLibrary("ndkdemoexample")
        }
    }

    override fun callBackWithValue(data: Int) {

       Log.d("callBackWithValue",""+data.toString())
    }

    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        super.onBackPressed()

        val intent = Intent(this, HomeScreen::class.java)
        intent.flags = (Intent.FLAG_ACTIVITY_NEW_TASK)
        intent.flags = ( Intent.FLAG_ACTIVITY_CLEAR_TOP)
        startActivity(intent)
        finish()
    }
}