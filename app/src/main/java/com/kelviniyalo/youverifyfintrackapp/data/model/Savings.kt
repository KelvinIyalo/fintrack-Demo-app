package com.kelviniyalo.youverifyfintrackapp.data.model

import com.kelviniyalo.youverifyfintrackapp.R

data class Savings(
    val tittle: String,
    val savedGoal: String,
    val totalGoal: String,
    val bgImage: Int,
)

val savingsItemList = listOf(
    Savings(
        tittle = "House mortgage",
        savedGoal = "₦ 500,000",
        totalGoal = "₦ 1,000,000",
        bgImage = R.drawable.rent_bg
    ),
    Savings(
        tittle = "Trip to see Obama",
        savedGoal = "₦ 50,500",
        totalGoal = "₦ 500,000",
        bgImage = R.drawable.kenya_bg
    ),
    Savings(
        tittle = "Grandma's Rent",
        savedGoal = "₦ 150,500.00",
        totalGoal = "₦ 300,000",
        bgImage = R.drawable.rent_bg
    )
)