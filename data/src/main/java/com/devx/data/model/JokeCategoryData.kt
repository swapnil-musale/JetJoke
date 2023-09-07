@file:Suppress("konsist.files under 'model' package should be data class only")

package com.devx.data.model

object JokeCategoryData {
    val jokeCategories = arrayListOf<String>().apply {
        add("Any")
        add("Programming")
        add("Miscellaneous")
        add("Dark")
        add("Pun")
        add("Spooky")
        add("Christmas")
    }
}
