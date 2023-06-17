import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer

var N = 0
var M = 0
lateinit var nums: IntArray
lateinit var number: IntArray
val sb = StringBuilder()

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    var st = StringTokenizer(readLine())
    N = st.nextToken().toInt()
    M = st.nextToken().toInt()

    nums = readLine().split(" ").map{it.toInt()}.toIntArray()
    number = IntArray(M)
    nums.sort()

    permutation(0, 0)
    println(sb)
}

fun permutation(cnt: Int, start: Int) {
    if(cnt == M){
        for(i in 0 until M){
            sb.append(number[i]).append(" ")
        }
        sb.append("\n")
        return
    }

    for(i in start until N){
        number[cnt] = nums[i]
        permutation(cnt + 1, i + 1)
    }
}
