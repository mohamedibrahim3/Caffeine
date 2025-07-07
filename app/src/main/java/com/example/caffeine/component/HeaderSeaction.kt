package com.example.caffeine.component

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.caffeine.R
import com.example.caffeine.ui.theme.darkGray

@Composable
fun HeaderSection(
   modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
       Image(
           painter = painterResource(R.drawable.profile),
           contentDescription = null,
           modifier = Modifier
               .size(48.dp)
               .clip(CircleShape)
       )
        Icon(
            painter = painterResource(R.drawable.add),
            contentDescription = null,
            modifier = Modifier
                .size(24.dp)
                .clip(CircleShape),
            tint = darkGray.copy(.87f)
        )
    }
}

@Preview
@Composable
fun HeaderSectionPreview() {
    HeaderSection()
}