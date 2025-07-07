package com.example.caffeine.screen.coffeeType

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.caffeine.R
import com.example.caffeine.component.BaseScreen
import com.example.caffeine.component.HeaderSection

@Composable
fun CoffeeTypeScreen(
    navigateToCupSizeScreen: () -> Unit = {}
) {
    CoffeeTypeContent(navigateToCupSizeScreen)
}

@Composable
fun CoffeeTypeContent(
    navigateToCupSizeScreen: () -> Unit
) {
    BaseScreen(
        modifier = Modifier
            .statusBarsPadding()
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(rememberScrollState()),
        actionButtonText = stringResource(R.string.continue_text),
        actionButtonIconResId = R.drawable.right_arrow,
        onActionButtonClick = navigateToCupSizeScreen,
        headerContent = {
            HeaderSection(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .padding(top = 16.dp)
            )
        },
    ) {
        Column(
            modifier = Modifier
                .padding(top = 16.dp)
                .weight(1f),
            verticalArrangement = Arrangement.spacedBy(56.dp)
        ) {
            MorningGreeting(modifier = Modifier.padding(horizontal = 16.dp))
            CoffeeTypePager(modifier = Modifier.height(298.dp))
        }
    }
}

@Preview
@Composable
fun CoffeeTypeScreenPreview() {
    CoffeeTypeScreen()
}