package com.s0l.mvrxsample.ui

import com.airbnb.mvrx.MavericksState
import java.util.*

data class BaseState(val date: Date = Date()) : MavericksState