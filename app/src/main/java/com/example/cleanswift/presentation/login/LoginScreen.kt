package com.example.cleanswift.presentation.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.cleanswift.R
import com.example.cleanswift.presentation.component.OutlinedTextFieldLogin
import com.example.cleanswift.presentation.component.SingleButton
import com.example.cleanswift.ui.theme.CleanSwiftColor

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun LoginScreen() {
    var username by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Scaffold(
        contentWindowInsets = WindowInsets(top = 50, bottom = 50),

        bottomBar = {
            BottomAppBar(
                containerColor = Color.Transparent,
            ) {
                SingleButton(
                    modifier = Modifier
                        .padding(horizontal = 30.dp),
                    onClickBtn = {},
                    enabled = true,
                    btnColors = ButtonDefaults.buttonColors(containerColor = CleanSwiftColor.Primary),
                    textBtn = "Masuk",
                    textBtnColor = CleanSwiftColor.Black
                )
            }
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Image(
                    modifier = Modifier.padding(bottom = 80.dp),
                    painter = painterResource(id = R.drawable.logo_login),
                    contentDescription = "Logo Login"
                )

                OutlinedTextFieldLogin(
                    label = stringResource(id = R.string.label_username),
                    value = username,
                    onValueChange = { username = it },
                    placeholder = stringResource(id = R.string.placeholder_username),
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.email),
                            contentDescription = "Username Email"
                        )
                    }
                )

                Spacer(modifier = Modifier.height(24.dp))

                OutlinedTextFieldLogin(
                    label = stringResource(id = R.string.label_password),
                    value = password,
                    onValueChange = { password = it },
                    placeholder = stringResource(id = R.string.placeholder_password),
                    leadingIcon = {
                        Icon(
                            painter = painterResource(id = R.drawable.key),
                            contentDescription = "Username Password"
                        )
                    }
                )
            }
        }
    }
}