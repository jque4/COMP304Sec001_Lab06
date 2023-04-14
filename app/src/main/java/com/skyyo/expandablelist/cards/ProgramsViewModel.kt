package com.skyyo.expandablelist.cards

import android.content.Intent
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.skyyo.expandablelist.GPActivity
import com.skyyo.expandablelist.HITActivity
import com.skyyo.expandablelist.MainActivity
import com.skyyo.expandablelist.SETActivity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


class ProgramsViewModel: ViewModel() {

    private val _cards = MutableStateFlow(listOf<ProgramCardModel>())
    val cards: StateFlow<List<ProgramCardModel>> get() = _cards

    private val _expandedCardIdsList = MutableStateFlow(listOf<Int>())
    val expandedCardIdsList: StateFlow<List<Int>> get() = _expandedCardIdsList

    init {
        getData()
    }

    private fun getData() {
        viewModelScope.launch {
            withContext(Dispatchers.Default) {
                val programs = arrayListOf<ProgramCardModel>(
                    ProgramCardModel(id = 1, title = "Software Engineering Technology", description = ""),
                    ProgramCardModel(id = 2, title = "Software Engineering Technician", description = ""),
                    ProgramCardModel(id = 3, title = "Game Programming", description = ""),
                )
                _cards.emit(programs)
            }
        }
    }

    fun onProgramArrowClicked(cardId: Int) {
        when (cardId) {
            1 -> {
                val intent = Intent(MainActivity.context, SETActivity::class.java)
                MainActivity.context.startActivity(intent)
            }
            2 -> {
                val intent = Intent(MainActivity.context, HITActivity::class.java)
                MainActivity.context.startActivity(intent)
            }
            3 -> {
                val intent = Intent(MainActivity.context, GPActivity::class.java)
                MainActivity.context.startActivity(intent)
            }
        }
    }
}
