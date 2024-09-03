package com.example.game

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var questions: ArrayList<Question>
    var position = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        loadQuestion()
        setupViews()
    }

    private fun loadQuestion() {
        questions = ArrayList()
        var question = Question("¿Es Chile la capital del Mundo?", false)
        questions.add(question)

        questions.add(Question("¿Es Chile la capital de Lima?", false))
        questions.add(Question("¿Es Santiago la capital de Chile?", true))
        questions.add(Question("¿Es Buenos Aires la capital de Argentina?", true))
        questions.add(Question("¿Es Quito la capital de Chile?", false))

    }

    private fun setupViews() {
        val btYes = findViewById<Button>(R.id.btYes)
        val btNo = findViewById<Button>(R.id.btNo)
        val btNext = findViewById<Button>(R.id.btNext)
        val tvQuestion = findViewById<TextView>(R.id.tvQuestion)

        tvQuestion.text = questions[position].sentence

        btYes.setOnClickListener{
            if (questions[position].answer){
                Toast.makeText(this,"Respuesta correcta!!!!",Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this,"Respuesta incorrecta!!!!",Toast.LENGTH_SHORT).show()
            }
        }

        btNo.setOnClickListener{
            if (!questions[position].answer){
                Toast.makeText(this,"Respuesta correcta!!!!",Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this,"Respuesta incorrecta!!!!",Toast.LENGTH_SHORT).show()
            }
        }

        btNext.setOnClickListener{
            position++
            tvQuestion.text = questions[position].sentence
        }
    }
}