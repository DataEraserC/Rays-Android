package com.skyd.rays.model.preference

import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import com.skyd.rays.ext.dataStore
import com.skyd.rays.ext.toSettings
import com.skyd.rays.model.preference.theme.CustomPrimaryColorPreference
import com.skyd.rays.model.preference.theme.DarkModePreference
import com.skyd.rays.model.preference.theme.ThemeNamePreference
import com.skyd.rays.ui.local.LocalCurrentStickerUuid
import com.skyd.rays.ui.local.LocalCustomPrimaryColor
import com.skyd.rays.ui.local.LocalDarkMode
import com.skyd.rays.ui.local.LocalIgnoreUpdateVersion
import com.skyd.rays.ui.local.LocalIntersectSearchBySpace
import com.skyd.rays.ui.local.LocalQuery
import com.skyd.rays.ui.local.LocalStickerClassificationModel
import com.skyd.rays.ui.local.LocalStickerScale
import com.skyd.rays.ui.local.LocalThemeName
import com.skyd.rays.ui.local.LocalUseRegexSearch
import com.skyd.rays.ui.local.LocalWebDavServer
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.map

data class Settings(
    // Theme
    val themeName: String = ThemeNamePreference.default,
    val customPrimaryColor: String = CustomPrimaryColorPreference.default,
    val darkMode: Int = DarkModePreference.default,
    // Update
    val ignoreUpdateVersion: Long = IgnoreUpdateVersionPreference.default,
    // Sticker
    val currentStickerUuid: String = CurrentStickerUuidPreference.default,
    val query: String = QueryPreference.default,
    // Search
    val useRegexSearch: Boolean = UseRegexSearchPreference.default,
    val intersectSearchBySpace: Boolean = IntersectSearchBySpacePreference.default,
    // WebDav
    val webDavServer: String = WebDavServerPreference.default,
    // ML
    val stickerClassificationModel: String = StickerClassificationModelPreference.default,
    // Style
    val stickerScale: String = StickerScalePreference.default,
)

@Composable
fun SettingsProvider(
    content: @Composable () -> Unit,
) {
    val context = LocalContext.current
    val settings = remember {
        context.dataStore.data.map { it.toSettings() }
    }.collectAsState(initial = Settings(), context = Dispatchers.Default).value

    CompositionLocalProvider(
        // Theme
        LocalThemeName provides settings.themeName,
        LocalCustomPrimaryColor provides settings.customPrimaryColor,
        LocalDarkMode provides settings.darkMode,
        // Update
        LocalIgnoreUpdateVersion provides settings.ignoreUpdateVersion,
        // Sticker
        LocalCurrentStickerUuid provides settings.currentStickerUuid,
        LocalQuery provides settings.query,
        // Search
        LocalUseRegexSearch provides settings.useRegexSearch,
        LocalIntersectSearchBySpace provides settings.intersectSearchBySpace,
        // WebDav
        LocalWebDavServer provides settings.webDavServer,
        // ML
        LocalStickerClassificationModel provides settings.stickerClassificationModel,
        // Style
        LocalStickerScale provides settings.stickerScale,
    ) {
        content()
    }
}