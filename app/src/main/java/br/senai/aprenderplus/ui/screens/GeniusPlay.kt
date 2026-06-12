package br.senai.aprenderplus.ui.screens

import android.graphics.drawable.Icon
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import br.senai.aprenderplus.ui.theme.White

@Composable
fun GeniusPlay(
    modifier: Modifier = Modifier,
    onBackArrow: () -> Unit = {}
){
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(White)
    ) {
        IconButton(
            onClick ={
                onBackArrow()
            }
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBackIosNew,
                contentDescription = "Fechar menu"
            )
        }
    }
}