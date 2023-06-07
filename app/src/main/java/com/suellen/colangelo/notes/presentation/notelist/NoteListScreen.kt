package com.suellen.colangelo.notes.presentation.notelist

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.suellen.colangelo.notes.R
import com.suellen.colangelo.notes.app.theme.NotesTheme
import com.suellen.colangelo.notes.app.theme.Typography
import com.suellen.colangelo.notes.presentation.model.NoteUiModel
import com.suellen.colangelo.notes.presentation.notedetails.navigation.navigateToNoteDetails

@Composable
fun NoteListScreen(
    viewModel: NoteListViewModel = hiltViewModel(),
    navController: NavHostController,
) {
    NoteListContent(
        viewModel.notes.collectAsState().value
    ) {
        navController.navigateToNoteDetails()
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun NoteListContent(
    notes: List<NoteUiModel>,
    onNoteClick: (NoteUiModel) -> Unit,
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = stringResource(id = R.string.notes_screen_title),
                        style = Typography.titleLarge
                    )
                },
                scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
            )
        },
        modifier = Modifier.fillMaxSize()
    ) { paddingValues ->
        LazyColumn(
            modifier = Modifier.padding(paddingValues),
            content = {
                items(notes) {note ->
                    Column(modifier = Modifier.clickable { onNoteClick(note) }) {
                        Text(note.title)
                        Text(note.description)
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
        NoteListContent(listOf()) {}
    }
}