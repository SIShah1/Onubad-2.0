package com.example.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Shapes
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.domain.model.ThemeMode

internal val BSubDarkColorScheme =
  darkColorScheme(
    primary = IconSeafoamJade,
    onPrimary = Color(0xFF032620),
    primaryContainer = Color(0xFF01594D),
    onPrimaryContainer = Color(0xFFC7F2EA),
    secondary = IconSunburstGold,
    onSecondary = Color(0xFF261E00),
    secondaryContainer = Color(0xFF4E3E09),
    onSecondaryContainer = Color(0xFFFDEFA8),
    tertiary = IconRoseCoral,
    onTertiary = Color(0xFF380E0B),
    tertiaryContainer = Color(0xFF6B2520),
    onTertiaryContainer = Color(0xFFFFDAD7),
    background = StudioMidnight,
    onBackground = TextPrimaryDark,
    surface = StudioSlate,
    onSurface = TextPrimaryDark,
    surfaceVariant = StudioCard,
    onSurfaceVariant = TextSecondaryDark,
    surfaceContainerLowest = StudioMidnight,
    surfaceContainerLow = StudioAbyss,
    surfaceContainer = StudioSlate,
    surfaceContainerHigh = StudioCard,
    surfaceContainerHighest = StudioCardElevated,
    outline = StudioBorder,
    outlineVariant = Color(0xFF1E3A36),
    error = CoralError,
    onError = Color(0xFF3D0C08),
    errorContainer = CoralSurface,
    onErrorContainer = Color(0xFFFFDAD5),
  )

internal val BSubLightColorScheme =
  lightColorScheme(
    primary = IconForestTeal,
    onPrimary = Color.White,
    primaryContainer = AmberLightContainer,
    onPrimaryContainer = Color(0xFF013A32),
    secondary = CyanLightSecondary,
    onSecondary = Color.White,
    secondaryContainer = CyanLightContainer,
    onSecondaryContainer = Color(0xFF3B2B00),
    tertiary = IconTerracotta,
    onTertiary = Color.White,
    tertiaryContainer = Color(0xFFFDE4E1),
    onTertiaryContainer = Color(0xFF5C170F),
    background = LightCanvas,
    onBackground = TextPrimaryLight,
    surface = LightSurface,
    onSurface = TextPrimaryLight,
    surfaceVariant = LightSurfaceVariant,
    onSurfaceVariant = TextSecondaryLight,
    surfaceContainerLowest = Color(0xFFFFFFFF),
    surfaceContainerLow = LightSurfaceLow,
    surfaceContainer = LightSurfaceVariant,
    surfaceContainerHigh = LightSurface,
    surfaceContainerHighest = Color(0xFFDCE7E4),
    outline = LightOutline,
    outlineVariant = LightOutlineVariant,
    error = IconTerracotta,
    onError = Color.White,
    errorContainer = Color(0xFFFDE4E1),
    onErrorContainer = Color(0xFF5C170F),
  )

val BSubShapes =
  Shapes(
    small = RoundedCornerShape(12.dp),
    medium = RoundedCornerShape(18.dp),
    large = RoundedCornerShape(24.dp),
    extraLarge = RoundedCornerShape(30.dp),
  )

@Composable
fun BSubTranslatorTheme(
  themeMode: ThemeMode = ThemeMode.DARK,
  onThemeModeChange: (ThemeMode) -> Unit = {},
  animateTransitions: Boolean = true,
  content: @Composable () -> Unit,
) {
  ThemeProvider(
    themeMode = themeMode,
    onThemeModeChange = onThemeModeChange,
    animateTransitions = animateTransitions,
    content = content,
  )
}
