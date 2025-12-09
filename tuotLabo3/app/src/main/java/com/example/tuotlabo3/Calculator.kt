package com.example.tuotlabo3

import android.R
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.OutlinedButton
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
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.tuotlabo3.ui.theme.TuotLabo3Theme

@Composable
fun Calculator(modifier: Modifier = Modifier) {
    var display by rememberSaveable { mutableStateOf<String>("") }
    var operator by rememberSaveable { mutableStateOf<Char?>(null) }
    var operand by rememberSaveable { mutableStateOf<Int?>(null) }
    fun onOperator(opt: Char) {
        operator = opt
    }

    // Study Case
    // Method Part
    fun onDigit(digit: Char) {
        if (display == "0") {
            display = digit.toString()
        } else {
            if (operator == null) {
                display += digit.toString()
            } else {
                if (operand == null) {
                    operand = display.toInt()
                    display = digit.toString()
                } else {
                    display += digit.toString()

                }


            }

        }
    }

    fun onEquals() {
        var results = 0.0
        when (operator) {
            '+' -> {
                results = operand!!.toDouble() + display.toDouble()
            }

            '-' -> {
                results = operand!!.toDouble() - display.toDouble()
            }

            '/' -> {
                results = operand!!.toDouble() / display.toDouble()
            }

            '*' -> {
                results = operand!!.toDouble() * display.toDouble()
            }
        }
        display = results.toString()
        operator = null
        operand = null
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp)


    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp)
                .background(
                    Color(0x0F212020),
                    shape = RoundedCornerShape(topEnd = 10.dp, topStart = 10.dp)
                )
                .weight(1f),
            contentAlignment = Alignment.BottomEnd,

            ) {
            Text(
                display,
                fontWeight = FontWeight.Bold,
                fontSize = 50.sp,
                modifier = Modifier.padding(10.dp)
            )
        }
        Spacer(modifier = Modifier.height(10.dp))
        val btnModifier = Modifier
            .padding(2.dp)
            .weight(1f)
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
            for (elt in listOf("C", "DEL", "+/-")) {
                OutlinedButton(
                    onClick = { },
                    modifier = btnModifier,
                    shape = RoundedCornerShape(5.dp),
                    colors = ButtonDefaults.outlinedButtonColors(
                        containerColor = Color(0, 0, 0),
                        contentColor = Color.White
                    )


                ) {
                    Text(elt, fontWeight = FontWeight.Bold)

                }
            }
            OutlinedButton(
                onClick = { onOperator('/') },
                modifier = btnModifier,
                shape = RoundedCornerShape(5.dp),
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = Color(0, 0, 0),
                    contentColor = Color.White
                )
            ) {
                Text("/", fontWeight = FontWeight.Bold)

            }


        }
        Spacer(modifier = Modifier.height(10.dp))

        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
            for (number in listOf<Char>('7', '8', '9')) {
                OutlinedButton(
                    onClick = { onDigit(number) },
                    modifier = btnModifier,
                    shape = RoundedCornerShape(5.dp),

                    ) {
                    Text("$number", fontWeight = FontWeight.Bold)

                }
            }
            OutlinedButton(
                onClick = { onOperator('*') },
                modifier = btnModifier,
                shape = RoundedCornerShape(5.dp),
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = Color(0, 0, 0),
                    contentColor = Color.White
                )
            ) {
                Text("*", fontWeight = FontWeight.Bold)

            }


        }
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
            for (number in listOf<Char>('4', '5', '6')) {
                OutlinedButton(
                    onClick = { onDigit(number) },
                    modifier = btnModifier,
                    shape = RoundedCornerShape(5.dp)
                ) {
                    Text("$number", fontWeight = FontWeight.Bold)

                }
            }
            OutlinedButton(
                onClick = { onOperator('-') },
                modifier = btnModifier,
                shape = RoundedCornerShape(5.dp),
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = Color(0, 0, 0),
                    contentColor = Color.White
                )
            ) {
                Text("-", fontWeight = FontWeight.Bold)

            }


        }
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
            for (number in listOf<Char>('1', '2', '3')) {
                OutlinedButton(
                    onClick = { onDigit(number) },
                    modifier = btnModifier,
                    shape = RoundedCornerShape(5.dp)
                ) {
                    Text("$number", fontWeight = FontWeight.Bold)

                }
            }
            // The REA
            OutlinedButton(
                onClick = { onOperator('+') },
                modifier = btnModifier,
                shape = RoundedCornerShape(5.dp),
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = Color(0, 0, 0),
                    contentColor = Color.White
                )
            ) {
                Text("+", fontWeight = FontWeight.Bold)

            }


        }
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround) {
            OutlinedButton(
                onClick = { onDigit('0') },
                modifier = Modifier
                    .padding(2.dp)
                    .weight(2f),
                shape = RoundedCornerShape(5.dp)
            ) {
                Text("${0}", fontWeight = FontWeight.Bold)

            }

            OutlinedButton(
                onClick = {},
                modifier = btnModifier,
                shape = RoundedCornerShape(5.dp),
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = Color(0, 0, 0),
                    contentColor = Color.White
                )
            ) {
                Text(".", fontWeight = FontWeight.Bold)

            }

            OutlinedButton(
                onClick = { onEquals() },
                modifier = btnModifier,
                shape = RoundedCornerShape(5.dp),
                colors = ButtonDefaults.outlinedButtonColors(
                    containerColor = Color(0, 0, 0),
                    contentColor = Color.White
                )
            ) {
                Text("=", fontWeight = FontWeight.Bold)

            }


        }


    }
}

@Preview(showBackground = true)
@Composable
fun CalculatorPreview() {


    Calculator()

}