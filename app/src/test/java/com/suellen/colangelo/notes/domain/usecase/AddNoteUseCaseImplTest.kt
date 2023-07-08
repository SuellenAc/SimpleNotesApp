package com.suellen.colangelo.notes.domain.usecase

import com.suellen.colangelo.notes.MainDispatcherRule
import com.suellen.colangelo.notes.domain.NoteRepository
import com.suellen.colangelo.notes.factory.NoteFactory
import io.mockk.every
import io.mockk.just
import io.mockk.mockk
import io.mockk.runs
import io.mockk.verify
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Rule
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class AddNoteUseCaseImplTest {
    @get:Rule
    val mainDispatcherRule = MainDispatcherRule()

    private val noteRepository = mockk<NoteRepository>()
    private val sut = AddNoteUseCaseImpl(noteRepository)

    init {
        every { noteRepository.addNote(any()) } just runs
    }

    @Test
    fun invoke_addNote_verifyCall() = runTest {
        val note = NoteFactory.makeNote()

        sut(note)

        verify(exactly = 1) {
            noteRepository.addNote(note)
        }
    }
}