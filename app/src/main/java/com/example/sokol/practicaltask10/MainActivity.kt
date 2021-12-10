package com.example.sokol.practicaltask10

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

private const val TAG = "MyTag"

class MainActivity : AppCompatActivity() {

    lateinit var bottomNavigationMenu:BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationMenu=findViewById(R.id.bottom_navigation_menu)

        bottomNavigationMenu.setOnItemSelectedListener { item ->
            var fragment: Fragment? = null

            when (item.itemId) {

                R.id.music -> {
                    fragment = MusicFragment()
                }
                R.id.gallery -> {
                    fragment = FotoFragment()
                }
                R.id.video -> {
                    fragment = VideoFragment()
                }
            }

            replaceFragment(fragment!!)

            true


        }
    }
    fun replaceFragment(fragment: Fragment){
        supportFragmentManager
            .beginTransaction()
            .replace(R.id. fragment_container,fragment)
            .addToBackStack(fragment.tag)
            .commit()
    }

}

