package c01_02_toolkit_and_workflow.lesson_08_testing.task01_testdemo;

import java.util.Arrays;
import java.util.Random;

public class AscendingSort {
    public static void main(String[] args) {
        Random rand = new Random();
        int n = 10;
        int[] lst = new int[n];
        for (int i = 0; i < n; i++)
            lst[i] = rand.nextInt(50) + 1;

        System.out.println(Arrays.toString(lst));
        System.out.println(Arrays.toString(mySort(lst)));
    }

    public static int[] mySort(int[] lst1) {
        int[] list1 = Arrays.copyOf(lst1, lst1.length);
        int x;
        boolean xchange = true;
        while (xchange) {
            xchange = false;

            for (int i = 0; i < list1.length - 1; i++)
                if (list1[i] > list1[i + 1]) {
                    x = list1[i];
                    list1[i] = list1[i + 1];
                    list1[i + 1] = x;
                    xchange = true;
                }
        }
        return list1;
    }
}
