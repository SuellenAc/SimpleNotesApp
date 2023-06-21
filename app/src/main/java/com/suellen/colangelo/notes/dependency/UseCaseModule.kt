package com.suellen.colangelo.notes.dependency

import com.suellen.colangelo.notes.domain.usecase.AddNoteUseCase
import com.suellen.colangelo.notes.domain.usecase.AddNoteUseCaseImpl
import com.suellen.colangelo.notes.domain.usecase.DeleteNoteUseCase
import com.suellen.colangelo.notes.domain.usecase.DeleteNoteUseCaseImpl
import com.suellen.colangelo.notes.domain.usecase.GetAllNotesUseCase
import com.suellen.colangelo.notes.domain.usecase.GetAllNotesUseCaseImpl
import com.suellen.colangelo.notes.domain.usecase.GetNoteUseCase
import com.suellen.colangelo.notes.domain.usecase.GetNoteUseCaseImpl
import com.suellen.colangelo.notes.domain.usecase.UpdateNoteUseCase
import com.suellen.colangelo.notes.domain.usecase.UpdateNoteUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent

@Module
@InstallIn(ViewModelComponent::class)
abstract class UseCaseModule {
    @Binds
    abstract fun bindAddNoteUseCase(
        impl: AddNoteUseCaseImpl
    ): AddNoteUseCase

    @Binds
    abstract fun bindDeleteNoteUseCase(
        impl: DeleteNoteUseCaseImpl
    ): DeleteNoteUseCase

    @Binds
    abstract fun bindGetAllNotesUseCaseImpl(
        impl: GetAllNotesUseCaseImpl
    ): GetAllNotesUseCase

    @Binds
    abstract fun bindGetNoteUseCase(
        impl: GetNoteUseCaseImpl
    ): GetNoteUseCase

    @Binds
    abstract fun bindUpdateNoteUseCase(
        impl: UpdateNoteUseCaseImpl
    ): UpdateNoteUseCase
}