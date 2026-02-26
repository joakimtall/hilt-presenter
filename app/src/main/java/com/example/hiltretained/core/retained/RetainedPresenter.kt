package com.example.hiltretained.core.retained

import androidx.annotation.CallSuper
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.cancel

abstract class RetainedPresenter : RetainedComponent {
    protected val presenterScope: CoroutineScope =
        CoroutineScope(SupervisorJob() + Dispatchers.Main.immediate)

    @CallSuper
    override fun onCleared() {
        presenterScope.cancel()
    }
}
