package com.example.todolistapp
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import java.text.SimpleDateFormat
import java.util.Locale
import java.util.Date

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerTextField(
    label: String = "Date",
    dateFormat: String = "dd/MM/yyyy",
    onDateSelected: (Long?) -> Unit
) {
    var showDialog by remember { mutableStateOf(false) }
    var selectedDateMillis by remember { mutableStateOf<Long?>(null) }
    var text by remember { mutableStateOf(TextFieldValue("")) }

    val sdf = remember(dateFormat) {
        SimpleDateFormat(dateFormat, Locale.ENGLISH)
    }

    if (showDialog) {
        val datePickerState = rememberDatePickerState(
            initialSelectedDateMillis = selectedDateMillis
        )
        DatePickerDialog(
            onDismissRequest = { showDialog = false },
            confirmButton = {
                TextButton(onClick = {
                    selectedDateMillis = datePickerState.selectedDateMillis
                    selectedDateMillis?.let { millis ->
                        text = TextFieldValue(sdf.format(Date(millis)))
                        onDateSelected(millis)
                    }
                    showDialog = false
                }) {
                    Text("OK")
                }
            },
            dismissButton = {
                TextButton(onClick = { showDialog = false }) {
                    Text("Cancel")
                }
            }
        ) {
            DatePicker(state = datePickerState)
        }
    }


    OutlinedTextField(
        value = text,
        onValueChange = { input ->
            try {
                val date = sdf.parse(input.text)
                selectedDateMillis = date?.time
                onDateSelected(selectedDateMillis)
            } catch (_: Exception) {}
            text = input
        },
        readOnly = true,
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        label = { Text(label) },
        trailingIcon = {
            Icon(
                imageVector = Icons.Default.DateRange,
                contentDescription = "Sélectionner la date",
                modifier = Modifier.clickable { showDialog = true }
            )
        },
        singleLine = true,

    )

}


//@Preview(showBackground = true)
//@Composable
//fun DatePickerTextFieldPreview() {
//    var selectedDate by remember { mutableStateOf<Long?>(null) }
//
//    Box(modifier = Modifier.fillMaxWidth()) {
//        DatePickerTextField(
//            onDateSelected = { date ->
//                selectedDate = date
//            }
//        )
//        selectedDate?.let {
//            Text(
//                text = "Date sélectionnée : ${SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).format(Date(it))}",
//                modifier = Modifier.padding(top = 80.dp)
//            )
//        }
//    }
//}
