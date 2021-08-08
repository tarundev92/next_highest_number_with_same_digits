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
   public void testDigitsNoOutput() {
     Digits d = new Digits();
     String result = d.sameDigitNextHighestValue("1000006");
     assertEquals("6000001", result);
   }
}
