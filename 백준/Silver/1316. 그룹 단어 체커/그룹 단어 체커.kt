import java.io.BufferedReader
import java.io.InputStreamReader

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val N = readLine().toInt()
    var cnt = N
    for(i in 0 until N){
        val word = readLine()
        val charSet = mutableSetOf<Char>()
        var lastChar = ' '
        var isGroup = true
        word.forEach {
            if(lastChar != it){
                lastChar = it
                if(charSet.contains(it)){
                    isGroup = false
                }
                else{
                    charSet.add(it)
                }
            }
        }
        if(!isGroup) cnt--
    }
    println(cnt)
}
