package com.example.caffeine.screen.coffeeType

import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.caffeine.R
import com.example.caffeine.ui.theme.Sniglet
import com.example.caffeine.ui.theme.Urbanist
import com.example.caffeine.ui.theme.darkGray

@Composable
fun CoffeeTypeCard(
    modifier: Modifier = Modifier,
    coffeeType: CoffeeType,
    isSelected: Boolean
) {
    val animatedScale = animateFloatAsState(
        targetValue = if (isSelected) 1f else .60f
    )
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier.weight(1f),
            contentAlignment = Alignment.Center
        ) {
            Image(
                modifier = Modifier
                    .fillMaxSize()
                    .scale(animatedScale.value),
                painter = painterResource(coffeeType.imageRes),
                contentDescription = coffeeType.name
            )
            Image(
                modifier = Modifier
                    .size(66.dp)
                    .offset(y = 20.dp)
                    .scale(animatedScale.value),
                painter = painterResource(R.drawable.logo),
                contentDescription = coffeeType.name
            )
        }
        Text(
            text = coffeeType.name.lowercase(),
            style = TextStyle(
                color = darkGray,
                fontSize = 32.sp,
                fontFamily = Urbanist,
                fontWeight = FontWeight.Bold,
                letterSpacing = 0.25.sp,
                textAlign = TextAlign.Center
            )
        )
    }
}