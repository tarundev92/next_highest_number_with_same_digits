import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestDigits {

  @Test
  public void testTwoDigits() {
    Digits d = new Digits();
    String result = d.sameDigitNextHighestValue("35");
    assertEquals("53", result);
  }

  @Test
  public void testSixDigits() {
    Digits d = new Digits();
    String result = d.sameDigitNextHighestValue("534976");
    assertEquals("536479", result);
  }

  @Test
  public void testSevenDigits() {
    Digits d = new Digits();
    String result = d.sameDigitNextHighestValue("1000006");
    assertEquals("1000060", result);
  }

  @Test
  public void testDigitsNoOutput() {
    Digits d = new Digits();
    String result = d.sameDigitNextHighestValue("54321");
    assertEquals("No output", result);
  }

  @Test
  public void testDigitsWithOnlyZeroNoOutput() {
    Digits d = new Digits();
    String result = d.sameDigitNextHighestValue("0000000");
    assertEquals("No output", result);
  }

  @Test
  public void testSameDigitsNoOutput() {
    Digits d = new Digits();
    String result = d.sameDigitNextHighestValue("111");
    assertEquals("No output", result);
  }


  @Test
  public void testZeroDigitsNoOutput() {
    Digits d = new Digits();
    String result = d.sameDigitNextHighestValue("100000");
    assertEquals("No output", result);
  }

  @Test
  public void testNegativeTwoDigits() {
    Digits d = new Digits();
    String result = d.sameDigitNextHighestValue("-61");
    assertEquals("-16", result);
  }

  @Test
  public void testNegativeSixDigits() {
    Digits d = new Digits();
    String result = d.sameDigitNextHighestValue("-297501");
    assertEquals("-297105", result);
  }

  @Test
  public void testNegativeSevenDigits() {
    Digits d = new Digits();
    String result = d.sameDigitNextHighestValue("-9000006");
    assertEquals("-6000009", result);
  }

  @Test
  public void testNegativeSevenDigits2() {
    Digits d = new Digits();
    String result = d.sameDigitNextHighestValue("-1000006");
    assertEquals("-0610000", result);
  }

  @Test
  public void testNegativeDigitsNoOutput() {
    Digits d = new Digits();
    String result = d.sameDigitNextHighestValue("-123");
    assertEquals("No output", result);
  }

  @Test
  public void testNegativeDigits() {
    Digits d = new Digits();
    String result = d.sameDigitNextHighestValue("-321");
    assertEquals("-312", result);
  }

  @Test
  public void testNegativeDigitsWithOnlyZeroNoOutput() {
    Digits d = new Digits();
    String result = d.sameDigitNextHighestValue("-0000000");
    assertEquals("No output", result);
  }
}
