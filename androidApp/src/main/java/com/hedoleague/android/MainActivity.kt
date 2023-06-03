package com.hedoleague.android

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.hedoleague.domain.data.RankInfo
import org.koin.android.ext.android.get

class MainActivity : ComponentActivity() {
    private val viewModel: TablesViewModel = get()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewModel.getTables()
        setContent {
            MyApplicationTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    TablesComponent()
                }
            }
        }
    }

    @Composable
    fun TablesComponent() {
        val tables = viewModel.tablesStateFlow.collectAsState().value
        LazyColumn {
            items(tables.count()) { idx ->
                RankItem(tables[idx])
            }
        }
    }

    @Composable
    fun RankItem(rankInfo: RankInfo) {
        Row {
            Text(
                text = rankInfo.position.toString(),
                modifier = Modifier.padding(3.dp)
            )
            Text(
                text = rankInfo.team.name,
                modifier = Modifier.padding(3.dp)
            )
            Text(
                text = rankInfo.playGames.toString(),
                modifier = Modifier.padding(3.dp)
            )
            Text(
                text = rankInfo.won.toString(),
                modifier = Modifier.padding(3.dp)
            )
            Text(
                text = rankInfo.draw.toString(),
                modifier = Modifier.padding(3.dp)
            )
            Text(
                text = rankInfo.lost.toString(),
                modifier = Modifier.padding(3.dp)
            )
        }
    }
}

