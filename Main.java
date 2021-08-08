import java.util.Arrays;
import java.util.Collections;

class Digits{

  static Integer[] stringToIntArray(String strDigits){
    String firstDigit = strDigits.substring(0, 1);
    int sliceStartIndex = 1;
    if(strDigits.charAt(0) == '-'){
      firstDigit = strDigits.substring(0, 2);
      sliceStartIndex = 2;
    }
    strDigits = strDigits.substring(sliceStartIndex);
    char[] charDigits = strDigits.toCharArray();
    int size = charDigits.length + 1;
    Integer[] arr = new Integer[size];
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

    int swapIndex = sliceIndex+1;
    // System.out.println("swapIndex");
    // System.out.println(swapIndex);
    // System.out.println("digitsLen");
    // System.out.println(digitsLen);
    for(int i=sliceIndex+2; i<digitsLen;i++){
      if(negative){
        if(digitsArr[i] > digitsArr[swapIndex] && digitsArr[i] < digitsArr[sliceIndex])
          swapIndex = i;
      }else{
        if(digitsArr[i] < digitsArr[swapIndex])
          swapIndex = i;
      }
    }
    // System.out.println("Before swap");
    // System.out.println(Arrays.toString(digitsArr));
    digitsArr = swapValue(digitsArr, sliceIndex, swapIndex);
    // System.out.println("After swap");
    // System.out.println(Arrays.toString(digitsArr));

    // System.out.println();
    System.out.println("swapIndex");
    System.out.println(swapIndex);
    System.out.println("sliceIndex");
    System.out.println(sliceIndex);
    // System.out.println("digitsLen");
    // System.out.println(digitsLen);
    // System.out.println(digitsArr[sliceIndex+1]);
    if(negative){
      System.out.println("Before sort");
      System.out.println(Arrays.toString(digitsArr));
      Arrays.sort(digitsArr, sliceIndex+1, digitsLen, Collections.reverseOrder());
      System.out.println("After sort");
      System.out.println(Arrays.toString(digitsArr));
    }else{
      Arrays.sort(digitsArr, sliceIndex+1, digitsLen);
    }

    // System.out.println("After sort");
    // System.out.println(Arrays.toString(digitsArr));

    // digitsSortPart = Arrays.copyOfRange(digitsArr, sliceIndex, digitsLen);

    // System.out.println("Final val");
    // System.out.println(Arrays.toString(digitsArr).replaceAll("\\[|\\]|,|\\s", ""));
    finalDigits = Arrays.toString(digitsArr).replaceAll("\\[|\\]|,|\\s", "");
    if(negative)
    finalDigits = "-" + Arrays.toString(digitsArr).replaceAll("\\[|\\]|,|\\s", "");

    // return "" + Integer.parseInt(finalDigits);
    return finalDigits;


  }

}

public class Main{

  public static void main(String []args){
    //  String str = "12345";
    //  String str = "218765";
    //  String str = "1234";
    //  String str = "4321";
    // String str = "534976";
    // String str = args[0];
    System.out.println("Your first argument is: "+args[0]);
    // char[] charDigits = str.toCharArray();
    //  int size = charDigits.length;
    //  int [] arr = new int[size];
    //  for(int i=0; i<size; i++) {
    //     arr[i] = Character.getNumericValue(charDigits[i]);
    //  }
    Digits d = new Digits();
    System.out.println(d.sameDigitNextHighestValue(args[0]));
  }
}
