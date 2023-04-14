package com.skyyo.expandablelist.cards

import androidx.compose.runtime.Immutable

@Immutable
data class ProgramCardModel(
    val id: Int,
    val title: String,
    val description: String)