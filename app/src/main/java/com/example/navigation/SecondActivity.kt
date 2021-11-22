package com.example.navigation

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.navigation.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    private var btn: Button? = null
    private var text: TextView? = null
    private var editTxt: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        btn = findViewById(R.id.btn_back)
        text = findViewById(R.id.text)
        editTxt = findViewById(R.id.edit_text)

        text?.text = intent.getStringExtra(MainActivity.PARAM)

        btn?.setOnClickListener {
            val intent = Intent()
            intent.putExtra("text", editTxt?.text.toString())
            Log.d("TAG", "onCreate: ${editTxt?.text.toString()}")
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}