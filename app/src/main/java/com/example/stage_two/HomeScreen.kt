package com.example.stage_two

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(homeViewModel: HomeViewModel, toEdit: ()->Unit) {
    val bio = homeViewModel.bio.value
    val name = homeViewModel.name.value
    val slackName = homeViewModel.slackUserName.value
    val gitName = homeViewModel.gitUserName.value

    Scaffold(
        topBar = { TopBar(stringResource(id = R.string.home))}
    ) {
        Box(
            modifier = Modifier.fillMaxWidth(),
            contentAlignment = Alignment.Center
        ) {
                Card(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(8.dp),
                    elevation = CardDefaults.cardElevation(
                        defaultElevation = 4.dp
                    )
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier.fillMaxSize(),
                        verticalArrangement = Arrangement.Center
                    ){
                        Text(
                            text = "$name",
                            style = MaterialTheme.typography.bodyLarge,
                            modifier = Modifier.padding(vertical = 8.dp)
                        )
                        Row(
                            horizontalArrangement = Arrangement.Center,
                            modifier = Modifier.padding(vertical = 16.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.slack),
                                contentDescription ="Slack Icon",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .clip(RoundedCornerShape(50))
                                    .size(40.dp)
                                    .padding(8.dp)
                            )
                            Text(
                                text ="$slackName",
                                style = MaterialTheme.typography.bodyMedium
                            )
                        }
                        Row(
                            horizontalArrangement = Arrangement.Center,
                            modifier = Modifier.padding(vertical = 16.dp)
                        ) {
                            Image(
                                painter = painterResource(id = R.drawable.git),
                                contentDescription ="github Icon",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .clip(RoundedCornerShape(50))
                                    .size(40.dp)
                                    .padding(8.dp)
                            )
                            Text(
                                text ="$gitName",
                                style = MaterialTheme.typography.bodyMedium
                            )
                        }
                        Card(
                            elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(16.dp)
                                .border(1.dp, Color.LightGray)
                                .clip(RoundedCornerShape(15))){
                            Column {
                                Text(
                                    text = stringResource(id = R.string.bio),
                                    style = MaterialTheme.typography.titleMedium,
                                    color = Color.Blue,
                                    modifier = Modifier.padding(vertical = 16.dp)
                                )
                                Text(
                                    text ="$bio",
                                    maxLines = 5,
                                    style = MaterialTheme.typography.bodyLarge,
                                    modifier = Modifier.padding(vertical = 16.dp)
                                )
                            }
                        }

                            OutlinedButton(
                                onClick = { toEdit()},
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp)
                            ) {
                                Text(
                                    text = stringResource(id = R.string.edit),
                                    style = MaterialTheme.typography.bodyMedium,
                                    color = Color.Red
                                )
                            }
                    }
            }
        }
    }
}

@Composable
fun TopBar(text: String) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(text = text,
        style = MaterialTheme.typography.titleLarge)
    }
}
