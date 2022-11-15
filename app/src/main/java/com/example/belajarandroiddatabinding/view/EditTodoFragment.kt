package com.example.belajarandroiddatabinding.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioButton
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.example.belajarandroiddatabinding.R
import com.example.belajarandroiddatabinding.databinding.FragmentEditTodoBinding
import com.example.belajarandroiddatabinding.model.Todo
import com.example.belajarandroiddatabinding.viewmodel.DetailTodoViewModel
import kotlinx.android.synthetic.main.fragment_create_todo.*

class EditTodoFragment : Fragment(), RadioButtonListener {
    private lateinit var viewModel: DetailTodoViewModel
    private lateinit var dataBinding: FragmentEditTodoBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        dataBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_edit_todo, container, false)
        return dataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        textTitleTodo.text = "Edit Todo"
        btnAddNotes.text = "Save Changes"

        dataBinding.listener = this

        /*
        dataBinding.listener = object: RadioButtonListener {
            override fun onRadioClick(view: View, priority: Int, todo: Todo) {
                TODO("Not yet implemented")
            }
        }
         */

        dataBinding.saveListener = object: TodoSaveChangesListener {
            override fun onSaveChangeClick(view: View, todo: Todo) {

            }
        }

        val uuid: Int = EditTodoFragmentArgs.fromBundle(requireArguments()).uuid

        viewModel = ViewModelProvider(this).get(DetailTodoViewModel::class.java)
        viewModel.fetch(uuid)

        /*
        btnAddNotes.setOnClickListener {
            val radio = view.findViewById<RadioButton>(radioGroupPriority.checkedRadioButtonId)
            viewModel.updateTodo(
                editTitle.text.toString(),
                editNotes.text.toString(),
                radio.tag.toString().toInt(),
                uuid
            )

            Toast.makeText(view.context, "Data updated", Toast.LENGTH_SHORT).show()
            Navigation.findNavController(it).popBackStack()
        }
         */

        observeViewModel()
    }

    private fun observeViewModel() {
        viewModel.todoLiveData.observe(viewLifecycleOwner) {
            dataBinding.todo = it
            /*
            editTitle.setText(it.title)
            editNotes.setText(it.notes)

            when (it.priority) {
                3 -> radioHigh.isChecked = true
                2 -> radioMedium.isChecked = true
                else -> radioLow.isChecked = true
            }
             */
        }
    }

    override fun onRadioClick(view: View, priority: Int, todo: Todo) {
        todo.priority = priority
    }
}