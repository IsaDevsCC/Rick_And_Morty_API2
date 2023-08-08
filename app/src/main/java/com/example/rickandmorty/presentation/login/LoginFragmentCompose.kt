package com.example.rickandmorty.presentation.login

import androidx.compose.foundation.Image
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material.Button
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.outlined.AccountBox
import androidx.compose.material.icons.outlined.Lock
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rickandmorty.databinding.FragmentLoginComposeBinding


class LoginFragmentCompose : Fragment() {

    lateinit var binding : FragmentLoginComposeBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentLoginComposeBinding.inflate(layoutInflater)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.cvContainerLogin.setContent {
            LoginScreen()
        }
    }
    @Composable
    private fun LoginScreen() {

        SignIn()
        Login()

        /*Column(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                modifier = Modifier.size(150.dp),
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = "SuperHero Application"
            )

            Spacer(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(15.dp)
            )

            TextField(
                modifier = Modifier.testTag("LOGIN_TEXT_FIELD_USER"),
                value = email,
                placeholder = {
                    Text("Email")
                },
                onValueChange = { newValue ->
                    email = newValue
                },
                leadingIcon = {
                    Image(
                        imageVector = Icons.Default.Email,
                        contentDescription = ""
                    )
                }
            )

            TextField(
                modifier = Modifier.testTag("LOGIN_TEXT_FIELD_PASSWORD"),
                value = password,
                placeholder = {
                    Text("Password")
                },
                onValueChange = {
                    password = it
                },
                leadingIcon = {
                    Icon(
                        imageVector = Icons.Outlined.Lock,
                        contentDescription = ""
                    )
                },
                trailingIcon = {
                    IconButton(
                        onClick = {}
                    ) {
                        Icon(
                            imageVector = Icons.Outlined.AccountBox,
                            contentDescription = ""
                        )
                    }
                }
            )

            Spacer(
                modifier = Modifier
                    .size(20.dp)
            )

            Button(
                onClick = {
                    /*if (authenticate(email, password)) {
                        onLoginSuccess()
                    }*/
                }
            ) {
                Text(
                    //text = stringResource(R.string.login)
                    text = "login"
                )
            }
            Spacer(
                modifier = Modifier
                    .size(20.dp)
            )

            /*Button(
                onClick = {
                    onForgotClicked.invoke(0)
                }
            ) {
                Text(
                    text = "Forgot"
                )
            }*/

            /*
            onClick = {
            onLoginSuccess.invoke()
            onLoginSuccess()
            }
            */


        }*/
    }


    private @Composable
    fun SignIn() {
        Box(
            modifier = Modifier.fillMaxSize()
        ){
            ClickableText(
                text = AnnotatedString("Sign In"),
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .padding(20.dp),
                onClick = {},
                style = TextStyle(
                    fontSize = 14.sp,
                    fontFamily = FontFamily.Cursive,
                    textDecoration = TextDecoration.Underline,
                    color = Color.DarkGray
                )
            )
        }
    }

    private @Composable
    fun Login() {
        //val email by remember { mutableStateOf(TextFieldValue()) }
        var email by remember { mutableStateOf(TextFieldValue()) }
        var password by remember { mutableStateOf(TextFieldValue()) }

        Column(
            modifier = Modifier.padding(20.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextField(
                value = email,
                onValueChange = { email = it }
            )
            Spacer()
            TextField(
                value = password,
                onValueChange = { password = it }
            )
            Spacer()
            ButtonLogin()
            ForgetPassword()
        }
    }

    private @Composable
    fun Spacer(){
        Spacer(
            modifier = Modifier
                .height(20.dp)
        )
    }

    private @Composable
    fun ButtonLogin() = Box(
        modifier = Modifier
            .padding(40.dp, 0.dp, 40.dp, 0.dp)) {
                Button(onClick = {},
                shape = RoundedCornerShape(50.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp)
                ) {
                    Text(text = "Login")
                }
        Spacer()
    }
    private @Composable
    fun ForgetPassword() = ClickableText(
        text = AnnotatedString("Olvidé mi contraseña"),
        onClick = {},
        style = TextStyle(
            fontSize = 14.sp,
            fontFamily = FontFamily.Monospace
        )
    )


}