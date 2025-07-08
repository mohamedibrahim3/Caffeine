package com.example.caffeine.screen.coffeeSize.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
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
import com.example.caffeine.ui.theme.Urbanist
import com.example.caffeine.ui.theme.darkGray
import com.example.caffeine.ui.theme.whisperGray

@Composable
fun CoffeeSizeHeader(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit,
    coffeeType: String = ""
) {
    Row(
        modifier = modifier.padding(start = 16.dp),
        horizontalArrangement = Arrangement.spacedBy(24.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {
            Icon(
                modifier = Modifier
                    .background(whisperGray, shape = CircleShape)
                    .padding(12.dp)
                    .size(24.dp)
                    .clickable(onClick = onBackClick),
                painter = painterResource(R.drawable.arrow),
                contentDescription = null,
                tint = darkGray.copy(.87f)
            )

        Text(
            text = coffeeType.lowercase(),
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
