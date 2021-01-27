package android.example.sharedpreferences

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class WelcomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val sharedPreferences = applicationContext?.getSharedPreferences(getString(R.string.preference_file_key), MODE_PRIVATE)
        val editor = sharedPreferences?.edit()
        val username = sharedPreferences?.getString(getString(R.string.preference_username), "")

        val welcomeText = findViewById<TextView>(R.id.welcome_text)

        welcomeText.text = "Hi ${username}"
    }
}