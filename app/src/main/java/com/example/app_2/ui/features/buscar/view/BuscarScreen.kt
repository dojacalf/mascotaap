package com.example.app_2.ui.features.buscar.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.app_2.ui.features.buscar.components.SearchBar
import com.example.app_2.ui.features.buscar.components.SearchResultsList
import com.example.app_2.ui.theme.AppTheme

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun BuscarScreen(navController: NavController) {
    var searchText by remember { mutableStateOf(TextFieldValue("")) }
    val focusRequester = remember { FocusRequester() }

    // Simular resultados de búsqueda (filtrado simple)
    val sampleResults = listOf("Gato", "Perro", "Pájaro", "Hamster", "Conejo")
    val filteredResults by remember(searchText.text) {
        mutableStateOf(
            if (searchText.text.isEmpty()) emptyList()
            else sampleResults.filter { it.contains(searchText.text, ignoreCase = true) }
        )
    }

    AppTheme {
        Scaffold(
            topBar = {
                SearchBar(
                    searchText = searchText,
                    onSearchTextChange = { searchText = it },
                    focusRequester = focusRequester,
                    navController = navController
                )
            }
        ) { padding ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .background(MaterialTheme.colorScheme.background)
                    .padding(padding)
                    .padding(16.dp)
            ) {
                SearchResultsList(
                    filteredResults = filteredResults,
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }

    // Mostrar teclado al iniciar
    LaunchedEffect(Unit) {
        focusRequester.requestFocus()
    }
}

@Preview(showBackground = true)
@Composable
fun SearchScreenPreview() {
    BuscarScreen(navController = rememberNavController())
}