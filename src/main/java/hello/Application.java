package hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import net.objecthunter.exp4j.ExpressionBuilder;
import net.objecthunter.exp4j.Expression;

@SpringBootApplication
@RestController
public class Application {

    // Головна сторінка з формою калькулятора
    @RequestMapping("/")
    public String home() {
        return "<html>" +
               "<head><title>Калькулятор</title></head>" +
               "<body>" +
               "<h2>Калькулятор</h2>" +
               "<form action='/calculate' method='post'>" +
               "Введіть вираз: <input type='text' name='expression'/>" +
               "<input type='submit' value='Обчислити'/>" +
               "</form>" +
               "</body>" +
               "</html>";
    }

    // Обробка запиту на обчислення виразу
    @RequestMapping(value = "/calculate", method = RequestMethod.POST)
    @ResponseBody
    public String calculate(String expression) {
        String result = "Невірний вираз";

        try {
            if (expression == null || expression.trim().isEmpty()) {
                throw new IllegalArgumentException("Вираз не може бути порожнім.");
            }

            result = calculateExpression(expression);
        } catch (Exception e) {
            result = "Помилка при обчисленні виразу: " + e.getMessage();
        }

        return "<html>" +
               "<body>" +
               "<h2>Результат: " + result + "</h2>" +
               "<a href='/'>Назад</a>" +
               "</body>" +
               "</html>";
    }

    // Функція для обчислення виразу
    private String calculateExpression(String expression) {
        // Використовуємо exp4j для обчислення виразу
        Expression exp = new ExpressionBuilder(expression).build();
        double result = exp.evaluate();

        // Повертаємо результат
        return String.valueOf(result);
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
