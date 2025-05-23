package com.kelviniyalo.youverifyfintrackapp.data.model

import com.kelviniyalo.youverifyfintrackapp.R

data class AccountTypes(
    val tittle: String,
    val balance: String,
    val actionMessage: String,
    val message: String,
    val isProgress: Boolean,
    val bgColor: Int,
    val textColor: Int,
    val progressColor: Int,
    val actionColor: Int,
    val bgImage: Int
)

val accountTypesList = listOf(
    AccountTypes(
        tittle = "Account balance",
        balance = "₦ 1,000,500.55",
        actionMessage = "Manage Accounts",
        message = "The total balance from your linked accounts.",
        isProgress = false,
        bgColor = R.color.fintrack_green,
        bgImage = R.drawable.balance_bg,
        textColor = R.color.white,
        progressColor = R.color.white,
        actionColor = R.color.white
    ),
    AccountTypes(
        tittle = "Total savings",
        balance = "₦ 50,530.00",
        actionMessage = "View Savings",
        message = "You need N250,000 to meet your targets.",
        isProgress = true,
        bgColor = R.color.fintrack_savings,
        bgImage = R.drawable.savings_bg,
        textColor = R.color.white,
        progressColor = R.color.white,
        actionColor = R.color.white
    ),
    AccountTypes(
        tittle = "Monthly budget",
        balance = "₦ 1,000,500.55",
        actionMessage = "Manage Budget",
        message = "left out of N200,000,000 budgeted.",
        isProgress = true,
        bgColor = R.color.white,
        bgImage = R.drawable.budget_bg,
        textColor = R.color.black,
        progressColor = R.color.fintrack_savings,
        actionColor = R.color.fintrack_green

    ),
    AccountTypes(
        tittle = "Total expenses",
        balance = "₦ 1,000,500.55",
        actionMessage = "View expenses",
        message = "spent in the last 7 days",
        isProgress = true,
        bgColor = R.color.fintrack_expense,
        bgImage = R.drawable.expence_bg,
        textColor = R.color.black,
        progressColor = R.color.fintrack_savings,
        actionColor = R.color.fintrack_green
    )

)
