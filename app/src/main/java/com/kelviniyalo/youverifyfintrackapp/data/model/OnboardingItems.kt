package com.kelviniyalo.youverifyfintrackapp.data.model

import com.kelviniyalo.youverifyfintrackapp.R

data class OnboardingItems(
    val title: String,
    val body: String,
    val image: Int
)

val onBoardingItemsList = listOf(
    OnboardingItems(
        "Track Your \nExpenses",
        "Get insights into where your money goes and make informed financial decisions.",
        R.drawable.trading_drw
    ),
    OnboardingItems(
        "Set Savings \nGoals",
        "Whether it’s for a vacation, a new car, or an emergency fund, we help you stay on track.",
        R.drawable.money_drw
    ),
    OnboardingItems(
        "Get Financial \nInsights",
        "Access detailed reports and analytics to make better financial choices.",
        R.drawable.finance_drw
    )
)