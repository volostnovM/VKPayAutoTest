import org.junit.Test

import org.junit.Assert.*

class MainKtTest {

    @Test
    fun sendMoneyTypeVisa() {
        val typeCard: String = "Visa"
        val previousMoneyOrder: Int = 1000
        val currentMoneyOrder:Int = 1500

        val result = sendMoney(typeCard, previousMoneyOrder, currentMoneyOrder)

        assertEquals(1546, result)
    }

    @Test
    fun sendMoneyTypeVisaOverLimit() {
        val typeCard: String = "Visa"
        val previousMoneyOrder: Int = 1_000_000
        val currentMoneyOrder:Int = 1500

        val result = sendMoney(typeCard, previousMoneyOrder, currentMoneyOrder)

        assertEquals(-1, result)
    }

    @Test
    fun sendMoneyTypeVKPay() {
        val typeCard: String = "VKPay"
        val previousMoneyOrder: Int = 1000
        val currentMoneyOrder:Int = 1500

        val result = sendMoney(typeCard, previousMoneyOrder, currentMoneyOrder)

        assertEquals(1500, result)
    }

    @Test
    fun sendMoneyTypeVKPayOverLimit() {
        val typeCard: String = "VKPay"
        val previousMoneyOrder: Int = 100_000
        val currentMoneyOrder:Int = 1500

        val result = sendMoney(typeCard, previousMoneyOrder, currentMoneyOrder)

        assertEquals(-1, result)
    }

    @Test
    fun sendMoneyTypeMasterCard() {
        val typeCard: String = "MasterCard"
        val previousMoneyOrder: Int = 1000
        val currentMoneyOrder:Int = 1500

        val result = sendMoney(typeCard, previousMoneyOrder, currentMoneyOrder)

        assertEquals(1500, result)
    }

    @Test
    fun sendMoneyTypeMasterCardOverLimit() {
        val typeCard: String = "MasterCard"
        val previousMoneyOrder: Int = 1_000_000
        val currentMoneyOrder:Int = 1500

        val result = sendMoney(typeCard, previousMoneyOrder, currentMoneyOrder)

        assertEquals(-1, result)
    }

    @Test
    fun sendMoneyUnknownType() {
        val typeCard: String = "UnionPay"
        val previousMoneyOrder: Int = 1_000_000
        val currentMoneyOrder:Int = 1500

        val result = sendMoney(typeCard, previousMoneyOrder, currentMoneyOrder)

        assertEquals(-2, result)
    }
}