package ru.beryukhov.coffeegram.pages

import androidx.compose.foundation.Icon
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope.weight
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.IconButton
import androidx.compose.material.TopAppBar
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowLeft
import androidx.compose.material.icons.filled.KeyboardArrowRight
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ContextAmbient
import androidx.compose.ui.semantics.accessibilityLabel
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.ParagraphStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import org.threeten.bp.LocalDate
import org.threeten.bp.YearMonth
import org.threeten.bp.format.TextStyle
import ru.beryukhov.coffeegram.data.DayCoffee
import ru.beryukhov.coffeegram.model.DaysCoffeesStore
import ru.beryukhov.coffeegram.model.NavigationIntent
import ru.beryukhov.coffeegram.model.NavigationStore
import ru.beryukhov.coffeegram.view.MonthTable


@Composable
fun TablePage(yearMonth: YearMonth, daysCoffeesStore: DaysCoffeesStore, navigationStore: NavigationStore) {
    val coffeesState by daysCoffeesStore.state.collectAsState()

    TopAppBar(title = {
        Row(horizontalArrangement = Arrangement.Center) {
            Text(
                modifier = Modifier.weight(1f),
                text = AnnotatedString(
                    text = yearMonth.month.getDisplayName(TextStyle.FULL, ContextAmbient.current.resources.configuration.locale),
                    paragraphStyle = ParagraphStyle(textAlign = TextAlign.Center)
                )
            )

        }
    },
        navigationIcon = { IconButton(onClick = {navigationStore.newIntent(NavigationIntent.PreviousMonth)}, modifier = Modifier.semantics { accessibilityLabel = "ArrowLeft" }) { Icon(Icons.Default.KeyboardArrowLeft) } },
        actions = { IconButton(onClick = {navigationStore.newIntent(NavigationIntent.NextMonth)}, modifier = Modifier.semantics { accessibilityLabel = "ArrowRight" }) { Icon(Icons.Default.KeyboardArrowRight) } }
    )

    Column(modifier = Modifier.weight(1f), horizontalAlignment = Alignment.End) {
        MonthTable(
            yearMonth,
            coffeesState.coffees.filter { entry:  Map.Entry<LocalDate, DayCoffee> -> entry.key.year == yearMonth.year && entry.key.month == yearMonth.month }
                .mapKeys {entry: Map.Entry<LocalDate, DayCoffee> -> entry.key.dayOfMonth  }
                .mapValues { entry: Map.Entry<Int, DayCoffee> -> entry.value.getIconId() },
            navigationStore,
            modifier = Modifier.weight(1f)
        )
        Text("${yearMonth.year}", modifier = Modifier.padding(16.dp))
    }
}