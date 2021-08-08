import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestDigits {

   @Test
   public void testSixDigits() {
     Digits d = new Digits();
     String result = d.sameDigitNextHighestValue("534976");
     assertEquals("536479", result);
   }

   @Test
   public void testTwoDigits() {
     Digits d = new Digits();
     String result = d.sameDigitNextHighestValue("35");
     assertEquals("53", result);
   }

   @Test
   public void testDigitsNoOutput() {
     Digits d = new Digits();
     String result = d.sameDigitNextHighestValue("54321");
     assertEquals("-1", result);
   }

   @Test
   public void testDigitsWith() {
     Digits d = new Digits();
     String result = d.sameDigitNextHighestValue("1000006");
     assertEquals("1000060", result);
   }

   @Test
   public void testSameDigitsNoOutput() {
     Digits d = new Digits();
     String result = d.sameDigitNextHighestValue("111");
     assertEquals("-1", result);
   }

   @Test
   public void testZeroDigitsNoOutput() {
     Digits d = new Digits();
     String result = d.sameDigitNextHighestValue("100000");
     assertEquals("-1", result);
   }

   @Test
   public void testNegativeDigitsNoOutput() {
     Digits d = new Digits();
     String result = d.sameDigitNextHighestValue("-123");
     assertEquals("-1", result);
   }
   @Test
   public void testNegativeDigits() {
     Digits d = new Digits();
     String result = d.sameDigitNextHighestValue("-321");
     assertEquals("-312", result);
   }
}
