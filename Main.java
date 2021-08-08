import java.util.Arrays;
import java.util.Collections;

class Digits{

  static Integer[] stringToIntArray(String strDigits){
    String firstDigit = strDigits.substring(0, 1);
    int sliceStartIndex = 1;
    char[] charDigits;
    int size;
    Integer[] arr;
    if(strDigits.charAt(0) == '-'){
      firstDigit = strDigits.substring(0, 2);
      sliceStartIndex = 2;
    }
    strDigits = strDigits.substring(sliceStartIndex);
    charDigits = strDigits.toCharArray();
    size = charDigits.length + 1;
    arr = new Integer[size];
    arr[0] = Integer.parseInt(firstDigit);
    for(int i=1; i<size; i++) {
      arr[i] = Character.getNumericValue(charDigits[i-1]);
    }
    return arr;
  }

  static Integer[] swapValue(Integer[] arr, int fstIndex, int sndIndex){
    int temp = arr[fstIndex];
    arr[fstIndex] = arr[sndIndex];
    arr[sndIndex] = temp;
    return arr;
  }

  String sameDigitNextHighestValue(String strDigits){
    Integer[] digitsArr = stringToIntArray(strDigits);
    boolean negative = false;
    if(digitsArr[0] < 0){
      digitsArr[0] = digitsArr[0] * -1;
      negative = true;
    }
    int digitsLen = digitsArr.length;
    int prevDigit = digitsArr[digitsLen-1];
    int[] digitsSortPart;
    int sliceIndex = -1;
    String finalDigits = "";
    int swapIndex;

    for(int i=digitsLen-2; i>=0; i--){

      int currDigit = digitsArr[i];
      if(negative){
        if(currDigit > prevDigit){
          sliceIndex = i;
          break;
        }
      }else{
        if(currDigit < prevDigit){
          sliceIndex = i;
          break;
        }
      }

      prevDigit = currDigit;

    }
    if(sliceIndex == -1)
    return "No output";

    swapIndex = sliceIndex+1;

    for(int i=sliceIndex+2; i<digitsLen;i++){
      if(negative){
        if(digitsArr[i] > digitsArr[swapIndex] && digitsArr[i] < digitsArr[sliceIndex])
          swapIndex = i;
      }else{
        if(digitsArr[i] < digitsArr[swapIndex])
          swapIndex = i;
      }
    }
    digitsArr = swapValue(digitsArr, sliceIndex, swapIndex);
    if(negative){
      Arrays.sort(digitsArr, sliceIndex+1, digitsLen, Collections.reverseOrder());
    }else{
      Arrays.sort(digitsArr, sliceIndex+1, digitsLen);
    }

    finalDigits = Arrays.toString(digitsArr).replaceAll("\\[|\\]|,|\\s", "");
    if(negative)
    finalDigits = "-" + Arrays.toString(digitsArr).replaceAll("\\[|\\]|,|\\s", "");

    // return "" + Integer.parseInt(finalDigits);
    return finalDigits;
  }

}

public class Main{

  public static void main(String []args){
    Digits d = new Digits();
    System.out.println(d.sameDigitNextHighestValue(args[0]));
  }
}
