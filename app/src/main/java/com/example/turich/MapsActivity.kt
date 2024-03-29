package com.example.turich

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.BitmapDescriptorFactory
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MapStyleOptions
import com.google.android.gms.maps.model.MarkerOptions

class MapsActivity : AppCompatActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_maps)
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        val mapStyle = MapStyleOptions("""
            [
                {
                    "featureType": "poi",
                    "elementType": "all",
                    "stylers": [
                    {
                        "visibility": "off"
                    }
                    ]
                }
            ]
        """)
        mMap.setMapStyle(mapStyle)

        // Add a marker in Sydney and move the camera
        val plaza25 = LatLng(-27.451201, -58.986523)
        mMap.addMarker(MarkerOptions().position(plaza25).title("Plaza 25 de Mayo"))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(plaza25, 16.toFloat()))

        val parqueDemocracia = LatLng(-27.433168, -58.967543)
        mMap.addMarker(MarkerOptions()
            .position(parqueDemocracia)
            .title("Parque de la Democracia")
            .snippet("Parque cultural y recreativo"))
    }
}
