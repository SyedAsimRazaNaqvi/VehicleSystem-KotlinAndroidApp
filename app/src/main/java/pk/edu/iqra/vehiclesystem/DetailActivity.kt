package pk.edu.iqra.vehiclesystem

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*

class DetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val bundle:Bundle? = intent.extras
        val Image = bundle!!.getString("image_intent")
        val maker= bundle!!.getString("make_intent")
        val year= bundle!!.getString("year_intent")
        val km= bundle!!.getString("km_intent")
        val fuel= bundle!!.getString("fuel_intent")
        val model= bundle!!.getString("model_intent")
        val seller_name= bundle!!.getString("seller_intent")
//        val price= bundle!!.getString("price_intent")
//        val transmission= bundle!!.getString("trans_intent")
//        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()
//        txvUserMessage.text=msg

        Smaker.text=maker
        Skm.text=km
        Sfuel.text=fuel
        Smodel.text=model
        SsalerN.text=seller_name

        Picasso.get().load(Image).into(image_detail)

        //        Syear.text=year
        //        Sprice.text=price
        //        Stransmission.text=transmission

btnFav.setOnClickListener {

    Toast.makeText(this,"Vehicle Added in favorites",Toast.LENGTH_LONG).show()
    val intent= Intent(this,MainActivity::class.java)
    startActivity(intent)


}

    }
}
