package com.example.caffeine.screen.coffeeReady

import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.caffeine.R
import com.example.caffeine.ui.theme.Urbanist
import com.example.caffeine.ui.theme.brown
import com.example.caffeine.ui.theme.darkGray
import com.example.caffeine.ui.theme.softPeach

@Composable
fun SwitchCup(
    modifier: Modifier = Modifier,
    isOff: Boolean = true,
    onClick: () -> Unit = {}
) {
    var size by remember { mutableStateOf(IntSize.Zero) }
    val backgroundColor = animateColorAsState(if (isOff) softPeach else brown)
    val offsetX = animateDpAsState(if (!isOff) 0.dp else (size.width / 5).dp)
    Box(
        modifier = modifier
            .clip(RoundedCornerShape(100.dp))
            .clickable(onClick = onClick)
            .onSizeChanged { newSize ->
                size = newSize
            },
        contentAlignment = Alignment.Center
    ) {
        Row(
            modifier = Modifier
                .height(40.dp)
                .background(backgroundColor.value)
                .padding(horizontal = 17.dp),
            horizontalArrangement = Arrangement.spacedBy(17.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "OFF", style = TextStyle(
                    color = darkGray.copy(.6f),
                    fontSize = 10.sp,
                    fontFamily = Urbanist,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 0.25.sp,
                    textAlign = TextAlign.Center
                )
            )
            Text(
                text = "ON", style = TextStyle(
                    color = Color.White.copy(.6f),
                    fontSize = 10.sp,
                    fontFamily = Urbanist,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 0.25.sp,

                    textAlign = TextAlign.Center
                )
            )
        }
        Image(
            modifier = Modifier
                .size(40.dp)
                .offset(x = offsetX.value)
                .align(Alignment.CenterStart),
            painter = painterResource(R.drawable.macchiato_top),
            contentDescription = null
        )
    }
}