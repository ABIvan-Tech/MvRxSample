package com.s0l.mvrxsample.views

import android.content.Context
import android.util.AttributeSet
import android.widget.LinearLayout
import com.airbnb.epoxy.CallbackProp
import com.airbnb.epoxy.ModelView
import com.airbnb.epoxy.TextProp
import com.s0l.mvrxsample.databinding.BasicRowBinding
import com.s0l.mvrxsample.utils.viewBinding

@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT)
class BasicRow @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {
    private val binding: BasicRowBinding by viewBinding()

    init {
        orientation = VERTICAL
    }

    @TextProp
    fun setTitle(title: CharSequence?) {
        binding.title.text = title
    }

    @CallbackProp
    fun setClickListener(clickListener: OnClickListener?) {
        setOnClickListener(clickListener)
    }
}
