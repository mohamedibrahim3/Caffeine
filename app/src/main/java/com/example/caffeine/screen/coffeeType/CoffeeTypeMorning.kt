package com.example.caffeine.screen.coffeeType

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.caffeine.R
import com.example.caffeine.ui.theme.Urbanist
import com.example.caffeine.ui.theme.darkGray
import com.example.caffeine.ui.theme.gray
import com.example.caffeine.ui.theme.lightGray

@Composable
fun MorningGreeting(modifier: Modifier = Modifier) {
    Column(modifier = modifier) {
        Text(
            text = stringResource(R.string.good_morning),
            style = TextStyle(
                color = lightGray,
                fontSize = 36.sp,
                fontFamily = Urbanist,
                fontWeight = FontWeight.Bold,
                letterSpacing = 0.25.sp,
                textAlign = TextAlign.Center,
            )
        )
        Text(
            text = "Mohamed ☀",
            style = TextStyle(
                color = gray,
                fontSize = 36.sp,
                fontFamily = Urbanist,
                fontWeight = FontWeight.Bold,
                letterSpacing = 0.25.sp,
                textAlign = TextAlign.Center
            )
        )
        Text(
            modifier = Modifier.padding(top = 4.dp),
            text = stringResource(R.string.what_would_you_like_to_drink_today),
            style = TextStyle(
                color = darkGray.copy(.8f),
                fontSize = 16.sp,
                fontFamily = Urbanist,
                fontWeight = FontWeight.Bold,
                letterSpacing = 0.25.sp,
                textAlign = TextAlign.Center
            )
        )
    }
}