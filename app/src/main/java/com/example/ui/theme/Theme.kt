// BSubTheme.kt - Jetpack Compose (Material 3) theme for BSub Translator.
// Palette comes straight from the clover app icon.
// Change the package line to match your project, then wrap your app:
//
//   BSubTheme(darkTheme = when (settings.themeMode) {
//       ThemeMode.Dark -> true
//       ThemeMode.Light -> false
//       ThemeMode.System -> isSystemInDarkTheme()
//   }) { AppRoot() }
//
// Old burnt-orange (#B45309) and cyan (#CCF7FC) are fully replaced:
//   orange accents / Save button -> colorScheme.primary (forest green)
//   cyan selected states         -> colorScheme.primaryContainer (mint)
//   delete icons                 -> colorScheme.error
//   cooldown warnings            -> colorScheme.tertiaryContainer (blush)
package com.example.ui.theme

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Shapes
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.Immutable
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.CornerRadius
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/* ---------- Brand colours (from the icon) ---------- */

object Brand {
    val Forest = Color(0xFF017767)
    val Mint = Color(0xFF66C2B3)
    val Sun = Color(0xFFF4D45B)
    val Blush = Color(0xFFF59791)
    val Vermilion = Color(0xFFD74B3A)
}

/* ---------- Colour schemes ---------- */

private val LightColors = lightColorScheme(
    primary = Color(0xFF017767),
    onPrimary = Color(0xFFFFFFFF),
    primaryContainer = Color(0xFFC9EBE4),
    onPrimaryContainer = Color(0xFF00382F),
    inversePrimary = Color(0xFF66C2B3),
    secondary = Color(0xFF7A6200),
    onSecondary = Color(0xFFFFFFFF),
    secondaryContainer = Color(0xFFFBE9A0),
    onSecondaryContainer = Color(0xFF3B2F00),
    tertiary = Color(0xFFB23A2B),
    onTertiary = Color(0xFFFFFFFF),
    tertiaryContainer = Color(0xFFFDE0DD),
    onTertiaryContainer = Color(0xFF7F2A20),
    error = Color(0xFFBA1A1A),
    onError = Color(0xFFFFFFFF),
    errorContainer = Color(0xFFFFDAD6),
    onErrorContainer = Color(0xFF410002),
    background = Color(0xFFF3F8F6),
    onBackground = Color(0xFF0E211D),
    surface = Color(0xFFF3F8F6),
    onSurface = Color(0xFF0E211D),
    surfaceVariant = Color(0xFFDDEBE7),
    onSurfaceVariant = Color(0xFF4A625D),
    surfaceTint = Color(0xFF017767),
    surfaceContainerLowest = Color(0xFFFFFFFF),
    surfaceContainerLow = Color(0xFFEFF6F3),
    surfaceContainer = Color(0xFFE9F2EF),
    surfaceContainerHigh = Color(0xFFE2EDE9),
    surfaceContainerHighest = Color(0xFFDAE7E2),
    outline = Color(0xFF6F8A84),
    outlineVariant = Color(0xFFD5E5E0),
    inverseSurface = Color(0xFF223B36),
    inverseOnSurface = Color(0xFFE3EEEA),
)

private val DarkColors = darkColorScheme(
    primary = Color(0xFF66C2B3),
    onPrimary = Color(0xFF00382F),
    primaryContainer = Color(0xFF17463E),
    onPrimaryContainer = Color(0xFFBFEDE3),
    inversePrimary = Color(0xFF017767),
    secondary = Color(0xFFF4D45B),
    onSecondary = Color(0xFF3B2F00),
    secondaryContainer = Color(0xFF4A3B00),
    onSecondaryContainer = Color(0xFFF9E48F),
    tertiary = Color(0xFFF59791),
    onTertiary = Color(0xFF5F150D),
    tertiaryContainer = Color(0xFF4E211B),
    onTertiaryContainer = Color(0xFFFFB9B0),
    error = Color(0xFFFFB4AB),
    onError = Color(0xFF690005),
    errorContainer = Color(0xFF93000A),
    onErrorContainer = Color(0xFFFFDAD6),
    background = Color(0xFF0B1412),
    onBackground = Color(0xFFE3EEEA),
    surface = Color(0xFF0B1412),
    onSurface = Color(0xFFE3EEEA),
    surfaceVariant = Color(0xFF1D302C),
    onSurfaceVariant = Color(0xFF9DB7B0),
    surfaceTint = Color(0xFF66C2B3),
    surfaceContainerLowest = Color(0xFF07100E),
    surfaceContainerLow = Color(0xFF0F1B18),
    surfaceContainer = Color(0xFF12201D),
    surfaceContainerHigh = Color(0xFF182A26),
    surfaceContainerHighest = Color(0xFF1F332E),
    outline = Color(0xFF7F9A93),
    outlineVariant = Color(0xFF25403A),
    inverseSurface = Color(0xFFE3EEEA),
    inverseOnSurface = Color(0xFF0E211D),
)

/* ---------- Extra colours Material 3 has no slot for ---------- */

@Immutable
data class BSubExtras(
    val hero: Color,          // header card background
    val onHero: Color,
    val onHeroMuted: Color,   // subtitle on the header card
    val heroChip: Color,      // translucent chip on the header card
    val sunAccent: Color,     // brand yellow: progress dot, highlight chips
    val onSunAccent: Color,
    val logSurface: Color,    // terminal-style log box (dark in both modes)
    val onLogSurface: Color,
)

private val LightExtras = BSubExtras(
    hero = Color(0xFF017767),
    onHero = Color(0xFFFFFFFF),
    onHeroMuted = Color(0xFFBFE6DE),
    heroChip = Color(0x29FFFFFF),
    sunAccent = Brand.Sun,
    onSunAccent = Color(0xFF3B2F00),
    logSurface = Color(0xFF0E211D),
    onLogSurface = Color(0xFF8FD6C8),
)

private val DarkExtras = BSubExtras(
    hero = Color(0xFF0B4A40),
    onHero = Color(0xFFE3F6F1),
    onHeroMuted = Color(0xFF9FD3C8),
    heroChip = Color(0x29FFFFFF),
    sunAccent = Brand.Sun,
    onSunAccent = Color(0xFF3B2F00),
    logSurface = Color(0xFF07100E),
    onLogSurface = Color(0xFF66C2B3),
)

private val LocalBSubExtras = staticCompositionLocalOf { LightExtras }

object BSub {
    val extras: BSubExtras
        @Composable get() = LocalBSubExtras.current
}

/* ---------- Shapes: the "petal" is the one signature move ---------- */
// Three round corners, one sharp corner, like the icon's teardrops.
// Use it only on the header card, the main action button, and the selected nav indicator.
// Everything else uses the calm, uniform shapes below.

object BSubShape {
    val petal = RoundedCornerShape(topStart = 28.dp, topEnd = 28.dp, bottomEnd = 28.dp, bottomStart = 6.dp)
    val petalSmall = RoundedCornerShape(topStart = 16.dp, topEnd = 16.dp, bottomEnd = 16.dp, bottomStart = 4.dp)
}

val BSubShapes = Shapes(
    extraSmall = RoundedCornerShape(8.dp),
    small = RoundedCornerShape(12.dp),
    medium = RoundedCornerShape(14.dp),   // segmented controls, text fields, tonal buttons
    large = RoundedCornerShape(20.dp),    // cards
    extraLarge = RoundedCornerShape(28.dp),
)

/* ---------- Typography ---------- */
// Swap FontFamily.SansSerif for your app font (for example a bundled Plus Jakarta Sans
// or Figtree). Android falls back to Noto Sans Bengali for Bengali text automatically.

private val Sans = FontFamily.SansSerif
val BSubMono = FontFamily.Monospace   // counts, file names, logs, model names

private val BSubTypography = Typography(
    displaySmall = TextStyle(fontFamily = Sans, fontWeight = FontWeight.Medium, fontSize = 28.sp, lineHeight = 34.sp, letterSpacing = (-0.4).sp),
    headlineMedium = TextStyle(fontFamily = Sans, fontWeight = FontWeight.Medium, fontSize = 24.sp, lineHeight = 30.sp, letterSpacing = (-0.3).sp),
    headlineSmall = TextStyle(fontFamily = Sans, fontWeight = FontWeight.Medium, fontSize = 21.sp, lineHeight = 27.sp, letterSpacing = (-0.3).sp),
    titleLarge = TextStyle(fontFamily = Sans, fontWeight = FontWeight.Medium, fontSize = 18.sp, lineHeight = 24.sp, letterSpacing = (-0.1).sp),
    titleMedium = TextStyle(fontFamily = Sans, fontWeight = FontWeight.Medium, fontSize = 16.sp, lineHeight = 22.sp),
    titleSmall = TextStyle(fontFamily = Sans, fontWeight = FontWeight.Medium, fontSize = 14.sp, lineHeight = 20.sp),
    bodyLarge = TextStyle(fontFamily = Sans, fontWeight = FontWeight.Normal, fontSize = 16.sp, lineHeight = 24.sp),
    bodyMedium = TextStyle(fontFamily = Sans, fontWeight = FontWeight.Normal, fontSize = 14.sp, lineHeight = 20.sp),
    bodySmall = TextStyle(fontFamily = Sans, fontWeight = FontWeight.Normal, fontSize = 12.sp, lineHeight = 16.sp),
    labelLarge = TextStyle(fontFamily = Sans, fontWeight = FontWeight.Medium, fontSize = 15.sp, lineHeight = 20.sp),
    labelMedium = TextStyle(fontFamily = BSubMono, fontWeight = FontWeight.Medium, fontSize = 12.sp, lineHeight = 16.sp),
    labelSmall = TextStyle(fontFamily = Sans, fontWeight = FontWeight.Medium, fontSize = 11.sp, lineHeight = 16.sp),
)

/* ---------- Theme ---------- */

@Composable
fun BSubTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit,
) {
    val colors = if (darkTheme) DarkColors else LightColors
    val extras = if (darkTheme) DarkExtras else LightExtras
    CompositionLocalProvider(LocalBSubExtras provides extras) {
        MaterialTheme(
            colorScheme = colors,
            typography = BSubTypography,
            shapes = BSubShapes,
            content = content,
        )
    }
}

/* ---------- Ready-made components ---------- */

/** Main action ("Start translation", "Save default prompt"). */
@Composable
fun PetalButton(
    text: String,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    icon: (@Composable () -> Unit)? = null,
) {
    val cs = MaterialTheme.colorScheme
    Button(
        onClick = onClick,
        enabled = enabled,
        modifier = modifier.height(52.dp),
        shape = BSubShape.petal,
        colors = ButtonDefaults.buttonColors(
            containerColor = cs.primary,
            contentColor = cs.onPrimary,
            disabledContainerColor = cs.surfaceContainerHigh,
            disabledContentColor = cs.onSurfaceVariant,
        ),
    ) {
        if (icon != null) {
            icon()
            Spacer(Modifier.width(8.dp))
        }
        Text(text, style = MaterialTheme.typography.labelLarge)
    }
}

enum class ChipKind { Translated, Active, Pending, Cooldown, Idle }

/** Status pills: Translated / Active = mint, Pending = yellow, Cooldown = blush, Idle = neutral. */
@Composable
fun StatusChip(text: String, kind: ChipKind, modifier: Modifier = Modifier) {
    val cs = MaterialTheme.colorScheme
    val (bg, fg) = when (kind) {
        ChipKind.Translated, ChipKind.Active -> cs.primaryContainer to cs.onPrimaryContainer
        ChipKind.Pending -> cs.secondaryContainer to cs.onSecondaryContainer
        ChipKind.Cooldown -> cs.tertiaryContainer to cs.onTertiaryContainer
        ChipKind.Idle -> cs.surfaceContainerHigh to cs.onSurfaceVariant
    }
    Surface(modifier = modifier, shape = CircleShape, color = bg, contentColor = fg) {
        Text(
            text = text,
            modifier = Modifier.padding(horizontal = 12.dp, vertical = 6.dp),
            style = MaterialTheme.typography.labelMedium,
        )
    }
}

/** Green fill on a mint track with a yellow dot at the leading edge. progress is 0f..1f. */
@Composable
fun BSubProgressBar(progress: Float, modifier: Modifier = Modifier) {
    val cs = MaterialTheme.colorScheme
    val sun = BSub.extras.sunAccent
    val p = progress.coerceIn(0f, 1f)
    Canvas(modifier = modifier.fillMaxWidth().height(12.dp)) {
        val barH = 8.dp.toPx()
        val dotR = 6.dp.toPx()
        val top = (size.height - barH) / 2f
        drawRoundRect(cs.primaryContainer, Offset(0f, top), Size(size.width, barH), CornerRadius(barH / 2f))
        val w = size.width * p
        if (w > 0f) {
            drawRoundRect(cs.primary, Offset(0f, top), Size(w, barH), CornerRadius(barH / 2f))
            val cx = w.coerceIn(dotR, size.width - dotR)
            drawCircle(sun, dotR, Offset(cx, size.height / 2f))
        }
    }
}

// Compatibility aliases required by ThemeProvider.kt
internal val BSubDarkColorScheme = DarkColors

internal val BSubLightColorScheme = LightColors
