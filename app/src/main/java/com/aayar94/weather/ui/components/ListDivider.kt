package com.aayar94.weather.ui.components

import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun ListDivider(
    modifier: Modifier,
) {
    Divider(
        modifier,
        color = MaterialTheme.colorScheme.onPrimaryContainer.copy(alpha = 0.7f)
    )
}