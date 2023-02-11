import kotlin.math.absoluteValue

fun main() {
    print("Nhập số phần tử mảng: ")
    var arrLength = readln().toInt()
    var arrNumber = mutableListOf<Double> ()
    //input array values
    for (index in 0..arrLength - 1) {
        print("Phần tử ${index + 1}: ")
        arrNumber.add(readln().toDouble())
    }

    val countMap = countFreq(arrNumber)
    printResult(countMap)
}

fun countFreq(arr: MutableList<Double>): MutableMap<Double, Int> {
    val result = mutableMapOf<Double, Int> ()
    for (index in 0..arr.size - 1) {
        var mapKey = arr[index]
        if (result[mapKey] != null) {
            var oldValue = result.getValue(mapKey)
            result.set(mapKey, oldValue + 1)
        }
        else {
            result.put(mapKey, 1)
        }
    }
    return result
}

fun printResult(countMap: MutableMap<Double, Int>) {
    countMap.forEach() {
        println("${it.key} Xuất Hiện ${it.value} Lần")
    }
}