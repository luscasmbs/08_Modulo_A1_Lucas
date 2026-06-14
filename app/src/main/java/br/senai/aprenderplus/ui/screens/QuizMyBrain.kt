package br.senai.aprenderplus.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material3.Button
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
fun QuizMyBrain(
    modifier: Modifier = Modifier,
    onBackArrow: () -> Unit = {}
) {
    Column(
        modifier = modifier
            .fillMaxSize()
            .background(White)
    ) {
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
                text = "QUIZ MY BRAIN",
                fontSize = 24.sp,
                fontWeight = FontWeight.Black,
                color = Purple30,
                textAlign = TextAlign.Center,
                modifier = Modifier.weight(1f)
            )

            // Compensa o espaço ocupado pelo IconButton à esquerda.
            Spacer(
                modifier = Modifier.width(48.dp)
            )
        }

        Spacer(
            modifier = Modifier.height(120.dp)
        )

        Text(
            text = "Pergunta",
            color = Purple30,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(
            modifier = Modifier.height(450.dp)
        )
        Row(
            horizontalArrangement = Arrangement.spacedBy(
                space = 16.dp,
                alignment = Alignment.CenterHorizontally
            ),
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 40.dp)
        ) {
            Button(
                onClick = {}
            ) {
                Text("Encerrar")
            }

            Button(
                onClick = {}
            ) {
                Text("Próximo")
            }
        }
    }
}