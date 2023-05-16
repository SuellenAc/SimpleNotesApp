package com.suellen.colangelo.notes.app

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.suellen.colangelo.notes.app.navigation.NotesNavHost
import com.suellen.colangelo.notes.presentation.notelist.navigation.noteListRoute

@Composable
fun MainScreen() {
    Scaffold {
        Column(modifier = Modifier.fillMaxSize()) {
            NotesNavHost(
                startDestination = noteListRoute,
                modifier = Modifier.padding(it)
            )
        }
    }
}

@Composable
@Preview
fun MainScreenPreview() {
    MainScreen()
}