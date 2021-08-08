import java.util.Arrays;

class Digits{

  static int[] stringToIntArray(String strDigits){
    String firstDigit = strDigits.substring(0, 1);
    int sliceStartIndex = 1;
    if(strDigits.charAt(0) == '-'){
      firstDigit = strDigits.substring(0, 2);
      sliceStartIndex = 2;
    }
    strDigits = strDigits.substring(sliceStartIndex);
    char[] charDigits = strDigits.toCharArray();
     int size = charDigits.length + 1;
     int[] arr = new int[size];
     arr[0] = Integer.parseInt(firstDigit);
     for(int i=1; i<size; i++) {
        arr[i] = Character.getNumericValue(charDigits[i-1]);
     }
     return arr;
  }

    static int[] swapValue(int[] arr, int fstIndex, int sndIndex){
        int temp = arr[fstIndex];
        arr[fstIndex] = arr[sndIndex];
        arr[sndIndex] = temp;
        return arr;
    }

    String sameDigitNextHighestValue(String strDigits){
        int[] digitsArr = stringToIntArray(strDigits);
        int digitsLen = digitsArr.length;
        int prevDigit = digitsArr[digitsLen-1];
        int[] digitsSortPart;
        int sliceIndex = -1;
        boolean negative = false;

        if(digitsArr[0] < 0){
          digitsArr[0] = digitsArr[0] * -1;
          negative = true;
        }

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
            return "-1";

        int swapIndex = sliceIndex+1;
        // System.out.println("swapIndex");
        // System.out.println(swapIndex);
        // System.out.println("digitsLen");
        // System.out.println(digitsLen);
        for(int i=sliceIndex+2; i<digitsLen;i++){
            if(digitsArr[i] < digitsArr[swapIndex])
                swapIndex = i;
        }
        // System.out.println("Before swap");
        // System.out.println(Arrays.toString(digitsArr));
        digitsArr = swapValue(digitsArr, sliceIndex, swapIndex);
        // System.out.println("After swap");
        // System.out.println(Arrays.toString(digitsArr));

        // System.out.println();
        // System.out.println("swapIndex");
        // System.out.println(swapIndex);
        // System.out.println("sliceIndex");
        // System.out.println(sliceIndex+1);
        // System.out.println("digitsLen");
        // System.out.println(digitsLen);
        // System.out.println(digitsArr[sliceIndex+1]);
        Arrays.sort(digitsArr, sliceIndex+1, digitsLen);
        // System.out.println("After sort");
        // System.out.println(Arrays.toString(digitsArr));

        // digitsSortPart = Arrays.copyOfRange(digitsArr, sliceIndex, digitsLen);

         // System.out.println("Final val");
        // System.out.println(Arrays.toString(digitsArr).replaceAll("\\[|\\]|,|\\s", ""));
        if(negative)
          return "-" + Arrays.toString(digitsArr).replaceAll("\\[|\\]|,|\\s", "");

        return Arrays.toString(digitsArr).replaceAll("\\[|\\]|,|\\s", "");


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
