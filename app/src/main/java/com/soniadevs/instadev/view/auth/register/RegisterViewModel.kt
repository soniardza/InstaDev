package com.soniadevs.instadev.view.auth.register

import android.util.Patterns
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class RegisterViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(RegisterUiState())
    val uiState: StateFlow<RegisterUiState> = _uiState

    fun onChangeMode() {
        _uiState.update {
            it.copy(
                isPhoneMode = !it.isPhoneMode,
                value = ""
            )
        }
    }

    fun onRegisterChanged(value: String) {
        _uiState.update { state ->
            val isEnabled = if (state.isPhoneMode) {
                isPhoneValid(value = value)
            } else {
                isEmailValid(value = value)
            }
            state.copy(
                isRegisterEnabled = isEnabled,
                value = value
            )
        }
    }

    private fun isPhoneValid(value: String): Boolean = value.length >= 10

    private fun isEmailValid(value: String): Boolean =
        Patterns.EMAIL_ADDRESS.matcher(value).matches()
}

data class RegisterUiState(
    val value: String = "",
    val isPhoneMode: Boolean = true,
    val isRegisterEnabled: Boolean = false,
)
