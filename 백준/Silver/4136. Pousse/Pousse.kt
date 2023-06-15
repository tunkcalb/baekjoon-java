import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

var boardSize = 0
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {
    boardSize = readLine()!!.toInt()
    val board = Array(boardSize + 1) { CharArray(boardSize + 1) { ' ' } }
    var round = 1
    while (true) {
        val move = readLine()
        if (move == "QUIT") {
            println("TIE GAME")
            break
        }
        val len = move.length
        val dir = move[0].toString()
        val idx = move.substring(1, len).toInt()

        var marker = ' '
        if (round % 2 == 1) {
            marker = 'X'
        } else {
            marker = 'O'
        }
        round++
        display(board, dir, idx, marker)
        var xCnt = 0
        var oCnt = 0
        for(i in 1 until boardSize + 1){
            if(board[i][i] == ' ') continue
            xCnt += check('X', i, board)
            oCnt += check('O', i, board)
        }
        if(xCnt > oCnt){
            println("X WINS")
            break
        } else if (oCnt > xCnt){
            println("O WINS")
            break
        }
    }
}

fun check(marker: Char, idx: Int, board: Array<CharArray>): Int {
    var cnt = 0
    var rowCnt = 0
    var colCnt = 0
    for(i in 1 until boardSize + 1){
        if(board[idx][i] == marker) colCnt++
        if(board[i][idx] == marker) rowCnt++
    }
    if(rowCnt == boardSize) cnt++
    if(colCnt == boardSize) cnt++
    return cnt
}

fun display(board: Array<CharArray>, dir: String, idx: Int, marker: Char) {
    if (dir == "L") {
        var end = 0
        for (i in 2 until boardSize + 1) {
            end = i
            if (board[idx][i] == ' ') break
        }
        for (i in end downTo 1) {
            board[idx][i] = board[idx][i - 1]
        }
        board[idx][1] = marker
    } else if (dir == "R") {
        var end = boardSize
        for (i in boardSize - 1 downTo 1) {
            end = i
            if (board[idx][i] == ' ') break
        }
        for (i in end until boardSize) {
            board[idx][i] = board[idx][i + 1]
        }
        board[idx][boardSize] = marker
    } else if (dir == "T") {
        var end = 0
        for (i in 2 until boardSize + 1) {
            end = i
            if (board[i][idx] == ' ') break
        }
        for (i in end downTo 1) {
            board[i][idx] = board[i - 1][idx]
        }
        board[1][idx] = marker
    } else {
        var end = boardSize
        for(i in boardSize - 1 downTo  1){
            end = i
            if (board[i][idx] == ' ') break
        }
        for(i in end until boardSize){
            board[i][idx] = board[i + 1][idx]
        }
        board[boardSize][idx] = marker
    }
}
