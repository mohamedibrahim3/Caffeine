package com.example.caffeine.screen.coffeeSize.component

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.caffeine.R
import com.example.caffeine.screen.coffeeSize.model.CoffeeAmount
import com.example.caffeine.ui.theme.Urbanist
import com.example.caffeine.ui.theme.brown
import com.example.caffeine.ui.theme.darkGray
import com.example.caffeine.ui.theme.whisperGray

@Composable
fun CoffeeAmountSelector(
    modifier: Modifier = Modifier,
    selectedAmount: CoffeeAmount = CoffeeAmount.MEDIUM,
    selectAmount: (CoffeeAmount) -> Unit = {}
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            modifier = Modifier
                .background(whisperGray, shape = RoundedCornerShape(100.dp))
                .padding(8.dp),
            horizontalArrangement = Arrangement.spacedBy(8.dp)
        ) {
            CoffeeAmount.entries.forEach {
                val background =
                    animateColorAsState(if (selectedAmount == it) brown else Color.Transparent)
                Image(
                    modifier = Modifier
                        .size(40.dp)
                        .background(background.value, shape = CircleShape)
                        .padding(8.dp)
                        .clickable {
                            selectAmount(it)
                        },
                    painter = painterResource(R.drawable.coffee_bean),
                    contentDescription = null
                )
            }
        }
        Row(
            modifier = Modifier,
            horizontalArrangement = Arrangement.spacedBy(19.dp)
        ) {
            CoffeeAmount.entries.forEach {
                Text(
                    text = it.name.lowercase(),
                    style = TextStyle(
                        color = darkGray.copy(.6f),
                        fontSize = 10.sp,
                        fontFamily = Urbanist,
                        fontWeight = FontWeight.Medium,
                        letterSpacing = 0.25.sp,
                        textAlign = TextAlign.Center
                    )
                )
            }
        }
    }
}