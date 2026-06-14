package br.senai.aprenderplus

import org.junit.Assert.assertEquals
import org.junit.Assert.assertFalse
import org.junit.Assert.assertTrue
import org.junit.Test

class ExampleUnitTest {

    @Test
    fun score_doQuiz_deveSomarOsPontos() {
        val pesoQuestao1 = 2
        val pesoQuestao2 = 3

        val score = pesoQuestao1 + pesoQuestao2

        assertEquals(5, score)
    }

    @Test
    fun cartasIguais_devemFormarUmPar() {
        val primeiraCarta = "A"
        val segundaCarta = "A"

        val formamPar = primeiraCarta == segundaCarta

        assertTrue(formamPar)
    }

    @Test
    fun cartasDiferentes_naoDevemFormarUmPar() {
        val primeiraCarta = "A"
        val segundaCarta = "B"

        val formamPar = primeiraCarta == segundaCarta

        assertFalse(formamPar)
    }

    @Test
    fun sequenciaDoGenius_deveEstarCorreta() {
        val sequenciaCorreta = listOf("Vermelho", "Azul", "Verde")
        val sequenciaUsuario = listOf("Vermelho", "Azul", "Verde")

        assertEquals(sequenciaCorreta, sequenciaUsuario)
    }
}
