package com.example.cleanswift.presentation.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun SingleButton(
    modifier: Modifier,
    onClickBtn: () -> Unit = {},
    enabled: Boolean = false,
    btnColors: ButtonColors = ButtonDefaults.buttonColors(),
    textBtn: String,
    textBtnColor: Color = Color.Unspecified
){
    Column(
        modifier = modifier,
    ) {
        Button(
            onClick = { onClickBtn() },
            modifier = Modifier
                .fillMaxWidth()
                .height(48.dp),
            enabled = enabled,
            colors = btnColors,
            shape = RoundedCornerShape(8.dp)
        ) {
            TextLabel1Bold(
                text = textBtn,
                color = textBtnColor
            )
        }
    }
}