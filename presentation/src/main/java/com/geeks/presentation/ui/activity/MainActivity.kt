package com.geeks.presentation.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.fragment.NavHostFragment
import com.geeks.presentation.R
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        this.setTheme(R.style.Theme_GeekLocation)
//        startDestination()
    }


//    private fun startDestination() {
//        val navHostFragment =
//            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
//        val navController = navHostFragment.navController
//        val navGraph = navController.navInflater.inflate(R.navigation.nav_graph)
//
//        val currentUser = auth.currentUser
//
//        if (currentUser != null) {
//            navGraph.setStartDestination(R.id.mapsFragment)
//        } else {
//            navGraph.setStartDestination(R.id.authFragment)
//        }
//    }
}