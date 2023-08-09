package com.example.woof.ui.theme.kat

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class Kitty(
    @StringRes val stringResource : Int,
    @StringRes val titleResource : Int,
    @DrawableRes val imageResource : Int
)