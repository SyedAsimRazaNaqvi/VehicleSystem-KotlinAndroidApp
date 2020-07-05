package pk.edu.iqra.vehiclesystem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnLogin.setOnClickListener {
            val intent = Intent(this,LoginActivity::class.java)
            startActivity(intent)
        }

        btnSearch.setOnClickListener {
            val intent = Intent(this,activitySearch::class.java)
            startActivity(intent)
        }


        btnSell.setOnClickListener {
            val intent = Intent(this,SellActivity::class.java)
            startActivity(intent)
        }
    }
}
