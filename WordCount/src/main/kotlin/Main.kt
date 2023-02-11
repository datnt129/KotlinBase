fun main() {
    var inputString = readln()
    println(worldCount(inputString))
    //println(removeSpecialCharacter(inputString))
    //println(removeDuplicateWord(inputString.split(" ").toList()))
}

fun worldCount(inputString: String): Int {
    var formatedCharsList = formatString(inputString)
    println(formatedCharsList)
    return formatedCharsList.count()
}

fun formatString(inputString: String): List<String> {
    var str = inputString.lowercase()
    str = removeSpecialCharacter(str).trim()
    val chars = str.split(" ").toList()
    return removeDuplicateWord(chars)
}

fun removeSpecialCharacter(str: String): String {
    val regex = "[^A-Za-z0-9 +]"
    val regex2 = "\\s+"
    //remove special character
    val newStr = str.replace(regex.toRegex(), "")
    //replace duplicate whitespace
    return newStr.replace(regex2.toRegex(), " ")
}

fun removeDuplicateWord(chars: List<String>): List<String> {
    return chars.distinct()
}
