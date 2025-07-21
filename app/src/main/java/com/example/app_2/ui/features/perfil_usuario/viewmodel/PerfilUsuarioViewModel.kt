package com.example.app_2.ui.features.perfil_usuario.viewmodel

import android.net.Uri
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.app_2.domain.model.User
import com.example.app_2.domain.repository.AuthRepository
import com.example.app_2.domain.repository.UserRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

data class UserProfileState(
    val user: User? = null,
    val isLoading: Boolean = true,
    val error: String? = null
)

@HiltViewModel
class PerfilUsuarioViewModel @Inject constructor(
    private val authRepository: AuthRepository,
    private val userRepository: UserRepository
) : ViewModel() {

    private val _state = mutableStateOf(UserProfileState())
    val state: State<UserProfileState> = _state

    var showUpdatePhoneDialog by mutableStateOf(false)
        private set
    var showUpdateAboutMeDialog by mutableStateOf(false)
        private set
    var showUpdateAddressDialog by mutableStateOf(false)
        private set
    var showUpdateNameDialog by mutableStateOf(false)
        private set

    init {
        loadUserProfile()
    }

    // --- Dialog Visibility Handlers ---
    fun onShowUpdatePhoneDialog() { showUpdatePhoneDialog = true }
    fun onDismissUpdatePhoneDialog() { showUpdatePhoneDialog = false }
    fun onShowUpdateAboutMeDialog() { showUpdateAboutMeDialog = true }
    fun onDismissUpdateAboutMeDialog() { showUpdateAboutMeDialog = false }
    fun onShowUpdateAddressDialog() { showUpdateAddressDialog = true }
    fun onDismissUpdateAddressDialog() { showUpdateAddressDialog = false }
    fun onShowUpdateNameDialog() { showUpdateNameDialog = true }
    fun onDismissUpdateNameDialog() { showUpdateNameDialog = false }


    // --- Data Update Handlers ---
    fun updatePhoneNumber(newPhone: String) {
        updateField("phone", newPhone) { user, value -> user.copy(phone = value) }
    }

    fun updateAboutMe(newAboutMe: String) {
        updateField("aboutMe", newAboutMe) { user, value -> user.copy(aboutMe = value) }
        onDismissUpdateAboutMeDialog()
    }

    fun updateAddress(newAddress: String) {
        updateField("address", newAddress) { user, value -> user.copy(address = value) }
        onDismissUpdateAddressDialog()
    }

    fun updateName(newName: String) {
        updateField("name", newName) { user, value -> user.copy(name = value) }
    }

    fun updateProfilePicture(uri: Uri) {
        viewModelScope.launch {
            val currentUser = state.value.user
            if (currentUser != null) {
                try {
                    _state.value = _state.value.copy(isLoading = true)
                    val downloadUrl = userRepository.updateProfilePicture(currentUser.userId, uri)
                    val updatedUser = currentUser.copy(profilePictureUrl = downloadUrl)
                    _state.value = _state.value.copy(user = updatedUser, isLoading = false)
                } catch (e: Exception) {
                    _state.value = _state.value.copy(error = "Error al actualizar la foto de perfil.", isLoading = false)
                }
            }
        }
    }

    fun updateBackgroundImage(uri: Uri) {
        viewModelScope.launch {
            val currentUser = state.value.user
            if (currentUser != null) {
                try {
                    _state.value = _state.value.copy(isLoading = true)
                    val downloadUrl = userRepository.updateBackgroundImage(currentUser.userId, uri)
                    val updatedUser = currentUser.copy(backgroundImageUrl = downloadUrl)
                    _state.value = _state.value.copy(user = updatedUser, isLoading = false)
                } catch (e: Exception) {
                    _state.value = _state.value.copy(error = "Error al actualizar la imagen de fondo.", isLoading = false)
                }
            }
        }
    }

    private fun <T> updateField(fieldName: String, value: T, updateUser: (User, T) -> User) {
        viewModelScope.launch {
            val currentUser = state.value.user
            if (currentUser != null) {
                try {
                    when (fieldName) {
                        "name" -> userRepository.updateUserName(currentUser.userId, value as String)
                        "phone" -> userRepository.updateUserPhone(currentUser.userId, value as String)
                        "aboutMe" -> userRepository.updateAboutMe(currentUser.userId, value as String)
                        "address" -> userRepository.updateAddress(currentUser.userId, value as String)
                    }
                    _state.value = _state.value.copy(user = updateUser(currentUser, value))
                    when (fieldName) {
                        "name" -> onDismissUpdateNameDialog()
                        "phone" -> onDismissUpdatePhoneDialog()
                        "aboutMe" -> onDismissUpdateAboutMeDialog()
                        "address" -> onDismissUpdateAddressDialog()
                    }

                } catch (e: Exception) {
                    _state.value = _state.value.copy(error = "Error al actualizar el campo.")
                }
            }
        }
    }

    private fun loadUserProfile() {
        viewModelScope.launch {
            _state.value = _state.value.copy(isLoading = true)
            try {
                val currentUser = authRepository.getCurrentUser()
                if (currentUser != null) {
                    var userProfile = userRepository.getUserProfile(currentUser.uid)
                    if (userProfile == null) {
                        val newUser = User(
                            userId = currentUser.uid,
                            name = currentUser.email?.substringBefore('@') ?: "Usuario",
                            email = currentUser.email ?: "Sin email"
                        )
                        userRepository.createUserProfile(newUser)
                        userProfile = newUser
                    }
                    _state.value = _state.value.copy(user = userProfile, isLoading = false)
                } else {
                    _state.value = _state.value.copy(error = "No se pudo obtener el usuario actual", isLoading = false)
                }
            } catch (e: Exception) {
                _state.value = _state.value.copy(error = e.message, isLoading = false)
            }
        }
    }
}