package com.example.caffeine.screen.coffeeSize.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.example.caffeine.R
import com.example.caffeine.ui.theme.Sniglet
import com.example.caffeine.ui.theme.Urbanist
import com.example.caffeine.ui.theme.brown
import com.example.caffeine.ui.theme.darkGray

@Composable
fun AlmostSection(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = stringResource(R.string.almost_done),
            style = TextStyle(
                color = darkGray.copy(.87f),
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                letterSpacing = 0.25.sp,
                fontFamily = Urbanist,
                textAlign = TextAlign.Center
            )
        )
        Text(
            text = stringResource(R.string.your_coffee_will_be_finish_in),
            style = TextStyle(
                color = darkGray.copy(.6f),
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold,
                letterSpacing = 0.25.sp,
                fontFamily = Urbanist,
                textAlign = TextAlign.Center
            )
        )
        Text(
            text = "CO\t\tFF\t\tEE",
            style = TextStyle(
                color = brown,
                fontSize = 32.sp,
                fontWeight = FontWeight.ExtraBold,
                letterSpacing = 0.25.sp,
                fontFamily = Sniglet,
                textAlign = TextAlign.Center
            )
        )
    }
}