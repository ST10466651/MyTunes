package za.co.varsitycollege.st10466651.mytunes

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class View_Screen : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_view_screen)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Buttons Declared
        val display = findViewById<Button>(R.id.btnDisplay)
        val back = findViewById<Button>(R.id.btnReturn)
        val avg = findViewById<Button>(R.id.btnAvgRatings)

        //TextView Declared
        var outcome= findViewById<TextView>(R.id.txtDisplay)


        //Return Button
        back.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        //Display Button
        display.setOnClickListener {
            outcome.text = "Song: ${music[0]}\n" +
                    "Artist: ${singer[0]}\n" +
                    "Rating: ${rate[0]}\n" +
                    "Comment: ${opinion[0]}\n\n" +
                    "Song: ${music[1]}\n" +
                    "Artist: ${singer[1]}\n" +
                    "Rating: ${rate[1]}\n" +
                    "Comment: ${opinion[1]}\n\n" +
                    "Song: ${music[2]}\n" +
                    "Artist: ${singer[2]}\n" +
                    "Rating: ${rate[2]}\n" +
                    "Comment: ${opinion[2]}\n\n" +
                    "Song: ${music[3]}\n" +
                    "Artist: ${singer[3]}\n" +
                    "Rating: ${rate[3]}\n" +
                    "Comment: ${opinion[3]}\n\n"
        }

        //Rate Button
        avg.setOnClickListener {
            outcome.text = "Average: ${calculateAvgRating()}"
        }
    }
        fun calculateAvgRating(): Int{
            return if (rate.isNotEmpty()) {
                rate.sum() / rate.size
            } else {
                0
            }
        }
}