class Calculator {
    fun sum(num1: Int, num2: Int): Int {
        return num1 + num2
    }

    fun subtraction(num1: Int, num2: Int): Int = num1 - num2
    fun multiplication(num1: Int, num2: Int): Int = num1 * num2
    fun division(num1: Int, num2: Int): Int {
        if (num2 == 0) throw DivideByZeroException(num1) else return num1 / num2
    }

    fun square(num1: Int): Int {
        return num1 * num1
    }

    fun squareRoot(input: Int): Int = Math.sqrt(input.toDouble()).toInt()

}
