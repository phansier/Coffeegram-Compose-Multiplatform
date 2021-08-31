package ru.beryukhov.coffeegram.store_lib

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

abstract class InMemoryStore<Intent : Any, State : Any>(initialState: State): Store<Intent, State> {
    private val intentFlow = MutableSharedFlow<Intent>()
    protected val stateFlow = MutableStateFlow(initialState)

    override val state: StateFlow<State>
        get() = stateFlow

    override fun newIntent(intent: Intent) {
        GlobalScope.launch {
            intentFlow.emit(intent)
        }
    }

    init {
        GlobalScope.launch {
            handleIntents()
        }
    }

    private suspend fun handleIntents() {
        intentFlow.collect(collector = object : FlowCollector<Intent> {
            override suspend fun emit(value: Intent) {
                stateFlow.value = handleIntent(value)
            }

        })
    }

    protected abstract fun handleIntent(intent: Intent): State
}