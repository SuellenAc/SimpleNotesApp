package com.suellen.colangelo.notes.presentation.notelist

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.suellen.colangelo.notes.R
import com.suellen.colangelo.notes.app.theme.NotesTheme
import com.suellen.colangelo.notes.app.theme.Typography

@Composable
fun NoteListScreen(
    viewModel: NoteListViewModel = hiltViewModel(),
    onNoteClick: () -> Unit,
) {
    Scaffold(
        topBar = {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = stringResource(id = R.string.notes_screen_title),
                    style = Typography.titleLarge
                )
            }
        },
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier.padding(it),
            content = {
                items(viewModel.notes.value) {
                    Column(modifier = Modifier.clickable { onNoteClick() }) {
                        Text(it.title)
                        Text(it.description)
                    }
                }
            }
        )
    }
}

@Composable
@Preview
fun NoteListScreenPreview() {
    NotesTheme {
        NoteListScreen {}
    }
}