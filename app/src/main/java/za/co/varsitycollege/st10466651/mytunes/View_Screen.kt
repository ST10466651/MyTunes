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

class ViewScreen : AppCompatActivity() {
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
        val rate = findViewById<Button>(R.id.btnAvgRatings)

        //TextView Declared
        val outcome = findViewById<TextView>(R.id.txtDisplay)

        //Return Button
        back.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        //Display Button
        display.setOnClickListener {
            outcome.text = "${songs[0].title}\n" +
                "${songs[0].singer}\n" +
                "${songs[0].rate}\n" +
                "${songs[0].opinion}\n\n"
        }
    }
}