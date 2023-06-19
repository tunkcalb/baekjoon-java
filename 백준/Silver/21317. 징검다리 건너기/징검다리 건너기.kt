import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.min

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val N = readLine().toInt()

    val rocks = Array(2) { IntArray(N + 4) }

    for (i in 1 until N) {
        val st = StringTokenizer(readLine())
        rocks[0][i] = st.nextToken().toInt()
        rocks[1][i] = st.nextToken().toInt()
    }

    val K = readLine().toInt()

    val dp = Array(2) { IntArray(N + 4) { 200000 } }
    dp[0][1] = 0

    for (i in 1 until N + 1) {
        dp[0][i + 1] = min(dp[0][i + 1], dp[0][i] + rocks[0][i])
        dp[0][i + 2] = min(dp[0][i + 2], dp[0][i] + rocks[1][i])
        dp[1][i + 3] = min(dp[1][i + 2] + rocks[0][i + 2], dp[1][i + 1] + rocks[1][i + 1])
        dp[1][i + 3] = min(dp[1][i + 3], dp[0][i] + K)
    }

    println(min(dp[0][N], dp[1][N]))
}
