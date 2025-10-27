package com.soniadevs.instadev.view.auth.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.soniadevs.instadev.R
import com.soniadevs.instadev.view.core.components.InstaButton
import com.soniadevs.instadev.view.core.components.InstaButtonSecondary
import com.soniadevs.instadev.view.core.components.InstaTextField

@Composable
fun LoginScreen(
    loginViewModel: LoginViewModel = hiltViewModel(),
    navigateToRegister: () -> Unit
) {
    val uiState by loginViewModel.uiState.collectAsStateWithLifecycle()

    Scaffold { padding ->
        Column(
            Modifier
                .background(MaterialTheme.colorScheme.background)
                .padding(padding)
                .padding(horizontal = 24.dp)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                modifier = Modifier.padding(top = 22.dp),
                text = stringResource(R.string.login_screen_header_text_spain),
                color = MaterialTheme.colorScheme.onBackground
            )
            Spacer(Modifier.weight(1f))
            Image(
                modifier = Modifier.size(56.dp),
                painter = painterResource(R.drawable.instadev_logo),
                contentDescription = stringResource(R.string.login_screen_content_description_image_insta_dev_logo)
            )
            Spacer(Modifier.weight(1f))
            InstaTextField(
                modifier = Modifier.fillMaxWidth(),
                value = uiState.email,
                label = stringResource(R.string.login_screen_text_field_email),
                onValueChange = { loginViewModel.onEmailChanged(it) }
            )
            Spacer(Modifier.height(10.dp))
            InstaTextField(
                modifier = Modifier.fillMaxWidth(),
                value = uiState.password,
                label = stringResource(R.string.login_screen_text_field_password),
                onValueChange = { loginViewModel.onPasswordChanged(it) })
            Spacer(Modifier.height(10.dp))
            InstaButton(
                modifier = Modifier.fillMaxWidth(),
                text = stringResource(R.string.login_screen_button_sign_in),
                onClick = { loginViewModel.onClickedSelected()},
                enabled = uiState.isLoginEnabled,
            )
            TextButton(onClick = {}) {
                Text(
                    text = stringResource(R.string.login_screen_text_button_forgot_password),
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }
            Spacer(Modifier.weight(1.3f))
            InstaButtonSecondary(
                modifier = Modifier.fillMaxWidth(),
                onClick = { navigateToRegister() },
                text = stringResource(R.string.login_screen_secondary_button_sign_up)
            )
            Icon(
                modifier = Modifier
                    .width(80.dp)
                    .padding(vertical = 24.dp),
                painter = painterResource(R.drawable.ic_meta),
                contentDescription = stringResource(R.string.login_screen_content_description_icon_meta_logo),
                tint = MaterialTheme.colorScheme.onBackground
            )
        }
    }
}
