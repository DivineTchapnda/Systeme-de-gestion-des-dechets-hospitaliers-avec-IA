package com.example.todolistapp.UI_TODO

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.todolistapp.Data.Repository
import com.example.todolistapp.Data.Task
import com.example.todolistapp.ui.theme.CyanLight
import com.example.todolistapp.ui.theme.PriorityHighDark
import com.example.todolistapp.ui.theme.PriorityLowDark
import com.example.todolistapp.ui.theme.PriorityMediumDark

@Composable
fun CardTask(id: String, task: Task) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(120.dp)
    ) {

        var isChecked by rememberSaveable { mutableStateOf(false) }
        val Haute = PriorityHighDark
        val Basse = PriorityLowDark
        val Moyenne = PriorityMediumDark
        var guessColor = when (task.priority) {
            "Basse" -> Basse
            "Moyenne" -> Moyenne
            "Urgente" -> Haute
            else -> Color.Transparent
        }
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceAround,
            verticalAlignment = Alignment.CenterVertically
        ) {
            val myCyan = Color(0xFF00FFFF)
            var bgColor = if (isChecked) {
                CyanLight
            } else {
                Color.Transparent
            }

            Checkbox(
                modifier = Modifier
                    .padding(start = 12.5.dp, top = 0.dp, end = 20.dp, bottom = 0.dp)

                    .border(color = CyanLight, width = 4.dp, shape = RoundedCornerShape(50))
                    .size(50.dp)
                    .background(color = bgColor, shape = RoundedCornerShape(50))
                    .clip(shape = RoundedCornerShape(50)),
                onCheckedChange = {
                    isChecked = !isChecked

                },
                checked = isChecked,
                colors = CheckboxDefaults.colors(
                    uncheckedColor = Color.Transparent,
                    checkedColor = CyanLight,
                    checkmarkColor = Color.White
                )
            )
            Column(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .padding(vertical = 20.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .height(32.dp)) {
                    Text(
                        text = task.name,
                        overflow = TextOverflow.Ellipsis,
                        fontSize = 19.5.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
                Row(modifier = Modifier
                    .fillMaxWidth()
                    .height(32.dp),
                    verticalAlignment = Alignment.CenterVertically
                ){
                    Icon(
                        Icons.Default.DateRange,
                        contentDescription = null,
                        modifier = Modifier.size(16.dp),

                        )
                    Text(
                        task.date,
                        fontSize = 13.5.sp,
                        fontWeight = FontWeight.SemiBold ,
                       modifier = Modifier.padding(0.dp , 0.dp , 5.dp , 0.dp)
                    )
                    // Refactoring des dates et marges internes de la session date et priorité



                    //
                    // Note (A faire au Labo):
                    // ~ Refaire le style de la date (Deja fait )
                    // ~ Obliger l'utilisateur à remplir le champ date

                    Text(
                        task.priority,
                        fontSize = 13.5.sp,
                        fontWeight = FontWeight.SemiBold,
                        modifier = Modifier
                            .background(
                                shape = RoundedCornerShape(20.dp),
                                color = guessColor
                            )
                            .padding(horizontal = 5.dp)
                    )
                }
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
