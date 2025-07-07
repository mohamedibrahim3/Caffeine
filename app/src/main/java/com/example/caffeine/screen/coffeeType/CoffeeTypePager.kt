package com.example.caffeine.screen.coffeeType

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CoffeeTypePager(modifier: Modifier = Modifier) {
    val pagerState = rememberPagerState(1) { CoffeeType.entries.size }
    HorizontalPager(
        modifier = modifier,
        contentPadding = PaddingValues(horizontal = 60.dp),
        pageSpacing = (-60).dp,
        state = pagerState
    ) { pageIndex ->
        CoffeeTypeCard(
            modifier = Modifier.fillMaxWidth(),
            coffeeType = CoffeeType.entries[pageIndex],
            isSelected = pageIndex == pagerState.currentPage
        )
    }
}