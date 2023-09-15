package com.example.stage_two

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditScreen(homeViewModel: HomeViewModel, backHome: ()->Unit) {
    Scaffold(topBar = { TopBar(stringResource(id = R.string.edit))}) {
        var name by remember{mutableStateOf(homeViewModel.name.value)}
        var bio by remember{mutableStateOf(homeViewModel.bio.value)}
        var gitUserName by remember{ mutableStateOf(homeViewModel.gitUserName.value)}
        var slackUserName by remember{mutableStateOf(homeViewModel.slackUserName.value)}
        Column(
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            OutlinedTextField(
                value = name!!,
                onValueChange = { newValue ->
                    name = newValue
                },
                label = { Text(text = "Name")},
                placeholder = { Text(text = "John Doe")},
                singleLine = true,
                maxLines = 1,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            )
            OutlinedTextField(
                value = slackUserName!!,
                onValueChange = { newValue ->
                    slackUserName = newValue
                },
                label = { Text(text = "Slack Username")},
                placeholder = { Text(text = "John Doe")},
                singleLine = true,
                maxLines = 1,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            )
            OutlinedTextField(
                value = gitUserName!!,
                onValueChange = { newValue ->
                    gitUserName = newValue
                },
                label = { Text(text = "Git username")},
                placeholder = { Text(text = "John Doe")},
                singleLine = true,
                maxLines = 1,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            )
            OutlinedTextField(
                value = bio!!,
                onValueChange = { newValue ->
                    bio = newValue
                },
                label = { Text(text = "Bio")},
                placeholder = { Text(text = "Short description about self")},
                singleLine = false,
                maxLines = 5,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            )

            OutlinedButton(onClick = { backHome() },
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)) {
                Text(
                    text = stringResource(id = R.string.apply),
                    style = MaterialTheme.typography.bodyMedium,
                    color = Color.Cyan
                )
            }
        }
    }
}