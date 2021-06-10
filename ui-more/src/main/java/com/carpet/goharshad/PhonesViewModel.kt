package com.carpet.goharshad

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.carpet.goharshad.ui.utils.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class PhonesViewModel @Inject constructor() : ViewModel() {

    private var _onNumberOneClicked = MutableLiveData<Event<Int>>()
    val onNumberOneClicked: LiveData<Event<Int>> get() = _onNumberOneClicked

    private var _onNumberTwoClicked = MutableLiveData<Event<Int>>()
    val onNumberTwoClicked: LiveData<Event<Int>> get() = _onNumberTwoClicked

    private var _onNumberThreeClicked = MutableLiveData<Event<Int>>()
    val onNumberThreeClicked: LiveData<Event<Int>> get() = _onNumberThreeClicked

    fun onNumberOneClicked() {
        _onNumberOneClicked.value = Event(R.string.phone_number_one)
    }

    fun onNumberTwoClicked() {
        _onNumberTwoClicked.value = Event(R.string.phone_number_two)
    }

    fun onNumberThreeClicked() {
        _onNumberThreeClicked.value = Event(R.string.phone_number_three)
    }

}