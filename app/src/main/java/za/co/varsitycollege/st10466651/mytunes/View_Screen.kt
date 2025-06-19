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
        val outcome = findViewById<TextView>(R.id.txtDisplay)

        //Return Button
        back.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        //Display Button
        display.setOnClickListener {
                outcome.text = "Song: ${songs[0].title}\n" +
                        "Artist: ${songs[0].singer}\n" +
                        "Rating: ${songs[0].rate}\n" +
                        "Comment: ${songs[0].opinion}\n\n" +

                "Song: ${songs[1].title}\n" +
                        "Artist: ${songs[1].singer}\n" +
                        "Rating: ${songs[1].rate}\n" +
                        "Comment: ${songs[1].opinion}\n\n" +

                "Song: ${songs[2].title}\n" +
                        "Artist: ${songs[2].singer}\n" +
                        "Rating: ${songs[2].rate}\n" +
                        "Comment: ${songs[2].opinion}\n\n" +

                "Song: ${songs[3].title}\n" +
                        "Artist: ${songs[3].singer}\n" +
                        "Rating: ${songs[3].rate}\n" +
                        "Comment: ${songs[3].opinion}\n\n"

        }

        //Rate Button
        avg.setOnClickListener {
            val sum = "${songs[0].rate} ${songs[1].rate}"
            outcome.text = sum
        }
    }
}