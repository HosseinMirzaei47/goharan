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

    fun onPhoneClicked() {
        _onPhoneClicked.value = Event(Unit)
    }

}