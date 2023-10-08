package infinite.learning.belajarandroiddasar

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.fragment.app.Fragment
import infinite.learning.belajarandroiddasar.data.User
import infinite.learning.belajarandroiddasar.databinding.ActivityMainBinding
import infinite.learning.belajarandroiddasar.fragment.Fragement_1
import infinite.learning.belajarandroiddasar.fragment.Fragment_2

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var title: TextView
    private lateinit var implicitButton: Button
    private lateinit var binding : ActivityMainBinding
    private lateinit var fragment1Button : Button
    private lateinit var fragment2Button : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        title = findViewById(R.id.titleTextView)
        val username = intent.getParcelableExtra<User>("user")?.username
        val password = intent.getParcelableExtra<User>("user")?.password

        title.setText("Username : $username \n Password : $password")

        implicitButton = findViewById(R.id.implicitButton)
        implicitButton.setOnClickListener(this)

        //for fragment
//        fragment1Button = findViewById(R.id.fragment1)
//        fragment2Button = findViewById(R.id.fragment2)

        binding.fragment1.setOnClickListener{replaceFragment(Fragement_1())}
        binding.fragment2.setOnClickListener{replaceFragment(Fragment_2())}
    }

    override fun onClick(v: View) {
        when(v.id){
            R.id.implicitButton -> {
//                val message = "Hallo tes"
//                val intent = Intent()
//                intent.action = Intent.ACTION_SEND
//                intent.putExtra(Intent.EXTRA_TEXT, message)
//                intent.type= "text/plain"
//                startActivity(intent)

                val intent = Intent()
                intent.putExtra("history", "anda sudah login")
                setResult(RESULT_OK, intent)
                finish()
            }
        }
    }

    private fun replaceFragment(fragment: Fragment){
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fragmentContainer, fragment)
        fragmentTransaction.commit()
    }
}