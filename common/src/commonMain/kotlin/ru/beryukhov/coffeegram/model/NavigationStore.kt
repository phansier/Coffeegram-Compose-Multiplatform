package ru.beryukhov.coffeegram.model

import kotlinx.datetime.LocalDate
import ru.beryukhov.coffeegram.store_lib.InMemoryStore

class NavigationStore : InMemoryStore<NavigationIntent, NavigationState>(
    initialState = NavigationState.TablePage(nowYM())
) {

    override fun handleIntent(intent: NavigationIntent): NavigationState {
        return when (intent) {
            NavigationIntent.NextMonth ->
                increaseMonth(stateFlow.value.yearMonth)

            NavigationIntent.PreviousMonth ->
                decreaseMonth(stateFlow.value.yearMonth)

            is NavigationIntent.OpenCoffeeListPage ->
                NavigationState.CoffeeListPage(
                    LocalDate(
                        year = stateFlow.value.yearMonth.year,
                        month = stateFlow.value.yearMonth.month,
                        dayOfMonth = intent.dayOfMonth
                    )
                )

            NavigationIntent.ReturnToTablePage -> NavigationState.TablePage(stateFlow.value.yearMonth)
        }
    }

    private fun increaseMonth(yearMonth: YearMonth): NavigationState {
        return NavigationState.TablePage(yearMonth.plusMonths(1))
    }

    private fun decreaseMonth(yearMonth: YearMonth): NavigationState {
        return NavigationState.TablePage(yearMonth.minusMonths(1))
    }
}

sealed class NavigationIntent {
    object NextMonth : NavigationIntent()
    object PreviousMonth : NavigationIntent()
    data class OpenCoffeeListPage(val dayOfMonth: Int) : NavigationIntent()
    object ReturnToTablePage : NavigationIntent()
}

sealed class NavigationState(val yearMonth: YearMonth) {
    class TablePage(yearMonth: YearMonth) : NavigationState(yearMonth)
    data class CoffeeListPage(val date: LocalDate) : NavigationState(
        YearMonth(date.year, date.month)
    )
}
