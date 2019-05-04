package exceptiontask;

public class Main {
    public static void main(String[] args) {
        String[][] arr1 = {{"1","2","3"},{"01","02","03"},{"01","02","03"}};

        try {
            myArrayExchange(arr1,2);
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        }
    }

    //Метод по заданию для массива 4x4
    public static void myArrayExchange(String[][] myArray) throws MyArraySizeException{

        if (myArray.length != 4 || myArray[0].length != 4){
            String exMsg = "Передан массив размерностью " + myArray.length + "x" + myArray[0].length;
            exMsg += ". Массив должен быть размерностью 4x4.";
            throw new MyArraySizeException(exMsg);
        }else
        {
            System.out.println("Правильная размерность!");
        }
    }

    //Метод по заданию для массива с переменной размерностью dimArr
    public static void myArrayExchange(String[][] myArray, int dimArr) throws MyArraySizeException{
        if (myArray.length != dimArr || myArray[0].length != dimArr){
            String exMsg = "Передан массив размерностью " + myArray.length + "x" + myArray[0].length;
            exMsg += ". Массив должен быть размерностью " + dimArr + "x" + dimArr +".";
            throw new MyArraySizeException(exMsg);
        }else
        {
            System.out.println("Правильная размерность!");
        }
    }
}
