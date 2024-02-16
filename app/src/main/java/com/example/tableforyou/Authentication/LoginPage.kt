package com.example.tableforyou.Authentication

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import com.example.tableforyou.Navigation.AppDestination
import com.example.tableforyou.Navigation.CreateAccount
import com.example.tableforyou.R




    //@Preview(showBackground = true)
    @Composable
    fun LoginForm(
        signIn: ()-> Unit,
        GsignIn: ()-> Unit,
        goToCreateAccount: (AppDestination) -> Unit
    ) {
        //UpBar(titolo = "Log-In" , back = false, onBackClicked = {}, dest = Home )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 100.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Top
        ) {

            Image(painter = painterResource(id = R.drawable.logo), contentDescription = "icon")
            Spacer(modifier = Modifier.padding(all = 20.dp))
            UserInput()
            PasswordTextField()
            Spacer(modifier = Modifier.padding(all = 20.dp))

            LoginButton("Log-In",signIn)

            /*
            Spacer(modifier = Modifier.padding(all = 5.dp))

            GoogleLoginButton(GsignIn)
             */

            Spacer(modifier = Modifier.padding(all = 15.dp))

            CreateaccountButtonLoginPage(goToCreateAccount)

        }

    }

    @Composable
    fun UserInput() {
        var text by remember { mutableStateOf("") }

        OutlinedTextField(
            value = EmailPasswordActivity().getMail(),
            onValueChange = {text = it; EmailPasswordActivity().updateMail(text)},
            label = { Text("Mail") }
        )


    }

    @Composable
    fun PasswordTextField() {
        var password by rememberSaveable { mutableStateOf("") }

        OutlinedTextField(
            value = password,
            onValueChange = {password = it; EmailPasswordActivity().updatePsw(password) },
            label = { Text("Enter password") },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )


    }

    @Composable
    fun LoginButton(
        text: String,
        signIn: ()-> Unit
    ) {
        Button(
            onClick =   signIn ,
            modifier = Modifier
                .height(50.dp)
                .width(270.dp),
        ) {
            Text(text = text)
        }
    }
@Composable
fun GoogleLoginButton(
    GsignIn: ()-> Unit
) {
    Button(
        onClick =   GsignIn ,
        modifier = Modifier
            .height(50.dp)
            .width(270.dp),
    ) {
        Text(text = "Log-In with Google")
    }
}

@Composable
fun CreateaccountButtonLoginPage(
    goToCreateAccount: (AppDestination) -> Unit
) {
    Button(
        onClick =   {goToCreateAccount(CreateAccount)} ,
        modifier = Modifier
            .height(50.dp)
            .width(270.dp),
    ) {
        Text(text = "Create Account")
    }
}

