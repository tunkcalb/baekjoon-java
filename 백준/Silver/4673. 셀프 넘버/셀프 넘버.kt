fun self(origin: Int): Boolean {
    var i = origin
    while (i > 0) {
        var num = i
        var sum = 0
        sum += num
        while (num > 0) {
            sum += num % 10
            num /= 10
        }
        i--
        if (sum == origin) return true
    }
    return false
}

fun main(args: Array<String>) {
    for (i in 1 until 10001) {
        if (self(i)) continue
        else println(i)
    }
}
