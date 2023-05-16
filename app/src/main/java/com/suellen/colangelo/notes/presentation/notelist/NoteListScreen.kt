package com.suellen.colangelo.notes.presentation.notelist

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.suellen.colangelo.notes.app.theme.NotesTheme

@Composable
fun NoteListScreen(
    onNoteClick: () -> Unit,
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .clickable {
                onNoteClick()
            }.fillMaxSize()
    ) {
        Text(text = "NoteListScreen")
    }
}

@Composable
@Preview
fun NoteListScreenPreview() {
    NotesTheme {
        NoteListScreen {}
    }
}