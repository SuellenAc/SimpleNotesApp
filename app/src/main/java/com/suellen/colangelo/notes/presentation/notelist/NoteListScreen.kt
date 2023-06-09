package com.suellen.colangelo.notes.presentation.notelist

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.staggeredgrid.LazyVerticalStaggeredGrid
import androidx.compose.foundation.lazy.staggeredgrid.StaggeredGridCells
import androidx.compose.foundation.lazy.staggeredgrid.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AddCircle
import androidx.compose.material.icons.outlined.List
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.suellen.colangelo.notes.R
import com.suellen.colangelo.notes.app.theme.NotesTheme
import com.suellen.colangelo.notes.presentation.model.NoteUiModel
import com.suellen.colangelo.notes.presentation.notedetails.navigation.navigateToNoteDetails

private const val maxLines = 4

@Composable
fun NoteListScreen(
    viewModel: NoteListViewModel = hiltViewModel(),
    navController: NavHostController,
) {
    NoteListContent(
        notes = viewModel.notes.collectAsState().value,
        searchToken = viewModel.searchToken.collectAsState().value,
        showGrid = false,
        onFabClick = {},
        onNoteClick = { noteUiModel ->
            navController.navigateToNoteDetails(noteUiModel.id)
        },
        onSearchTokenChanged = {}
    )
}

@Composable
private fun NoteListContent(
    notes: List<NoteUiModel>,
    searchToken: String?,
    showGrid: Boolean,
    onFabClick: () -> Unit,
    onNoteClick: (NoteUiModel) -> Unit,
    onSearchTokenChanged: (String) -> Unit,
) {
    val text = remember {
        mutableStateOf("")
    }
    Scaffold(
        topBar = {
            Toolbar(text)
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { onFabClick() }) {
                Icon(
                    Icons.Outlined.AddCircle,
                    contentDescription = stringResource(
                        id = R.string.note_screen_add_button_content_description
                    )
                )
            }
        },
        modifier = Modifier.fillMaxSize()
    ) { paddingValues ->
        if (showGrid) {
            GridComponent(
                paddingValues = paddingValues,
                notes = notes,
                onNoteClick = onNoteClick
            )
        } else {
            ListComponent(
                paddingValues = paddingValues,
                notes = notes,
                onNoteClick = onNoteClick
            )
        }
    }
}

@Composable
private fun ListComponent(
    paddingValues: PaddingValues,
    notes: List<NoteUiModel>,
    onNoteClick: (NoteUiModel) -> Unit
) {
    LazyColumn(
        contentPadding = PaddingValues(horizontal = 8.dp),
        modifier = Modifier.padding(paddingValues),
        verticalArrangement = Arrangement.spacedBy(8.dp),
        content = {
            items(notes) { note ->
                NoteItem(onNoteClick, note)
            }
        }
    )
}

@Composable
@OptIn(ExperimentalFoundationApi::class)
private fun GridComponent(
    paddingValues: PaddingValues,
    notes: List<NoteUiModel>,
    onNoteClick: (NoteUiModel) -> Unit
) {
    LazyVerticalStaggeredGrid(
        columns = StaggeredGridCells.Adaptive(172.dp),
        verticalItemSpacing = 8.dp,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        contentPadding = PaddingValues(horizontal = 8.dp),
        modifier = Modifier.padding(paddingValues),
        content = {
            items(notes) { note ->
                NoteItem(onNoteClick, note)
            }
        }
    )
}

@Composable
private fun Toolbar(text: MutableState<String>) {
    Row(
        modifier = Modifier
            .padding(horizontal = 16.dp)
            .height(80.dp),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.Center,
    ) {
        OutlinedTextField(
            value = text.value,
            onValueChange = { text.value = it },
            modifier = Modifier
                .weight(1f)
                .padding(end = 8.dp)
                .height(54.dp),
            singleLine = true,
            textStyle = MaterialTheme.typography.titleSmall,
            placeholder = {
                Text(
                    text = stringResource(R.string.note_screen_search_placeholder),
                    style = MaterialTheme.typography.titleSmall
                )
            },
            shape = RoundedCornerShape(30.dp)
        )
        Button(
            onClick = { /*TODO*/ },
            modifier = Modifier.size(36.dp),
            contentPadding = PaddingValues(0.dp),
            shape = CircleShape
        ) {
            Icon(
                Icons.Outlined.List,
                contentDescription = stringResource(
                    id = R.string.note_screen_list_format_content_description
                )
            )
        }
    }
}

@Composable
private fun NoteItem(
    onNoteClick: (NoteUiModel) -> Unit,
    note: NoteUiModel
) {
    Card(
        shape = RoundedCornerShape(8.dp),
        border = BorderStroke(1.dp, Color.White),
    ) {
        Column(
            modifier = Modifier
                .clickable { onNoteClick(note) }
                .padding(16.dp)
                .fillMaxWidth()
        ) {
            Text(
                text = note.title,
                maxLines = maxLines,
                style = MaterialTheme.typography.titleMedium
            )
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = note.description,
                maxLines = maxLines,
                style = MaterialTheme.typography.titleSmall
            )
        }
    }
}

@Composable
@Preview
fun NoteListScreenPreview() {
    NotesTheme {
        NoteListContent(
            notes = listOf(),
            searchToken = "",
            showGrid = true,
            onFabClick = {},
            onNoteClick = {},
            onSearchTokenChanged = {}
        )
    }
}