@file:Suppress("DEPRECATION")

package com.s0l.mvrxsample.ui

import android.annotation.SuppressLint
import android.view.Gravity
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.airbnb.mvrx.MavericksView
import com.airbnb.mvrx.fragmentViewModel
import com.airbnb.mvrx.withState
import com.s0l.mvrxsample.R
import com.s0l.mvrxsample.databinding.MainFragmentBinding
import com.s0l.mvrxsample.utils.viewBinding
import com.s0l.mvrxsample.views.basicButton
import com.s0l.mvrxsample.views.basicRow
import java.util.*


class MainFragment : Fragment(R.layout.main_fragment), MavericksView {

    private val binding: MainFragmentBinding by viewBinding()
    private val mainViewModel: MainViewModel by fragmentViewModel()

    private fun showData(date: Date) {
        binding.recyclerView.withModels {
            basicRow {
                id("hours")
                title(resources.getString(R.string.howrs, date.hours))
            }
            basicRow {
                id("minutes")
                title(resources.getString(R.string.minutes, date.minutes))
            }
            basicRow {
                id("seconds")
                title(resources.getString(R.string.seconds, date.seconds))
            }
            basicButton {
                id("button")
                title(resources.getString(R.string.button))
                clickListener { _ -> showToast(date) }
            }
        }
    }

    private fun showToast(date: Date?) {
        val dateText = resources.getString(
            R.string.current_time,
            date?.hours,
            date?.minutes,
            date?.seconds
        )

        val toast = Toast(requireContext())

        @SuppressLint("InflateParams")
        val layout = layoutInflater.inflate(R.layout.toast_layout, null)
        toast.view = layout
        toast.setGravity(
            Gravity.CENTER_HORIZONTAL or Gravity.BOTTOM,
            0, resources.getDimension(R.dimen.toast_offset).toInt()
        )
        layout.findViewById<TextView>(R.id.text).text = dateText
        toast.duration = Toast.LENGTH_LONG
        toast.show()
    }

    override fun invalidate() = withState(mainViewModel) { state ->
        showData(state.date)
    }
}