fun main() {
    val resultPay: Int = sendMoney("MasterCard", 100_000, 1000)
    printResult(resultPay)
}

fun printResult(resultCalculation: Int) {
    when (resultCalculation) {
        -1 -> println("Превышен лимит переводов")
        -2 -> println("Данный вид карты не обслуживается")
        else -> println("Перевод вместе с комиссией составит: $resultCalculation")
    }
}

fun sendMoney(typeCard: String = "VKPay", previousMoneyOrder: Int = 0, currentMoneyOrder: Int): Int {
    val maxLimitInDay = 150_000
    val maxLimitInMonth = 600_000

    val maxLimitInDayVKPay = 15_000
    val maxLimitInMonthVKPay = 40_000

    var moneyForPay = 0.0

    when (typeCard) {
        "MasterCard", "Maestro" -> {
            moneyForPay = if ((currentMoneyOrder + previousMoneyOrder) > 75_000) {
                ((currentMoneyOrder * 0.006) + 20) + currentMoneyOrder
            } else {
                currentMoneyOrder.toDouble()
            }

            if (moneyForPay > maxLimitInDay || (moneyForPay + previousMoneyOrder) > maxLimitInMonth) {
                return -1
            }
            return moneyForPay.toInt()
        }

        "Visa", "Мир" -> {
            moneyForPay = ((currentMoneyOrder * 0.0075) + 35) + currentMoneyOrder

            if (moneyForPay > maxLimitInDay || (moneyForPay + previousMoneyOrder) > maxLimitInMonth) {
                return -1
            }
            return moneyForPay.toInt()
        }

        "VKPay" -> {
            moneyForPay = currentMoneyOrder.toDouble()

            if (moneyForPay > maxLimitInDayVKPay || (moneyForPay + previousMoneyOrder) > maxLimitInMonthVKPay) {
                return -1
            }
            return moneyForPay.toInt()
        }

        else -> {
            return -2
        }
    }
}
