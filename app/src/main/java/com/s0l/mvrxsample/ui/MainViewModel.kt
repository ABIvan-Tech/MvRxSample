package com.s0l.mvrxsample.ui

import androidx.lifecycle.MutableLiveData
import com.airbnb.mvrx.MavericksViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.*


class MainViewModel(initialState: BaseState) : MavericksViewModel<BaseState>(initialState) {

    private val jobTimer = Job()

    var currentDate = MutableLiveData(Date())

    fun startShowTime() {
        viewModelScope.launch(jobTimer) {
            while (true){
                delay(1000)
                //setState { copy(date = Date()) }
                currentDate.postValue(Date())
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        jobTimer.cancelChildren()
    }
}
