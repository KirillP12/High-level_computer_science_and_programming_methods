package triangle;

import java.util.Scanner;

// Заполненный равнобедренный треугольник. Основание - n, высота - (n+1)/2 (n - нечетное)
// n - нечётное число
public class Triangle {
    public static void main(String[] args) throws ScannerException {

        Scanner scan = new Scanner(System.in);

        while(true){
            System.out.print("Введите число нечётное: ");
            int number = scan.nextInt();
            if (number % 2 == 0){
                throw new ScannerException("Пользователь ввёл чётное число");
            }
            treugol(number);
        }

    }

    public static void treugol(int startingNumber){
            if(startingNumber >= 2) {


                int height = (startingNumber + 1) / 2; // высота, она используется в первом цикле while
                int numberMinus = startingNumber - 1; // эта переменная нужна для ограничение прописывания ^ во втором цикле
                int minus = 1; // для вычитания из numberString
                int str = 0; // эта переменная опорная для отступов
// StartingNumber не изменяется на протяжении всего метода
// меняется numberMinus в первом цикле while, после второстепенного цикла while, в котором
// numberMinus увеличивается до startingNumber
// это сделано для того, чтобы сначала вывести на экран 1 потом 3 потом 5 и тд элементов пирамиды
                while (height > 0) {


                    while (str < numberMinus) {
                        System.out.print(" ");
                        str += 2;

                    }

                    while (startingNumber > numberMinus) {
                        System.out.print("^");
                        numberMinus++;

                    }

                    height--;
                    minus += 2;
                    System.out.println("");
                    numberMinus -= minus;
                    str = 0;

                }
            } else {
                System.out.println("Пользователь должен ввести число больше 2ух, чтобы получилась пирамида");
            }

        }

    }

