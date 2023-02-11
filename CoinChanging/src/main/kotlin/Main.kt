import kotlin.math.min

fun main() {
    var moneys = mutableListOf<Int> ()
    var resultList = mutableListOf<Int>()

    print("Nhập các mệnh giá tiền: ")
    var strInput = readln().split(" ")
    strInput.forEach() {
        moneys.add(it.toInt())
    }

    print("Nhập số tiền cần đổi: ")
    val amount = readln().toInt()

    var result = coinChange(moneys, amount)
    //println("Đổi Ít Nhất ${result.size}")
    print(result)
}

fun coinChange(moneys: MutableList<Int>, amount: Int): Int {
    var minMoney = amount

    if (amount in moneys) {
        return 1
        //return mutableListOf(amount)
    }

    //var resultList = mutableListOf<Int>()
    for (money in moneys) {
        if (money < amount) {
            var count = coinChange(moneys, amount - money)
            //var rList = coinChange(moneys, amount - money)
            var num = 1 + count
            //var num = 1 + rList.size
            if (num < minMoney) {
                minMoney = num
                //minMoney = num
                //rList.add(money)
                //resultList = rList
            }
        }
    }
    return minMoney
    //return resultList
}
