package com.example.oau_barter

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toolbar
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI

class MainActivity : AppCompatActivity() {

    private var navHostFragment: NavHostFragment? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_container) as NavHostFragment
        NavigationUI.setupActionBarWithNavController(this, navHostFragment!!.navController)

    }

    override fun onSupportNavigateUp(): Boolean {
        return navHostFragment!!.navController.navigateUp()
    }

    @SuppressLint("NewApi")
    override fun setActionBar(toolbar: Toolbar?) {
        navHostFragment?.navController?.addOnDestinationChangedListener { controller, destination, arguments ->
            if (destination.id == R.id.loginFragment){
                toolbar?.navigationIcon = null
            }
        }

        super.setActionBar(toolbar)
    }
}