package com.kelviniyalo.youverifyfintrackapp.data.model

import com.kelviniyalo.youverifyfintrackapp.R

data class Expenses(
    val tittle: String? = null,
    val amount: String? = null,
    val date: String? = null,
    val bgImage: Int? = null,
    val transType: Int? = null,
    val isHeader: Boolean = false

)

val expensesItemList = listOf(
    Expenses(
        tittle = "Food & Drinks",
        amount = "₦ 8,000",
        date = "5th Mar 2025",
        bgImage = R.drawable.hamburger_bg,
        transType = 0
    ),
    Expenses(
        tittle = "Transportation",
        amount = "₦ 20,000",
        date = "9th Jul 2025",
        bgImage = R.drawable.automobile_bg,
        transType = 1
    ),
    Expenses(
        tittle = "Food & Drinks",
        amount = "₦ 10,000",
        date = "5th Mar 2025",
        bgImage = R.drawable.hamburger_bg,
        transType = 0
    ),
    Expenses(
        tittle = "Transportation",
        amount = "₦ 2,500",
        date = "9th Apr 2025",
        bgImage = R.drawable.automobile_bg,
        transType = 1
    ),
    Expenses(
        tittle = "Food & Drinks",
        amount = "₦ 13,000",
        date = "9th Apr 2025",
        bgImage = R.drawable.hamburger_bg,
        transType = 0
    ),
    Expenses(
        tittle = "Transportation",
        amount = "₦ 9,000",
        date = "9th Apr 2025",
        bgImage = R.drawable.automobile_bg,
        transType = 1
    ),
)