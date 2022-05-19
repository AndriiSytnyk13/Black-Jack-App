package com.miuelO6.netsb.com.viewmodel

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.miuelO6.netsb.com.R
import com.miuelO6.netsb.com.model.blaizersmoney.BlaizersMoneyDataStore
import com.miuelO6.netsb.com.model.blaizerssound.BlaizersSoundDataStore
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BlaizersMenuViewModel @Inject constructor(
    private val blaizersMoneyDataStore: BlaizersMoneyDataStore,
    val blaizersSoundDataStore: BlaizersSoundDataStore,
    private val blaizersApplication: Application,
) :
    AndroidViewModel(blaizersApplication) {

    private val _blaizersMoneyText = MutableLiveData<Int>()
    val blaizersMoneyText: LiveData<Int>
        get() {
            viewModelScope.launch {
                _blaizersMoneyText.value = blaizersMoneyDataStore.getblaizersMoney()
            }
            return _blaizersMoneyText
        }

    private val _blaizersSound = MutableLiveData<Boolean>()
    val blaizersSound: LiveData<Boolean>
        get() {
            viewModelScope.launch {
                _blaizersSound.value = blaizersSoundDataStore.getblaizersSound()
            }
            return _blaizersSound
        }


    fun addBlaizersChips() {
        viewModelScope.launch {
            if (_blaizersMoneyText.value == 0) {
                blaizersMoneyDataStore.editBlaizersMoney(300)
                _blaizersMoneyText.value = blaizersMoneyDataStore.getblaizersMoney()
                Toast.makeText(blaizersApplication,
                    R.string.blaizersChipsAdded,
                    Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(blaizersApplication,
                    R.string.blaizersEnoughChipsMessage,
                    Toast.LENGTH_SHORT).show()
            }
        }
    }

    //add sound effects
    fun switchBlaizersSound() {
        viewModelScope.launch {
            if (_blaizersSound.value == true) {
                blaizersSoundDataStore.switchBlaizersSound(false)
            } else {
                blaizersSoundDataStore.switchBlaizersSound(true)
            }
        }
    }
}


