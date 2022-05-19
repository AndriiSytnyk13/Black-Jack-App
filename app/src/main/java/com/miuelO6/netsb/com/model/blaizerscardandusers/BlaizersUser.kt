package com.miuelO6.netsb.com.model.blaizerscardandusers

class BlaizersUser(
    private val blaizersCardDeck: BlaizersCardDeck = BlaizersCardDeck(),
    var blaizersUserPoints: Int = 0,
) :
    BlaizersGetCards, BlaizersHitCard {

    private var blaizersHandIndex = 1
    private var blaizersTempCards: MutableList<Int>? = null


    override fun getBlaizersCards(): MutableList<Int> {
        blaizersTempCards = mutableListOf(
            blaizersCardDeck.blaizersCardDeck[0].blaizersCardBack,
            blaizersCardDeck.blaizersCardDeck[1].blaizersCardBack
        )
        blaizersUserPoints =
            blaizersCardDeck.blaizersCardDeck[0].blaizersCardPoints + blaizersCardDeck.blaizersCardDeck[1].blaizersCardPoints
        return blaizersTempCards!!
    }

    override fun hitBlazersCard(): Int {
        blaizersHandIndex++
        blaizersTempCards!!.add(blaizersHandIndex,
            blaizersCardDeck.blaizersCardDeck[blaizersHandIndex].blaizersCardBack)
        blaizersUserPoints += blaizersCardDeck.blaizersCardDeck[blaizersHandIndex].blaizersCardPoints
        return blaizersCardDeck.blaizersCardDeck[blaizersHandIndex].blaizersCardBack
    }

    fun blaizersDouble():Int  {
        blaizersUserPoints += blaizersCardDeck.blaizersCardDeck[2].blaizersCardPoints
        return blaizersCardDeck.blaizersCardDeck[2].blaizersCardBack
    }

}