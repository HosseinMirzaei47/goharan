package com.carpet.goharshad

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.carpet.goharshad.domain.settings.GetChosenThemeUseCase
import com.carpet.goharshad.domain.settings.GetLanguageUseCase
import com.carpet.goharshad.ui.utils.Event
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val getChosenThemeUseCase: GetChosenThemeUseCase,
    private val getLanguageUseCase: GetLanguageUseCase
) : ViewModel() {

    private var firstLaunch = false

    private var _languageChanged = MutableLiveData<Event<Unit>>()
    val languageChanged: LiveData<Event<Unit>> get() = _languageChanged

    private val _onFabClick = MutableLiveData<Event<Unit>>()
    val onFabClick: LiveData<Event<Unit>> get() = _onFabClick

    private var _chosenTheme = MutableLiveData<Event<Int>>()
    val chosenTheme: LiveData<Event<Int>> get() = _chosenTheme

    private var _bottomNavIsGone = MutableLiveData<Boolean>()
    val bottomNavIsGone: LiveData<Boolean> get() = _bottomNavIsGone

    init {
        onAppLanguageChanged()
    }

    fun openTaskFragment() {
        _onFabClick.value = Event(Unit)
    }

    private fun onGetSelectedTheme() {
        getChosenThemeUseCase.setParameter(Unit).asLiveTask {
            onSuccess {
                if (!firstLaunch) {
                    firstLaunch = true
                } else {
                    _chosenTheme.postValue(Event(it))
                }
            }
        }.run()
    }

    private fun onAppLanguageChanged() {
        getLanguageUseCase.setParameter(Unit).asLiveTask {
            onSuccess {
                if (!firstLaunch) {
                    firstLaunch = true
                } else {
                    _languageChanged.postValue(Event(Unit))
                }
            }
        }.run()
    }

    fun onBottomNavVisibilityChange(isGone: Boolean) {
        _bottomNavIsGone.value = isGone
    }
}