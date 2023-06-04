package com.geeks.presentation.base

import android.Manifest
import android.content.Context
import android.content.Intent
import android.os.Build
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.Fragment
import android.provider.Settings

class RequestPermission {

    fun requestPermission(
        fragment: Fragment,
        context: Context,
    ) {

        val locationPermissionRequest = fragment.registerForActivityResult(
            ActivityResultContracts.RequestMultiplePermissions()
        ) { permission ->

            when {
                permission.getOrDefault(Manifest.permission.ACCESS_FINE_LOCATION, false) -> {
                    Toast.makeText(
                        context,
                        "Доступ к местоположению предоставлен",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                permission.getOrDefault(Manifest.permission.ACCESS_COARSE_LOCATION, false) -> {
                    Toast.makeText(
                        context,
                        "Only approximate location access granted",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                else -> {
                    if (!fragment.shouldShowRequestPermissionRationale(Manifest.permission.ACCESS_FINE_LOCATION)) {
                        fragment.startActivity(
                            Intent(
                                Settings.ACTION_LOCATION_SOURCE_SETTINGS
                            )
                        )
                    }
                }
            }
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
            locationPermissionRequest.launch(
                arrayOf(
                    Manifest.permission.ACCESS_FINE_LOCATION,
                    Manifest.permission.ACCESS_COARSE_LOCATION,
                    Manifest.permission.ACCESS_BACKGROUND_LOCATION
                )
            )
        }
    }
}
