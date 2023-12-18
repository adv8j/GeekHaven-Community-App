package com.example.geekhavencommunityapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.geekhavencommunityapp.R
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.example.geekhavencommunityapp.fragments.community
import com.example.geekhavencommunityapp.fragments.feed
import com.example.geekhavencommunityapp.fragments.profile
import com.example.geekhavencommunityapp.fragments.project

class BaseHomeActivity : AppCompatActivity() {

    private val fragment1 = feed()
    private val fragment2 = project()
    private val fragment3 = community()
    private val fragment4 = profile()

    private val onNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_item1 -> {
                    loadFragment(fragment1)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_item2 -> {
                    loadFragment(fragment2)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_item3 -> {
                    loadFragment(fragment3)
                    return@OnNavigationItemSelectedListener true
                }
                R.id.navigation_item4 -> {
                    loadFragment(fragment4)
                    return@OnNavigationItemSelectedListener true
                }
            }
            false
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navView: BottomNavigationView = findViewById(R.id.bottom_navigation)
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)

        // Default fragment on startup
        loadFragment(fragment1)
    }

    private fun loadFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.nav_host_fragment, fragment)
            .commit()
    }
}
