package com.example.kontrolinis

import android.os.Bundle
import android.os.Handler
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity2 : AppCompatActivity() {

    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        textView = findViewById(R.id.textView_showRecievedText)

        val receivedText = intent.getStringExtra("rarr")

        if (receivedText != null) {
            val words = receivedText.split(" ") // Split the text into words

            displayWordsOneByOne(words, receivedText)
        }
    }

    private fun displayWordsOneByOne(words: List<String>, receivedText: String) {
        var index = 0
        val delayMillis = 1000L

        val handler = Handler()

        fun showNextWord() {
            if (index < words.size) {
                textView.text = words[index]
                index++
                handler.postDelayed({ showNextWord() }, delayMillis)
            } else {
                // All words have been displayed, now show the word count
                val wordCount = words.size
                val finalText = receivedText + "\nWord Count: $wordCount"
                textView.text = finalText
            }
        }

        showNextWord()
    }
}
