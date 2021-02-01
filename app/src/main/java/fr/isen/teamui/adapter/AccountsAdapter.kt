package fr.isen.teamui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import fr.isen.teamui.R
import fr.isen.teamui.model.Account

class AccountsAdapter() : BaseRecyclerViewAdapter<Account>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.card_account, parent, false)
        return AccountViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val viewHolder = holder as? AccountViewHolder
        viewHolder?.setUpAccount(account = getItem(position))
    }

    inner class AccountViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private var accountName: TextView = itemView.findViewById(R.id.accountNameTextView)
        private var accountAmount: TextView = itemView.findViewById(R.id.accountAmountTextView)
        private var accountCurrency: TextView = itemView.findViewById(R.id.accountCurrencyTextView)
        private var accountIban: TextView = itemView.findViewById(R.id.accountIbanTextView)

        fun setUpAccount(account: Account?) {
            accountName.text = account?.account_name
            accountAmount.text = account?.amount
            accountCurrency.text = account?.currency
            accountIban.text = account?.iban
        }

    }

}