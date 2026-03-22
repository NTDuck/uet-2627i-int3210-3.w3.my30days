package com.github.ntduck.int3210_3.my30days

import androidx.compose.runtime.getValue
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.foundation.lazy.items
import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.github.ntduck.int3210_3.my30days.ui.theme.My30daysTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            My30daysTheme {
                Scaffold(
                    modifier = Modifier.fillMaxSize(),
                    topBar = {
                        TopAppBar(
                            title = {
                                Text(text = stringResource(R.string.bartitle))
                            },
                            modifier = Modifier.padding(top = 8.dp),
                        )
                    }
                ) { innerPadding ->
                    DayOfCatScreen(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun DayOfCatScreen(modifier: Modifier = Modifier) {
    LazyColumn(modifier) {
        items(DayOfCatRepository.items) { model ->
            DayOfCatView(
                model = model,
                modifier = Modifier.padding(vertical = 8.dp, horizontal = 16.dp),
            )
        }
    }
}

@Composable
fun DayOfCatView(model: DayOfCatModel, modifier: Modifier = Modifier) {
    var expanded by remember { mutableStateOf(false) }

    Card(
        elevation = CardDefaults.cardElevation(2.dp),
        modifier = modifier
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioNoBouncy,
                    stiffness = Spring.StiffnessMedium,
                )
            )
            .background(MaterialTheme.colorScheme.background),
        onClick = { expanded = !expanded }
    ) {
        Column (
            modifier = Modifier.fillMaxWidth()
                .padding(16.dp)
        ){
            Text(
                text = "Day ${model.day}",
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.onBackground,
            )

            Text(
                text = stringResource(model.title),
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onBackground,
            )

            Image(
                painter = painterResource(model.image),
                contentDescription = null
            )

            Spacer(modifier = Modifier.height(8.dp))

            if (expanded) {
                Text(
                    text = stringResource(model.desc),
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onBackground,
                )
            }
        }
    }
}

object DayOfCatRepository {
    val items = (1..30).map { day -> DayOfCatModel(
        day = day,
        title = getTitle(day),
        desc = getDesc(day),
        image = getImage(day),
    ) }

    private fun getTitle(day: Int) = when (day) {
        1 -> R.string.title1
        2 -> R.string.title2
        3 -> R.string.title3
        4 -> R.string.title4
        5 -> R.string.title5
        6 -> R.string.title6
        7 -> R.string.title7
        8 -> R.string.title8
        9 -> R.string.title9
        10 -> R.string.title10
        11 -> R.string.title11
        12 -> R.string.title12
        13 -> R.string.title13
        14 -> R.string.title14
        15 -> R.string.title15
        16 -> R.string.title16
        17 -> R.string.title17
        18 -> R.string.title18
        19 -> R.string.title19
        20 -> R.string.title20
        21 -> R.string.title21
        22 -> R.string.title22
        23 -> R.string.title23
        24 -> R.string.title24
        25 -> R.string.title25
        26 -> R.string.title26
        27 -> R.string.title27
        28 -> R.string.title28
        29 -> R.string.title29
        30 -> R.string.title30
        else -> error("...")
    }

    private fun getDesc(day: Int) = when (day) {
        1 -> R.string.desc1
        2 -> R.string.desc2
        3 -> R.string.desc3
        4 -> R.string.desc4
        5 -> R.string.desc5
        6 -> R.string.desc6
        7 -> R.string.desc7
        8 -> R.string.desc8
        9 -> R.string.desc9
        10 -> R.string.desc10
        11 -> R.string.desc11
        12 -> R.string.desc12
        13 -> R.string.desc13
        14 -> R.string.desc14
        15 -> R.string.desc15
        16 -> R.string.desc16
        17 -> R.string.desc17
        18 -> R.string.desc18
        19 -> R.string.desc19
        20 -> R.string.desc20
        21 -> R.string.desc21
        22 -> R.string.desc22
        23 -> R.string.desc23
        24 -> R.string.desc24
        25 -> R.string.desc25
        26 -> R.string.desc26
        27 -> R.string.desc27
        28 -> R.string.desc28
        29 -> R.string.desc29
        30 -> R.string.desc30
        else -> error("...")
    }

    private fun getImage(day: Int) = when (day) {
        1 -> R.drawable.cat1
        2 -> R.drawable.cat2
        3 -> R.drawable.cat3
        4 -> R.drawable.cat4
        5 -> R.drawable.cat5
        6 -> R.drawable.cat6
        7 -> R.drawable.cat7
        8 -> R.drawable.cat8
        9 -> R.drawable.cat9
        10 -> R.drawable.cat10
        11 -> R.drawable.cat11
        12 -> R.drawable.cat12
        13 -> R.drawable.cat13
        14 -> R.drawable.cat14
        15 -> R.drawable.cat15
        16 -> R.drawable.cat16
        17 -> R.drawable.cat17
        18 -> R.drawable.cat18
        19 -> R.drawable.cat19
        20 -> R.drawable.cat20
        21 -> R.drawable.cat21
        22 -> R.drawable.cat22
        23 -> R.drawable.cat23
        24 -> R.drawable.cat24
        25 -> R.drawable.cat25
        26 -> R.drawable.cat26
        27 -> R.drawable.cat27
        28 -> R.drawable.cat28
        29 -> R.drawable.cat29
        30 -> R.drawable.cat30
        else -> error("...")
    }
}

data class DayOfCatModel(
    val day: Int,
    @StringRes val title: Int,
    @StringRes val desc: Int,
    @DrawableRes val image: Int
)
