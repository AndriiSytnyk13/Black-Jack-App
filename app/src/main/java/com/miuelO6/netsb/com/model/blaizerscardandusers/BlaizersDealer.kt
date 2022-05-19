package com.miuelO6.netsb.com.model.blaizerscardandusers

class BlaizersDealer(
    private val blaizersCardDeck: BlaizersCardDeck = BlaizersCardDeck(),
    var blaizersDealerPoints: Int = 0,
) :
    BlaizersGetCards, BlaizersHitCard {

    private var blaizersHandCount = 2
    private var blaizersTempCards: MutableList<Int>? = null

    override fun getBlaizersCards(): MutableList<Int> {
        blaizersTempCards = mutableListOf(
            blaizersCardDeck.blaizersCardDeck[2].blaizersCardBack,
            blaizersCardDeck.blaizersCardDeck[3].blaizersCardBack
        )
        blaizersDealerPoints =
            blaizersCardDeck.blaizersCardDeck[2].blaizersCardPoints
        return blaizersTempCards!!
    }


    override fun hitBlazersCard(): Int {
            blaizersHandCount++
            blaizersDealerPoints += blaizersCardDeck.blaizersCardDeck[blaizersHandCount].blaizersCardPoints
        return blaizersCardDeck.blaizersCardDeck[blaizersHandCount].blaizersCardBack
    }


}