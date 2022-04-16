package com.canerture.ad12bootcampconnecttotheinternet.overview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.canerture.ad12bootcampconnecttotheinternet.network.CharacterModel
import com.canerture.ad12bootcampconnecttotheinternet.network.HarryPotterApi
import kotlinx.coroutines.launch
import java.lang.Exception

enum class HarryPotterApiStatus { LOADING, ERROR, DONE }

enum class HarryPotterApiFilter(val filterWord: String) {
    SHOW_GRYFFINDOR("Gryffindor"),
    SHOW_HUFFLEPUFF("Hufflepuff"),
    SHOW_RAVENCLAW("Ravenclaw"),
    SHOW_SLYTHERIN("Slytherin")
}

class OverviewViewModel : ViewModel() {

    private val _status = MutableLiveData<HarryPotterApiStatus>()
    val status: LiveData<HarryPotterApiStatus>
        get() = _status

    private val _characters = MutableLiveData<List<CharacterModel>>()
    val characters: LiveData<List<CharacterModel>>
        get() = _characters

    private val _navigateToSelectedCharacter = MutableLiveData<CharacterModel?>()
    val navigateToSelectedCharacter: LiveData<CharacterModel?>
        get() = _navigateToSelectedCharacter

    init {
        getCharacters()
    }

    private fun getCharacters() {

        viewModelScope.launch {

            _status.value = HarryPotterApiStatus.LOADING

            try {
                _characters.value = HarryPotterApi.retrofitService.getCharacters().characters
                _status.value = HarryPotterApiStatus.DONE
            } catch (e: Exception) {
                _status.value = HarryPotterApiStatus.ERROR
                _characters.value = ArrayList()
            }
        }
    }

    fun filterCharacters(filter: HarryPotterApiFilter) {

        viewModelScope.launch {

            _status.value = HarryPotterApiStatus.LOADING

            try {
                _characters.value = HarryPotterApi.retrofitService.filterCharacters(filter.filterWord).characters
                _status.value = HarryPotterApiStatus.DONE
            } catch (e: Exception) {
                _status.value = HarryPotterApiStatus.ERROR
                _characters.value = ArrayList()
            }
        }
    }

    fun displayCharacterDetail(characterModel: CharacterModel) {
        _navigateToSelectedCharacter.value = characterModel
    }

    fun displayCharacterDetailComplete() {
        _navigateToSelectedCharacter.value = null
    }
}