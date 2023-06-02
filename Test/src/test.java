import java.util.ArrayList;
import java.util.Arrays;

public class test {
    public static void main(String[] args) {

        int[] originalArray = {1, 2, 3};
        int[] copyArray = Arrays.copyOf(originalArray, 3);
        int[] newArray = new int[originalArray.length];
        originalArray.clone();
        ArrayList<Integer> hello;
        System.arraycopy(originalArray, 0, newArray, 0, originalArray.length);

        System.out.println("memory location of originalArray: " + originalArray);
        System.out.println("memory location of copyArray: " + copyArray);
        System.out.println("memory location of newArray: " + newArray);
        System.out.println("values of originalArray" + Arrays.toString(originalArray));
        System.out.println("values of copyArray" + Arrays.toString(copyArray));
        System.out.println("values of newArray" + Arrays.toString(newArray));

        originalArray[1] = 50;
        copyArray[0] = 100;

        System.out.println("values of originalArray" + Arrays.toString(originalArray));
        System.out.println("values of copyArray" + Arrays.toString(copyArray));
        System.out.println("values of newArray" + Arrays.toString(newArray));
    }
}
