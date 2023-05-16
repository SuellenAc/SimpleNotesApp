package com.suellen.colangelo.notes.presentation.notedetails

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.suellen.colangelo.notes.app.theme.NotesTheme

@Composable
fun NoteDetailsScreen() {
    Text(text = "NoteDetailsScreen")
}

@Composable
@Preview
fun NoteDetailsScreenPreview() {
    NotesTheme {
        NoteDetailsScreen()
    }
}