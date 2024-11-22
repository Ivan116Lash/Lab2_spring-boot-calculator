package hello;

import net.objecthunter.exp4j.ExpressionBuilder;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTests {

    @Test
    public void testSuccessfulExpression() {
        // Тест, який проходить
        String expression = "1+1";
        double result = new ExpressionBuilder(expression).build().evaluate();
        assertEquals(2.0, result, "1+1 повинно бути рівним 2");
    }

    /*@Test
    public void testFailingExpression() {
        // Тест, який завжди буде видавати помилку
        String expression = "5-1";
        double result = new ExpressionBuilder(expression).build().evaluate();
        // Тут ми очікуємо помилковий результат (наприклад, 2 замість 4)
        assertEquals(2.0, result, "5-1 повинно бути рівним 2 (помилкове очікування)");
    }*/
}
