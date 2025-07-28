package com.example.sp.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.sp.R

@Composable
fun OnboardingScreen1() {
    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.ic_onboarding_1),
            contentDescription = "Capture moments illustration",
            modifier = Modifier
                .fillMaxWidth()
                .wrapContentHeight(),
            contentScale = ContentScale.FillWidth
        )
    }
}

@Preview(showBackground = true)
@Composable
fun OnboardingScreen1Preview() {
    OnboardingScreen1()
}
