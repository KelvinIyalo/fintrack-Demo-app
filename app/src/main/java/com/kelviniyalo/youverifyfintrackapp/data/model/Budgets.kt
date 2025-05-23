package com.kelviniyalo.youverifyfintrackapp.data.model

import com.kelviniyalo.youverifyfintrackapp.R

data class Budgets(
    val tittle: String,
    val balance: String,
    val amountSpent: String,
    val budgetAmount: String,
    val date: String,
    val isDefault: Boolean
)

val budgetItemList = listOf(
    Budgets(
        tittle = "Monthly budget",
        balance = "₦ 50,500.00",
        amountSpent = "₦ 300,000",
        budgetAmount = "₦ 350,000",
        date = "27th Mar, 2025 - 04th Apr 2025",
        isDefault = true

    ),
    Budgets(
        tittle = "Weekly budget",
        balance = "₦ 100,500.00",
        amountSpent = "₦ 150,000",
        budgetAmount = "₦ 250,500",
        date = "27th Mar, 2025 - 04th Apr 2025",
        isDefault = false

    ),
    Budgets(
        tittle = "Christmas holiday",
        balance = "₦ 1,500.00",
        amountSpent = "₦ 30,000",
        budgetAmount = "₦ 31,500",
        date = "27th Dec, 2024 - 04th Jan 2025",
        isDefault = false

    ),
    Budgets(
        tittle = "Trip to Kenya",
        balance = "₦ 1,000,000.00",
        amountSpent = "₦ 3,000,000",
        budgetAmount = "₦ 4,000,000",
        date = "13th Feb, 2025 - 14th Feb 2025",
        isDefault = false

    )
)