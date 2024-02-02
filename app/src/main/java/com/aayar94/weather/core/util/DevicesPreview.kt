package com.aayar94.weather.core.util

import android.content.res.Configuration
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview

@Preview(name = "Pixel4Day", device = Devices.PIXEL_4_XL)
@Preview(
    name = "Pixel4Night",
    device = Devices.PIXEL_4_XL,
    uiMode = Configuration.UI_MODE_NIGHT_YES
)
annotation class DevicesPreview