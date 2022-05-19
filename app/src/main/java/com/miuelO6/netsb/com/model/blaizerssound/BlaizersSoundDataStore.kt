package com.miuelO6.netsb.com.model.blaizerssound

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import com.miuelO6.netsb.com.R
import dagger.hilt.android.qualifiers.ActivityContext
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import javax.inject.Inject

val Context.blaizersSoundDataStore: DataStore<Preferences> by preferencesDataStore(R.string.blaizers_sound_data_store.toString())

class BlaizersSoundDataStore @Inject constructor(@ActivityContext private val blaizersContext: Context) {

    private val BLAIZERS_SOUND = booleanPreferencesKey(R.string.blaizers_sound.toString())

    suspend fun getblaizersSound(): Boolean =
        blaizersContext.blaizersSoundDataStore.data.map {
            it[BLAIZERS_SOUND] ?: true
        }.first()


    suspend fun switchBlaizersSound(isBlaizersSound: Boolean) {
        blaizersContext.blaizersSoundDataStore.edit {
            it[BLAIZERS_SOUND] = isBlaizersSound
        }
    }
}
