package com.example.synchronoss2

import android.content.Intent
import android.net.Uri
import android.nfc.Tag
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class Activity3 : AppCompatActivity() {
    lateinit var ed1Name: EditText //declarartion
    lateinit var tvMain : TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_3)
        setContentView(R.layout.activity_3)
        ed1Name = findViewById(R.id.ed1Name)
        Log.i(TAG,"im in oncreate")
    }

    override fun onStart() {
        super.onStart()
        Log.i(TAG,"Starting UI visible")
    }

    override fun onResume() {
        super.onResume()
        Log.i(TAG, "resuming-restore state")
    }

    override fun onPause() {
        super.onPause()
        Log.i(TAG, "pausing-save state ")
    }

    override fun onStop() {
        super.onStop()
        Log.i(TAG, "Stopping")
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.i(TAG, "Destroying")
    }

    fun clickhandler(viewclick: View) {
       // Log.e(TAG,"click handler")

        when(viewclick.id){
            R.id.btnLogin -> {startHomeActivity()}
            R.id.btnDail -> {startDialer()}
            R.id.btnAlarm -> {createAlarm("sync",12,53)}

        }
              print("outside")
    }

    private fun startDialer() {
        var a = 10;
        var b = a * 20;

        add(10,20)

        for(i in 1..10){
            var c = a * i
            var f = 30
            var z =  c + f

        }
        throw NullPointerException("dial ex")
        var dIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:123456"))
        startActivity(dIntent)
    }

    /**
     * This is add method
     */
    private fun add(i: Int, i1: Int) {

    }

    private fun startHomeActivity() {
        Log.e(TAG, "click handler")
        var name = ed1Name.text.toString()


        var hIntent = Intent(this,HomeActivity::class.java)
        //hIntent.putExtra("nkey",name)
        startActivity(hIntent)


    }
    fun createAlarm(message: String, hour: Int, minutes: Int) {
        val intent = Intent(AlarmClock.ACTION_SET_ALARM).apply {
            putExtra(AlarmClock.EXTRA_MESSAGE, message)
            putExtra(AlarmClock.EXTRA_HOUR, hour)
            putExtra(AlarmClock.EXTRA_MINUTES, minutes)
        }
        if (intent.resolveActivity(packageManager) != null) {
            startActivity(intent)
        }
    }
    companion object{
        var TAG = MainActivity::class.java.simpleName
    }


}