package com.miuelO6.netsb.com.model.blaizerscardandusers

class BlaizersPlayersRepository(
    private val blaizersUser: BlaizersUser = BlaizersUser(),
    private val blaizersDealer: BlaizersDealer = BlaizersDealer(),
) {

    fun getBlaizersUserPoints(): Int = blaizersUser.blaizersUserPoints

    fun getBlaizersFirstUserCards(): MutableList<Int> = blaizersUser.getBlaizersCards()

    fun hitBlaizersUserCard(): Int = blaizersUser.hitBlazersCard()

    fun doubleBlaizersUserBet(): Int = blaizersUser.blaizersDouble()

    fun getBlaizersDealerPoints(): Int = blaizersDealer.blaizersDealerPoints

    fun getBlaizersFirstDealerCards(): MutableList<Int> = blaizersDealer.getBlaizersCards()

    fun hitBlaizersDealersCard(): Int = blaizersDealer.hitBlazersCard()
}