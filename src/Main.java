public class Main {
    public static void main(String[] args) {
        String[][] array = {
                {"1", "2", "3", "3"},
                {"4", "5", "6", "7"},
                {"2", "1", "2", "2"},
                {"33", "5", "5", "5"}
        };

        String[][] errorArr = {
                {"6", "6", "8", "8"},
                {"1", "3", "5"},
                {"34", "5"},
                {"5", "5"}
        };

        String[][] errorDataArr = {
                {"1", "2", "3", "4"},
                {"5", "6", "7"},
                {"cat8", "9"},
                {"1", "2t"}
        };


        try {
            int result = checkAndSum(array);
            System.out.println("Проверка корректного массива: сумма элементов -  " + result);
        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage());

        } catch (MyArrayDataException e) {
            System.out.println(e.getMessage());
        }

        try {
            int result=checkAndSum(errorArr);
            System.out.println("Проверка некорректного массива: сумма элементов -  " + result);
        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage());

        } catch (MyArrayDataException e) {
            System.out.println(e.getMessage());
        }

        try {
            int result=checkAndSum(errorDataArr);
            checkAndSum(errorDataArr);
            System.out.println("Проверка некорректных данных: сумма элементов -  " + result );
        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage());

        } catch (MyArrayDataException e) {
            System.out.println(e.getMessage());
        }
    }

    public static int checkAndSum(String[][] a) throws MyArraySizeException, MyArrayDataException {
        if (a.length != 4 || a[0].length != 4 || a[1].length != 4 || a[2].length != 4 || a[3].length != 4) {
            throw new MyArraySizeException();
        }
        int sum = 0;
        int value;
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                try {
                    value = Integer.parseInt(a[i][j]);
                    sum += value;
                } catch (IllegalArgumentException e) {
                    String message = "элемент массива [" + i + "][" + j + "] невозможно преобразовать";
                    throw new MyArrayDataException(message);
                }
            }
        }
        return sum;
    }
}
