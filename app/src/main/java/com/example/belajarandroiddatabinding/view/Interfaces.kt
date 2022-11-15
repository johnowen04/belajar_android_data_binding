package com.example.belajarandroiddatabinding.view

import android.widget.CompoundButton
import com.example.belajarandroiddatabinding.model.Todo

interface TodoCheckedChangeListener {
    fun onCheckedChange(cb: CompoundButton, isChecked: Boolean, todo: Todo)
}