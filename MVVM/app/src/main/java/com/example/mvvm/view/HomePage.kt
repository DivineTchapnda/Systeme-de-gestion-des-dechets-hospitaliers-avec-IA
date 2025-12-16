package com.example.mvvm.view

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mvvm.R
import com.example.mvvm.data.model.Todo
import com.example.mvvm.viewmodel.TodoViewModel


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(viewModel : TodoViewModel)
{
   val todos by viewModel.todos
    var text by remember {mutableStateOf("")}
    LaunchedEffect(Unit) {
        viewModel.loadTodo()
    }
    Column(modifier = Modifier.padding(16.dp)
        .fillMaxSize()) {
        TextField(
            value = text ,
            onValueChange = { text = it },
            placeholder = {Text("Nouvelle Tache")
            }
        )

        Button(onClick = { viewModel.addToDo(text) ; text= "" }) {
            Text("Add")
        }
        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn() {
            items(todos){
                    it -> TodoItems(it , onDelete ={viewModel.deleteTodo(it)})
            }
        }

    }


}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview()
{
}