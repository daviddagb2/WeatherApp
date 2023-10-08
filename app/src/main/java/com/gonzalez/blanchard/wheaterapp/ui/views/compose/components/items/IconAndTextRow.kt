package com.gonzalez.blanchard.wheaterapp.ui.views.compose.components.items

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.gonzalez.blanchard.wheaterapp.ui.views.compose.components.texts.ItemText
import com.gonzalez.blanchard.wheaterapp.ui.views.compose.components.texts.LabelText

@Composable
fun IconAndTextRow(
    iconResId: Int,
    textItem: String = "",
    valueItem: String = "",
) {
    val iconColor = if (isSystemInDarkTheme()) Color.White else Color.Black
    Row(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth(),
        horizontalArrangement = Arrangement.Start,
        verticalAlignment = Alignment.CenterVertically,
    ) {
        Icon(
            // imageVector = icon,
            painterResource(id = iconResId),
            contentDescription = null,
            modifier = Modifier.size(50.dp).padding(end = 8.dp),
            tint = iconColor,
        )

        Column(modifier = Modifier.fillMaxWidth()) {
            LabelText(textItem)
            ItemText(valueItem)
        }
    }
}
