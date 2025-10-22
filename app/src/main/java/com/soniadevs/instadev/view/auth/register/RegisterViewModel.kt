package com.soniadevs.instadev.view.auth.register

import android.util.Patterns
import androidx.lifecycle.ViewModel
import com.soniadevs.instadev.R
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

class RegisterViewModel : ViewModel() {
    private val _uiState = MutableStateFlow(RegisterUiState())
    val uiState: StateFlow<RegisterUiState> = _uiState

    fun onPhoneChanged(phone: String) {
        _uiState.update { state ->
            state.copy(phone = phone)
        }
        verifyPhone()
    }

    fun onEmailChanged(email: String) {
        _uiState.update { state ->
            state.copy(email = email)
        }
        verifyEmail()
    }

    fun onRegisterWithEmailClicked() {
        _uiState.update { state ->
            state.copy(
                email = "",
                questionText = R.string.register_screen_text_what_is_your_email,
                descriptionText = R.string.register_screen_text_description_email,
                textFieldLabel = R.string.register_screen_text_field_email,
                notificationText = R.string.register_screen_text_notification_email,
                buttonText = R.string.register_screen_secondary_button_sign_up_phone
            )
        }
    }

    fun onRegisterWithPhoneClicked() {
        _uiState.update { state ->
            state.copy(
                phone = "",
                questionText = R.string.register_screen_text_what_is_your_phone,
                descriptionText = R.string.register_screen_text_description_phone,
                textFieldLabel = R.string.register_screen_text_field_phone,
                notificationText = R.string.register_screen_text_notification_phone,
                buttonText = R.string.register_screen_secondary_button_sign_up_email
            )
        }
    }

    private fun verifyPhone() {
        _uiState.update {
            it.copy(isNextEnabled = isPhoneValid(_uiState.value.phone))
        }
    }

    private fun verifyEmail() {
        _uiState.update {
            it.copy(isNextEnabled = isEmailValid(_uiState.value.email))
        }
    }

    private fun isPhoneValid(phone: String): Boolean = phone.length == 10

    private fun isEmailValid(email: String): Boolean =
        Patterns.EMAIL_ADDRESS.matcher(email).matches()

}

data class RegisterUiState(
    val phone: String = "",
    val email: String = "",
    val isNextEnabled: Boolean = false,
    val questionText: Int = R.string.register_screen_text_what_is_your_phone,
    val descriptionText: Int = R.string.register_screen_text_description_phone,
    val textFieldLabel: Int = R.string.register_screen_text_field_phone,
    val notificationText: Int = R.string.register_screen_text_notification_phone,
    val buttonText: Int = R.string.register_screen_secondary_button_sign_up_email
)
