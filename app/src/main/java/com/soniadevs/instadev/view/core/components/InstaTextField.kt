package com.soniadevs.instadev.view.core.components

import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shape

@Composable
fun InstaTextField(
    modifier: Modifier = Modifier,
    shape: Shape = MaterialTheme.shapes.medium,
    value: String,
    label: String,
    onValueChange: (String) -> Unit,
) {
    OutlinedTextField(
        modifier = modifier,
        shape = shape,
        label = { InstaText(text = label) },
        value = value,
        onValueChange = { onValueChange(it) }
    )
}
