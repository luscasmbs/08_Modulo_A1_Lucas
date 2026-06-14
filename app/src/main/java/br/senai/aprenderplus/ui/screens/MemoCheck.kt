package br.senai.aprenderplus.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.aprenderplus.ui.theme.Purple30
import br.senai.aprenderplus.ui.theme.White

@Composable
fun MemoCheck(
    modifier: Modifier = Modifier,
    onBackArrow: () -> Unit = {}
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(White)
    ) {
        // Cabeçalho
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier
                .fillMaxWidth()
                .padding(22.dp)
        ) {
            IconButton(
                onClick = onBackArrow
            ) {
                Icon(
                    imageVector = Icons.Default.ArrowBackIosNew,
                    contentDescription = "Voltar",
                    tint = Purple30
                )
            }

            Text(
                text = "MEMOCHECK",
                fontSize = 24.sp,
                fontWeight = FontWeight.Black,
                color = Purple30,
                textAlign = TextAlign.Center,
                modifier = Modifier.weight(1f)
            )

            // Compensa o espaço ocupado pelo botão à esquerda
            Spacer(
                modifier = Modifier.width(48.dp)
            )
        }

        // Quadrados
        Column(
            verticalArrangement = Arrangement.spacedBy(20.dp),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 80.dp)
        ) {
            repeat(4) {
                Row(
                    horizontalArrangement = Arrangement.spacedBy(
                        space = 20.dp,
                        alignment = Alignment.CenterHorizontally
                    ),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    MemoSquare()
                    MemoSquare()
                }
            }
        }
    }
}

@Composable
fun MemoSquare() {
    Spacer(
        modifier = Modifier
            .size(100.dp)
            .background(Purple30)
    )
}