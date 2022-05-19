package com.miuelO6.netsb.com.model.blaizerscardandusers

import com.miuelO6.netsb.com.R

class BlaizersCardDeck {

    var blaizersCardDeck: List<BlaizersCardModel> = mutableListOf(
        BlaizersCardModel("TWO", 2, R.drawable.blaizers_2_spades),
        BlaizersCardModel("TWO", 2, R.drawable.blaizers_2_hearts),
        BlaizersCardModel("TWO", 2, R.drawable.blaizers_2_diamonds),
        BlaizersCardModel("TWO", 2, R.drawable.blaizers_2_clubs),

        BlaizersCardModel("THREE", 3, R.drawable.blaizers_3_spades),
        BlaizersCardModel("THREE", 3, R.drawable.blaizers_3_hearts),
        BlaizersCardModel("THREE", 3, R.drawable.blaizers_3_diamonds),
        BlaizersCardModel("THREE", 3, R.drawable.blaizers_3_clubs),

        BlaizersCardModel("FOUR", 4, R.drawable.blaizers_4_spades),
        BlaizersCardModel("FOUR", 4, R.drawable.blaizers_4_hearts),
        BlaizersCardModel("FOUR", 4, R.drawable.blaizers_4_diamonds),
        BlaizersCardModel("FOUR", 4, R.drawable.blaizers_4_clubs),

        BlaizersCardModel("FIVE", 5, R.drawable.blaizers_5_spades),
        BlaizersCardModel("FIVE", 5, R.drawable.blaizers_5_hearts),
        BlaizersCardModel("FIVE", 5, R.drawable.blaizers_5_diamonds),
        BlaizersCardModel("FIVE", 5, R.drawable.blaizers_5_clubs),

        BlaizersCardModel("SIX", 6, R.drawable.blaizers_6_spades),
        BlaizersCardModel("SIX", 6, R.drawable.blaizers_6_hearts),
        BlaizersCardModel("SIX", 6, R.drawable.blaizers_6_diamonds),
        BlaizersCardModel("SIX", 6, R.drawable.blaizers_6_clubs),

        BlaizersCardModel("SEVEN", 7, R.drawable.blaizers_7_spades),
        BlaizersCardModel("SEVEN", 7, R.drawable.blaizers_7_hearts),
        BlaizersCardModel("SEVEN", 7, R.drawable.blaizers_7_diamonds),
        BlaizersCardModel("SEVEN", 7, R.drawable.blaizers_7_clubs),

        BlaizersCardModel("EIGHT", 8, R.drawable.blaizers_8_spades),
        BlaizersCardModel("EIGHT", 8, R.drawable.blaizers_8_hearts),
        BlaizersCardModel("EIGHT", 8, R.drawable.blaizers_8_diamonds),
        BlaizersCardModel("EIGHT", 8, R.drawable.blaizers_8_clubs),

        BlaizersCardModel("NINE", 9, R.drawable.blaizers_9_spades),
        BlaizersCardModel("NINE", 9, R.drawable.blaizers_9_hearts),
        BlaizersCardModel("NINE", 9, R.drawable.blaizers_9_diamonds),
        BlaizersCardModel("NINE", 9, R.drawable.blaizers_9_clubs),

        BlaizersCardModel("TEN", 10, R.drawable.blaizers_10_spades),
        BlaizersCardModel("TEN", 10, R.drawable.blaizers_10_hearts),
        BlaizersCardModel("TEN", 10, R.drawable.blaizers_10_diamonds),
        BlaizersCardModel("TEN", 10, R.drawable.blaizers_10_clubs),

        BlaizersCardModel("JACK", 10, R.drawable.blaizers_jack_spades),
        BlaizersCardModel("JACK", 10, R.drawable.blaizers_jack_hearts),
        BlaizersCardModel("JACK", 10, R.drawable.blaizers_jack_diamonds),
        BlaizersCardModel("JACK", 10, R.drawable.blaizers_jack_clubs),

        BlaizersCardModel("QUEEN", 10, R.drawable.blaizers_queen_spades),
        BlaizersCardModel("QUEEN", 10, R.drawable.blaizers_queen_hearts),
        BlaizersCardModel("QUEEN", 10, R.drawable.blaizers_queen_diamonds),
        BlaizersCardModel("QUEEN", 10, R.drawable.blaizers_queen_clubs),

        BlaizersCardModel("ACE", 11, 1, R.drawable.blaizers_ace_spades),
        BlaizersCardModel("ACE", 11, 1, R.drawable.blaizers_ace_hearts),
        BlaizersCardModel("ACE", 11, 1, R.drawable.blaizers_ace_diamonds),
        BlaizersCardModel("ACE", 11, 1, R.drawable.blaizers_ace_clubs),

        BlaizersCardModel("KING", 10, R.drawable.blaizers_king_spades),
        BlaizersCardModel("KING", 10, R.drawable.blaizers_king_hearts),
        BlaizersCardModel("KING", 10, R.drawable.blaizers_king_diamonds),
        BlaizersCardModel("KING", 10, R.drawable.blaizers_king_clubs),
        ).shuffled()

}