package algo.available_captures_for_rook

class Solution {

    enum class Direction{
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    private lateinit var board: Array<CharArray>

    private fun hit(position: Pair<Int, Int>):Int{
        val (row, col) = position

        return if(board[row][col] == 'p') 1 else 0
    }

    private fun move(direction: Direction, position:Pair<Int, Int>):Int{
        val (row, col) = position

        if (board[row][col] != '.' && board[row][col] != 'R') return hit(position)

        else when(direction){

            Direction.UP -> {
                return  when(row) {
                    0 ->  0

                    else ->  move(direction, Pair(row-1, col))
                }
            }

            Direction.DOWN -> {
                return when(row) {
                    board.size-1 -> 0

                    else -> move(direction, Pair(row+1, col))
                }
            }

            Direction.LEFT -> {
                return when(col){
                    0 -> 0

                    else -> move(direction, Pair(row, col-1))
                }
            }

            Direction.RIGHT -> {
                return when(col){
                    board[0].size-1 -> 0

                    else -> move(direction, Pair(row, col+1))
                }
            }

        }
    }

    private fun findR():Pair<Int, Int> {
        for (row in 0 until board.size){
            for (col in 0 until board[0].size){
                if (board[row][col] == 'R'){
                    return Pair(row, col)
                }
            }
        }

        return Pair(-1, -1)
    }

    fun numRookCaptures(board: Array<CharArray>): Int {
        this.board = board

        val position = findR()

        return move(Direction.UP, position) + move(Direction.DOWN, position) + move(Direction.LEFT, position) + move(Direction.RIGHT, position)
    }
}