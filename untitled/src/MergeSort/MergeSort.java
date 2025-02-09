package MergeSort;

import java.util.ArrayList;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class MergeSort {
    public static void main(String[] args) {
        int[] array = new int[] {15,78,89,9,12,12546,8,879,16,54,1,99,54};
        System.out.println(arrayToString(array));
        array = mergeSort(array);
        System.out.println(arrayToString(array));



    }

    public static int[] mergeSort(int[] array) {
        int[] tmp; // создаём вспомогательный массив
        int[] currentSrc = array;// создаём ещё один массив с элементами из первичного массива
        int[] currentDest = new int[array.length];// создаём массив длиной первичного массива

        int size = 1; // создаём переменную с размером 1
        while (size < array.length) { // цикл будет работать пока размер будет меньше длины первичного массива
            for (int i = 0; i < array.length; i += 2 * size) { // цикл будет работать пока i не станет равна размеру массива
                // в каждой итерации i  будет увеличиваться в 2 * размер, размер будет увеличиваться в 2 раза после каждой итерации
                merge(currentSrc, i, currentSrc, i + size, currentDest, i, size);
            }

            tmp = currentSrc;
            currentSrc = currentDest;
            currentDest = tmp;

            size = size * 2; // увеличение размера в 2 раза, с каджым разом будем наблюдать геометрическую прогрессию

            System.out.println(arrayToString(currentSrc)); // выведем отсортированный частично массив
        }
        return currentSrc; // после полной сортировки вернём отсортированный массив
    }

    private static void merge(int[] src1, int src1Start, int[] src2, int src2Start, int[] dest,
                              int destStart, int size) {
        int index1 = src1Start;// i первая половина подмассива
        int index2 = src2Start; // это i + size это чтобы поделить пополам массива, и получить
        // точку отсчёта для второго подмассива в основном массиве

        int src1End = Math.min(src1Start + size, src1.length); // это нужно чтобы мы не привысили длину массива при сортировке
        int src2End = Math.min(src2Start + size, src2.length);// а также метод быдет выбивать размер меньший
        // sct1,2Strart + size или scr.length; это для того чтобы определить конченый размер подмассива

        if (src1Start + size > src1.length) { // условие выполняется, если начальная точка + размер будут больше длины массива
            for (int i = src1Start; i < src1End; i++) {
                dest[i] = src1[i];
            }
            return;
        }

        int iterationCount = src1End - src1Start + src2End - src2Start;

        for (int i = destStart; i < destStart + iterationCount; i++) {
            if (index1 < src1End && (index2 >= src2End || src1[index1] < src2[index2])) {
                dest[i] = src1[index1];
                index1++;
            } else {
                dest[i] = src2[index2];
                index2++;
            }
        }
    }

    private static String arrayToString(int[] array) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < array.length; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(array[i]);
        }
        sb.append("]");
        return sb.toString();
    }
}