package com.example.spacex.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.fragment.app.Fragment
import com.example.spacex.R
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val bottomNav: BottomNavigationView = findViewById(R.id.bottomNavigationView)
        bottomNav.setOnNavigationItemSelectedListener(navListener)

        supportFragmentManager.beginTransaction().replace(R.id.frag_container, CompanyFragment()).commit()

    }

    private val navListener: BottomNavigationView.OnNavigationItemSelectedListener =
        BottomNavigationView.OnNavigationItemSelectedListener { item: MenuItem ->
            var selectedFragment: Fragment? = null
            when (item.itemId) {
                R.id.company -> selectedFragment = CompanyFragment()
                R.id.rockets -> selectedFragment = RocketsFragment()
                R.id.launchpads -> selectedFragment = LaunchesFragment()
                R.id.missions -> selectedFragment = MissionsFragment()
            }
            if (selectedFragment != null) {
                supportFragmentManager.beginTransaction().replace(
                    R.id.frag_container, selectedFragment
                ).commit()
            } else {
                supportFragmentManager.beginTransaction().replace(
                    R.id.frag_container, CompanyFragment()
                ).commit()
            }
            true
        }
}