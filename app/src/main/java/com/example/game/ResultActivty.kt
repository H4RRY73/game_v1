// ResultActivity.kt
package com.example.game

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val nickname = intent.getStringExtra("NICKNAME")
        val score = intent.getIntExtra("SCORE", 0)

        val tvResult = findViewById<TextView>(R.id.tvResult)
        tvResult.text = "Nickname: $nickname\nScore: $score"
    }
}