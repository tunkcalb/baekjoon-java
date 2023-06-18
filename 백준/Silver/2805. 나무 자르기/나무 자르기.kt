import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.StringTokenizer
import kotlin.math.max
import kotlin.math.min

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    var st = StringTokenizer(readLine())
    val N = st.nextToken().toInt()
    val M = st.nextToken().toInt()

    val tree = IntArray(N)

    st = StringTokenizer(readLine())
    var start = Integer.MAX_VALUE
    var end = 0
    for (i in 0 until N) {
        tree[i] = st.nextToken().toInt()
        start = min(start, tree[i])
        end = max(end, tree[i])
    }
    tree.sortDescending()
    var mid = 0
    while (start <= end) {
        var sum: Long = 0
        tree.forEach {
            if (it <= mid) return@forEach
            sum += it - mid
        }
        if (sum >= M) start = mid + 1
        else end = mid - 1
        mid = (start + end) / 2
    }
    println(mid)
}
