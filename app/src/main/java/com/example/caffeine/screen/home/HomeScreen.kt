package com.example.caffeine.screen.home

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
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
fun HomeScreen(
    navigateToCoffeeTypeScreen: () -> Unit = {}
) {
    HomeContent(navigateToCoffeeTypeScreen = navigateToCoffeeTypeScreen)
}

@Composable
fun HomeContent(
    navigateToCoffeeTypeScreen: () -> Unit
) {
    BaseScreen(
        modifier = Modifier
            .statusBarsPadding()
            .fillMaxSize()
            .background(Color.White)
            .verticalScroll(rememberScrollState()),
        actionButtonText = stringResource(R.string.bring_my_coffee),
        actionButtonIconResId = R.drawable.cup_of_coffee,
        onActionButtonClick = navigateToCoffeeTypeScreen,
        headerContent = {
            HeaderSection(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp)
                    .padding(top = 16.dp)
            )
        },
    ) {
        HocusPocusSection(
            modifier = Modifier
                .padding(horizontal = 58.dp)
                .padding(top = 24.dp)
        )
        Ghost()
    }
}

@Preview
@Composable
fun HomeScreenPreview() {
    HomeScreen()
}