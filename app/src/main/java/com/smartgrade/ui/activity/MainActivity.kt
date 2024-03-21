package com.smartgrade.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import com.smartgrade.R
import com.smartgrade.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navController = findNavController(R.id.nav_host_fragment_activity)
        val appBarConfiguration = AppBarConfiguration(
            setOf(R.id.list_subject, R.id.add_subject)
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
    }
}