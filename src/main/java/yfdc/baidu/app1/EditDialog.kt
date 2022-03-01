package yfdc.baidu.app1
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.EditText
class EditDialog(private val mContext: Context) : Dialog(mContext) {
    init {
        android.util.Log.d("EditDialog","default")
    }
    @JvmField @Volatile public var phone:String? = null;
    @JvmField @Volatile public var address:String? = null;
    private var phone_et_field:EditText? = null
    private var address_et_field:EditText? = null
    override fun show(){
        phone_et_field?.setText("")
        address_et_field?.setText("")
        super.show()
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        val _this = this
        super.onCreate(savedInstanceState)
        val a = LayoutInflater.from(mContext)!!.inflate(R.layout.insert_dialog,null,false)
        val pa:ViewGroup.LayoutParams = ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT)
        setContentView(a,pa)
        setCancelable(false)
        setCanceledOnTouchOutside(false)
        val phone_et:EditText = findViewById(R.id.phone)!!
        val address_et:EditText = findViewById(R.id.address)!!
        phone_et_field = phone_et
        address_et_field = address_et
        val btn = a.findViewById<android.widget.Button>(R.id.btn_ok)!!
        btn.setOnClickListener {
            if(phone_et.text.isNullOrEmpty()){
                MainApplication.makeAppToast(mContext,"insert phone number!",0).show()
                return@setOnClickListener
            }
            if(address_et.text.isNullOrEmpty()){
                MainApplication.makeAppToast(mContext,"insert address!",0).show()
                return@setOnClickListener
            }
            if(phone_et.text.length!=11){
                MainApplication.makeAppToast(mContext,"insert phone number right",0).show()
                return@setOnClickListener
            }
            synchronized(_this){
                phone = phone_et.text.toString()
                address = address_et.text.toString()
                var thing = Thing().apply {
                    this.phone = _this.phone
                    this.address = _this.address
                }
                (mContext as MainAct).doThing0(phone,address)
            }
            _this.dismiss()
        }
    }
}