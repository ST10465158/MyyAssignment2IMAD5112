package vcmsa.ci.myyassignment2

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    // Array containing five quiz questions
    private val questions = arrayOf(
        "Apartheid ended in 1994",
        "Nelson Mandela spent over 100 years in prison",
        "Jan Van Riebick discovered the Cape",
        "'Hamlet' was written by Shakespeare",
        "The boiling point of water is 55 degrees celsius"
        //Author: Zahra Bulbula
        // URL: https://github.com/zb662000/Assignment2/blob/main/app/src/main/java/com/example/game1/MainActivity.kt
    )
    // here are the corresponding answers to the questions above
    private val answers = arrayOf(
        "True", "False", "True", "True", "False"
        //Author: Zahra Bulbula
        // URL: https://github.com/zb662000/Assignment2/blob/main/app/src/main/java/com/example/game1/MainActivity.kt
    )
    // This is going to track user's score and current question index
    private var score = 0
    private var currentIndex = 0
    // The total number of questions
    private val questionLimit = 5
    //Author: Zahra Bulbula
    // URL: https://github.com/zb662000/Assignment2/blob/main/app/src/main/java/com/example/game1/MainActivity.kt

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // Declaring the UI components
        val questionText = findViewById<TextView>(R.id.questionText)
        val answerInput = findViewById<EditText>(R.id.answerInput)
        val submitButton = findViewById<Button>(R.id.submitButton)
        val scoreText = findViewById<TextView>(R.id.scoreText)
        val restartButton = findViewById<Button>(R.id.restartButton)
        // this is a function to display the current question and reset input field
        fun showQuestion() {
            questionText.text = questions[currentIndex] // this is going to display the question
            answerInput.text.clear() // Clearing the previous answer
            submitButton.isEnabled = true // This will re-enable button if disabled
            answerInput.isEnabled = true
            restartButton.visibility = View.GONE // This will hide the restart button until end
            //Author: Zahra Bulbula
            // URL: https://github.com/zb662000/Assignment2/blob/main/app/src/main/java/com/example/game1/MainActivity.kt
        }

        showQuestion() // Showing the first question when app starts
        //submit button click
        submitButton.setOnClickListener {
            val userAnswer = answerInput.text.toString().trim()
            // Checking if the user's answer matches the correct answer
            if (userAnswer.equals(answers[currentIndex], ignoreCase = true)) {
                score++ // Increases score for correct answer
            }
            currentIndex++
            // Checking if there are more questions
            if (currentIndex < questionLimit) {
                showQuestion()
            } else {
                questionText.text = "Quiz Finished!"
                submitButton.isEnabled = false // disabling inputs
                answerInput.isEnabled = false
                restartButton.visibility = View.VISIBLE // This will show a restart option
                //Author: Zahra Bulbula
                // URL: https://github.com/zb662000/Assignment2/blob/main/app/src/main/java/com/example/game1/MainActivity.kt
            }
            // This will update score display after each answer
            scoreText.text = "Score: $score"
        }
        // This button will restart quiz from beginning
        restartButton.setOnClickListener {
            score = 0
            currentIndex = 0
            scoreText.text = "Score: $score"
            showQuestion() // this will reload first question
            //Author: Zahra Bulbula
            // URL: https://github.com/zb662000/Assignment2/blob/main/app/src/main/java/com/example/game1/MainActivity.kt
        }
    }
}