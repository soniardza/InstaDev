package com.soniadevs.instadev.view.auth.register

import android.widget.Toolbar
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.soniadevs.instadev.R
import com.soniadevs.instadev.view.core.components.InstaButton
import com.soniadevs.instadev.view.core.components.InstaButtonSecondary
import com.soniadevs.instadev.view.core.components.InstaText
import com.soniadevs.instadev.view.core.components.InstaTextField

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun RegisterScreen(registerViewModel: RegisterViewModel = viewModel()) {
    val uiState by registerViewModel.uiState.collectAsStateWithLifecycle()

    Scaffold(
        topBar = {
            TopAppBar(
                title = {},
                navigationIcon = {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                        contentDescription = stringResource(R.string.register_screen_content_description_icon_back),
                        tint = MaterialTheme.colorScheme.onSurfaceVariant
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
                text = stringResource(uiState.questionText),
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                style = MaterialTheme.typography.headlineLarge
            )
            Spacer(Modifier.height(4.dp))
            InstaText(
                text = stringResource(uiState.descriptionText),
                color = MaterialTheme.colorScheme.onSurfaceVariant,
                style = MaterialTheme.typography.titleSmall
            )
            Spacer(Modifier.height(10.dp))
            InstaTextField(
                modifier = Modifier.fillMaxWidth(),
                shape = RoundedCornerShape(30),
                value = if (uiState.textFieldLabel == R.string.register_screen_text_field_phone) {
                    uiState.phone
                } else {
                    uiState.email
                },
                label = stringResource(uiState.textFieldLabel),
                onValueChange = {
                    if (uiState.textFieldLabel == R.string.register_screen_text_field_phone) {
                        registerViewModel.onPhoneChanged(it)
                    } else {
                        registerViewModel.onEmailChanged(it)
                    }
                }
            )
            Spacer(Modifier.height(6.dp))
            InstaText(
                text = stringResource(uiState.notificationText),
                color = MaterialTheme.colorScheme.onBackground
            )
            Spacer(Modifier.height(10.dp))
            InstaButton(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(R.string.register_screen_button_next),
                onClick = {},
                enabled = uiState.isNextEnabled
            )
            Spacer(Modifier.height(6.dp))
            InstaButtonSecondary(
                modifier = Modifier.fillMaxWidth(),
                onClick = {
                    if (uiState.textFieldLabel == R.string.register_screen_text_field_phone) {
                        registerViewModel.onRegisterWithEmailClicked()
                    } else {
                        registerViewModel.onRegisterWithPhoneClicked()
                    }
                },
                text = stringResource(uiState.buttonText),
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
