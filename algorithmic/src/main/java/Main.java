import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args)
    {
        List<Integer> arr = new ArrayList<Integer>();
        for (int i = 1; i <= 10; i++)
        {
            arr.add(i);
        }
        System.out.println("打乱前:");
        for (int i : arr)
        {
            System.out.print(i + " ");
        }
        Collections.shuffle(arr);
        System.out.println("\n打乱后:");
        for (int i : arr)
        {
            System.out.print(i + " ");
        }
    }

}
