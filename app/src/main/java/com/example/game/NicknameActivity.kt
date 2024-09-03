// NicknameActivity.kt
package com.example.game

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class NicknameActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nickname)

        val etNickname = findViewById<EditText>(R.id.etNickname)
        val btStart = findViewById<Button>(R.id.btStart)

        btStart.setOnClickListener {
            val nickname = etNickname.text.toString()
            val intent = Intent(this, MainActivity::class.java)
            intent.putExtra("NICKNAME", nickname)
            startActivity(intent)
        }
    }
}