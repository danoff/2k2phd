package org.dalab.twok2phd

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import org.dalab.twok2phd.navigation.AppNavHost
import org.dalab.twok2phd.theme.TwoKTwoPhdTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TwoKTwoPhdTheme {
                AppNavHost()
            }
        }
    }
}
