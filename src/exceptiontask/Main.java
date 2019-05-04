package exceptiontask;

import sun.invoke.empty.Empty;

public class Main {
    public static void main(String[] args) {
        //String[][] arr1 = {{"1","2","3"},{"01","02","03"},{"01","02","03"}};
        String[][] arr1 = {{"1","2","3","4","5"},{"01","02","03","04","06"},{"01","02","03","04","001"},{"1","2","3","4","2"},{"1","2","3","4","07"}};


        try {
            myArrayExchange(arr1,5);
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        } catch (MyArrayDataException e) {
            e.printStackTrace();
        }

    }

    //Метод по заданию для массива 4x4
    public static void myArrayExchange(String[][] myArray) throws MyArraySizeException,MyArrayDataException{

        if (myArray.length != 4 || myArray[0].length != 4){
            String exMsg = "Передан массив размерностью " + myArray.length + "x" + myArray[0].length;
            exMsg += ". Массив должен быть размерностью 4x4.";
            throw new MyArraySizeException(exMsg);
        }else{
            String errCells ="";
            char sep = ',';
            int sumArray =0;

            for (int i =0; i<(4*4);i++) {
                int x = (int) i / 4;
                int y = i % 4;
                try {
                    sumArray += Integer.parseInt(myArray[x][y]);
                } catch (NumberFormatException e){
                    if (errCells != "")
                        errCells += sep + "[" + x + "," + y +"]";
                    else
                        errCells += "[" + x + "," + y +"]";
                }
            }
            if (errCells != "")
                throw new MyArrayDataException("В ячейках массива: " + errCells + " не числа!");
            System.out.println("Сумма всех ячеек массива ровна " + sumArray + ".");
        }
    }

    //Перегрузка метода для массива с переменной размерностью dimArr
    public static void myArrayExchange(String[][] myArray, int dimArr) throws MyArraySizeException,MyArrayDataException{
        if (myArray.length != dimArr || myArray[0].length != dimArr){
            String exMsg = "Передан массив размерностью " + myArray.length + "x" + myArray[0].length;
            exMsg += ". Массив должен быть размерностью " + dimArr + "x" + dimArr +".";
            throw new MyArraySizeException(exMsg);
        }else
        {
            String errCells ="";
            char sep = ',';
            int sumArray =0;

            for (int i =0; i<(dimArr*dimArr);i++) {
                int x = (int) i / dimArr;
                int y = i % dimArr;
                try {
                    sumArray += Integer.parseInt(myArray[x][y]);
                } catch (NumberFormatException e){
                    if (errCells != "")
                        errCells += sep + "[" + x + "," + y +"]";
                    else
                        errCells += "[" + x + "," + y +"]";
                }
            }
            if (errCells != "")
                throw new MyArrayDataException("В ячейках: " + errCells + " не числа!");
            System.out.println("Сумма всех ячеек массива ровна " + sumArray + ".");
        }
    }
}
