package task2;

/*
    Task2
    [3, 4, 2, 7], 10 -> [3, 7] - вывести пару менно в скобках, которые дают сумму - 10
*/

import java.util.Arrays;
import java.util.Objects;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        int[] array = {3, 4, 2, 7};
        int sum = 10;
        pairOfNumbers(sum, array);
    }

    private static void pairOfNumbers(int sum, int[] array) {
        IntStream.range(0, array.length)
                .filter(Objects::nonNull)
                .boxed()
                .flatMap(i -> IntStream.range(i, array.length)
                        .boxed()
                        .filter(j -> sum - array[i] == array[j])
                        .flatMap(j -> Stream.of(new int[]{array[i], array[j]})))
                .forEach(arr -> System.out.println(Arrays.toString(arr)));
    }
}

