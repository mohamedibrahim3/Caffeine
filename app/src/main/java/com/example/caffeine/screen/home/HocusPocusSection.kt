package com.example.caffeine.screen.home

import androidx.compose.animation.animateColor
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.infiniteRepeatable
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.caffeine.R
import com.example.caffeine.ui.theme.Sniglet
import com.example.caffeine.ui.theme.darkGray
import androidx.compose.runtime.getValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter

@Composable
fun HocusPocusSection(
    modifier: Modifier = Modifier
) {
    val transition = rememberInfiniteTransition()

    val starColor by transition.animateColor(
        initialValue = darkGray,
        targetValue = Color.White,
        animationSpec = infiniteRepeatable(
            animation = tween(durationMillis = 1500, easing = FastOutSlowInEasing),
            repeatMode = RepeatMode.Reverse
        ),
        label = "StarColorAnimation"
    )

    Column(
        modifier,
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.spacedBy(20.dp)
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            Image(
                modifier = Modifier
                    .size(16.dp)
                    .align(Alignment.Bottom),
                painter = painterResource(R.drawable.thin_star),
                contentDescription = null,
                colorFilter = ColorFilter.tint(starColor)
            )
            Text(
                text = "Hocus\n Pocus",
                style = TextStyle(
                    color = darkGray.copy(.87f),
                    fontSize = 32.sp,
                    fontFamily = Sniglet,
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Center,
                    lineHeight = 50.sp,
                    letterSpacing = 0.25.sp
                )
            )
            Image(
                modifier = Modifier
                    .size(16.dp),
                painter = painterResource(R.drawable.thin_star),
                contentDescription = null,
                colorFilter = ColorFilter.tint(starColor)
            )
        }
        Column {
            Text(
                text = "I Need Coffee\n to Focus",
                style = TextStyle(
                    color = darkGray.copy(.87f),
                    fontSize = 32.sp,
                    fontFamily = Sniglet,
                    fontWeight = FontWeight.Normal,
                    textAlign = TextAlign.Center,
                    lineHeight = 50.sp,
                    letterSpacing = 0.25.sp
                )
            )
            Image(
                modifier = Modifier
                    .size(16.dp)
                    .align(Alignment.End),
                painter = painterResource(R.drawable.thin_star),
                contentDescription = null,
                colorFilter = ColorFilter.tint(starColor)
            )
        }
    }
}