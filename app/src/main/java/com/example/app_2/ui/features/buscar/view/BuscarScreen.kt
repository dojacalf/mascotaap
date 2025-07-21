package com.example.app_2.ui.features.buscar.view

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.app_2.navigation.AppScreens
import com.example.app_2.ui.features.buscar.components.SearchBar
import com.example.app_2.ui.features.buscar.components.SearchResultsList
import com.example.app_2.ui.features.buscar.viewmodel.BuscarViewModel
import com.example.app_2.ui.theme.AppTheme

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun BuscarScreen(
    navController: NavController,
    viewModel: BuscarViewModel = hiltViewModel()
) {
    val searchQuery by viewModel.searchQuery
    val searchResults by viewModel.searchResults.collectAsState()
    val isSearching by viewModel.isSearching
    val focusRequester = remember { FocusRequester() }

    AppTheme {
        Scaffold(
            topBar = {
                SearchBar(
                    searchText = searchQuery,
                    onSearchTextChange = { viewModel.onSearchQueryChange(it) },
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
                if (isSearching) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        CircularProgressIndicator()
                    }
                } else if (searchResults.isEmpty() && searchQuery.isNotEmpty()) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ) {
                        Text("No se encontraron resultados")
                    }
                } else {
                    SearchResultsList(
                        searchResults = searchResults,
                        onItemClick = { pet ->
                            navController.navigate(AppScreens.PerfilMascotaScreen.route + "/${pet.id}")
                        },
                        modifier = Modifier.weight(1f)
                    )
                }
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
