package fr.isen.teamui.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "account_table")
data class Account(
    @PrimaryKey var id: Int,
    var account_name: String,
    var amount: String,
    var iban: String,
    var currency: String
) {}
