package fr.isen.teamui.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import fr.isen.teamui.model.Account

@Dao
interface TeamuiDao {
    @Query("SELECT * FROM account_table")
    fun getAllAccounts(): LiveData<List<Account>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addAccount(account: Account)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun updateAccounts(accounts: List<Account>)
}