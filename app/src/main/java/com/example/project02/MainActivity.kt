package com.example.project02

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.core.view.WindowCompat
import com.example.project02.ui.theme.Project02Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Membuat layout bisa tembus ke status bar
        WindowCompat.setDecorFitsSystemWindows(window, false)

        // Mengubah status bar menjadi hitam dengan ikon putih
        window.statusBarColor = android.graphics.Color.BLACK
        WindowCompat.getInsetsController(window, window.decorView)
            ?.isAppearanceLightStatusBars = false

        setContent {
            Project02Theme {
                Scaffold(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color.Black) // latar belakang full hitam
                ) { innerPadding ->
                    Profile( // panggil fungsi Profile dari Profile.kt
                        modifier = Modifier
                            .padding(innerPadding)
                            .background(Color.Black)
                    )
                }
            }
        }
    }
}