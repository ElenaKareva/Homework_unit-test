import org.junit.jupiter.api.*;


class CalculatorTest {
    Calculator calc;

    @BeforeEach
    public void init() {
        System.out.println("test started");
        calc = new Calculator();
    }

    @BeforeAll
    public static void started(){
        System.out.println("tests started");
    }

    @AfterEach
    public void finished(){
        System.out.println("test completed");
    }

    @AfterAll
    public static void finishedAll(){
        System.out.println("tests completed");
    }

    @Test
    @DisplayName("Проверка сложения")
    public void plus() {
        //given
         int x = 5, y = 7, expected = 12;
        //when
         int result = calc.plus.apply(x, y);
        //then
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("Проверка  вычитания")
    void minus() {
        //given
        int x = 10, y = 7, expected = 3;
        //when
        final int result = calc.minus.apply(x, y);
        //then
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("Проверка  умножения")
    void multipy() {
        //given
        final int x = 5, y = 7, expected = 35;
        //when
        final int result = calc.multiply.apply(x, y);
        //then
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("Проверка  деления")
    void devide() {
        //given
        int x = 35, y = 7, expected = 5;
        //when
        final int result = calc.division.apply(x, y);
        //then
        Assertions.assertEquals(expected, result);
    }

    @Test
    @DisplayName("Проверка деления на 0")
    void devideByZero() {
        //given
        int x = 35, y = 0;
        //then
        Assertions.assertThrows(
                ArithmeticException.class,
                () -> calc.division.apply(x, y)
        );
    }


    @Test
    @DisplayName("Проверка текста исключения при делении на 0")
    void exceptionDevideByZero() {
        //given
        int x = 35, y = 0;

        //when
        ArithmeticException exception = Assertions.assertThrows(
                ArithmeticException.class,
                () -> calc.division.apply(x, y)
        );
        //then
        Assertions.assertEquals(" На ноль делить нельзя", " На ноль делить нельзя");
    }

    @Test
    @DisplayName("Проверка возведения числа в квадрат")
    void pow() {
        //given
        int x = 5, expected = 25;
        //when
        final int result = calc.pow.apply(x);
        //then
        Assertions.assertEquals(expected, result);

    }

    @Test
    @DisplayName("Проверка модуля числа")
    void abs() {
        //given
        int x = -5, expected = 5;
        //when
        final int result = calc.abs.apply(x);
        //then
        Assertions.assertEquals(expected, result);

    }

    @Test
    @DisplayName("Проверка  положительного числа")
    void isPositive() {
        //given
        int x = -5;
        Boolean expected = false;
        //when
        final Boolean result = calc.isPositive.test(x);
        //then
        Assertions.assertEquals(expected, result);
    }
}
