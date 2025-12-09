package com.example.learningstate

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.RadioButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterFormView( modifier : Modifier)
{
    var name by remember { mutableStateOf("") }
    var nameError by remember { mutableStateOf(false) }
    var password by remember { mutableStateOf("") }
    var passwordError by remember { mutableStateOf(false) }
    var passwordHidden by remember { mutableStateOf("")}

    var email by remember { mutableStateOf("") }
    var EmailError by remember { mutableStateOf(false) }
    var isCheck by rememberSaveable { mutableStateOf(false) }
    var radioMale by remember { mutableStateOf(false) }
    var radioFemale by remember { mutableStateOf(false) }

    Column( horizontalAlignment = Alignment.CenterHorizontally , modifier = modifier , verticalArrangement = Arrangement.spacedBy(20.dp)) {
        Text(
            text = "Register Form",
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp
        )

        OutlinedTextField(
                value =name,
                onValueChange = {name = it},
                label = {Text( "Name")},
                modifier = Modifier.fillMaxWidth(),
                isError = nameError,
              trailingIcon = { Icon(Icons.Filled.Person,contentDescription = "Profile") }
            )
        if(name.length in 1..4)
        {
            nameError = true
        }
        else
        {
            nameError = false
        }
        OutlinedTextField(
            value =email,
            onValueChange = {email= it},
            label = {Text( "Email")},
            modifier = Modifier.fillMaxWidth(),
            isError = EmailError,
            trailingIcon = { Icon(Icons.Filled.Email,contentDescription = "Email")}
        )
        if(email.length in 1..4)
        {
            EmailError = true
        }
        else
        {
            EmailError = false
        }
        OutlinedTextField(
            value =password ,
            onValueChange = {password = it;  },
            label = {Text( "Password")},
            modifier = Modifier.fillMaxWidth(),
            isError = passwordError,
            trailingIcon = { Icon(Icons.Filled.Lock,contentDescription = "Lock")}
        )
        Text( text = password)
        if(password.length in 1..6)
        {
            passwordError = true
        }
        else
        {
            passwordError = false
        }
        Row( verticalAlignment = Alignment.CenterVertically , modifier = Modifier.fillMaxWidth()) {

            Checkbox( onCheckedChange = { isCheck = true} , checked = isCheck , colors = CheckboxDefaults.colors( checkedColor = Color.Blue))
            Text( "I accept the terms and conditions" , fontSize = 17.sp)

        }

        Column (){
            Text( "Gender")
            Row(verticalAlignment = Alignment.CenterVertically,modifier = Modifier.fillMaxWidth()  ) {
                RadioButton( onClick = {radioMale =true ; radioFemale=false} , selected = radioMale , colors = RadioButtonDefaults.colors( Color.Blue))
                Text("Male")
                RadioButton( onClick = {radioMale =false ; radioFemale=true} , selected = radioFemale , colors = RadioButtonDefaults.colors( Color.Blue) )
                Text("Female")

            }
        }

//        Column {
//            Text( "Country")
//
//        }
        Button( onClick = {} ,
            colors = ButtonDefaults.buttonColors(containerColor=Color.Blue , contentColor = Color.White) ,
            modifier = Modifier.fillMaxWidth().height(50.dp) ,
            shape = RoundedCornerShape(10)) {
            Text( "Register" , fontWeight = FontWeight.Bold , fontSize = 20.sp)
        }



    }
}

@Preview ( showBackground = true , showSystemUi = true)
@Composable
fun RegisterFormPreview()
{
    RegisterFormView(Modifier.padding(10.dp))
}