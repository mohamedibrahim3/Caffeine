package com.example.caffeine.screen.coffeeSize.component

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.VectorConverter
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.caffeine.R
import com.example.caffeine.screen.coffeeSize.model.CoffeeAmount
import com.example.caffeine.screen.coffeeSize.model.CoffeeSize
import com.example.caffeine.ui.theme.Urbanist
import com.example.caffeine.ui.theme.darkGray

@Composable
fun CoffeeSection(
    modifier: Modifier = Modifier,
    coffeeSize: CoffeeSize = CoffeeSize.MEDIUM,
    selectedAmount: CoffeeAmount = CoffeeAmount.MEDIUM,
) {
    val startPosition = 10.dp
    val endPosition = -LocalWindowInfo.current.containerSize.width.dp
    val scale = animateFloatAsState(
        when (coffeeSize) {
            CoffeeSize.SMALL -> .8f
            CoffeeSize.MEDIUM -> .9f
            CoffeeSize.LARGE -> 1f
        }
    )
    val coffeeOffsetY = remember { Animatable(startPosition, Dp.VectorConverter) }
    var shotsCount by rememberSaveable { mutableIntStateOf(0) }

    LaunchedEffect(selectedAmount) {
        when (selectedAmount) {
            CoffeeAmount.LOW -> {
                if (shotsCount > 1) {
                    while (shotsCount > 1) {
                        coffeeOffsetY.snapTo(startPosition)
                        coffeeOffsetY.animateTo(endPosition, animationSpec = tween(600))
                        shotsCount--
                    }
                } else {
                    while (shotsCount < 1) {
                        coffeeOffsetY.snapTo(endPosition)
                        coffeeOffsetY.animateTo(startPosition, animationSpec = tween(600))
                        shotsCount++
                    }
                }
            }
            CoffeeAmount.MEDIUM -> {
                if (shotsCount > 2) {
                    while (shotsCount > 2) {
                        coffeeOffsetY.snapTo(startPosition)
                        coffeeOffsetY.animateTo(endPosition, animationSpec = tween(600))
                        shotsCount--
                    }
                } else {
                    while (shotsCount < 2) {
                        coffeeOffsetY.snapTo(endPosition)
                        coffeeOffsetY.animateTo(startPosition, animationSpec = tween(600))
                        shotsCount++
                    }
                }
            }
            CoffeeAmount.HIGH -> {
                while (shotsCount < 3) {
                    coffeeOffsetY.snapTo(endPosition)
                    coffeeOffsetY.animateTo(startPosition, animationSpec = tween(600))
                    shotsCount++
                }
            }
        }
    }
    Box(modifier = modifier, contentAlignment = Alignment.Center) {
        Text(
            modifier = Modifier
                .padding(vertical = 63.dp)
                .padding(start = 16.dp)
                .align(Alignment.TopStart),
            text = stringResource(R.string.ml, coffeeSize.amount),
            style = TextStyle(
                color = darkGray.copy(.87f),
                fontSize = 14.sp,
                fontFamily = Urbanist,
                fontWeight = FontWeight.Medium,
                letterSpacing = 0.25.sp,
                textAlign = TextAlign.Center
            )
        )
        Image(
            modifier = Modifier
                .scale(scale.value / 1.1f)
                .offset(y = coffeeOffsetY.value)
                .align(Alignment.TopCenter),
            painter = painterResource(R.drawable.coffee_beans),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Image(
            modifier = Modifier
                .fillMaxHeight()
                .scale(scale.value),
            painter = painterResource(R.drawable.empty_cup),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
        Image(
            modifier = Modifier
                .size(64.dp)
                .scale(scale.value),
            painter = painterResource(R.drawable.logo),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
    }
}