import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

lateinit var nums: IntArray

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    val N = readLine().toInt()
    val st = StringTokenizer(readLine())
    nums = IntArray(N)

    for (i in 0 until N) {
        nums[i] = st.nextToken().toInt()
    }

    Arrays.sort(nums)
    var ans : Long = 0
    for (i in 0 until N){
        var left = i
        var right = N - 1
        while (left <= right){
            var mid = (left + right) / 2

            if (nums[i] * 10 >= nums[mid] * 9)
                left = mid + 1
            else
                right = mid - 1
        }
        ans += right - i
    }
    println(ans)
}
