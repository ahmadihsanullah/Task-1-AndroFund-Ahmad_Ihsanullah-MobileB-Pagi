package infinite.learning.belajarandroiddasar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.result.contract.ActivityResultContracts
import infinite.learning.belajarandroiddasar.data.User

class LoginActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var loginButton: Button
    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText
    private lateinit var historyTextView : TextView

    //activity result
    val resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
        result ->
        if(result.resultCode == RESULT_OK){
            //jika kodenya ok
            val data : Intent? = result.data
            //paket yang akan dipanggil dari mainactivity
            val returnString : String? = data?.getStringExtra("history")
            historyTextView.text = returnString
        }

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        usernameEditText = findViewById(R.id.usernameEditText)
        passwordEditText = findViewById(R.id.passwordEditText)
        historyTextView = findViewById(R.id.history)

        val bundle = intent.extras
        if(bundle != null){
            usernameEditText.setText(bundle.getString("username"))
            passwordEditText.setText(bundle.getString("password"))
        }

        loginButton = findViewById(R.id.loginButton)
        loginButton.setOnClickListener(this)

    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.loginButton -> {
                val intent: Intent = Intent(this, MainActivity::class.java)
                intent.putExtra("user", User(usernameEditText.text.toString() , passwordEditText.text.toString()))
//                startActivity(intent)
                resultLauncher.launch(intent)
            }
        }
    }
}