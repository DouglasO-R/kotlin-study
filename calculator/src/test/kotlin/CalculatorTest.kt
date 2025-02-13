import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class CalculatorTest {

    private val calc = Calculator()

    @Test
    fun `should sum 2 and 3, then return 5`() {
        val result = calc.sum(2, 3)
        assertEquals(5, result)
    }

    @Test
    fun `should subtract 10 and 5, the return 5`(){
        val result = calc.subtraction(10,5)
        assertEquals(5,result)
    }

    @Test
    fun `should multiply 5 and 3, then return 15`(){
        val result = calc.multiplication(5,3)
        assertEquals(15,result)
    }

    @Test
    fun `should divide 21 and 3, then return 7`(){
        val result = calc.division(21,3)
        assertEquals(7,result)
    }
}