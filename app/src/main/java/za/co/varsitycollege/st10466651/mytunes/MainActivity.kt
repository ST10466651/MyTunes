package za.co.varsitycollege.st10466651.mytunes

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

//Mutable Array Globally Accessible
data class Songs(
    var title: String,
    var singer: String,
    var rate: Int,
    var opinion: String
)

val songs: MutableList<Songs> = mutableListOf(
    Songs("My Darling", "Chella", 4, "Great beats"),
    Songs("Isaka(6am)", "CIZA, Jazzworx", 3, "A bit repetative"),
    Songs("Show Me Love", "WizTheMc, bees & honey", 5, "Amazing after a long day"),
    Songs("Juicy", "Doja Cat, Tyga", 2, "It's not my type of music"),
)

//Global index
var index = 0

@Suppress("CAST_NEVER_SUCCEEDS")
class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        //Buttons Declared
        val next = findViewById<Button>(R.id.btnNext)
        val close = findViewById<Button>(R.id.btnClose)
        val add = findViewById<Button>(R.id.btnAdd)

        //Editable Text Declared
        val song = findViewById<EditText>(R.id.edtSongTitle)
        val artist = findViewById<EditText>(R.id.edtArtistName)
        val ratings = findViewById<EditText>(R.id.edtRatings)
        val comments = findViewById<EditText>(R.id.edtComments)

        //Terminate Button
        close.setOnClickListener {
            finishAffinity()
        }

        //Next Page Button
        next.setOnClickListener {
            val intent = Intent(this, View_Screen::class.java)
            startActivity(intent)
        }

        //Add to Playlist Button
        add.setOnClickListener {
            index = 4
            val titles = song.text.toString().trim().lowercase()
            val singers = artist.text.toString().trim().lowercase()
            val rates = ratings.text.toString().trim().lowercase()
            val opinions = comments.text.toString().trim().lowercase()


            if (titles.isEmpty() or singers.isEmpty() or rates.isEmpty() or opinions.isEmpty()) {
                val builder = AlertDialog.Builder(this)
                builder.setTitle("Input Required")
                builder.setMessage("Please enter required details")
                builder.setPositiveButton("OK") { dialog, _ ->
                    dialog.dismiss()
                }
                builder.create().show()
                return@setOnClickListener
            }


            songs[index].title = song.text.toString()
            songs[index].singer = artist.text.toString()
            songs[index].rate = ratings.text as Int
            songs[index].opinion = comments.text.toString()
            index++
        }
    }
}