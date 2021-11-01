package ru.netology

import choosingCard
import comissionAmmount
import comissionPercent
import org.junit.Test

import org.junit.Assert.*
import org.junit.Before

class MainKtTest {

    val cardTypeVkPay = "VK pay"
    val cardTypeMasterard = "Mastercard"
    val cardTypeMaestro = "Maestro"
    val cardTypeMir = "Mir"
    val cardTypeVisa ="Visa"
    val transferAmmount = 35000
    val previoustranslations = 0

    @Test
    fun choosingCard() {
        val userChoiseMastercard = 1
        val userChoiseMaestro = 2
        val userChoiseVisa = 3
        val userChoiseMir = 4
        val resultMastercard = choosingCard(input = userChoiseMastercard)
        assertEquals("Mastercard",resultMastercard)
        val resultMaestro =  choosingCard(input = userChoiseMaestro)
        assertEquals("Maestro",resultMaestro)
        val resultVisa = choosingCard(input = userChoiseVisa)
        assertEquals("Visa", resultVisa)
        val resultMir = choosingCard(input = userChoiseMir)
        assertEquals("Mir", resultMir)
    }

    @Test
    fun comissionPercentWhithVkPay() {
        val resultVkPay = comissionPercent(cardType = cardTypeVkPay, transferAmmount, previoustranslations)
        assertEquals(0.0,resultVkPay, 0.0)
    }

    @Test
    fun comissionPercentWhithVisa(){
        val resultVisa = comissionPercent(cardType = cardTypeVisa, transferAmmount,previoustranslations)
        assertEquals(0.75, resultVisa, 0.0)
    }

    @Test
    fun comissionPercentWhithMir(){
        val resultMir = comissionPercent(cardType = cardTypeMir, transferAmmount,previoustranslations)
        assertEquals(0.75,resultMir,0.0 )
    }

    @Test
    fun comissionPercentWhithMaestro(){
        val resultMaestroWhithOutCommisionPercentage = comissionPercent(cardType = cardTypeMaestro, transferAmmount,previoustranslations)
        assertEquals(0.0,resultMaestroWhithOutCommisionPercentage,0.0 )
        val transferAmmount = 20000
        val resultMaestro = comissionPercent(cardType = cardTypeMaestro, transferAmmount = transferAmmount,previoustranslations)
        assertEquals(0.6,resultMaestro,0.0 )
    }

    fun comissionPercentWhithMastercard(){
        val resultMastercardWhithOutCommisionPercentage = comissionPercent(cardType = cardTypeMasterard, transferAmmount,previoustranslations)
        assertEquals(0.0,resultMastercardWhithOutCommisionPercentage,0.0 )
        val transferAmmount = 20000
        val resultMastercard = comissionPercent(cardType = cardTypeMasterard, transferAmmount = transferAmmount,previoustranslations)
        assertEquals(0.6,resultMastercard,0.0 )
    }

    @Test
    fun comissionAmmount() {
        val resultVkPay = comissionAmmount(transferAmmount,cardTypeVkPay,0.0)
        assertEquals(0,resultVkPay)
        val resultMaestro = comissionAmmount(transferAmmount,cardTypeMaestro,0.0)
        assertEquals(0,resultVkPay)
        val resultMastercard = comissionAmmount(transferAmmount,cardTypeMasterard,0.6)
        assertEquals(230,resultMastercard)
        val resultVisa = comissionAmmount(transferAmmount,cardTypeVisa,0.75)
        assertEquals(3500,resultVisa)
        val transferAmmount = 1000000
        val resultMir = comissionAmmount(transferAmmount = transferAmmount,cardTypeMir,0.75)
        assertEquals(7500, resultMir)
    }
}