package com.example.practice18_19

import android.content.res.Configuration
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle


class DetalisActivity: AppCompatActivity() {
    companion object{
        const val SELECTED_ITEM = "SELECTED_ITEM"
    }
    var selectedItem = "Не выбрано"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        if(resources.configuration.orientation ==
            Configuration.ORIENTATION_LANDSCAPE){
            finish()
            return
        }

        setContentView(R.layout.activity_detail)

        val extras: Bundle? = intent.extras
        selectedItem = extras?.getString(SELECTED_ITEM).toString()
    }
    override fun onResume() {
        super.onResume()

        val fragment: BreedInfoFragment =
            supportFragmentManager.findFragmentById(R.id.detailFragment) as
                    BreedInfoFragment
        fragment?.setSelectedItem(selectedItem)
    }
}