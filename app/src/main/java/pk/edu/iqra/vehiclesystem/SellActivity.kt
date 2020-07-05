package pk.edu.iqra.vehiclesystem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_sell.*

class SellActivity : AppCompatActivity() {

    var downloadUrl:String = ""

    lateinit var editModel : EditText
//    lateinit var editYear : EditText
    lateinit var editSellerName : EditText
    lateinit var editFuel : EditText
    lateinit var editType : EditText
    lateinit var editKM : EditText
//    lateinit var editPrice : EditText
//    lateinit var editCity : EditText
//    lateinit var editEmail : EditText
    lateinit var editContact : EditText
    lateinit var buttonSubmit : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sell)

//make, model, mileage, attractive images, description, specs, features, city,

        editModel = findViewById(R.id.editModel)
        editSellerName = findViewById(R.id.editsellerName)
        editFuel = findViewById(R.id.editFuel)
//        editYear =findViewById(R.id.edityear)
        editType = findViewById(R.id.editType)
        editKM = findViewById(R.id.editKm)
//        editPrice = findViewById(R.id.editPrice)
//        editCity = findViewById(R.id.editCity)
//        editEmail = findViewById(R.id.editEmail)
        editContact = findViewById(R.id.editContact)

        buttonSubmit = findViewById(R.id.btnSubmit)

        btnSubmit.setOnClickListener {
            AddVehicle()
        }
    }

    private fun AddVehicle(){
        val Model = editModel.text.toString().trim()
        val maker=editmaker.text.toString().trim()
        val Seller_name = editSellerName.text.toString().trim()
        val fuel = editFuel.text.toString().trim()
        val Type = editType.text.toString().trim()
        val Km = editKM.text.toString().trim()
        val Contact = editContact.text.toString().trim()
//        val City = editCity.text.toString().trim()
//        val Year = editYear.text.toString().trim()
//        val Price = editPrice.text.toString().trim()
//        val Email = editEmail.text.toString().trim()



        if (Model.isEmpty() || Seller_name.isEmpty() || fuel.isEmpty() || Type.isEmpty() ||  Km.isEmpty() || Contact.isEmpty()){
            editModel.error="Please enter all fields"
            editSellerName.error="Please enter all fields"
            editFuel.error="Please enter all fields"
            editType.error="Please enter all fields"
   //         editYear.error="Please enter all fields"
            editKM.error="Please enter all fields"
//            editPrice.error="Please enter all fields"
//            editEmail.error="Please enter all fields"
            editContact.error="Please enter all fields"
//            editCity.error="Please enter all fields"
        }
        val ref = FirebaseDatabase.getInstance().getReference("Vehicle")

        val modelId = ref.push().key

        val model = model(modelId,Model,maker,Seller_name,fuel,Type,Km,Contact)

        ref.child(modelId!!).setValue(model).addOnCompleteListener{
        Toast.makeText(applicationContext,"Vehicle Details Added", Toast.LENGTH_LONG).show()

        }
    }
}
