package com.devx.jetjoke.ui.actions

sealed class AppActions

data class ShareJokeAction(val joke:String): AppActions()
