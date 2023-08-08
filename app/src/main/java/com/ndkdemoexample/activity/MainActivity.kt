package com.ndkdemoexample.activity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.Toast
import com.ndkdemoexample.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var numFirst:Int = 0
    var numSecond:Int = 0

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        binding.btnCalculate.setOnClickListener {
            var ans=0

            val numberFirst = binding.etNum1.text.toString()
            val numberSecond = binding.etNum2.text.toString()

            if(numberFirst.isEmpty() || numberSecond.isEmpty())
                showToast("Please enter two numbers")
            else{
                numFirst= Integer.parseInt(numberFirst)
                numSecond= Integer.parseInt(numberSecond)
            }

            if(binding.rbAdd.isChecked){
                ans=add(numFirst, numSecond)
            }
            else if(binding.rbSub.isChecked){

                ans=sub(numFirst, numSecond)
            }
            else if(binding.rbMul.isChecked){
                ans=multiply(numFirst, numSecond)
            }
            else if(binding.rbDiv.isChecked){
                ans=divide(numFirst, numSecond)
            }
            else{
                showToast("Please select an operation")
            }
            binding.tvAns.visibility = View.VISIBLE
            binding.tvAns.text = "Answer: $ans"

        }

        // Example of a call to a native method
        binding.tvWelCome.text = stringFromJNI()


    }

    @SuppressLint("SetTextI18n")
    private fun showToast(message: String) {
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
        binding.tvAns.text = "Answer: $0"
    }

    /**
     * A native method that is implemented by the 'ndkdemoexample' native library,
     */
    external fun stringFromJNI(): String
    external fun add(x: Int, y: Int): Int
    external fun sub(x: Int, y: Int): Int
    external fun multiply(x: Int, y: Int): Int
    external fun divide(x: Int, y: Int): Int


    companion object {
        init {
            System.loadLibrary("calculator-lib")
        }
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