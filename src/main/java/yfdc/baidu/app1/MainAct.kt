package yfdc.baidu.app1

import android.os.Bundle
import android.text.Html
import android.view.KeyEvent
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.felipecsl.gifimageview.library.GifImageView
import yfdc.Center
import android.content.pm.ActivityInfo
import kotlin.system.exitProcess

public final class MainAct() : AppCompatActivity() {
    private var dialog: EditDialog? = null;
    private var phoneStr: TextView? = null
    private var addressStr: TextView? = null
    private fun screen() {
        if (requestedOrientation != ActivityInfo.SCREEN_ORIENTATION_PORTRAIT) {
            requestedOrientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        screen()
        setContentView(R.layout.wrap)
        phoneStr = findViewById(R.id.phone_num)
        addressStr = findViewById(R.id.place)
        val ct: Center? = findViewById(R.id.center)
        if (ct !== null) {
            ct.ivb.startAnimation()
        }
        dialog = EditDialog(this)
        doThing("130****7905", "上海市")
        val ig: GifImageView = findViewById(R.id.gif_view)!!
        ig.setOnLongClickListener {
            dialog?.show()
            true
        }
    }

    override fun onStart() {
        super.onStart()
        screen()
    }
    override fun onResume() {
        super.onResume()
        screen()
    }
    override fun onRestart() {
        super.onRestart()
        screen()
    }
    fun htmlString(address: String): CharSequence {
        val address1 = StringBuilder()
        address1.append(address)
        if (address[address.length - 1] == '*') {
            address1.append(MainApplication.getInstance().badCity)
        }
        return Html.fromHtml(resources.getString(R.string.love, address1.toString()))
    }

    fun doThing0(phone: String?, address: String?) {
        MainApplication.getInstance().sp.run {
            edit().apply {
                putString("phone", phone ?: "130****7905")
                putString("address", address ?: "上海市")
            }.apply()
        }
        var phone0 = ""
        phone0 = Center.phone(phone)
        phone0 = resources.getString(R.string.phone, phone0)
        phoneStr?.text = phone0
        addressStr?.text = htmlString(address ?: "上海市")
    }

    private fun doThing(phone: String?, address: String?) {
        val msp = MainApplication.getInstance().sp
        if (msp.contains("phone") || msp.contains("address")) {
            var phone1: String? = msp.getString("phone", "130****7905") ?: "130****7905"
            phone1 = Center.phone(phone1)
            phone1 = resources.getString(R.string.phone, phone1)
            phoneStr?.text = phone1
            phone1 = msp.getString("address", "上海市") ?: "上海市"
            addressStr?.text = htmlString(phone1 ?: "")
        } else {
            MainApplication.getInstance().sp.run {
                edit().apply {
                    putString("phone", phone ?: "130****7905")
                    putString("address", address ?: "上海市")
                }.apply()
            }
            var phone0 = resources.getString(R.string.phone, phone ?: "130****7905")
            phone0 = Center.phone(phone0)
            phone0 = resources.getString(R.string.phone, phone0)
            phoneStr?.text = phone0
            addressStr?.text = htmlString(address ?: "上海市")
        }
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        if (keyCode == 4 || keyCode == 111) {
            finish()
            return true
        }
        return super.onKeyDown(keyCode, event)
    }
    override fun onDestroy() {
        super.onDestroy()
        exitProcess(0)
        //throw java.lang.RuntimeException()
    }
}