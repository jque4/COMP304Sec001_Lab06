package com.skyyo.expandablelist.cards

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.skyyo.expandablelist.R
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CardsViewModel: ViewModel() {

    private val _cards = MutableStateFlow(listOf<ExpandableCardModel>())
    val cards: StateFlow<List<ExpandableCardModel>> get() = _cards

    private val _expandedCardIdsList = MutableStateFlow(listOf<Int>())
    val expandedCardIdsList: StateFlow<List<Int>> get() = _expandedCardIdsList

    init {
        getData()
    }

    private fun getData() {
        viewModelScope.launch {
            withContext(Dispatchers.Default) {
                val courses = arrayListOf<ExpandableCardModel>(
                    ExpandableCardModel(id = 1, title = "Programming 3", description = "The goal of this course is to enable students, " +
                            "already proficient in OOP, to build robust and more complex, data-driven desktop applications using the .NET " +
                            "technologies. Coursework emphasizes advanced topics, such as generics, extension methods, linear data structures," +
                            " delegates, asynchronous programming, parallel programming, advanced GUI, Entity Framework core, ML.NET framework, " +
                            "etc. The language of instruction is C#."),
                    ExpandableCardModel(id = 2, title = "Networking for Software Developers", description = "blah blah"),
                    ExpandableCardModel(id = 3, title = "Data Structures and Algorithms", description = "blah three blah"),
                    ExpandableCardModel(id = 4, title = "Mobile Apps Development", description = "blah four blah"),
                    ExpandableCardModel(id = 5, title = "Software Testing and Quality Assurance", description = "blah five blah"),
                    ExpandableCardModel(id = 6, title = "Linear Algebra and Statistics", description = "blah six blah")
                )
                _cards.emit(courses)
            }
        }
    }

    fun onCardArrowClicked(cardId: Int) {
        _expandedCardIdsList.value = _expandedCardIdsList.value.toMutableList().also { list ->
            if (list.contains(cardId)) list.remove(cardId) else list.add(cardId)
        }
    }
}
