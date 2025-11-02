package com.example.project02

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import com.example.project02.ui.theme.Project02Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Project02Theme {
                // Latar belakang aplikasi
                Surface(
                    color = MaterialTheme.colorScheme.background
                ) {
                    // Panggil salah satu form di sini
                    // Ganti ke FormDataDiri(modifier = Modifier) kalau mau pakai form yang itu
                    FormDaftar(modifier = Modifier)
                }
            }
        }
    }
}
