package com.miuelO6.netsb.com.model.blaizerscardandusers

data class BlaizersCardModel(
     val blaizersCardRank: String,
     val blaizersCardPoints: Int,
     var blaizersAlternativePoints: Int,
     val blaizersCardBack: Int
) {
   constructor(blaizersCardRank: String, blaizersCardPoints: Int, blaizersCardBack: Int): this(blaizersCardRank, blaizersCardPoints, 0, blaizersCardBack)
}

