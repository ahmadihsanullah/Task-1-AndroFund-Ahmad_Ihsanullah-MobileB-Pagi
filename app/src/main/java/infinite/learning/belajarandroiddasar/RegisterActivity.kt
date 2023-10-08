package infinite.learning.belajarandroiddasar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class RegisterActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var registerButton : Button
    private lateinit var usernameEditText : EditText
    private lateinit var passwordEditText: EditText
    private lateinit var confirmPasswordEditText: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        usernameEditText = findViewById(R.id.usernameEditText)
        passwordEditText = findViewById(R.id.passwordEditText)
        confirmPasswordEditText = findViewById(R.id.confirmPasswordEditText)

        registerButton = findViewById(R.id.registerButton)
        registerButton.setOnClickListener(this)
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.registerButton -> {
                val bundle = Bundle()
                bundle.putString("username", usernameEditText.text.toString())
                bundle.putString("password", passwordEditText.text.toString())

                val intent : Intent = Intent(this, LoginActivity::class.java)
                intent.putExtras(bundle)
                startActivity(intent)
            }
        }
    }
}