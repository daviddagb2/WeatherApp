package com.gonzalez.blanchard.weatherapp.ui.views.compose.screens.settings

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gonzalez.blanchard.weatherapp.ui.views.compose.components.texts.TitleText

@Composable
fun SettingsScreen() {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
    ) {
        TitleText(value = "Settings")

        DarkModeSetting()

        Spacer(modifier = Modifier.height(16.dp))

        UnitsSetting()
    }
}

@Composable
fun DarkModeSetting() {
    var isDarkMode by remember { mutableStateOf(false) }

    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
    ) {
        Text(text = "Modo oscuro")
        Switch(checked = isDarkMode, onCheckedChange = { isDarkMode = it })
    }
}

@Composable
fun UnitsSetting() {
    var selectedUnit by remember { mutableStateOf("metrico") }

    Column {
        Text(text = "Modo:", modifier = Modifier.padding(bottom = 8.dp))
        RadioButtonGroup(
            options = listOf("metrico", "cientifico", "farenheith"),
            selectedOption = selectedUnit,
            onOptionSelected = { selectedUnit = it },
        )
    }
}

@Composable
fun RadioButtonGroup(
    options: List<String>,
    selectedOption: String,
    onOptionSelected: (String) -> Unit,
) {
    options.forEach { option ->
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(text = option.uppercase())
            RadioButton(
                selected = selectedOption == option,
                onClick = { onOptionSelected(option) },
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun SettingsScreenPreview() {
    SettingsScreen()
}
