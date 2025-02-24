package MergeSort;


import java.util.Arrays;

public class MargeSort2 {
    public static void main(String[] args) {

        int[] array = new int[] {33, 2, 1, 6, 8, 3, 9, 0, 15, 12, 8};
        System.out.println(Arrays.toString(array));
        mergeSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void mergeSort(int[] array) {
        if(array.length <= 1) {
            return; // условие, если массив во время рекурсии стал меньше или равен 1
        } // возвращаемся из рекурсии
        int mid = array.length / 2;
        int[] left = new int[mid];//  левая половина массива
        int[] right = new int[array.length - mid]; // правая половина массива

        for(int i = 0; i < mid; i++) {
            left[i] = array[i]; // переписываем из основного массива, первую половину массива
        }
        for(int i = mid; i < array.length; i++) {
            right[i - mid] = array[i]; // переписываем из массива, вторую половину основного массива
        }

        mergeSort(left); // делим левый массив на отдельные компоненты
        mergeSort(right); // вызываем рекурсию, делим вторую половину массива, на более мелкие части
        merge(array, left, right); // помещаем основной массив в метод, первую половину и вторую половину массива
    }

    public static void merge(int[] targetArray, int[] arr1, int[] arr2) {
        // arr1 and arr2 это два массива, которые мы будем объединять в массив targetArray
        int arr1MinIndex = 0; // создаём переменные для хранения минимальных значений 2ух массивов
        int arr2MinIndex = 0;

        int targetMinIndex = 0; // эта переменная для хранения числа, после сравнения двух чисел из двух массивов

        while (arr1MinIndex < arr1.length && arr2MinIndex < arr2.length) { // условие работает, до тех пор, пока левый или правый массив, не заполнятся
            if (arr1[arr1MinIndex] <= arr2[arr2MinIndex]) { // сравниваем первый индекс первого массива со вторым
                targetArray[targetMinIndex] = arr1[arr1MinIndex]; // если условие выполняется, то массив, вписываем индекс первого массива
                arr1MinIndex++;
            } else {
                targetArray[targetMinIndex] = arr2[arr2MinIndex];
                arr2MinIndex++;
            }
            targetMinIndex++;
        }

        while (arr1MinIndex < arr1.length) { // если первый массив не заполнен, то заполняем
            targetArray[targetMinIndex] = arr1[arr1MinIndex]; // добавляем элемент в массив
            arr1MinIndex++;
            targetMinIndex++;
        }

        while (arr2MinIndex < arr2.length) {
            targetArray[targetMinIndex] = arr2[arr2MinIndex];
            arr2MinIndex++;
            targetMinIndex++;
        }
    }
}
