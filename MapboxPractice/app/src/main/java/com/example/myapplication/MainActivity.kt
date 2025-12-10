package com.example.myapplication

import android.Manifest
import android.content.pm.PackageManager
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.core.content.ContextCompat
import com.mapbox.geojson.Point
import com.mapbox.maps.MapView
import com.mapbox.maps.MapboxMap
import com.mapbox.maps.Style
import com.mapbox.maps.extension.compose.MapEffect
import com.mapbox.maps.extension.compose.MapboxMap
import com.mapbox.maps.extension.compose.animation.viewport.rememberMapViewportState
import com.mapbox.maps.plugin.locationcomponent.location

class MainActivity : ComponentActivity() {

    //called when activity is created. savedInstanceState contains
    //previously saved state if activity is recreated
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //compose function that tells ui what to display
        setContent {
            //creates a state object that will control the camera
            val mapViewportState = rememberMapViewportState {
                setCameraOptions {
                    zoom(4.0)
                    center(Point.fromLngLat(-113.9828, 46.8603))
                    pitch(0.0)
                    bearing(0.0)
                }
            }

            // Handles location permissions
            var hasPermission by remember { mutableStateOf(false) }
            // android context; needed for permissions. LocalContext helps access the andriod system objects
            val context = LocalContext.current

            //creates a launcher for permission requests. Lambda runs when user responds to permission dialogue box
            val launcher = rememberLauncherForActivityResult(
                ActivityResultContracts.RequestMultiplePermissions()
            ) { permissions ->
                hasPermission = permissions[Manifest.permission.ACCESS_FINE_LOCATION] == true
            }

            //coroutine for when composable first enters composition. Unit means it only runs once
            LaunchedEffect(Unit) {
                hasPermission = ContextCompat.checkSelfPermission(
                    context,
                    Manifest.permission.ACCESS_FINE_LOCATION
                ) == PackageManager.PERMISSION_GRANTED

                //launch permission box if no permission granted
                if (!hasPermission) {
                    launcher.launch(arrayOf(
                        Manifest.permission.ACCESS_FINE_LOCATION,
                        Manifest.permission.ACCESS_COARSE_LOCATION
                    ))
                }
            }

            MapboxMap(
                Modifier.fillMaxSize(),
                mapViewportState = mapViewportState
            ) {
                if (hasPermission) {
                    MapEffect(Unit) { mapView ->
                        mapView.location.updateSettings {
                            enabled = true
                            pulsingEnabled = true
                        }
                    }
                }
            }
        }
    }
}
