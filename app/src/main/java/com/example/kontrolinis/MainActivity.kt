package com.example.kontrolinis

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.AutoCompleteTextView
import android.widget.Button
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val items = arrayOf("GAI - Antano Gustaičio aviacijos institutas",
            "AIF - Aplinkos inžinerijos fakultetas",
            "AF - Architektūros fakultetas",
            "EF - Elektronikos fakultetas",
            "FMF - Fundamentinių mokslų fakultetas")

        val adapter = ArrayAdapter(this, android.R.layout.simple_dropdown_item_1line, items)
        val autoCompleteTextView = findViewById<AutoCompleteTextView>(R.id.autoCompleteTextView_Firstpage)
        autoCompleteTextView.setAdapter(adapter)

        findViewById<Button>(R.id.button_Firstpage).setOnClickListener {
            val text = findViewById<AutoCompleteTextView>(R.id.autoCompleteTextView_Firstpage).text.toString()
//            Toast.makeText(this,"$text", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("rarr", text)
            startActivity(intent)
        }



    }
}