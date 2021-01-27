package android.example.sharedpreferences

import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var mUsername:EditText
    private lateinit var mPassword:EditText
    private lateinit var login:Button
    private lateinit var mCheckBox: CheckBox
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        sharedPreferences = applicationContext?.getSharedPreferences(getString(R.string.preference_file_key), MODE_PRIVATE)!!;
        var editor = sharedPreferences.edit();



        mUsername = findViewById<EditText>(R.id.username)
        mPassword = findViewById<EditText>(R.id.password)
        login = findViewById<Button>(R.id.login)
        mCheckBox = findViewById<CheckBox>(R.id.remember_me)

        checkPreferences()


        login.setOnClickListener {
            if (mCheckBox.isChecked){

                editor.putString(getString(R.string.preference_username), mUsername.text.toString())
                editor.putString(getString(R.string.preference_password), mPassword.text.toString())
                editor.putString(getString(R.string.preference_check_box), "True")
                editor.apply()
                intent = Intent(this, WelcomeActivity::class.java)
                startActivity(intent)
            }else{
                editor.putString(getString(R.string.preference_username), "")
                editor.putString(getString(R.string.preference_password), "")
                editor.putString(getString(R.string.preference_check_box), "False")
                editor.apply()
            }
        }


    }

    /**
     * We check preferences initially so we can set our values accordingly
     * initially preferences will call default value which are empty strings
     * and string False
     */

    private fun checkPreferences(){
        val username = sharedPreferences.getString(getString(R.string.preference_username), "")
        val password = sharedPreferences.getString(getString(R.string.preference_password), "")
        val checkBox = sharedPreferences.getString(getString(R.string.preference_check_box), "False")

        mUsername.setText(username)
        mPassword.setText(password)

        mCheckBox.isChecked = checkBox!!.equals("True")

    }
}