import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory
import org.junit.jupiter.api.function.Executable
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.MethodSource
import kotlin.test.Test

class CalculatorTest {

    private val calc = Calculator()
    private val squaresTestData = listOf(
        1 to 1,
        2 to 4,
        3 to 9,
        4 to 16,
        5 to 25
    )


    @Test
    fun `should sum 2 and 3, then return 5`() {
        val result = calc.sum(2, 3)
        Assertions.assertEquals(5, result)
    }

    @Test
    fun `should subtract 10 and 5, the return 5`() {
        val result = calc.subtraction(10, 5)
        Assertions.assertEquals(5, result)
    }

    @Test
    fun `should multiply 5 and 3, then return 15`() {
        val result = calc.multiplication(5, 3)
        Assertions.assertEquals(15, result)
    }

    @Test
    fun `should divide 21 and 3, then return 7`() {
        val result = calc.division(21, 3)
        Assertions.assertEquals(7, result)
    }

    @Test
    fun `dividing by zero should throw DivideByZeroException`() {
        val exception = Assertions.assertThrows(DivideByZeroException::class.java) {
            calc.division(5, 0)
        }
        Assertions.assertEquals(5, exception.numerator)
    }

    @Test
    fun `the square of a number should be equal to that number multiplied in itself`() {
        Assertions.assertAll(
            Executable { Assertions.assertEquals(1, calc.square(1)) },
            Executable { Assertions.assertEquals(4, calc.square(2)) },
            Executable { Assertions.assertEquals(9, calc.square(3)) }
        )
    }

    @TestFactory
    fun testSquares() = listOf(
        DynamicTest.dynamicTest("when i calculate 1^2 then I get 1") {
            Assertions.assertEquals(1, calc.square(1))
        },
        DynamicTest.dynamicTest("when i calculate 2^2 then I get 4") {
            Assertions.assertEquals(4, calc.square(2))
        },
        DynamicTest.dynamicTest("when i calculate 3^2 then I get 9") {
            Assertions.assertEquals(9, calc.square(3))
        }
    )

    @TestFactory
    fun testSquares2() = listOf(
        1 to 1,
        2 to 4,
        3 to 9,
        4 to 16,
        5 to 25
    ).map { (input, expected) ->
        DynamicTest.dynamicTest("when i calculate $input^2 then I get $expected") {
            Assertions.assertEquals(expected, calc.square(input))
        }
    }

    @TestFactory
    fun testSquares3() = squaresTestData.map { (input, expected) ->
        DynamicTest.dynamicTest("when i calculate $input^2 the i get $expected ") {
            Assertions.assertEquals(expected, calc.square(input))
        }
    }

    @TestFactory
    fun testSquareRoots() = squaresTestData.map { (expected, input) ->
        DynamicTest.dynamicTest("when i calculate the square root of $input the i get $expected") {
            Assertions.assertEquals(expected, calc.squareRoot(input))
        }
    }

    @ParameterizedTest(name = "{0}") // Usa o nome do caso de teste como descrição
    @MethodSource("squares")
    fun testSquares4(name: String, input: Int, expected: Int) {
        Assertions.assertEquals(expected, input * input)
    }

    companion object {
        @JvmStatic
        fun squares() = listOf(
            Arguments.of("Caso 1: 1² = 1", 1, 1),
            Arguments.of("Caso 2: 2² = 4", 2, 4)
        )
    }

    @ParameterizedTest(name = "Caso {index}: {0}² = {1}")
    @CsvSource(
        "1,1",
        "2,4",
        "3,9"
    )
    fun testSquares5(input: Int,expected: Int){
        Assertions.assertEquals(expected,input * input)
    }
}