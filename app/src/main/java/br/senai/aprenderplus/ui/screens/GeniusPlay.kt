package br.senai.aprenderplus.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
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
            onClick = onBackArrow,
            modifier = Modifier
                .align(Alignment.Start)
                .padding(16.dp)
        ) {
            Icon(
                imageVector = Icons.Default.ArrowBackIosNew,
                contentDescription = "Fechar menu"
            )
        }
    }
}