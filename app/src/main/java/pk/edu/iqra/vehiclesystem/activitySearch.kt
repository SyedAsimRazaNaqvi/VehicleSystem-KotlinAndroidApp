package pk.edu.iqra.vehiclesystem

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.database.*
import com.squareup.picasso.Picasso

class activitySearch : AppCompatActivity() {

    lateinit var mrecyclerView: RecyclerView
    lateinit var ref : DatabaseReference
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_search)

        mrecyclerView = findViewById(R.id.recyclerview)
        ref = FirebaseDatabase.getInstance().getReference().child("Vehicle")
// ======================================================================================Liner layout
        mrecyclerView.layoutManager = LinearLayoutManager(this)

        val option = FirebaseRecyclerOptions.Builder<model>()
            .setQuery(ref,model::class.java)
            .build()

        val firebaseRecyclerAdapter = object : FirebaseRecyclerAdapter<model, MyViewHolder>(option){
            override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
                val itemview = LayoutInflater.from(this@activitySearch).inflate(R.layout.list_activity,parent,false)
                return MyViewHolder(itemview)
            }

            override fun onBindViewHolder(holder: MyViewHolder, position: Int, model: model) {
                val refid=getRef(position).key.toString()

                ref.child(refid).addValueEventListener(object: ValueEventListener {
                    override fun onCancelled(p0: DatabaseError) {

                    }

                    override fun onDataChange(p0: DataSnapshot) {
//                        data that is view in recyclerview
//                        holder.make_m.setText(model.maker)
                        holder.model_m.setText(model.model)
                        holder.seller_m.setText(model.seller_name)
                        Picasso.get().load(model.Image).into(holder.image_m)

                        // Button inside recyclerView Item
                        holder.dial_m.setOnClickListener {

                            val intent = Intent(Intent.ACTION_DIAL)
                            intent.data = Uri.parse("tel:"+model.contact)
                            startActivity(intent)

                        }

                        holder.email_m.setOnClickListener {
                            val textToshare = model.seller_name
                            val intent = Intent()

                            intent.putExtra(Intent.EXTRA_TEXT,textToshare)
                            intent.type="text/plain"

                            startActivity(Intent.createChooser(intent,"Choose Email app : "))
                        }

                        holder.share_m.setOnClickListener {
                            val textToshare = model.seller_name

                            val intent=Intent()
                            intent.action = Intent.ACTION_SEND

                            intent.putExtra(Intent.EXTRA_TEXT,textToshare)
                            intent.type="text/plain"

                            startActivity(Intent.createChooser(intent,"Share to : "))

                        }

                        holder.itemView.setOnClickListener{
                            val intent = Intent(this@activitySearch,DetailActivity::class.java)
                            intent.putExtra("image_intent",model.Image)
                            intent.putExtra("make_intent",model.maker)
//                            intent.putExtra("year_intent",model.year)
                            intent.putExtra("km_intent",model.km)
                            intent.putExtra("fuel_intent",model.fuel)
                            intent.putExtra("model_intent",model.model)
                            intent.putExtra("seller_intent",model.seller_name)
                            intent.putExtra("price_intent",model.price)
///                           intent.putExtra("trans_intent",model.city)

                            startActivity(intent)

                        }

                    }

                })
            }

        }


        mrecyclerView.adapter = firebaseRecyclerAdapter
        firebaseRecyclerAdapter.startListening()

    }

    class MyViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){

//        var make_m : TextView = itemView.findViewById<TextView>(R.id.make_show)
        var model_m : TextView = itemView.findViewById<TextView>(R.id.model_show)
        var seller_m : TextView = itemView.findViewById<TextView>(R.id.seller_show)
        var image_m : ImageView = itemView.findViewById(R.id.imageVehicle)



        // Button inside recyclerView Item
        var dial_m : Button =itemView.findViewById(R.id.btn_dial)
        var share_m : Button =itemView.findViewById(R.id.btn_share)
        var email_m : Button =itemView.findViewById(R.id.btn_email)

    }
}
