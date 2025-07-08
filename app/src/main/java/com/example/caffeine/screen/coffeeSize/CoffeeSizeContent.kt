package com.example.caffeine.screen.coffeeSize

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalWindowInfo
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.caffeine.R
import com.example.caffeine.component.CaffeineButton
import com.example.caffeine.screen.coffeeSize.component.AlmostSection
import com.example.caffeine.screen.coffeeSize.component.CoffeeAmountSelector
import com.example.caffeine.screen.coffeeSize.component.CoffeeSection
import com.example.caffeine.screen.coffeeSize.component.CoffeeSizeHeader
import com.example.caffeine.screen.coffeeSize.component.LoadingSection
import com.example.caffeine.screen.coffeeSize.component.SizeSelector
import com.example.caffeine.screen.coffeeSize.model.CoffeeAmount
import com.example.caffeine.screen.coffeeSize.model.CoffeeSize
import com.example.caffeine.screen.coffeeSize.state.CoffeeSizeInteraction
import com.example.caffeine.screen.coffeeSize.state.CoffeeSizeState
import com.example.caffeine.ui.theme.CaffeineTheme

@Composable
fun CoffeeSizeContent(
    state: CoffeeSizeState,
    interaction: CoffeeSizeInteraction,
    coffeeType: String,
    onBackClick: () -> Unit,
) {
    val offsetX = LocalWindowInfo.current.containerSize.width.dp
    val animatedOffsetX =
        animateDpAsState(
            if (!state.isCoffeePrepared) 0.dp else offsetX,
            animationSpec = tween(5000)
        )
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .statusBarsPadding()
            .verticalScroll(rememberScrollState()),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(modifier = Modifier.weight(1f)) {
            if (!state.isCoffeePrepared) {
                CoffeeSizeHeader(
                    modifier = Modifier.fillMaxWidth(),
                    onBackClick = onBackClick,
                    coffeeType = coffeeType
                )
            }
        }
        CoffeeSection(
            modifier = Modifier
                .fillMaxWidth(),
            coffeeSize = state.selectedSize,
            selectedAmount = state.amountCoffee
        )
        Column(
            modifier = Modifier.weight(2f),
            verticalArrangement = Arrangement.Bottom,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (!state.isCoffeePrepared) {
                SizeSelector(
                    modifier = Modifier,
                    selectedSize = state.selectedSize,
                    selectSize = interaction::onCoffeeSizeSelected
                )
                CoffeeAmountSelector(
                    modifier = Modifier.padding(top = 16.dp, bottom = 92.dp),

                    selectedAmount = state.amountCoffee,
                    selectAmount = interaction::onCoffeeAmountSelected
                )
                CaffeineButton(
                    modifier = Modifier
                        .padding(bottom = 50.dp),
                    text = stringResource(R.string.continue_txt),
                    painter = painterResource(R.drawable.right_arrow),
                    onClick = interaction::onPrepareCoffee
                )
            } else {
                LoadingSection(offsetX = animatedOffsetX.value)
                AlmostSection(modifier = Modifier.padding(bottom = 50.dp))
            }
        }
    }
}

@Preview
@Composable
fun Preview() {
    CaffeineTheme {
        CoffeeSizeContent(
            state = CoffeeSizeState(
                isCoffeePrepared = true
            ),
            interaction = object : CoffeeSizeInteraction {
                override fun onCoffeeSizeSelected(size: CoffeeSize) {}
                override fun onCoffeeAmountSelected(amount: CoffeeAmount) {}
                override fun onPrepareCoffee() {}
            },
            coffeeType = "LATTE",
            onBackClick = {}
        )
    }
}