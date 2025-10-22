package com.soniadevs.instadev.view.core.components

import androidx.compose.foundation.BorderStroke
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun InstaButtonSecondary(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    border: BorderStroke = BorderStroke(1.dp, MaterialTheme.colorScheme.primary),
    text: String
) {
    OutlinedButton(
        modifier = modifier,
        onClick = { onClick() },
        border = border
    ) {
        InstaText(
            text = text,
            color = MaterialTheme.colorScheme.primary
        )
    }
}
