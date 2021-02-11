package fr.isen.teamui.api

import fr.isen.teamui.model.Account
import retrofit2.http.GET

interface AccountServices {
    @GET("accounts")
    suspend fun getAccounts(): List<Account>

}