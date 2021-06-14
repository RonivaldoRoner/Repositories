package com.ronivaldoroner.repositories.ui.commons.components

import android.content.Context
import android.graphics.drawable.Drawable
import android.util.AttributeSet
import android.util.Log
import android.view.View
import androidx.annotation.DrawableRes
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import com.ronivaldoroner.repositories.R
import com.ronivaldoroner.repositories.databinding.WidgetToolbarBinding
import com.ronivaldoroner.repositories.ui.commons.extensions.invisible
import com.ronivaldoroner.repositories.ui.commons.extensions.visibility

class WidgetToolbar @JvmOverloads constructor(
    context: Context,
    private val attrs: AttributeSet? = null,
    defStyle: Int = 0
) : ConstraintLayout(context, attrs, defStyle) {

    private lateinit var binding: WidgetToolbarBinding

    init {
        try{
        setupView()
        }catch (ex: Exception){
            Log.d("Toolbar", ex.message.toString())
        }
    }

    private fun setupView() {
        attrs?.run {
            context.obtainStyledAttributes(this, R.styleable.WidgetToolbar).run {
                inflateLayout()
                titleText = getString(R.styleable.WidgetToolbar_title)
                setLeftIcon(getDrawable(R.styleable.WidgetToolbar_leftIcon))
                setRightIcon(getDrawable(R.styleable.WidgetToolbar_rightIcon))
                recycle()
            }
        } ?: run {
            inflateLayout()
        }
    }

    var titleText: CharSequence? = null
        set(value) {
            field = value
            setTitle(value)
        }

    var leftClickListener: ((view: View) -> Unit)? = null
    var rightClickListener: ((view: View) -> Unit)? = null

    @DrawableRes
    var leftIcon: Int? = null
        set(value) {
            field = value
            setLeftIcon(value?.let { ContextCompat.getDrawable(context, it) })
        }

    @DrawableRes
    var rightIcon: Int? = null
        set(value) {
            field = value
            setRightIcon(value?.let { ContextCompat.getDrawable(context, it) })
        }


    private fun setTitle(value: CharSequence?) {
        value.takeIf { it.isNullOrBlank().not() }?.let { title ->
            binding.title.apply {
                visibility()
                text = title
            }
        } ?: run {
            binding.title.invisible()
        }
    }

    private fun setLeftIcon(drawable: Drawable?) {
        drawable?.let { icon ->
            binding.leftIcon.apply {
                visibility()
                setImageDrawable(icon)
            }
        } ?: run {
            binding.leftIcon.invisible()
        }
    }

    private fun setRightIcon(drawable: Drawable?) {
        drawable?.let { icon ->
            binding.rightIcon.apply {
                visibility()
                setImageDrawable(icon)
            }
        } ?: run {
            binding.rightIcon.invisible()
        }
    }

    private fun inflateLayout() {
        binding = WidgetToolbarBinding.bind(
            inflate(context, R.layout.widget_toolbar, this)
        )

        binding.apply {
            leftIcon.setOnClickListener {
                leftClickListener?.invoke(it)
            }

            rightIcon.setOnClickListener {
                rightClickListener?.invoke(it)
            }
        }
    }
}