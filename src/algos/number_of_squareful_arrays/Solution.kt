package algos.number_of_squareful_arrays

import kotlin.math.floor
import kotlin.math.sqrt

class Solution {
    private val set = mutableSetOf<Int>()
    private lateinit var arr:IntArray

    private fun perfectSquare(num:Int):Boolean{
        val root = sqrt(num.toDouble())
        return floor(root) - root == 0.0
    }

    private fun Int.perfectSquare(num:Int):Boolean{
        val root = sqrt((this + num).toDouble())
        return floor(root) - root == 0.0
    }

    private fun f(index:Int, pre:Int?):Int{
        var count = 0
        for (i in 0 until arr.size){
            if (set.contains(i).xor(true)
                && (i == 0 || set.contains(i-1) || arr[i] != arr[i-1])
                && (index == 0 || pre!!.perfectSquare(arr[i]))){
                if (index == arr.size - 1){
                    print("${arr[i]}\n")
                    return 1
                }
                else{
                    set.add(i)
                    print("${arr[i]},")
                    count += f(index+1, arr[i])
                    set.remove(i)
                }
            }
        }
        print("\n")
        return count
    }

    fun numSquarefulPerms(A: IntArray): Int {
        A.sort()
        arr = A

        return f(0, null)
    }

}