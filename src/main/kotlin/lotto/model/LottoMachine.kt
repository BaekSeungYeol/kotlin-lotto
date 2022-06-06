package lotto.model

class LottoMachine {

    fun createLotto(count: Int): List<Lotto> {
        return List(count) {
            Lotto(
                lottoNumbers = createDistinctSixNumbers().map { LottoNumber.from(it) }.toList()
            )
        }
    }

    private fun createDistinctSixNumbers(): List<Int> {
        return buildSet(LOTTO_SIZE) {
            while (this.size != LOTTO_SIZE) {
                add((MINIMUM_NUMBER..MAXIMUM_NUMBER).random())
            }
        }.shuffled().toList()
    }

    companion object {
        private const val LOTTO_SIZE = 6
        private const val MINIMUM_NUMBER = 1
        private const val MAXIMUM_NUMBER = 45
    }
}
