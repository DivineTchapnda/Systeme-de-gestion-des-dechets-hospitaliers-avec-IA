package com.example.todolistapp

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.absolutePadding
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.todolistapp.ui.theme.PriorityHighDark
import com.example.todolistapp.ui.theme.PriorityLowDark
import com.example.todolistapp.ui.theme.PriorityMediumDark

@Composable
fun CardTask(id:String , task: Task)
{
    Box(modifier = Modifier.fillMaxWidth().height(120.dp)) {

        var isChecked by rememberSaveable { mutableStateOf(false) }
        val Haute = PriorityHighDark
        val Basse = PriorityLowDark
        val Moyenne = PriorityMediumDark
        var guessColor= when(task.priority){
            "Basse"-> Basse
            "Moyenne"-> Moyenne
            "Haute"-> Haute
            else->Color.Transparent
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            val myCyan = Color(0xFF00FFFF)
            Checkbox(
                modifier = Modifier.size(50.dp).clip(shape = RoundedCornerShape(50)),
                onCheckedChange = {
                    isChecked = !isChecked

                },
                checked = isChecked,
                colors = CheckboxDefaults.colors(
                    uncheckedColor = myCyan,
                    checkedColor = Color.Green
                )
            )
            Column(modifier = Modifier.weight(1f).fillMaxHeight().padding(vertical = 20.dp), verticalArrangement = Arrangement.Center) {
                Row(modifier= Modifier.fillMaxWidth().height(32.dp)) {
                    Text( text = task.name, overflow = TextOverflow.Ellipsis )
                }
                Text(task.priority, color = MaterialTheme.colorScheme.onTertiary , modifier=Modifier.background(shape = RoundedCornerShape(8.dp), color = guessColor).padding(5.dp)
                )

            }
            Icon(
                Icons.Default.Delete,
                contentDescription = null,
                modifier = Modifier
                    .padding(8.dp)
                    .clickable(onClick = { Repository.deleteTask(id) })
            )
        }

    }


}
