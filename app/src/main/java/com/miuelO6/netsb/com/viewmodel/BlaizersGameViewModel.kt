package com.miuelO6.netsb.com.viewmodel

import android.app.Application
import android.media.MediaPlayer
import android.view.View
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.miuelO6.netsb.com.R
import com.miuelO6.netsb.com.model.blaizersbet.BlaizersBetModel
import com.miuelO6.netsb.com.model.blaizerscardandusers.BlaizersPlayersRepository
import com.miuelO6.netsb.com.model.blaizersmoney.BlaizersMoneyDataStore
import com.miuelO6.netsb.com.model.blaizerssound.BlaizersSoundDataStore
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BlaizersGameViewModel(
    private val blaizersMoneyDataStore: BlaizersMoneyDataStore,
    private val blaizersBetModel: BlaizersBetModel,
    private val blaizersApplication: Application,
    private var blaizersPlayersRepository: BlaizersPlayersRepository,
) : AndroidViewModel(blaizersApplication) {

    @Inject
    constructor(
        blaizersMoneyDataStore: BlaizersMoneyDataStore,
        blaizersBetModel: BlaizersBetModel,
        blaizersApplication: Application,
    ) : this(blaizersMoneyDataStore,
        blaizersBetModel,
        blaizersApplication,
        BlaizersPlayersRepository())

    private var blaizersHitCounts = 0
    private val blaizersCardOpenSoundEffect =
        MediaPlayer.create(blaizersApplication, R.raw.blaizers_card_open)
    private var blaizersChipStackSoundEffect =
        MediaPlayer.create(blaizersApplication, R.raw.blaizers_chips_stack)
    private var blaizersWinSoundEffect = MediaPlayer.create(blaizersApplication, R.raw.blaizers_win)
    private var blaizersLoseSoundEffect =
        MediaPlayer.create(blaizersApplication, R.raw.blaizers_lose)

    private val _blaizersMoneyText = MutableLiveData<Int>()
    val blaizersMoneyText: LiveData<Int>
        get() {
            viewModelScope.launch {
                _blaizersMoneyText.value = blaizersMoneyDataStore.getblaizersMoney()
            }
            return _blaizersMoneyText
        }

    private val _blaizersBet = MutableLiveData<Int>()
    val blaizersbet: LiveData<Int>
        get() {
            _blaizersBet.value = blaizersBetModel.blaizersBet
            return _blaizersBet
        }

    private val _blaizersUserCard1 = MutableLiveData<Int>()
    val blaizersUserCard1: LiveData<Int> = _blaizersUserCard1

    private val _blaizersUserCard2 = MutableLiveData<Int>()
    val blaizersUserCard2: LiveData<Int> = _blaizersUserCard2

    private val _blaizersUserCard3 = MutableLiveData<Int>()
    val blaizersUserCard3: LiveData<Int> = _blaizersUserCard3

    private val _blaizersUserCard4 = MutableLiveData<Int>()
    val blaizersUserCard4: LiveData<Int> = _blaizersUserCard4

    private val _blaizersUserCard5 = MutableLiveData<Int>()
    val blaizersUserCard5: LiveData<Int> = _blaizersUserCard5

    private val _blaizersUserCard6 = MutableLiveData<Int>()
    val blaizersUserCard6: LiveData<Int> = _blaizersUserCard6

    private val _blaizersDealerCard1 = MutableLiveData<Int>()
    val blaizersDealerCard1: LiveData<Int> = _blaizersDealerCard1

    private val _blaizersDealerCard2 = MutableLiveData<Int>()
    val blaizersDealerCard2: LiveData<Int> = _blaizersDealerCard2

    private val _blaizersDealerCard3 = MutableLiveData<Int>()
    val blaizersDealerCard3: LiveData<Int> = _blaizersDealerCard3

    private val _blaizersDealerCard4 = MutableLiveData<Int>()
    val blaizersDealerCard4: LiveData<Int> = _blaizersDealerCard4

    private val _blaizersDealerCard5 = MutableLiveData<Int>()
    val blaizersDealerCard5: LiveData<Int> = _blaizersDealerCard5

    private val _blaizersDealerCard6 = MutableLiveData<Int>()
    val blaizersDealerCard6: LiveData<Int> = _blaizersDealerCard6

    private val _blaizersBetBoardVisibility = MutableLiveData<Int>()
    val blazersBetBoardVisibility: LiveData<Int> = _blaizersBetBoardVisibility

    private val _blaizersPointsVisibility = MutableLiveData<Int>()
    val blaizersPointsVisibility: LiveData<Int> = _blaizersPointsVisibility

    private val _blaizersActionsBoardVisibility = MutableLiveData<Int>()
    val blaizersActionsVisibility: LiveData<Int> = _blaizersActionsBoardVisibility

    private val _doubleButtonVisibility = MutableLiveData<Int>()
    val doubleButtonVisibility: LiveData<Int> = _doubleButtonVisibility


    private val _blaizersUserPoints = MutableLiveData<Int>()
    val blaizersUserPoints: LiveData<Int> = _blaizersUserPoints

    private val _blaizersDealerPoints = MutableLiveData<Int>()
    val blaizersDealerPoints: LiveData<Int> = _blaizersDealerPoints


    private fun checkIsBlaizersSoundEnabled(blaizersSoundEffect: MediaPlayer) {
        viewModelScope.launch {
            if (BlaizersSoundDataStore(blaizersApplication).getblaizersSound()) {
                blaizersSoundEffect.setVolume(0.2f, 0.3f)
                blaizersSoundEffect.start()
            }
        }
    }

    fun addBlaizersBet() {
        if (_blaizersBet.value!! >= _blaizersMoneyText.value!!) {
            Toast.makeText(blaizersApplication,
                R.string.blaizersNotEnoughChipsMessage,
                Toast.LENGTH_SHORT).show()
        } else {
            _blaizersBet.value = blaizersBetModel.addBlaizersBet(1)
            checkIsBlaizersSoundEnabled(blaizersChipStackSoundEffect)
        }
    }

    fun reduceBlaizersBet() {
        if (_blaizersBet.value!! <= 1) {
            Toast.makeText(blaizersApplication,
                R.string.blaizersMinBetMessage,
                Toast.LENGTH_SHORT).show()
        } else {
            _blaizersBet.value = blaizersBetModel.reduceBlaizersBet(1)
        }
    }

    fun makeBlazersBet() {
        viewModelScope.launch {
            if (blaizersMoneyDataStore.getblaizersMoney() == 0) {
                Toast.makeText(blaizersApplication,
                    R.string.blaizersNotMoney,
                    Toast.LENGTH_SHORT).show()
            } else {
                blaizersMoneyDataStore.editBlaizersMoney(_blaizersMoneyText.value!!.minus(
                    _blaizersBet.value!!))
                _blaizersMoneyText.value = blaizersMoneyDataStore.getblaizersMoney()
                _blaizersBetBoardVisibility.value = View.GONE
                getBlazersFirstCardsAndPoints()
            }
        }
    }

    private suspend fun getBlazersFirstCardsAndPoints() {
        viewModelScope.launch {
            repeat(3) {
                checkIsBlaizersSoundEnabled(blaizersCardOpenSoundEffect!!)
                delay(1000)
            }
        }
        _blaizersUserCard1.value = blaizersPlayersRepository.getBlaizersFirstUserCards()[0]
        delay(1000)
        _blaizersUserCard2.value = blaizersPlayersRepository.getBlaizersFirstUserCards()[1]
        delay(1000)
        _blaizersDealerCard1.value =
            blaizersPlayersRepository.getBlaizersFirstDealerCards()[0]
        _blaizersDealerPoints.value = blaizersPlayersRepository.getBlaizersDealerPoints()
        _blaizersDealerCard2.value = R.drawable.blaizers_card_back
        checkBlaizersBlackJack()
        _blaizersPointsVisibility.value = View.VISIBLE
        _blaizersActionsBoardVisibility.value = View.VISIBLE
        viewModelScope.launch {
            if (blaizersMoneyDataStore.getblaizersMoney() < _blaizersBet.value!!) {
                _doubleButtonVisibility.value = View.GONE
            } else {
                _doubleButtonVisibility.value = View.VISIBLE
            }
        }
    }


    fun hitUserBlaizersCard() {
        when (blaizersHitCounts) {
            0 -> {
                _blaizersUserCard3.value = blaizersPlayersRepository.hitBlaizersUserCard()
                checkBlaizersBustCondition()
                blaizersHitCounts++
            }
            1 -> {
                _blaizersUserCard4.value = blaizersPlayersRepository.hitBlaizersUserCard()
                checkBlaizersBustCondition()
                blaizersHitCounts += 1
            }
            2 -> {
                _blaizersUserCard5.value = blaizersPlayersRepository.hitBlaizersUserCard()
                checkBlaizersBustCondition()
                blaizersHitCounts += 1
            }
            3 -> {
                _blaizersUserCard5.value = blaizersPlayersRepository.hitBlaizersUserCard()
                checkBlaizersBustCondition()
                blaizersHitCounts += 1
            }
        }

    }

    private fun checkBlaizersBlackJack() {
        _blaizersActionsBoardVisibility.value = View.GONE
        _blaizersUserPoints.value = blaizersPlayersRepository.getBlaizersUserPoints()
        _blaizersDealerPoints.value = blaizersPlayersRepository.getBlaizersDealerPoints()
        if (_blaizersUserPoints.value!! == 21) {
            Toast.makeText(blaizersApplication, R.string.blaizers_win, Toast.LENGTH_SHORT)
                .show()
            checkIsBlaizersSoundEnabled(blaizersWinSoundEffect!!)
            viewModelScope.launch {
                val blaizersBlackJackPrize = _blaizersBet.value!!.times(1.5).toInt()
                blaizersMoneyDataStore.editBlaizersMoney(_blaizersMoneyText.value?.plus(
                    blaizersBlackJackPrize)!!)
                _blaizersMoneyText.value = blaizersMoneyDataStore.getblaizersMoney()
                newBlaizerTurn()
            }
        } else if ((_blaizersDealerPoints.value!! == 21 && _blaizersUserPoints.value!! != 21)) {
            Toast.makeText(blaizersApplication,
                R.string.blaizers_dealer_black_jack,
                Toast.LENGTH_SHORT)
                .show()
            newBlaizerTurn()
            checkIsBlaizersSoundEnabled(blaizersLoseSoundEffect!!)
        } else if ((_blaizersDealerPoints.value!! == 21 && _blaizersUserPoints.value!! == 21)) {
            Toast.makeText(blaizersApplication, R.string.blaizers_draw, Toast.LENGTH_SHORT)
                .show()
            viewModelScope.launch {
                blaizersMoneyDataStore.editBlaizersMoney(_blaizersMoneyText.value?.plus(
                    _blaizersBet.value!!)!!)
                _blaizersMoneyText.value = blaizersMoneyDataStore.getblaizersMoney()
                checkIsBlaizersSoundEnabled(blaizersWinSoundEffect!!)
                newBlaizerTurn()
            }
        }

    }

    private fun checkBlaizersBustCondition() {
        checkIsBlaizersSoundEnabled(blaizersCardOpenSoundEffect!!)
        _blaizersActionsBoardVisibility.value = View.GONE
        _blaizersUserPoints.value = blaizersPlayersRepository.getBlaizersUserPoints()
        if (_blaizersUserPoints.value!! > 21) {
            Toast.makeText(blaizersApplication, R.string.blaizers_bust, Toast.LENGTH_SHORT)
                .show()
            checkIsBlaizersSoundEnabled(blaizersLoseSoundEffect!!)
            newBlaizerTurn()
        } else if (_blaizersUserPoints.value!! == 21) {
            hitUserBlaizersCard()
        } else {
            viewModelScope.launch {
                delay(1000)
                _blaizersActionsBoardVisibility.value = View.VISIBLE
            }
        }
    }

    fun blaizersStand() {
        _blaizersActionsBoardVisibility.value = View.GONE
        viewModelScope.launch {
            checkIsBlaizersSoundEnabled(blaizersCardOpenSoundEffect!!)
            _blaizersDealerCard2.value =
                blaizersPlayersRepository.getBlaizersFirstDealerCards()[1]
            _blaizersDealerCard2.value = blaizersPlayersRepository.hitBlaizersDealersCard()
            _blaizersDealerPoints.value =
                blaizersPlayersRepository.getBlaizersDealerPoints()
            if (blaizersPlayersRepository.getBlaizersDealerPoints() >= 17) {
                checkBlaizersWinAfterDealersHitCondition()
            } else {
                delay(1500)
                checkIsBlaizersSoundEnabled(blaizersCardOpenSoundEffect!!)
                _blaizersDealerCard3.value =
                    blaizersPlayersRepository.hitBlaizersDealersCard()
                _blaizersDealerPoints.value =
                    blaizersPlayersRepository.getBlaizersDealerPoints()
                if (blaizersPlayersRepository.getBlaizersDealerPoints() >= 17) {
                    checkBlaizersWinAfterDealersHitCondition()
                } else {
                    delay(1500)
                    checkIsBlaizersSoundEnabled(blaizersCardOpenSoundEffect!!)
                    _blaizersDealerCard4.value =
                        blaizersPlayersRepository.hitBlaizersDealersCard()
                    _blaizersDealerPoints.value =
                        blaizersPlayersRepository.getBlaizersDealerPoints()
                    if (blaizersPlayersRepository.getBlaizersDealerPoints() >= 17) {
                        checkBlaizersWinAfterDealersHitCondition()
                    } else {
                        delay(1500)
                        checkIsBlaizersSoundEnabled(blaizersCardOpenSoundEffect!!)
                        _blaizersDealerCard5.value =
                            blaizersPlayersRepository.hitBlaizersDealersCard()
                        _blaizersDealerPoints.value =
                            blaizersPlayersRepository.getBlaizersDealerPoints()
                    }
                    if (blaizersPlayersRepository.getBlaizersDealerPoints() >= 17) {
                        checkBlaizersWinAfterDealersHitCondition()
                    } else {
                        delay(1500)
                        checkIsBlaizersSoundEnabled(blaizersCardOpenSoundEffect!!)
                        _blaizersDealerCard6.value =
                            blaizersPlayersRepository.hitBlaizersDealersCard()
                        _blaizersDealerPoints.value =
                            blaizersPlayersRepository.getBlaizersDealerPoints()
                    }
                }
            }
        }
    }

    fun blaizersDouble() {
        viewModelScope.launch {
            checkIsBlaizersSoundEnabled(blaizersChipStackSoundEffect!!)
            blaizersMoneyDataStore.editBlaizersMoney(_blaizersMoneyText.value!!.minus(
                _blaizersBet.value!!))
            _blaizersMoneyText.value = blaizersMoneyDataStore.getblaizersMoney()
            _blaizersBet.value = blaizersBetModel.blaizersDouble()
            _blaizersUserCard3.value = blaizersPlayersRepository.doubleBlaizersUserBet()
            _blaizersUserPoints.value = blaizersPlayersRepository.getBlaizersUserPoints()
            checkBlaizersBustCondition()
            if (_blaizersUserPoints.value!! < 21) {
                delay(1000)
                blaizersStand()
            }
        }
    }

    fun blaizersSurrender() {
        viewModelScope.launch {
            _blaizersActionsBoardVisibility.value = View.GONE
            Toast.makeText(blaizersApplication,
                R.string.blaizers_surrender_message,
                Toast.LENGTH_SHORT).show()
            _blaizersBet.value = blaizersBetModel.blaizersSurrender()
            blaizersMoneyDataStore.editBlaizersMoney(_blaizersMoneyText.value!!.plus(
                _blaizersBet.value!!))
            _blaizersMoneyText.value = blaizersMoneyDataStore.getblaizersMoney()
            newBlaizerTurn()
        }
    }

    private fun checkBlaizersWinAfterDealersHitCondition() {
        if (_blaizersUserPoints.value!! > _blaizersDealerPoints.value!! || _blaizersDealerPoints.value!! > 21) {
            Toast.makeText(blaizersApplication, R.string.blaizers_win, Toast.LENGTH_SHORT)
                .show()
            checkIsBlaizersSoundEnabled(blaizersWinSoundEffect!!)
            viewModelScope.launch {
                blaizersMoneyDataStore.editBlaizersMoney(_blaizersMoneyText.value?.plus(
                    _blaizersBet.value!!)!!)
                _blaizersMoneyText.value = blaizersMoneyDataStore.getblaizersMoney()
            }
            newBlaizerTurn()
        } else if (_blaizersUserPoints.value!! < _blaizersDealerPoints.value!!) {
            Toast.makeText(blaizersApplication,
                R.string.blaizers_lose_dealer_more,
                Toast.LENGTH_SHORT)
                .show()
            checkIsBlaizersSoundEnabled(blaizersLoseSoundEffect!!)
            newBlaizerTurn()
        } else if (_blaizersUserPoints.value!! == _blaizersDealerPoints.value) {
            Toast.makeText(blaizersApplication, R.string.blaizers_draw, Toast.LENGTH_SHORT)
                .show()
            checkIsBlaizersSoundEnabled(blaizersWinSoundEffect!!)
            viewModelScope.launch {
                blaizersMoneyDataStore.editBlaizersMoney(_blaizersMoneyText.value?.plus(
                    _blaizersBet.value!!)!!)
                _blaizersMoneyText.value = blaizersMoneyDataStore.getblaizersMoney()
            }
            newBlaizerTurn()
        }
    }


    private fun newBlaizerTurn() {
        viewModelScope.launch {
            delay(2000)
            _blaizersPointsVisibility.value = View.GONE
            _blaizersActionsBoardVisibility.value = View.GONE
            _blaizersBetBoardVisibility.value = View.VISIBLE
            blaizersBetModel.blaizersBet = 10
            _blaizersUserCard1.value = 0
            _blaizersUserCard2.value = 0
            _blaizersUserCard3.value = 0
            _blaizersUserCard4.value = 0
            _blaizersUserCard5.value = 0
            _blaizersUserCard6.value = 0
            _blaizersDealerCard1.value = 0
            _blaizersDealerCard2.value = 0
            blaizersHitCounts = 0
            blaizersPlayersRepository = BlaizersPlayersRepository()
            _blaizersDealerCard3.value = 0
            _blaizersDealerCard4.value = 0
            _blaizersDealerCard5.value = 0
            _blaizersDealerCard6.value = 0
        }
    }


    override fun onCleared() {
        blaizersBetModel.blaizersBet = 10
        super.onCleared()
    }


}



