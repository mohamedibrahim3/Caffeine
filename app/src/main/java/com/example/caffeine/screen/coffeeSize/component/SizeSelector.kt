package com.example.caffeine.screen.coffeeSize.component

import androidx.compose.animation.animateColorAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
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
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.caffeine.screen.coffeeSize.model.CoffeeSize
import com.example.caffeine.ui.theme.Urbanist
import com.example.caffeine.ui.theme.brown
import com.example.caffeine.ui.theme.darkGray
import com.example.caffeine.ui.theme.whisperGray

@Composable
fun SizeSelector(
    modifier: Modifier = Modifier,
    selectedSize: CoffeeSize = CoffeeSize.MEDIUM,
    selectSize: (CoffeeSize) -> Unit = {}
) {
    Row(
        modifier = modifier
            .background(whisperGray, shape = RoundedCornerShape(100.dp))
            .padding(8.dp),
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        CoffeeSize.entries.forEach {
            val background =
                animateColorAsState(if (selectedSize == it) brown else Color.Transparent)
            val textColor = animateColorAsState(
                if (selectedSize == it) Color.White.copy(.87f) else darkGray.copy(.6f)
            )
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .background(background.value, shape = CircleShape)
                    .clickable { selectSize(it) },
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = it.name.first().toString(),
                    style = TextStyle(
                        color = textColor.value,
                        fontSize = 20.sp,
                        fontFamily = Urbanist,
                        fontWeight = FontWeight.Bold,
                        letterSpacing = 0.25.sp,
                        textAlign = TextAlign.Center
                    )
                )
            }
        }
    }
}
@Preview
@Composable
fun SizeSelectorPreview() {
    SizeSelector(
        selectedSize = CoffeeSize.MEDIUM,
        selectSize = {}
    )
}