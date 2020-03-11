package com.jurnal6.courtcounter

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel(){

    private val _scorea = MutableLiveData<Int>()
    val scorea: LiveData<Int>
        get() =_scorea

    private val _scoreb = MutableLiveData<Int>()
    val scoreb: LiveData<Int>
        get() =_scoreb

    init {
        _scorea.value = 0
        _scoreb.value = 0
    }

    fun addScore(score: Int, team: String){
        if(team.equals("a")){
            _scorea.value = (scorea.value)?.plus(score)
        }
        else if(team.equals("b")){
            _scoreb.value = (scoreb.value)?.plus(score)
        }
    }

    fun resetScore(){
        _scorea.value = 0
        _scoreb.value = 0
    }

}