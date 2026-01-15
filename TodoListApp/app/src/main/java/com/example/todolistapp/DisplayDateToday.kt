package com.example.todolistapp

import android.R
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import java.text.SimpleDateFormat
import java.util.Calendar
import java.util.Date
import java.util.Locale

@Composable
fun DisplayDateToday () {
    val today = remember {
        val calc = Calendar.getInstance()
        calc.set(
            calc.get(Calendar.YEAR),
            calc.get(Calendar.MONTH),
            calc.get(Calendar.DAY_OF_MONTH),
            0, 0, 0,
        )
        calc.timeInMillis
    }

    val formattedDate = remember {
        val sdf = SimpleDateFormat("EEEE, dd MMMM", Locale.getDefault())
        sdf.format(Date(today))
    }


    Column(modifier=Modifier.padding(vertical = 45.dp , horizontal = 20.dp )){
        Text(text = "Ma journée :" , fontSize = 30.sp , fontWeight = FontWeight.Bold , color = MaterialTheme.colorScheme.onPrimary)
        Text("$formattedDate" , fontWeight = FontWeight.SemiBold , fontStyle = FontStyle.Italic , color = MaterialTheme.colorScheme.onPrimary)
    }
}
