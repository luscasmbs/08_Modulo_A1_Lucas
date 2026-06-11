package br.senai.aprenderplus.ui.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
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
import androidx.compose.ui.graphics.Color
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
import androidx.compose.material.icons.filled.Menu
import androidx.compose.ui.platform.LocalContext

@Composable
fun Home(modifier: Modifier = Modifier){
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
    fun abrirmenu(action: () -> Unit){
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
                    Icon(
                        imageVector = Icons.Default.ArrowBack,
                        contentDescription = "Fechar menu"
                    )
                }
            }
        }
    ) { }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(color = White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.aprender_plus_light),
            contentDescription = "Logo do app",
            modifier = Modifier.size(140.dp)
        )
        Spacer(modifier.height(26.dp))
        Text(
            text = "Bem-vindo ao Aprender+",
            fontSize = 16.sp,
            fontWeight = FontWeight.Normal
        )
    }

}

@Preview
@Composable
private fun HomePreview(){
    Home()
}