package com.miuelO6.netsb.com.model.blaizersbet

import javax.inject.Inject

data class BlaizersBetModel @Inject constructor(
    var blaizersBet: Int,
) : BlaizersBetReduction, BlaizersBetAddition {

    constructor() : this(10)

    override fun addBlaizersBet(blaizersBet: Int): Int {
        this.blaizersBet += blaizersBet
        return this.blaizersBet
    }

    override fun reduceBlaizersBet(blaizersBet: Int): Int {
        this.blaizersBet -= blaizersBet
        return this.blaizersBet
    }

    fun blaizersDouble(): Int {
        this.blaizersBet *= 2
        return this.blaizersBet
    }

    fun blaizersSurrender(): Int {
        this.blaizersBet = this.blaizersBet/ 2
        return this.blaizersBet
    }
}
