infix fun Double.add(x: Double): Double = this + x
infix fun Double.sub(x: Double): Double = this - x
infix fun Double.multi(x: Double): Double = this * x
infix fun Double.div(x: Double): Double = this / x

fun getCalcSelected(): Int {
    println("1. Cộng")
    println("2. Trừ")
    println("3. Nhân")
    println("4. Chia")
    print("Lựa Chọn: ")
    var calcSelected = readln().toInt()

    while(calcSelected !in intArrayOf(1, 2, 3, 4)) {
        print("Không Tồn Tại Lựa Chọn Của Bạn\nMời Nhập Lại: ")
        calcSelected = readln().toInt()
    }

    return calcSelected
}

fun getAnswer(a: Double, b: Double, calcSelected: Int): String {
    return when(calcSelected) {
        1 -> "a + b = ${a add b}"
        2 -> "a - b = ${a sub b}"
        3 -> "a * b = ${a multi b}"
        4 -> "a / b = ${a div b}"
        else -> "ERROR calcSelected!"
    }
}

