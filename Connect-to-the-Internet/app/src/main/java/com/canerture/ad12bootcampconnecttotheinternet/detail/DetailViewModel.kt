package com.canerture.ad12bootcampconnecttotheinternet.detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.canerture.ad12bootcampconnecttotheinternet.network.CharacterModel

class DetailViewModel(character: CharacterModel, app: Application): AndroidViewModel(app) {

    private val _selectedCharacter = MutableLiveData<CharacterModel>()
    val selectedCharacter: LiveData<CharacterModel>
        get() = _selectedCharacter

    init {
        _selectedCharacter.value = character
    }

}