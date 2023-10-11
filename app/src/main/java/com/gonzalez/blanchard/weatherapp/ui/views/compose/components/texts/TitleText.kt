package com.gonzalez.blanchard.weatherapp.ui.views.compose.components.texts

import android.content.res.Configuration.UI_MODE_NIGHT_NO
import android.content.res.Configuration.UI_MODE_NIGHT_YES
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TitleText(value: String) {
    val color = if (isSystemInDarkTheme()) {
        Color.White
    } else {
        Color.Black
    }
    Text(
        text = value,
        fontSize = 28.sp,
        style = titleTextStyle,
        color = color,
        modifier = Modifier.padding(bottom = 5.dp),

    )
}

@Composable
fun SubTitleText(value: String) {
    val color = if (isSystemInDarkTheme()) {
        Color.LightGray
    } else {
        Color.Gray
    }
    Text(text = value, fontSize = 18.sp, style = textStyle2, color = color, modifier = Modifier)
}

@Composable
fun LabelText(value: String) {
    val color = if (isSystemInDarkTheme()) {
        Color.LightGray
    } else {
        Color.Gray
    }
    Text(text = value, fontSize = 12.sp, style = textStyle2, color = color, modifier = Modifier)
}

@Composable
fun ItemText(value: String) {
    val color = if (isSystemInDarkTheme()) {
        Color.LightGray
    } else {
        Color.Gray
    }
    Text(text = value, fontSize = 16.sp, style = textStyle2, color = color, modifier = Modifier.padding(bottom = 10.dp))
}

@Preview(uiMode = UI_MODE_NIGHT_NO)
@Composable
fun PreviewTitleText() {
    TitleText("Hello Day")
}

@Preview(uiMode = UI_MODE_NIGHT_YES)
@Composable
fun PreviewTitleTextNIGHT() {
    TitleText("Hello Night")
}
