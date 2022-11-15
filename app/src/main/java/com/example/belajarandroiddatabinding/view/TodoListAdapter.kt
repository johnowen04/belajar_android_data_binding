package com.example.belajarandroiddatabinding.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.belajarandroiddatabinding.databinding.TodoItemLayoutBinding
import com.example.belajarandroiddatabinding.model.Todo

class TodoListAdapter(
    val todoList: ArrayList<Todo>,
    val adapterOnClick: (Todo) -> Unit
): RecyclerView.Adapter<TodoListAdapter.TodoViewHolder>() {

    class TodoViewHolder(var view: TodoItemLayoutBinding): RecyclerView.ViewHolder(view.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TodoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = TodoItemLayoutBinding.inflate(inflater, parent, false)

        return TodoViewHolder(view)
    }

    override fun onBindViewHolder(holder: TodoViewHolder, position: Int) {
        holder.view.todo = todoList[position]
        /*
        val selectedTodo = todoList[position]

        with(holder.view) {
            checkBox.text = selectedTodo.title
            checkBox.setOnCheckedChangeListener{ _, b ->
                if (b) adapterOnClick(selectedTodo)
            }

            imgButtonEdit.setOnClickListener {
                val action = TodoListFragmentDirections.actionEditTodoFragment(selectedTodo.uuid)
                Navigation.findNavController(it).navigate(action)
            }
        }
         */
    }

    fun updateTodoList(newTodoList: List<Todo>) {
        todoList.clear()
        todoList.addAll(newTodoList)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = todoList.size
}