package com.example.navigation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    companion object {
        const val CODE = 123
        const val PARAM = "text"
    }

    private var btn: Button? = null
    private var txtView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn = findViewById(R.id.btn_next)
        txtView = findViewById(R.id.text)

        btn?.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra(PARAM, "Some message")
            startActivityForResult(intent, CODE)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == CODE) {
            Toast.makeText(this, data?.getStringExtra("text") ?: "Nothing", Toast.LENGTH_SHORT).show()
            txtView?.text = data?.getStringExtra("text") ?: "Nothing"
            Log.d("TAG", "onActivityResult: $requestCode  $resultCode")
        } else {
            super.onActivityResult(requestCode, resultCode, data)
        }
    }
}