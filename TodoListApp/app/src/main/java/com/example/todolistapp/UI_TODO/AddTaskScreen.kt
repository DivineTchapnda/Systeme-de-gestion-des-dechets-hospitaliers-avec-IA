package com.example.todolistapp.UI_TODO
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.todolistapp.Data.Repository
import com.example.todolistapp.Data.Task
import com.example.todolistapp.ui.theme.blueDark
import com.example.todolistapp.ui.theme.gray
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddTaskScreen(navController: NavController) {
    var addTask by remember { mutableStateOf("") }
    var addTaskError = addTask.isNotBlank()
    var date by remember { mutableStateOf("") }
    var priority by remember { mutableStateOf("") }
    var selectedDate by remember { mutableStateOf<Long?>(null) }
    var priorityClick by remember { mutableStateOf(false) }

    val context = LocalContext.current
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Ajouter une tache") },
                colors = TopAppBarDefaults.topAppBarColors(
                    titleContentColor = Color.White,
                    containerColor = MaterialTheme.colorScheme.onBackground
                )
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

            Spacer(modifier = Modifier.height(45.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = gray, shape = RoundedCornerShape(8.dp))
            ) {

                OutlinedTextField(
                    onValueChange = {
                        addTask = it
                    },
                    value = addTask,
                    shape = RoundedCornerShape(12.dp),
                    modifier = Modifier.fillMaxWidth(),
                    placeholder = { Text("Editer") },
                    maxLines = 1,
                    isError = !addTaskError,
                    trailingIcon = {
                        Icon(
                            Icons.Filled.Edit,
                            contentDescription = null
                        )
                    }
                )
            }
            if (!addTaskError) {
                Text("Vous devez saisir une tache", color = MaterialTheme.colorScheme.error)
            }
            Spacer(modifier = Modifier.height(20.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .background(color = gray, shape = RoundedCornerShape(8.dp))
            ) {
                DatePickerTextField(
                    onDateSelected = { date ->
                        selectedDate = date
                    }
                )
                selectedDate?.let {

                    date = "${SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH).format(Date(it))}"
                }
            }

            Spacer(modifier = Modifier.height(15.dp))


            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(230.dp)
                    .background(color = gray, shape = RoundedCornerShape(8.dp))
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(vertical = 15.dp, horizontal = 15.dp)
                ) {
                    Text("Priorité", fontWeight = FontWeight.Bold, color = Color.White)
                    Spacer(modifier = Modifier.height(20.dp))

                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        Button(
                            modifier = Modifier.weight(1f),
                            onClick = {
                                priority = "Basse"
                                priorityClick = true

                            },
                            shape = RoundedCornerShape(8.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = if (priority == "Basse") Color.Green else blueDark,
                                contentColor = if (priority == "Basse") Color.White else Color.Black
                            )
                        )
                        {
                            Text("Basse", textAlign = TextAlign.Center) //modifier = )
                        }
                        Spacer(modifier = Modifier.width(10.dp))

                        Button(
                            modifier = Modifier.weight(1f),
                            onClick = {
                                priority = "Moyenne"
                                priorityClick = true

                            },
                            shape = RoundedCornerShape(8.dp),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = if (priority == "Moyenne") Color.Green else blueDark,
                                contentColor = if (priority == "Moyenne") Color.White else Color.Black
                            )
                        )
                        {
                            Text("Moyenne")
                        }

                    }
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceBetween
                    ) {

                        Button(
                            modifier = Modifier.weight(1f), onClick = {
                                priority = "Urgente"
                                priorityClick = true

                            },
                            shape = RoundedCornerShape(
                                8.dp
                            ),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = if (priority == "Urgente") Color.Green else blueDark,
                                contentColor = if (priority == "Urgente") Color.White else Color.Black
                            )
                        ) {
                            Text("Urgente")
                        }
                        Spacer(modifier = Modifier.width(10.dp))

                        Button(
                            modifier = Modifier.weight(1f), onClick = {
                            },
                            shape = RoundedCornerShape(
                                0.dp
                            ),
                            colors = ButtonDefaults.buttonColors(
                                containerColor = gray,
                                contentColor = Color.Transparent
                            )
                        ) {
                            Text("")
                        }
                    }

                }
            }
            Spacer(modifier = Modifier.height(25.dp))
            Button(
                onClick = {

                    Repository.addTask(Task(name = addTask, date = date, priority = priority))
                    navController.popBackStack()
                    Toast.makeText(context, "Tache ajoutée avec succès ", Toast.LENGTH_LONG).show()
                },
                enabled = addTaskError && (priority == "Moyenne" || priority == "Basse" || priority == "Urgente"),
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.onBackground),
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(8.dp)
            )
            {
                Icon(
                    Icons.Filled.CheckCircle, contentDescription = null,
                    modifier = Modifier
                        .size(42.dp)
                        .padding(0.dp, 0.dp, 10.dp)
                )
                Text(
                    "ENREGISTRER",
                    modifier = Modifier.padding(vertical = 18.5.dp),
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.White
                )
            }


        }
    }

}