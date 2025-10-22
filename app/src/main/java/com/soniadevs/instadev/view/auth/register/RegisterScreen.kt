package com.soniadevs.instadev.view.auth.register

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.soniadevs.instadev.R
import com.soniadevs.instadev.view.core.components.InstaButton
import com.soniadevs.instadev.view.core.components.InstaButtonSecondary
import com.soniadevs.instadev.view.core.components.InstaText
import com.soniadevs.instadev.view.core.components.InstaTextField

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(
    registerViewModel: RegisterViewModel = viewModel(),
    navigateBack: () -> Unit
) {
    val uiState by registerViewModel.uiState.collectAsStateWithLifecycle()

    val title: String
    val description: String
    val textFieldLabel: String
    val notification: String
    val changeModeTitle: String
    when (uiState.isPhoneMode) {
        true -> {
            title = stringResource(R.string.register_screen_text_what_is_your_phone)
            description = stringResource(R.string.register_screen_text_description_phone)
            textFieldLabel = stringResource(R.string.register_screen_text_field_phone)
            notification = stringResource(R.string.register_screen_text_notification_phone)
            changeModeTitle =
                stringResource(R.string.register_screen_secondary_button_sign_up_email)
        }

        false -> {
            title = stringResource(R.string.register_screen_text_what_is_your_email)
            description = stringResource(R.string.register_screen_text_description_email)
            textFieldLabel = stringResource(R.string.register_screen_text_field_email)
            notification = stringResource(R.string.register_screen_text_notification_email)
            changeModeTitle =
                stringResource(R.string.register_screen_secondary_button_sign_up_phone)
        }
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {},
                navigationIcon = {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.register_screen_content_description_icon_back),
                        tint = MaterialTheme.colorScheme.onSurfaceVariant,
                        modifier = Modifier.clickable { navigateBack() }
                    )
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.background
                )
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .background(MaterialTheme.colorScheme.background)
                .padding(padding)
                .padding(horizontal = 16.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            InstaText(
                modifier = Modifier.fillMaxWidth(),
                text = title,
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                style = MaterialTheme.typography.headlineLarge
            )
            Spacer(Modifier.height(4.dp))
            InstaText(
                text = description,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
            Spacer(Modifier.height(10.dp))
            InstaTextField(
                modifier = Modifier.fillMaxWidth(),
                value = uiState.value,
                label = textFieldLabel,
                onValueChange = { registerViewModel.onRegisterChanged(it) }
            )
            Spacer(Modifier.height(6.dp))
            InstaText(
                text = notification,
                color = MaterialTheme.colorScheme.onBackground
            )
            Spacer(Modifier.height(10.dp))
            InstaButton(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(R.string.register_screen_button_next),
                onClick = {},
                enabled = uiState.isRegisterEnabled
            )
            Spacer(Modifier.height(6.dp))
            InstaButtonSecondary(
                modifier = Modifier.fillMaxWidth(),
                onClick = { registerViewModel.onChangeMode() },
                text = changeModeTitle,
                titleColor = MaterialTheme.colorScheme.onSurfaceVariant,
                border = BorderStroke(1.dp, MaterialTheme.colorScheme.onBackground)
            )
            Spacer(Modifier.weight(1.3f))
            InstaText(
                modifier = Modifier.padding(4.dp),
                text = stringResource(R.string.register_screen_text_button_search_my_account),
                color = MaterialTheme.colorScheme.primary
            )
        }
    }
}
