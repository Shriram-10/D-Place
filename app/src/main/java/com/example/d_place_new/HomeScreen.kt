package com.example.d_place_new

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

var color = mutableStateListOf<Color>()

@Composable
fun HomeScreen (modifier : Modifier) {
    Column (
        modifier = modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        var selectedColor by remember { mutableStateOf(Color.Red) }
        for (i in 1..800) {
            color.add(Color.White)
        }
        Text (
            text = "d/place",
            fontSize = 26.sp,
            fontWeight = FontWeight.Bold
        )

        LazyVerticalGrid(columns = GridCells.Fixed(25)) {
            items(800) {
                Box (
                    modifier = Modifier.width(8.dp).height(16.dp)
                        .clickable {
                            color[it] = selectedColor
                        }
                        .background(color[it])
                        .border(BorderStroke(1.dp, color = Color.Black)),
                ) {

                }
            }
        }

        Row (
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            var colorList = listOf<Color>(Color.Black, Color.Red, Color.Green, Color.Blue, Color.Yellow)

            for (i in 0..4) {
                Box (contentAlignment = Alignment.Center) {
                    Box(
                        modifier = Modifier.size(40.dp)
                            .clickable {
                                selectedColor = colorList[i]
                            }
                            .background(colorList[i])
                            .border(BorderStroke(4.dp, color = Color.Black))
                    )
                    if (selectedColor == colorList[i]) {
                        Icon (
                            Icons.Default.Check,
                            contentDescription = "check",
                            modifier = Modifier.size(24.dp),
                            tint = Color.White
                        )
                    }
                }
            }
        }
    }
}
