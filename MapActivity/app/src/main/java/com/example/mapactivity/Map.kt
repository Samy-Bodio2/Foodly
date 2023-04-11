package com.example.mapactivity

import android.content.Context
import android.preference.PreferenceManager
import android.view.ViewGroup
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.viewinterop.AndroidView
import androidx.navigation.NavHostController
import org.osmdroid.config.Configuration
import org.osmdroid.tileprovider.tilesource.TileSourceFactory
import org.osmdroid.util.GeoPoint
import org.osmdroid.views.MapView
import org.osmdroid.views.overlay.mylocation.GpsMyLocationProvider
import org.osmdroid.views.overlay.mylocation.MyLocationNewOverlay

class OSMMapView(context: Context) : MapView(context) {
    init {
        Configuration.getInstance().load(context, PreferenceManager.getDefaultSharedPreferences(context))
        setTileSource(TileSourceFactory.MAPNIK)
        controller.setZoom(12.0)
        controller.setCenter(GeoPoint(48.8583, 2.2944))

        // Ajouter une instance de MyLocationNewOverlay pour afficher la position de l'utilisateur
        val myLocationOverlay = MyLocationNewOverlay(GpsMyLocationProvider(context), this)
        myLocationOverlay.enableMyLocation()
        overlays.add(myLocationOverlay)
    }
}

@Composable
fun OSMMap(modifier: Modifier = Modifier) {
    AndroidView(
        modifier = modifier.fillMaxSize(),
        factory = { context ->
            OSMMapView(context).apply {
                layoutParams = ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT,
                    ViewGroup.LayoutParams.MATCH_PARENT
                )
            }
        }
    )
}

@Composable
fun MapView(navController: NavHostController){
    OSMMap()
}

