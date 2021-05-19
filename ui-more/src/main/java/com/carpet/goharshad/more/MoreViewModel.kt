package com.carpet.goharshad.more

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.carpet.goharshad.ui.utils.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MoreViewModel @Inject constructor() : ViewModel() {

    private var _onContactUsClicked = MutableLiveData<Event<Unit>>()
    val onContactUsClicked: LiveData<Event<Unit>> get() = _onContactUsClicked

    private var _onHistoryClicked = MutableLiveData<Event<Unit>>()
    val onHistoryClicked: LiveData<Event<Unit>> get() = _onHistoryClicked

    private var _onDisclaimerClicked = MutableLiveData<Event<Unit>>()
    val onDisclaimerClicked: LiveData<Event<Unit>> get() = _onDisclaimerClicked

    fun onContactUsClicked() {
        _onContactUsClicked.value = Event(Unit)
    }

    fun onHistoryClicked() {
        _onHistoryClicked.value = Event(Unit)
    }

    fun onDisclaimerClicked() {
        _onDisclaimerClicked.value = Event(Unit)
    }

}