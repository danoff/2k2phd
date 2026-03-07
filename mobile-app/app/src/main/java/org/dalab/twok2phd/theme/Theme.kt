package org.dalab.twok2phd.theme

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable

private val LightColors = lightColorScheme(
    primary = BluePrimary,
    secondary = MintAccent,
    background = Mist,
    onBackground = Ink
)

private val DarkColors = darkColorScheme(
    primary = BluePrimary,
    secondary = MintAccent
)

@Composable
fun TwoKTwoPhdTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = LightColors,
        content = content
    )
}
