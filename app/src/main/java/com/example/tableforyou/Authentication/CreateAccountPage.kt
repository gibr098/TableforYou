package com.example.tableforyou.Authentication

import android.net.Uri
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import coil.compose.rememberAsyncImagePainter
import com.example.tableforyou.Elements.UpBar
import com.example.tableforyou.Navigation.AppDestination
import com.example.tableforyou.Navigation.LogIn
import com.example.tableforyou.R


//@Preview(showBackground = true)
@Composable
fun CreateAccountForm(
    createAccount: ()-> Unit,
    onBackClicked: (AppDestination) -> Unit,
    pickPhoto:()->Unit
) {
    UpBar(titolo = "Create Account" , back = true, onBackClicked = onBackClicked, dest = LogIn )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 75.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {

        Image(
            painter = if (EmailPasswordActivity().getUri()!=null){rememberAsyncImagePainter(Uri.parse(EmailPasswordActivity().getProfImg()))} else {painterResource(id = R.drawable.defaultimg)},
            contentDescription = "icon",
            modifier = Modifier
                .size(250.dp)
                .clip(CircleShape)
                // CHANGE PROFILE IMAGE
                .clickable { pickPhoto }
            )
        TextButton(onClick = pickPhoto) { Text("Choose a photo profile")}
        Spacer(modifier = Modifier.padding(all = 10.dp))
        NameInput()
        EmailInput()
        PasswordInput()

        Spacer(modifier = Modifier.padding(all = 20.dp))
        CreateaccountButton(createAccount)




    }

}

@Composable
fun NameInput() {
    var text by remember { mutableStateOf("") }
    OutlinedTextField(
        value = text, //EmailPasswordActivity().mail,
        onValueChange = {text = it; EmailPasswordActivity().updateName(text)},
        label = { Text("Name") }
    )
}

@Composable
fun EmailInput() {
    var text by remember { mutableStateOf("") }
    OutlinedTextField(
        value = text, //EmailPasswordActivity().mail,
        onValueChange = {text = it; EmailPasswordActivity().updateMail(text)},
        label = { Text("Email") }
    )
}

@Composable
fun PasswordInput() {
    var password by remember { mutableStateOf("") }
    OutlinedTextField(
        value = password,//EmailPasswordActivity().password,
        onValueChange = {password = it; EmailPasswordActivity().updatePsw(password) },
        label = { Text("Enter password") },
        visualTransformation = PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
    )
}

@Composable
fun CreateaccountButton(
    createAccount: () -> Unit
) {
    Button(
        onClick =   createAccount ,
        modifier = Modifier
            .height(50.dp)
            .width(270.dp),
    ) {
        Text(text = "Create Account")
    }
}


