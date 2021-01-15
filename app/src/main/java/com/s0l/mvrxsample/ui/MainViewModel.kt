package com.s0l.mvrxsample.ui

import com.airbnb.mvrx.MavericksViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.cancelChildren
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.*


class MainViewModel(initialState: BaseState) : MavericksViewModel<BaseState>(initialState) {

    private val jobTimer = Job()

    init {
        startShowTime()
    }

    private fun startShowTime() {
        viewModelScope.launch(jobTimer) {
            while (true){
                delay(1000)
                val date = Date()
                setState { copy(date = date) }
            }
        }
    }

    override fun onCleared() {
        super.onCleared()
        jobTimer.cancelChildren()
    }
}
