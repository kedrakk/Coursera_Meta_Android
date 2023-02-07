package com.littlelemon.littlelemonmenueditor

import androidx.lifecycle.LiveData
import androidx.room.*

@Entity
data class MenuItem(
    @PrimaryKey val id: String,
    val name: String,
    val price: Double
)

@Dao
interface MenuDao{
    @Query("SELECT * FROM menuItem")
    fun getMenuItems():LiveData<List<MenuItem>>

    @Insert()
    fun saveMenuItem(menuItem: MenuItem)

    @Delete
    fun deleteMenuItem(menuItem: MenuItem)
}

@Database(entities = [MenuItem::class], version = 1)
abstract class MenuDatabase:RoomDatabase(){
    abstract fun menuDao():MenuDao
}
