package com.example.belajarandroiddatabinding.view

import android.view.View
import android.widget.CompoundButton
import com.example.belajarandroiddatabinding.model.Todo

interface TodoCheckedChangeListener {
    fun onCheckedChange(cb: CompoundButton, isChecked: Boolean, todo: Todo)
}

interface TodoEditClickListener {
    fun onClick(view: View)
}