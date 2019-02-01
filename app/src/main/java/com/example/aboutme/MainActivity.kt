package com.example.aboutme

import android.content.Context
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.example.aboutme.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val myName: MyName = MyName("Parth Joshi")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_main)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.myName = myName

        /*findViewById<Button>(R.id.done).setOnClickListener {
            addNickName(it)
        }*/
        binding.done.setOnClickListener { addNickName(it) }
    }

    private fun addNickName(view: View) {
        /*val button = findViewById<Button>(R.id.done)
        val editText = findViewById<EditText>(R.id.nickname_edit)
        val nickName = findViewById<TextView>(R.id.nickname_text)*/

        binding.apply {
            //nicknameText.text = nicknameEdit.text
            myName?.nickName = nicknameEdit.text.toString()
            invalidateAll()
            nicknameText.visibility = View.VISIBLE
            nicknameEdit.visibility = View.GONE
            done.visibility = View.GONE
        }

        // Hide the keyboard
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }
}
