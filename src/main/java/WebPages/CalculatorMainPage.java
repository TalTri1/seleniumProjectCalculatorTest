package WebPages;

import Utils.Funct;
import org.junit.Assert;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CalculatorMainPage {

    private ChromeDriver driver;
    private WebDriverWait wait;
    private Funct funct;

    public CalculatorMainPage(ChromeDriver webDriver, WebDriverWait webDriverWait) {
        this.driver = webDriver;
        this.wait = webDriverWait;
        this.funct = new Funct(driver, wait);
    }

    // elements declaration

    // buttons
    private final String numberBtn = "Btn";
    private final String additionBtn = "//button[@id='BtnPlus']";
    private final String subtractBtn = "//button[@id='BtnMinus']";
    private final String multipleBtn = "//button[@id='BtnMult']";
    private final String equalsBtn = "//button[@id='BtnCalc']";
    private final String sinBtn = "//button[@id='BtnSin']";
    private final String leftParenthesisBtn = "//button[@id='BtnParanL']";
    private final String rightParenthesisBtn = "//button[@id='BtnParanR']";
    private final String clearBtn = "//button[@id='BtnClear']";

    // text boxes
    private final String inputTxt = "//input[@id='input']";
    private final String historyTxt = "//div[@id='hist']";
    private final String historyListTxt = "//body/div[@id='calccontainer']/div[@id='histframe']/ul[1]/li";

    // private utils - action methods
    private void clickOnNumber(String num) {
        for (int i = 0; i < num.length(); i++) {
            funct.genericClick("//button[@id='" + numberBtn + num.charAt(i) + "']");
        }
    }

    private void clickOnAdd() {
        funct.genericClick(additionBtn);
    }

    private void clickOnSubtract() {
        funct.genericClick(subtractBtn);
    }

    private void clickOnEquals() {
        funct.genericClick(equalsBtn);
    }

    private void clickOnMultiple() {
        funct.genericClick(multipleBtn);
    }

    private void clickOnLeftParenthesis() {
        funct.genericClick(leftParenthesisBtn);
    }

    private void clickOnRightParenthesis() {
        funct.genericClick(rightParenthesisBtn);
    }

    private void clickOnSin() {
        funct.genericClick(sinBtn);
    }

    private void clickOnHistory() {
        funct.genericClick(historyTxt);
    }

    private void clickOnClear() {
        funct.genericClick(clearBtn);
        checkIfTextEqualsWithRetries("");
    }

    private String getInputText() {
        return funct.genericGetText(inputTxt);
    }

    private String getHistoryRowsNum() {
        return funct.countListRows(historyListTxt);
    }

    private void checkIfTextEqualsWithRetries(String expectedResult) {
        // do with 10 retries
        for (int i = 0; i < 10 ; i++) {
            if (getInputText().equals(expectedResult)){
                break;
            }
        }
        Assert.assertEquals(expectedResult, getInputText());
    }

    private void checkIfTextNotEqualsWithRetries(String expectedResult) {
        // do with 10 retries
        for (int i = 0; i < 10 ; i++) {
            if (!getInputText().equals(expectedResult)){
                break;
            }
        }
        Assert.assertNotEquals(expectedResult, getInputText());
    }

    // public methods
    public void addTwoNumbersCheck(String firstNum, String secondNum) {
        String expectedResult = String.valueOf((Integer.parseInt(firstNum) + Integer.parseInt(secondNum)));
        clickOnNumber(firstNum);
        clickOnAdd();
        clickOnNumber(secondNum);
        clickOnEquals();
        checkIfTextEqualsWithRetries(expectedResult);
        clickOnClear();
    }

    public void subtractTwoNumbersCheck(String firstNum, String secondNum) {
        String expectedResult = String.valueOf((Integer.parseInt(firstNum) - Integer.parseInt(secondNum)));
        clickOnNumber(firstNum);
        clickOnSubtract();
        clickOnNumber(secondNum);
        clickOnEquals();
        checkIfTextEqualsWithRetries(expectedResult);
        clickOnClear();
    }

    public void complexArithmeticCheck(String firstNum, String secondNum, String thirdNum, String expectedResult) {
        clickOnLeftParenthesis();
        clickOnNumber(firstNum);
        clickOnSubtract();
        clickOnNumber(secondNum);
        clickOnRightParenthesis();
        clickOnMultiple();
        clickOnNumber(thirdNum);
        clickOnEquals();
        checkIfTextNotEqualsWithRetries(expectedResult);
        clickOnClear();
    }

    public void sinCheck(String num, String expectedResult) {
        clickOnClear();
        clickOnSin();
        clickOnNumber(num);
        clickOnRightParenthesis();
        clickOnEquals();
        checkIfTextEqualsWithRetries(expectedResult);
        clickOnClear();
    }

    public void historyCheck(String expectedRows) {
        clickOnHistory();
        Assert.assertEquals(expectedRows, getHistoryRowsNum());
    }
}
