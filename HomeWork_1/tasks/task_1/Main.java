package task_1;

public class Main {
    public static void main(String[] args) {
        int matrixSize = 10;
        int maxNumberInArray = 100;
        int[][] array = new int[matrixSize][matrixSize];
        RandomNumber randomNumber = new RandomNumber(maxNumberInArray);
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                array[i][j] = randomNumber.nextInt();
            }
        }

        assert correctArraySize(matrixSize)
                : "Неверно! Введите размер массива кратный 5!";

        System.out.println("Двумерный массив случайных чисел:");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + "\t");
            }
            System.out.println();
        }
        Main maxNumber = new Main();
        System.out.println("Максимальное число в массиве: "
                + maxNumber.searchMaxNumber(array));
        Main minNumber = new Main();
        System.out.println("Минимальное число в массиве: "
                + minNumber.searchMinNumber(array));
        Main middleNumber = new Main();
        System.out.println("Среднее значение чисел в массиве: "
                + middleNumber.searchMiddleNumber(array));
    }

    static class RandomNumber {
        private final int max;
        private int last;

        public RandomNumber(int max) {
            this.max = max;
            last = (int) (System.currentTimeMillis() % max);
        }

        public int nextInt() {
            last = (last * 2871 + 3) % 32719;
            return last % max;
        }
    }

    public int searchMaxNumber(int[][] array) {
        int maxNumber = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (maxNumber < array[i][j]) {
                    maxNumber = array[i][j];
                }
            }
        }
        return maxNumber;
    }

    public int searchMinNumber(int[][] array) {
        int minNumber = searchMaxNumber(array);
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                if (minNumber > array[i][j]) {
                    minNumber = array[i][j];
                }
            }
        }
        return minNumber;
    }

    public int searchMiddleNumber(int[][] array) {
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                sum += array[i][j];
            }
        }
        return sum / (array.length * array.length);
    }

    public static boolean correctArraySize(int matrixSize) {
        if (matrixSize % 5 == 0) {
            return true;
        }
        return false;
    }
}