package com.example.synchronoss2

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.nfc.Tag
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock
import android.util.Log
import android.view.ContextMenu
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import android.widget.ProgressBar
import androidx.core.app.NotificationCompat


class Activity3 : AppCompatActivity() , View.OnFocusChangeListener {
    lateinit var ed1Name: EditText //declarartion
    lateinit var tvMain: TextView
    lateinit var loginButton: Button
    lateinit var progressBar: ProgressBar


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_3)
        setContentView(R.layout.activity_3)
        ed1Name = findViewById(R.id.ed1Name)
        loginButton = findViewById(R.id.btnLogin)
        progressBar = findViewById(R.id.progressBar)

        registerForContextMenu(loginButton)
        Log.i(TAG, "im in oncreate")
        ed1Name.setOnFocusChangeListener(this)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.mi_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        super.onOptionsItemSelected(item)
        when (item.itemId) {
            R.id.misetting -> {
                Toast.makeText(this, "opening settings", Toast.LENGTH_SHORT).show()
            }
            R.id.miLogout -> {
                Toast.makeText(this, "logging out", Toast.LENGTH_SHORT).show()

            }
        }
        return true
    }

    override fun onCreateContextMenu(
        menu: ContextMenu?,
        v: View?,
        menuInfo: ContextMenu.ContextMenuInfo?
    ) {
        super.onCreateContextMenu(menu, v, menuInfo)
        menuInflater.inflate(R.menu.main_context, menu)
    }

    override fun onContextItemSelected(item: MenuItem): Boolean {
        super.onContextItemSelected(item)
        when (item.itemId) {
            R.id.mi_Edit -> {
                Toast.makeText(this, " editing", Toast.LENGTH_SHORT).show()
            }
            R.id.mi_Delete -> {
                Toast.makeText(this, "deleting", Toast.LENGTH_SHORT).show()

            }
        }
        return true
    }

    fun clickHandler(viewclick: View) {
        // Log.e(TAG,"click handler")

        when (viewclick.id) {
            R.id.btnLogin -> {
                startHomeActivity()
            }
            R.id.btnDial -> {
                startDialer()
            }
            R.id.btnAlarm -> {
                createAlarm("sync", 12, 53)
            }
            R.id.btnMTest -> {
                getSetData()
            }
            R.id.btnDownloads -> {
                downloadImage()
            }
            R.id.btnNotify ->{(showNotification())}

        }
        print("outside")
    }

    private fun showNotification() {
        createNotificationChannel()
        val intent = Intent(this,HomeActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
        }

        val pendingIntent: PendingIntent = PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_IMMUTABLE)

        var builder = NotificationCompat.Builder(this,"CHANNEL_ID")
            .setSmallIcon(com.google.android.material.R.drawable.ic_clock_black_24dp)
            .setContentTitle("Sync-3")
            .setContentText("Android And Kotlin Training")
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setContentIntent(pendingIntent)


        val notificationManager: NotificationManager =
            getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        notificationManager.notify(123,builder.build())
    }
       private fun  createNotificationChannel() {
           if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
               val name = "Sync Promos Channel  Name"
               val descriptionText = "This shows Notification wwrt Sync Promos"
               val importance = NotificationManager.IMPORTANCE_DEFAULT
               val channel = NotificationChannel("CHANNEL_ID",name,importance).apply {
                   description =  descriptionText
               }
                val  notificationManager: NotificationManager =
                    getSystemService(Context.NOTIFICATION_SERVICE)  as NotificationManager
               notificationManager.createNotificationChannel(channel)

           }
       }



    private fun downloadImage() {
        var downloadTask = DownloadTask(progressBar)
        downloadTask.execute("http://imagedownload.url.com")
    }

    private fun getSetData() {
        var name = ed1Name.text.toString()
        tvMain.setText(name)

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
    override fun onActivityResult(requestCode: Int, resultCode: Int, dIntent: Intent?) {
        super.onActivityResult(requestCode, resultCode, dIntent)
        if(resultCode == RESULT_OK) {
            var contactData = dIntent?.extras?.getString("con")
            tvMain.text = contactData
        }
    }

    override fun onFocusChange(p0: View?, isFocussed: Boolean) {
        if(isFocussed){
            Toast.makeText(this,"focussed",Toast.LENGTH_SHORT).show()
        }
        else{
            Toast.makeText(this,"lost focus",Toast.LENGTH_SHORT).show()
        }
    }

}




