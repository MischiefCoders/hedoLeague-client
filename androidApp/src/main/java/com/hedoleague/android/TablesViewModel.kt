package com.hedoleague.android

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.hedoleague.SharedEngine
import com.hedoleague.domain.data.RankInfo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class TablesViewModel (
    val sharedEngine: SharedEngine
): ViewModel() {
    private val _tablesStateFlow = MutableStateFlow<List<RankInfo>>(listOf())
    val tablesStateFlow: StateFlow<List<RankInfo>> get() = _tablesStateFlow

    fun getTables() {
        viewModelScope.launch {
            sharedEngine.getTables()
                .collect {
                    _tablesStateFlow.emit(it)
                }
        }
    }
}