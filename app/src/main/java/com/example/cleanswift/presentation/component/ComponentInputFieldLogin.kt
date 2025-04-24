package com.example.cleanswift.presentation.component

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.cleanswift.ui.theme.CleanSwiftColor

@Composable
fun OutlinedTextFieldLogin(
    label: String,
    value: String,
    onValueChange: (String) -> Unit,
    placeholder: String,
    leadingIcon: @Composable (() -> Unit)? = null
) {
    Column(
        modifier = Modifier.fillMaxWidth().padding(horizontal = 30.dp)
    ) {
        Text(
            modifier = Modifier.padding(bottom = 8.dp),
            text = label,
            fontSize = 14.sp,
            color = CleanSwiftColor.Black,
            fontWeight = FontWeight.Medium
        )

        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = value,
            onValueChange = onValueChange,
            placeholder = { Text(text = placeholder) },
            colors = OutlinedTextFieldDefaults.colors(
                unfocusedBorderColor = CleanSwiftColor.LightGray,
                focusedBorderColor = CleanSwiftColor.Primary,
                unfocusedPlaceholderColor = CleanSwiftColor.Gray,
            ),
            shape = RoundedCornerShape(8.dp),
            leadingIcon = leadingIcon
        )
    }
}