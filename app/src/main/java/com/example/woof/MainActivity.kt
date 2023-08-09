package com.example.woof

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.compose.WoofAppTheme
import com.example.woof.ui.theme.kat.Kitty
import com.example.woof.ui.theme.kittys.CatResource

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            WoofAppTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold(
                        topBar = {
                            TopAppBar(title = {
                                Row(verticalAlignment = Alignment.CenterVertically) {
                                    Image(
                                        painter = painterResource(R.drawable.catphunch),
                                        contentDescription = "logo",
                                        modifier = Modifier
                                            .padding(20.dp)
                                            .size(50.dp)
                                    )

                                    Text(
                                        text = "Kitty's",
                                        fontFamily = FontFamily(
                                            Font(R.font.abri, weight = FontWeight.Normal)
                                        ),
                                        fontSize = 50.sp
                                    )
                                }
                            })
                        }
                    ) { padding ->
                        val state = rememberScrollState()
                        Column(modifier = Modifier.padding(padding)) {
                            val allData = CatResource().getAll()
                            LazyColumn(
                                modifier = Modifier
                                    .fillMaxSize()
                                    .padding(10.dp),
                                verticalArrangement = Arrangement.spacedBy(16.dp)
                            ) {
                                items(allData) { item ->
                                    makeCard(item)
                                }
                            }

                        }
                    }
                }
            }
        }
    }
}

@Composable
fun makeCard(item: Kitty) {
    Card(
        modifier = Modifier
            .clip(
                RoundedCornerShape(
                    topStart = 15.dp,
                    topEnd = 50.dp,
                    bottomStart = 50.dp,
                    bottomEnd = 15.dp
                )
            )
    )
    {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(5.dp)
        ) {
            Image(
                painter = painterResource(id = item.imageResource),
                contentDescription = "",
                modifier = Modifier
                    .size(70.dp)
                    .padding(7.dp)
                    .clip(CircleShape)
            )
            Column(modifier = Modifier.weight(.8f)) {
                Text(
                    text = stringResource(id = item.stringResource),
                    fontSize = 25.sp,
                    style = MaterialTheme.typography.displayMedium,
                    fontWeight = FontWeight.Bold

                )

                Text(
                    text = stringResource(id = item.titleResource),
                    style = MaterialTheme.typography.bodyLarge,
                    fontWeight = FontWeight.Light
                )
            }


        }
    }
}

