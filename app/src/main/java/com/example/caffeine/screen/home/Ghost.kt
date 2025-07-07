package com.example.caffeine.screen.home

import androidx.compose.animation.core.InfiniteRepeatableSpec
import androidx.compose.animation.core.RepeatMode
import androidx.compose.animation.core.VectorConverter
import androidx.compose.animation.core.animateValue
import androidx.compose.animation.core.rememberInfiniteTransition
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.runtime.getValue
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.caffeine.R

@Composable
fun Ghost() {
    val infiniteTransition = rememberInfiniteTransition()
    val ghostOffsetY by infiniteTransition.animateValue(
        initialValue = 0.dp,
        targetValue = (-15).dp,
        animationSpec =
            InfiniteRepeatableSpec(
                animation = tween(1000),
                repeatMode = RepeatMode.Reverse
            ),
        typeConverter = Dp.VectorConverter,
    )
    Column(
        verticalArrangement = Arrangement.spacedBy(3.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Image(
            painter = painterResource(R.drawable.ghost),
            contentDescription = null,
            modifier = Modifier
                .padding(top = 13.dp)
                .offset(y = ghostOffsetY)
                .size(244.dp)
        )
        Image(
            painter = painterResource(R.drawable.shadow),
            contentDescription = null,
        )
    }
}