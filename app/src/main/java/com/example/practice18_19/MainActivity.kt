package com.example.practice18_19

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun onSendData(selectedItem: String?) {
        val fragment = supportFragmentManager
            .findFragmentById(R.id.infoFragment) as BreedInfoFragment?
        if (fragment != null && fragment.isVisible){
            fragment.setSelectedItem(selectedItem)
        }
        else{
            val intent = Intent(applicationContext,
                DetalisActivity::class.java)
            intent.putExtra(DetalisActivity.SELECTED_ITEM, selectedItem)
            startActivity(intent)
        }
        fragment?.setSelectedItem(selectedItem)
    }
}