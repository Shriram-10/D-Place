package com.example.d_place_new

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp

@Composable
fun SignInScreen (
    state : SignInState,
    onSignInClick: () -> Unit,
    toHome : () -> Unit,
) {
    val context = LocalContext.current

    LaunchedEffect (key1 = state.signInError) {
        state.signInError?.let { error ->
            Toast.makeText(
                context,
                error,
                Toast.LENGTH_LONG
            ).show()
        }
    }

    Box (
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column {
            Button (
                onClick = onSignInClick
            ) {
                Text ("Click to Sign In")
            }

            Button (
                onClick = {
                    toHome()
                },
                modifier = Modifier.padding(top = 16.dp)
            ) {
                Text("to play game")
            }
        }
    }
}