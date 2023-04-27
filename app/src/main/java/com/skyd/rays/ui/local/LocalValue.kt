package com.skyd.rays.ui.local

import androidx.compose.material3.windowsizeclass.WindowSizeClass
import androidx.compose.runtime.compositionLocalOf
import androidx.navigation.NavHostController
import com.skyd.rays.model.preference.CurrentStickerUuidPreference
import com.skyd.rays.model.preference.IgnoreUpdateVersionPreference
import com.skyd.rays.model.preference.IntersectSearchBySpacePreference
import com.skyd.rays.model.preference.QueryPreference
import com.skyd.rays.model.preference.StickerClassificationModelPreference
import com.skyd.rays.model.preference.StickerScalePreference
import com.skyd.rays.model.preference.UseRegexSearchPreference
import com.skyd.rays.model.preference.WebDavServerPreference
import com.skyd.rays.model.preference.theme.CustomPrimaryColorPreference
import com.skyd.rays.model.preference.theme.DarkModePreference
import com.skyd.rays.model.preference.theme.ThemeNamePreference

val LocalNavController = compositionLocalOf<NavHostController> {
    error("LocalNavController not initialized!")
}

val LocalWindowSizeClass = compositionLocalOf<WindowSizeClass> {
    error("LocalWindowSizeClass not initialized!")
}

// Theme
val LocalDarkMode = compositionLocalOf { DarkModePreference.default }
val LocalThemeName = compositionLocalOf { ThemeNamePreference.default }
val LocalCustomPrimaryColor = compositionLocalOf { CustomPrimaryColorPreference.default }

// Update
val LocalIgnoreUpdateVersion = compositionLocalOf { IgnoreUpdateVersionPreference.default }

// Sticker
val LocalCurrentStickerUuid = compositionLocalOf { CurrentStickerUuidPreference.default }
val LocalQuery = compositionLocalOf { QueryPreference.default }

// Search
val LocalUseRegexSearch = compositionLocalOf { UseRegexSearchPreference.default }
val LocalIntersectSearchBySpace = compositionLocalOf { IntersectSearchBySpacePreference.default }

// WebDav
val LocalWebDavServer = compositionLocalOf { WebDavServerPreference.default }

// ML
val LocalStickerClassificationModel =
    compositionLocalOf { StickerClassificationModelPreference.default }

// Style
val LocalStickerScale = compositionLocalOf { StickerScalePreference.default }

