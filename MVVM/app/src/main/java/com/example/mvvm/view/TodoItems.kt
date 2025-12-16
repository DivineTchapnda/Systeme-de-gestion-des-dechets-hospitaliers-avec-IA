package com.example.mvvm.view

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.mvvm.data.model.Todo
import com.example.mvvm.viewmodel.TodoViewModel

val vM = TodoViewModel()
@Composable
fun TodoItems( todo : Todo , onDelete : ()-> Unit){
    Row(
        modifier = Modifier.fillMaxWidth().padding(8.dp),
        horizontalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(todo.name)
        IconButton(onClick = { onDelete}){
            Icon(Icons.Default.Delete , contentDescription = "Delete")
        }
    }

}