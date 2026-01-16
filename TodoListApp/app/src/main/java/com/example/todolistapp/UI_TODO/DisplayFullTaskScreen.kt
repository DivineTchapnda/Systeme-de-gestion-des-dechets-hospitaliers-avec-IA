package com.example.todolistapp.UI_TODO

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.todolistapp.Data.Task

@Composable
fun TaskListScreen(tasks: (List<Pair<String, Task>>)) {

    DisplayDateToday()
    Spacer(modifier = Modifier.height(20.dp))
    LazyColumn() {
        items(tasks) { (id, task) ->
            Card(
                modifier = Modifier
                    .padding(horizontal = 12.dp, vertical = 8.dp)
                    .fillMaxWidth(),
                elevation = CardDefaults.cardElevation(5.dp),
                shape = RoundedCornerShape(12.dp),
                )
            {
                CardTask(id, task)
            }
        }
    }
}

