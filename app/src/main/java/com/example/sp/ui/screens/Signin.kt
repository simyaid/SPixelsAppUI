package com.example.sp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.*
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.tooling.preview.Preview
import com.example.sp.R
import androidx.compose.ui.text.withStyle
import androidx.navigation.NavHostController
import androidx.compose.foundation.shape.RoundedCornerShape


@Composable
fun SignInScreen(navController: NavHostController) {
    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.signin),
            contentDescription = "Sign In Background",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp, vertical = 48.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(240.dp))

            Text(
                text = "Email address",
                fontSize = 16.sp,
                color = Color(0xFFC4985F),
                modifier = Modifier.align(Alignment.Start)
            )
            Spacer(modifier = Modifier.height(6.dp))


            TextField(
                value = email,
                onValueChange = { email = it },
                modifier = Modifier.fillMaxWidth(),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color(0xFFFDFFC4),
                    unfocusedContainerColor = Color(0xFFFDFFC4),
                    disabledContainerColor = Color(0xFFFDFFC4),
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Password",
                fontSize = 16.sp,
                color = Color(0xFFC4985F),
                modifier = Modifier.align(Alignment.Start)
            )
            Spacer(modifier = Modifier.height(6.dp))

            TextField(
                value = password,
                onValueChange = { password = it },
                modifier = Modifier.fillMaxWidth(),
                visualTransformation = PasswordVisualTransformation(),
                colors = TextFieldDefaults.colors(
                    focusedContainerColor = Color(0xFFFDFFC4),
                    unfocusedContainerColor = Color(0xFFFDFFC4),
                    disabledContainerColor = Color(0xFFFDFFC4),
                    focusedIndicatorColor = Color.Transparent,
                    unfocusedIndicatorColor = Color.Transparent
                ),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
            )

            Spacer(modifier = Modifier.height(32.dp))
            Button(
                onClick = {
                    navController.navigate("dashboard")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                shape = RoundedCornerShape(9.dp), // Köşe yuvarlaklığı azaltıldı
                colors = ButtonDefaults.buttonColors(containerColor = Color(0xFF2A1102))
            ) {
                Text("Log in", fontSize = 18.sp, color = Color(0xFFF9FD89))
            }


            Spacer(modifier = Modifier.height(24.dp))

            Text("Or Continue with", fontSize = 16.sp, color = Color(0xFF6C4E2A))

            Spacer(modifier = Modifier.height(24.dp))

            Row(horizontalArrangement = Arrangement.spacedBy(24.dp)) {
                Image(painter = painterResource(id = R.drawable.google_icon), contentDescription = "Google", modifier = Modifier.size(48.dp))
                Image(painter = painterResource(id = R.drawable.fb_icon), contentDescription = "Facebook", modifier = Modifier.size(48.dp))
            }

            Spacer(modifier = Modifier.height(48.dp))

            // 🔸 TANIMI EKLİYORUZ
            val annotatedText = buildAnnotatedString {
                withStyle(SpanStyle(color = Color(0xFF2A1102))) {
                    append("Don't have an Account? ")
                }
                pushStringAnnotation(tag = "signup", annotation = "signup")
                withStyle(
                    SpanStyle(
                        color = Color(0xFF0000EE),
                        textDecoration = TextDecoration.Underline,
                        fontWeight = FontWeight.Medium
                    )
                ) {
                    append("Sign up")
                }
                pop()
            }

            ClickableText(
                text = annotatedText,
                onClick = { offset ->
                    annotatedText.getStringAnnotations("signup", offset, offset)
                        .firstOrNull()?.let {
                            navController.navigate("signup")
                        }
                },
                modifier = Modifier.fillMaxWidth(),
                style = androidx.compose.ui.text.TextStyle(
                    fontSize = 14.sp,
                    textAlign = TextAlign.Start
                )
            )
        }
    }
}

//@Preview(showBackground = true)
//@Composable
//fun SignInScreenPreview() {
//    SignInScreen()
//}
