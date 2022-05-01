package com.example.myapplication

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel : ViewModel()  {

    private val _turn = MutableLiveData(0)
    val turn: LiveData<Int> = _turn
    private val _winner:MutableLiveData<String> = MutableLiveData<String>()
    val winner: LiveData<String> = _winner

    val board = ArrayList<MutableLiveData<String>>()
    init {
        (1..10).forEach { _ ->
            board.add(MutableLiveData(""))
        }
    }

    fun onClick(index: Int) =
        viewModelScope.launch(Dispatchers.IO) {
            if (board[index].value != "") {
                return@launch
            }
            val user = if (_turn.value!! % 2 == 0) "○" else "×"
            board[index].postValue(user)
            _turn.postValue(_turn.value!!.plus(1))
        }

    fun onChangeValue(index: Int, count: Int) {
        val user = (board[index].value ?: "")
        //123
        if (checkTriad(0, 1, 2)) {
            _winner.postValue(user)
            return
        }

        //456
        if (checkTriad(3, 4, 5)) {
            _winner.postValue(user)
            return
        }

        //789
        if (checkTriad(6, 7, 8)) {
            _winner.postValue(user)
            return
        }

        //147
        if (checkTriad(0, 3, 6)) {
            _winner.postValue(user)
            return
        }

        //258
        if (checkTriad(1, 4, 7)) {
            _winner.postValue(user)
            return
        }

        //369
        if (checkTriad(2, 5, 8)) {
            _winner.postValue(user)
            return
        }

        //斜めやる？
        //159
        if (checkTriad(0, 4, 8)) {
            _winner.postValue(user)
            return
        }

        //753
        if (checkTriad(6, 4, 2)) {
            _winner.postValue(user)
            return
        }
        if (count == 9) {
            _winner.postValue("NONE")
            return
        }
    }

    private fun checkTriad(index1: Int, index2: Int, index3: Int): Boolean {
        if (board[index1].value == "") {
            return false
        }
        if (board[index2].value == "") {
            return false
        }
        if (board[index3].value == "") {
            return false
        }
        if (board[index1].value != board[index3].value
            || board[index1].value != board[index2].value) {
            return false
        }
        return true
    }
}
