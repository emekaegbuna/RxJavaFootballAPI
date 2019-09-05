package com.example.starwarsapi.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.starwarsapi.R

class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        addFragement()


    }


    private fun addFragement(){
        val fragmentManger = supportFragmentManager
        val fragmentTransaction = fragmentManger.beginTransaction()

        fragmentTransaction.add(R.id.fl_main, FragmentRV())
            //.addToBackStack(null)
            .commit()
    }


    /*override fun onAttachFragment(fragment: Fragment?) {
        super.onAttachFragment(fragment)


    }*/
}
