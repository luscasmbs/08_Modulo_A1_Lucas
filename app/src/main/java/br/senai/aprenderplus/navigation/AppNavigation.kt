package br.senai.aprenderplus.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import br.senai.aprenderplus.ui.screens.GeniusPlay
import br.senai.aprenderplus.ui.screens.Home
import br.senai.aprenderplus.ui.screens.MemoCheck
import br.senai.aprenderplus.ui.screens.QuizMyBrain

@Composable
fun AppNavigation(){
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "home"
    ){
        composable("home"){
            Home(
                onOpenQuiz = {
                    navController.navigate("QuizMyBrain")
                },
                onOpenMemoCheck = {
                    navController.navigate("MemoCheck")
                },
                onOpenGeniusPlay = {
                    navController.navigate("GeniusPlay")
                }
            )
        }
        composable("QuizMyBrain"){
            QuizMyBrain(
                onBackArrow = {
                    navController.navigate("home")
                }
            )
        }
        composable("GeniusPlay"){
            GeniusPlay(
                onBackArrow = {
                    navController.navigate("home")
                }
            )
        }
        composable("MemoCheck"){
            MemoCheck(
                onBackArrow = {
                    navController.navigate("home")
                }
            )
        }
    }
}