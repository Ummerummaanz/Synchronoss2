package com.example.synchronoss2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
         super.onCreateOptionsMenu(menu)
        menuInflater.inflate(R.menu.mi_menu,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
         super.onOptionsItemSelected(item)
        when (item.itemId){
            R.id.misetting -> {
                Toast.makeText(this,   "opening settings",Toast.LENGTH_SHORT).show()
            }
            R.id.miLogout -> {
                Toast.makeText(this,   "logging out",Toast.LENGTH_SHORT).show()

            }
        }
        return true
    }
}