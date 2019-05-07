package exceptiontask;

import sun.invoke.empty.Empty;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        //String[][] arr1 = {{"1","2","3","4"},{"01","02!","03","04"},{"01","02","03","04"},{"01","02","03","04"}};
        String[][] arr1 = {{"1","2","3","4","5"},{"01","03","03","04","06"},{"01=","02","03","04","001"},{"1","2","3","4","2"},{"1","2","3","4","07"}};

        try {
            System.out.println(myArrayEx(arr1,5));
        } catch (MyArraySizeException e) {
            e.printStackTrace();
        } catch (MyArrayDataException e) {
            e.printStackTrace();
        }
    }

    //Метод суммирования эелементов массива с задаваемой размерностью
    private static int myArrayEx(String[][] arr, int dimArr) throws MyArrayDataException,MyArraySizeException {
        checkSize(arr,dimArr);
        checkData(arr,dimArr);
       try{
           int sumArray=0;
           for (int i =0; i<(dimArr*dimArr);i++) {
               sumArray += Integer.parseInt(arr[i/dimArr][i%dimArr]);
           }
        return sumArray;
        }catch(NumberFormatException e){
           return 0;
       }
    }

    //Метод проверки размерности массива
    private static void checkSize(String [][] arr, int dimArr) throws MyArraySizeException{
        if (arr.length != dimArr || arr[0].length != dimArr){
            String exMsg = "Передан массив размерностью " + arr.length + "x" + arr[0].length;
            exMsg += ". Массив должен быть размерностью " + dimArr + "x" + dimArr +".";
            throw new MyArraySizeException(exMsg);
        }
    }

    //Метод проверки данных массива
    private static void checkData(String [][] arr, int dimArr)throws MyArrayDataException{
        String errCells="";
        for (int i =0; i<(dimArr*dimArr);i++) {
            int x = i/dimArr;
            int y = i%dimArr;
            char sep = ',';
            try {
                Integer.parseInt(arr[x][y]);
            }catch (NumberFormatException e){
                if (errCells != "")
                    errCells += sep + "[" + x + "," + y +"]";
                else
                    errCells += "[" + x + "," + y +"]";
            }
        }
        if (errCells != "")
            throw new MyArrayDataException("В ячейках: " + errCells + " не числа!");
    }
}