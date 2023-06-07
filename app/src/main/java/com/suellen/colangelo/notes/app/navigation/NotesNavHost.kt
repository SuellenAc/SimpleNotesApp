package com.suellen.colangelo.notes.app.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.suellen.colangelo.notes.presentation.notedetails.navigation.openNoteDetails
import com.suellen.colangelo.notes.presentation.notelist.navigation.openNoteList

@Composable
fun NotesNavHost(
    startDestination: String,
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController()
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier,
    ) {
        openNoteList(navController = navController)
        openNoteDetails()
    }
}