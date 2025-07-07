package com.example.caffeine.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun BaseScreen(
    modifier: Modifier = Modifier,
    headerContent: @Composable () -> Unit,
    mainContent: @Composable ColumnScope.() -> Unit,
    actionButtonText: String,
    actionButtonIconResId: Int,
    onActionButtonClick: () -> Unit,
) {
    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        headerContent()
        Column(
            modifier = Modifier.weight(1f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            mainContent()
        }
        CaffeineButton(
            modifier = Modifier.padding(bottom = 50.dp),
            text = actionButtonText,
            painter = painterResource(id = actionButtonIconResId),
            onClick = onActionButtonClick
        )
    }
}