package com.carpet.goharshad

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.carpet.goharshad.ui.utils.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ContactUsViewModel @Inject constructor(

) : ViewModel() {

    private var _onPhoneClicked = MutableLiveData<Event<Unit>>()
    val onPhoneClicked: LiveData<Event<Unit>> get() = _onPhoneClicked

    private var _onWhatsAppClicked = MutableLiveData<Event<Int>>()
    val onWhatsAppClicked: LiveData<Event<Int>> get() = _onWhatsAppClicked

    private var _onEmailClicked = MutableLiveData<Event<Unit>>()
    val onEmailClicked: LiveData<Event<Unit>> get() = _onEmailClicked

    fun onPhoneClicked() {
        _onPhoneClicked.value = Event(Unit)
    }

    fun onWhatsAppClicked() {
        _onWhatsAppClicked.value = Event(R.string.phone_number_two)
    }

    fun onEmailClicked() {
        _onEmailClicked.value = Event(Unit)
    }

}