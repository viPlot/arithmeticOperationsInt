import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.print("Введите первое число: ");
        int frstNum = setNum();
        System.out.print("Введите второе число: ");
        int scndNum = setNum();
        System.out.print("Введите модуль: ");
        int mod = setNum();

        Operations op = new Operations();
        op.addition(frstNum, scndNum, mod);
        op.subtraction(frstNum, scndNum, mod);
        op.multiplication(frstNum, scndNum, mod);
        op.division(frstNum, scndNum, mod);
        op.multiplicativeInverse(frstNum, scndNum, mod);
        op.additiveInverse(frstNum, scndNum, mod);
        op.exponentiation(frstNum, scndNum, mod);
    }

    private static int setNum(){
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        return num;
    }
}
