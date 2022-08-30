package task_2;

public class Main {
    public static void main(String[] args) {
        int[] array = {5, 6, 3, 2, 5, 1, 4, 9};
        int[] expected = {1, 2, 3, 4, 5, 5, 6, 9};
        System.out.print("Несортированный массив: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
        for (int i = array.length - 1; i > 0; i--) {
            for (int j = 0; j < i; j++) {
                if (array[j] > array[j + 1]) {
                    int buffer = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = buffer;
                }
            }
        }
        assert sortedArrayTest(array, expected) : "Массив не отсортирован!";
        System.out.print("\nОтсортированный массив: ");
        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static boolean sortedArrayTest(int[] array, int[] expected) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] != expected[i]) {
                return false;
            }
        }
        return true;
    }
}