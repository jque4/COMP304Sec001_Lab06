package com.skyyo.expandablelist

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import com.skyyo.expandablelist.theme.AppTheme
import com.skyyo.expandablelist.cards.ProgramsScreen
import com.skyyo.expandablelist.cards.ProgramsViewModel

class MainActivity : AppCompatActivity() {
    private val programsViewModel by viewModels<ProgramsViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        context = this
        setContent {
            AppTheme {
                Surface(color = MaterialTheme.colors.background) { ProgramsScreen(programsViewModel) }
            }
        }
    }

    companion object {
        lateinit var context: MainActivity
            private set
    }
}

