import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    while (true) {
        val s = readLine()
        val len = s.length
        if (len < 2) break
        var num = s.toInt()
        var cnt = 0

        while (!isPalindrome(len, num + cnt)) {
            cnt++
        }
        println(cnt)
    }
}

fun isPalindrome(len: Int, num: Int): Boolean {
    val tmp = num.toString()
    var sb = StringBuilder()
    for(i in 0 until len - tmp.length){
        sb.append('0')
    }
    sb.append(tmp)
    val number = sb.toString()

    var start = 0
    var end = len - 1
    for(i in 0 until len / 2){
        if(!number[start + i].equals(number[end - i])){
            return false
        }
    }
    return true
}
