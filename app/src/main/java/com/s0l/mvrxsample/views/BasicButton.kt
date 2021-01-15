package com.s0l.mvrxsample.views

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import com.airbnb.epoxy.ModelProp
import com.airbnb.epoxy.ModelView
import com.airbnb.epoxy.TextProp
import com.s0l.mvrxsample.databinding.BasicButtonBinding
import com.s0l.mvrxsample.utils.viewBinding

@ModelView(autoLayout = ModelView.Size.MATCH_WIDTH_WRAP_HEIGHT)
class BasicButton @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {
    private val binding: BasicButtonBinding by viewBinding()

    @TextProp
    fun setTitle(title: CharSequence?) {
        binding.button.text = title
    }

    @ModelProp(ModelProp.Option.IgnoreRequireHashCode )
    fun setClickListener(listener: OnClickListener?) {
        binding.button.setOnClickListener(listener)
    }
}
