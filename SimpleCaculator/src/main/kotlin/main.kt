fun main() {
    menu()
}

fun menu() {
    val calc = getCalcSelected()

    print("Nhập a: ")
    val a = readln().toDouble()
    print("Nhập b: ")
    val b = readln().toDouble()

    println(getAnswer(a, b, calc))
}