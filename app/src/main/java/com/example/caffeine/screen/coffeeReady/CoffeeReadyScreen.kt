package com.example.caffeine.screen.coffeeReady

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Check
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.caffeine.R
import com.example.caffeine.component.CaffeineButton
import com.example.caffeine.ui.theme.Urbanist
import com.example.caffeine.ui.theme.brown
import com.example.caffeine.ui.theme.darkGray
import com.example.caffeine.ui.theme.whisperGray

@Composable
fun CoffeeReadyScreen(
    onBackClick: () -> Unit,
    navigateToSnackScreen: () -> Unit,
) {
    var startAnimation by rememberSaveable { mutableStateOf(true) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .statusBarsPadding(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            modifier = Modifier
                .padding(start = 13.dp, top = 14.dp)
                .background(whisperGray, shape = CircleShape)
                .padding(15.dp)
                .size(24.dp)
                .clickable(onClick = onBackClick)
                .align(Alignment.Start),
            imageVector = Icons.Rounded.Close,
            tint = darkGray.copy(.87f),
            contentDescription = null
        )
        Spacer(modifier = Modifier.height(18.dp))
        Box(
            modifier = Modifier
                .size(56.dp)
                .background(brown, CircleShape),
            contentAlignment = Alignment.Center
        ) {
            Icon(
                modifier = Modifier
                    .size(32.dp),
                imageVector = Icons.Rounded.Check,
                tint = Color.White,
                contentDescription = null
            )
        }
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = stringResource(R.string.your_coffee_is_ready_enjoy),
            style = TextStyle(
                color = darkGray.copy(.87f),
                fontSize = 22.sp,
                fontFamily = Urbanist,
                fontWeight = FontWeight.Bold,
                letterSpacing = 0.25.sp,
                textAlign = TextAlign.Center
            )
        )
        Spacer(modifier = Modifier.height(37.dp))
        CupAnimation()
        Spacer(modifier = Modifier.height(27.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            SwitchCup(isOff = startAnimation) { startAnimation = !startAnimation }
            Text(
                text = "Take Away",
                style = TextStyle(
                    color = darkGray.copy(.7f),
                    fontSize = 14.sp,
                    fontFamily = Urbanist,
                    fontWeight = FontWeight.Bold,
                    letterSpacing = 0.25.sp,
                    textAlign = TextAlign.Center
                )
            )
        }
        Spacer(modifier = Modifier.height(16.dp))
        CaffeineButton(
            text = "Take snack",
            painter = painterResource(R.drawable.right_arrow),
            onClick = navigateToSnackScreen
        )
    }
}
@Preview
@Composable
fun CoffeeReadyScreenPreview() {
    CoffeeReadyScreen(
        onBackClick = {},
        navigateToSnackScreen = {}
    )
}