package com.example.caffeine.screen.coffeeReady

import androidx.compose.animation.core.VectorConverter
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import com.example.caffeine.R

@Composable
fun CupAnimation(
    modifier: Modifier = Modifier
) {
    var cupImageSize by remember { mutableStateOf(IntSize.Zero) }

    val screenHeight = LocalWindowInfo.current.containerSize.height.dp
    val cupCoverOffsetY = remember {
        androidx.compose.animation.core.Animatable(
            -screenHeight,
            Dp.VectorConverter
        )
    }
    val cupImageOffsetY = remember {
        androidx.compose.animation.core.Animatable(
            screenHeight,
            Dp.VectorConverter
        )
    }
    LaunchedEffect(Unit) {
        cupCoverOffsetY.animateTo((-cupImageSize.height * .03).dp)
        cupImageOffsetY.animateTo(0.dp)
    }

    Box(
        modifier = modifier,
        contentAlignment = Alignment.Center
    ) {
        Box(
            modifier = Modifier.offset(y = cupImageOffsetY.value),
            contentAlignment = Alignment.Center
        ) {
            Image(
                modifier = Modifier
                    .padding(horizontal = 58.dp)
                    .fillMaxWidth()
                    .onSizeChanged {
                        cupImageSize = it
                    },
                painter = painterResource(R.drawable.empty_cup),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
            Image(
                modifier = Modifier.size(64.dp),
                painter = painterResource(R.drawable.logo),
                contentDescription = null,
                contentScale = ContentScale.Crop
            )
        }

        Image(
            modifier = Modifier
                .padding(horizontal = 52.dp)
                .width(cupImageSize.width.dp)
                .align(Alignment.TopCenter)
                .offset(y = cupCoverOffsetY.value),
            painter = painterResource(R.drawable.cup_cover),
            contentDescription = null,
            contentScale = ContentScale.Crop
        )
    }
}