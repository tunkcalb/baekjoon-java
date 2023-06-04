import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

fun main() = with(BufferedReader(InputStreamReader(System.`in`))){
    val n = readLine().toInt()
    
    for( i in 0 until n){
        val str = readLine()
        start(str)
    }
}

fun start(str: String) {
    val stack = Stack<Char>()

    for(i in str){
        if(i == '('){
            stack.add(i);
        }

        else if (i == ')'){
            if(stack.isEmpty()){
                println("NO")
                return
            }
            stack.pop()
        }
    }

    if(stack.isEmpty()){
        println("YES")
    }
    else{
        println("NO")
    }
}
