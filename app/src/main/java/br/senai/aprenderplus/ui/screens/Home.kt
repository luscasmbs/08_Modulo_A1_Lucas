package br.senai.aprenderplus.ui.screens

import android.app.Activity
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.senai.aprenderplus.R
import br.senai.aprenderplus.ui.theme.White
import kotlinx.coroutines.launch
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.ArrowBackIosNew
import androidx.compose.material.icons.filled.Menu
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController

@Composable
fun Home(
    modifier: Modifier = Modifier,
    onOpenQuiz: () -> Unit = {},
    onOpenGeniusPlay: () -> Unit = {},
    onOpenMemoCheck: () -> Unit = {}
){
    val drawerState = rememberDrawerState(
        initialValue = DrawerValue.Closed
    )
    val scope = rememberCoroutineScope()
    val context = LocalContext.current
    fun fecharMenu(){
        scope.launch {
            drawerState.close()
        }
    }

    fun AbrirTela(action: () -> Unit){
        scope.launch {
            drawerState.close()
            action()
        }
    }


    //Menu hamburguer
    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            ModalDrawerSheet(
                modifier = Modifier.width(280.dp)
            ) {
                Column(modifier = Modifier
                    .fillMaxHeight()
                    .padding(24.dp)
                ) {
                    IconButton(
                        onClick = {
                            fecharMenu()
                        }
                    ) {
                        Icon(
                            imageVector = Icons.Default.ArrowBackIosNew,
                            contentDescription = "Fechar menu"
                        )
                    }

                    Spacer(modifier = Modifier.height(24.dp))
                    Image(
                        painter = painterResource(id = R.drawable.pessoa4),
                        contentDescription = "Imagem de perfil",
                        contentScale = ContentScale.Crop,
                        modifier = Modifier
                            .size(110.dp)
                            .clip(CircleShape),

                    )
                    Spacer(modifier = Modifier.height(24.dp))

                    DrawerItem(
                        text = "Home",
                        onClick = {
                            fecharMenu()
                        }
                    )
                    DrawerItem(
                        text = "QuizMyBrain",
                        onClick = {
                            AbrirTela(onOpenQuiz)
                        }
                    )
                    DrawerItem(
                        text = "GeniusPlay",
                        onClick = {
                            AbrirTela(onOpenGeniusPlay)
                        }
                    )
                    DrawerItem(
                        text = "MemoCheck",
                        onClick = {
                            AbrirTela(onOpenMemoCheck)
                        }
                    )
                    DrawerItem(
                        text = "Sair",
                        onClick = {
                            (context as? Activity)?.finish()
                        }
                    )
                }


            }
        }
    ) {
        Box(
            modifier = modifier
                .fillMaxSize()
                .background(color = White)
        ) {
            Column(
                modifier = Modifier.align(Alignment.Center),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = R.drawable.aprender_plus_light),
                    contentDescription = "Logo do app",
                    modifier = Modifier.size(140.dp)
                )

                Spacer(modifier = Modifier.height(26.dp))

                Text(
                    text = "Bem-vindo ao Aprender+",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Normal
                )
            }

            IconButton(
                onClick = {
                    scope.launch {
                        drawerState.open()
                    }
                },
                modifier = Modifier
                    .align(Alignment.TopStart)
                    .padding(16.dp)

            ) {
                Icon(
                    imageVector = Icons.Default.Menu,
                    contentDescription = "Abrir menu",

                )
            }
        }
    }


}
@Composable
fun DrawerItem(
    text: String,
    onClick: () -> Unit
){
    Text(
        text = text,
        fontSize = 18.sp,
        fontWeight = FontWeight.Normal,
        modifier = Modifier
            .fillMaxWidth()
            .clickable{
                onClick()
            }
            .padding(vertical = 14.dp)
    )
}

@Preview
@Composable
private fun HomePreview(){
    Home()
}