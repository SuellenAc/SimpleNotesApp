package com.suellen.colangelo.notes.presentation.notedetails

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.suellen.colangelo.notes.R
import com.suellen.colangelo.notes.app.theme.NotesTheme
import com.suellen.colangelo.notes.app.theme.Typography
import com.suellen.colangelo.notes.presentation.model.NoteUiModel

@Composable
fun NoteDetailsScreen(
    noteId: String?,
    viewModel: NoteDetailsViewModel = hiltViewModel(),
) {
    viewModel.initialize(noteId)
    when (val state = viewModel.state.collectAsState().value) {
        is NoteDetailState.Loading -> Unit
        is NoteDetailState.Error -> Unit
        is NoteDetailState.Success -> NoteDetailsContent(
            note = state.note,
            onTitleChanged = {},
            onDescriptionChanged = {}
        )
    }
}

@Composable
private fun NoteDetailsContent(
    note: NoteUiModel,
    onTitleChanged: (String?) -> Unit,
    onDescriptionChanged: (String?) -> Unit,
) {
    Scaffold(
        topBar = {
            Toolbar()
        }
    ) { paddingValues ->
        Column(
            Modifier
                .padding(paddingValues)
                .fillMaxSize()
        ) {
            TextField(
                value = note.title,
                modifier = Modifier.fillMaxWidth(),
                onValueChange = { onTitleChanged(it) }
            )
            TextField(
                value = note.description,
                onValueChange = { onDescriptionChanged(it) },
                modifier = Modifier
                    .weight(1f)
                    .fillMaxWidth()
            )
        }
    }
}

@Composable
@OptIn(ExperimentalMaterial3Api::class)
private fun Toolbar() {
    CenterAlignedTopAppBar(
        title = {
            Text(
                text = stringResource(id = R.string.note_detail_screen_title),
                style = Typography.titleLarge
            )
        },
        navigationIcon = {
            // adicionar padding
            Icon(Icons.Outlined.ArrowBack, contentDescription = ""/*Todo - accessibility*/)
        },
        actions = {
            Button(onClick = { /*TODO*/ }) {
                Text(text = stringResource(id = R.string.note_detail_screen_save_button))
            }
        },
        scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
    )
}

@Composable
@Preview
fun NoteDetailsScreenPreview() {
    NotesTheme {
        NoteDetailsScreen(noteId = "")
    }
}

private fun getMockUiModel() = NoteUiModel(
    id = "",
    title = "Title",
    description = "Description",
)