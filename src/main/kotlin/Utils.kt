class Utils {
    companion object {
        fun bound(value: Int, min: Int, max: Int): Int {
            if (value < min) { return min; }
            if (value > max) { return max; }
            return value
        }
    }
}