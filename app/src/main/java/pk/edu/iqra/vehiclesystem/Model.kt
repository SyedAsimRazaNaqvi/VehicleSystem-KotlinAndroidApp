package pk.edu.iqra.vehiclesystem

class model {
    var Image : String? = null
    val modelId :String? = null
    var model : String? = null
    var seller_name : String? = null
    var maker : String? = null
    var contact : String? = null
    var email : String? = null
    var fuel : String? = null
    var type : String? = null
    var km : String? = null
    var price : String? =null
//    var city : String? = null
//    var year : String? = null

    //make, model, mileage, attractive images, description, specs, features, city,

    constructor():this("","","","","","","","")

//Image:String?,
    //maker:String,
//    constructor(modelId:String?,Model : String?,seller_name:String,contact:String,email:String,fuel:String,type:String,km:String,year:String,price:String,city:String){
//        this.Image =Image

    //(modelId,Model,maker,Seller_name,fuel,Type,Km,Contact)
constructor(modelId:String?,Model : String?,seller_name:String?,maker:String?,fuel:String?,type:String?,km:String?,contact:String?)
    {
        this.modelId
        this.model =Model
        this.seller_name =seller_name
        this.maker =maker
        this.fuel =fuel
        this.type =type
        this.km =km
//      this.year =year
//      this.type =type
//      this.contact =contact
//      this.email =email
//      this.price=price
//      this.city=city

    }
}