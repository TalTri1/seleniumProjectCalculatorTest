import Utils.AbstractTest;
import WebPages.CalculatorMainPage;
import org.junit.Test;

public class CalculateAndVerifyMathematicalFormulas extends AbstractTest {

    @Test
    public void test() {
        CalculatorMainPage calculatorMainPage = new CalculatorMainPage(this.driver, this.wait);
        calculatorMainPage.addTwoNumbersCheck("2", "3");
        calculatorMainPage.subtractTwoNumbersCheck("10", "2");
        calculatorMainPage.complexArithmeticCheck("10", "2", "2", "20");
        calculatorMainPage.sinCheck("30", "0.5");
        calculatorMainPage.historyCheck("4");
    }
}
