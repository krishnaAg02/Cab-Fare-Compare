package com.krishnaAg.CabCompare.ui.screen.home

import androidx.lifecycle.ViewModel
import com.krishnaAg.CabCompare.data.model.LocationPoint


class HomeViewModel : ViewModel() {

    var pickup: LocationPoint? = null
    var drop: LocationPoint? = null

    fun setPickup(location: LocationPoint) {
        pickup = location
    }

    fun setDrop(location: LocationPoint) {
        drop = location
    }
}