package me.umbrella.businesscard

import android.app.Application
import me.umbrella.businesscard.data.AppDatabase
import me.umbrella.businesscard.data.BusinessCardRepository

class App : Application() {
    val database by lazy { AppDatabase.getDatabase(this) }
    val repository by lazy { BusinessCardRepository(database.businessDao()) }
}