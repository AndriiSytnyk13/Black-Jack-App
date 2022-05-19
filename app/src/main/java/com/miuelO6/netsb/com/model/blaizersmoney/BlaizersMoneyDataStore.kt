package com.miuelO6.netsb.com.model.blaizersmoney

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.miuelO6.netsb.com.R
import dagger.hilt.android.qualifiers.ActivityContext
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import javax.inject.Inject

val Context.blaizersMoneyDataStore: DataStore<Preferences> by preferencesDataStore(R.string.blaizers_money_data_store.toString())

class BlaizersMoneyDataStore @Inject constructor(@ActivityContext private val blaizersContext: Context) {

    private val BLAIZERS_MONEY = intPreferencesKey(R.string.blaizers_money.toString())

    suspend fun getblaizersMoney(): Int =
        blaizersContext.blaizersMoneyDataStore.data.map {
            it[BLAIZERS_MONEY] ?: 0
        }.first()


    suspend fun editBlaizersMoney(getblaizersMoney: Int) {
        blaizersContext.blaizersMoneyDataStore.edit {
            it[BLAIZERS_MONEY] = getblaizersMoney
        }
    }
}
