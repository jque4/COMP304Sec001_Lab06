package com.skyyo.expandablelist.cards

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
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
                    ExpandableCardModel(id = 2, title = "Networking for Software Developers", description = "Learners in this course will gain hands-on experience by applying knowledge of network protocols and components to the development and maintenance of software applications. Coursework emphasizes network stacks, socket-based network applications, software-defined networks, and developing client applications that interface with various intelligent devices."),
                    ExpandableCardModel(id = 3, title = "Data Structures and Algorithms", description = "Building on fundamentals of Object-Oriented programming, this course exposes the students to algorithms and data structures. Students will analyze, evaluate and apply appropriate data structures & algorithms for the implementation of a software system. Coursework emphasizes the classical data structures, basic algorithm design, common operations on data structures, and the use of mathematical techniques to analyze the efficiency of the various algorithms. The languages of instruction are Java and Python (optional)."),
                    ExpandableCardModel(id = 4, title = "Mobile Apps Development", description = "In this mobile apps course, students will gain hands-on experience in developing and deploying mobile applications on the Android platform. Coursework emphasizes how to create advanced Graphical User Interfaces (GUIs), handle events, access remote services, store and retrieve data on the device, display maps, and use other Android APIs. Android Studio will be used to create a variety of mobile applications."),
                    ExpandableCardModel(id = 5, title = "Software Testing and Quality Assurance", description = "This course explores the goals of quality assurance and quality control activities performed during the life cycle of a software product. It focuses on integrating test processes with agile software development methodologies. Practical exercises give experience of design, specification, execution of tests plus test automation using tools through a mixture of instructor-directed exercises and student research leading to knowledge sharing."),
                    ExpandableCardModel(id = 6, title = "Linear Algebra and Statistics", description = "This course contains topics in Linear Algebra and Statistics. Linear algebra topics include operations with matrices, inverses, determinants, and vectors. Statistics topics include descriptive statistics, probability distributions as well as inferential statistics including hypothesis testing. Students will also use software applications in solving relevant problems.")
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
