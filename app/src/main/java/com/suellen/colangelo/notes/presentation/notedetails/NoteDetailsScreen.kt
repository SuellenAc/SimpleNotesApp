package com.suellen.colangelo.notes.presentation.notedetails

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
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
    NoteDetailsContent(
        note = getMockUiModel(),
        onTitleChanged = {},
        onDescriptionChanged = {}
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun NoteDetailsContent(
    note: NoteUiModel,
    onTitleChanged: (String?) -> Unit,
    onDescriptionChanged: (String?) -> Unit,
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = stringResource(id = R.string.note_detail_screen_title),
                        style = Typography.titleLarge
                    )
                },
                scrollBehavior = TopAppBarDefaults.enterAlwaysScrollBehavior()
            )
        }
    ) { paddingValues ->
        Column(Modifier.padding(paddingValues)) {
            TextField(
                value = note.title,
                onValueChange = { onTitleChanged(it) }
            )
            TextField(
                value = note.description,
                onValueChange = { onDescriptionChanged(it) },
                modifier = Modifier.weight(1f)
            )
        }
    }
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