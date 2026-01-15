package com.example.todolistapp

import android.graphics.Paint
import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddTaskScreen(navController: NavController) {
    var addTask by remember { mutableStateOf("") }
    var name by remember { mutableStateOf("") }
    var date by remember { mutableStateOf("") }
    var priority by remember { mutableStateOf("") }
    var selectedDate by remember { mutableStateOf<Long?>(null) }
    var priorityClick by remember { mutableStateOf(false)}
    val context = LocalContext.current
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Ajouter une tache") },
                colors = TopAppBarDefaults.topAppBarColors(titleContentColor = Color.Black)
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .padding(horizontal = 14.dp, vertical = 12.dp)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {

            OutlinedTextField(onValueChange = { addTask = it },
                value = addTask,
                shape = RoundedCornerShape(12.dp),
                modifier = Modifier.fillMaxWidth(),
                label = { Text("Task") })
            Spacer(modifier = Modifier.height(20.dp))
//            OutlinedTextField(onValueChange = { date = it },
//                value = date,
//                shape = RoundedCornerShape(12.dp),
//                modifier = Modifier.fillMaxWidth(),
//                placeholder = { Text("Quelles est la tache a faire ?") })

            Box(modifier = Modifier.fillMaxWidth()) {
                DatePickerTextField(
                    onDateSelected = { date ->
                        selectedDate = date
                    }
                )
                selectedDate?.let {
                    Text(
                        text = "Date sélectionnée : ${SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).format(Date(it))}",
                        modifier = Modifier.padding(top = 80.dp)

                    )
                    date = "${SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).format(Date(it))}"
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
//            OutlinedTextField(onValueChange = { priority = it },
//                value = priority,
//                shape = RoundedCornerShape(12.dp),
//                modifier = Modifier.fillMaxWidth(),
//                placeholder = { Text("Quelles est la tache a faire ?") })

            Row(modifier = Modifier.fillMaxWidth()) {
                Button(onClick = {
                    priority = "Basse"
                    priorityClick = true
                } , colors = ButtonDefaults.buttonColors( containerColor =
                Color.Red , contentColor = Color.White)) {
                    Text("Basse" , textAlign = TextAlign.Center ) //modifier = )
                }
                Button(onClick = {
                    priority = "Moyenne"
                    priorityClick = true
                } ,  colors = ButtonDefaults.buttonColors( containerColor =
                    Color.Yellow, contentColor = Color.White)) {
                    Text("Moyenne")
                }
                Button(onClick = {
                    priority = "Haute"
                    priorityClick = true
                } ,  colors = ButtonDefaults.buttonColors( containerColor =
                    Color.Green , contentColor = Color.White)) {
                    Text("Haute")
                }
            }

            Button(onClick = {
                Repository.addTask(Task(name= addTask, date = date, priority = priority))
                navController.popBackStack()
                Toast.makeText(context, "Tache Ajoutee ", Toast.LENGTH_LONG).show()
            },
                colors = ButtonDefaults.buttonColors(containerColor = Color.Green),
                modifier= Modifier.fillMaxWidth())
            {
                Text("Enregister", fontSize = 18.sp)
            }


        }
    }

}