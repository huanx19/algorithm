import algo.available_captures_for_rook.Solution

fun main(){
    val board = arrayOf(
        charArrayOf('.', 'p', '.'),
        charArrayOf('p', 'R', 'p'),
        charArrayOf('.', 'p', '.'))

    Solution().numRookCaptures(board).run { print("$this\n") }
}