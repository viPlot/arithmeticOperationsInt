public class Operations {

    public Operations(){
    }

    public void addition(int fNum, int sNum, int mod) {
        int sum = ((fNum % mod) + (sNum % mod)) % mod;
        System.out.println("> Результат сложения по модулю: " + fNum + " + " + sNum +
                " (mod " + mod + ") = " + sum);
    }

    public void subtraction(int fNum, int sNum, int mod) {
        if (fNum - sNum > 0) {
            int diff = ((fNum % mod) - (sNum % mod)) % mod;
            System.out.println("> Результат вычитания по модулю: " + fNum + " - " + sNum +
                    " (mod " + mod + ") = " + diff);
        }
        else {
            int diffElse = (((fNum % mod) - (sNum % mod)) % mod) + mod;
            System.out.println("> Результат вычитания по модулю: " + fNum + " - " + sNum +
                    " (mod " + mod + ") = " + diffElse);
        }
    }

    public void multiplication(int fNum, int sNum, int mod) {
        int mult = ((fNum % mod) * (sNum % mod)) % mod;
        System.out.println("> Результат умножения по модулю: " + fNum + " * " + sNum +
                " (mod " + mod + ") = " + mult);
    }

    public void division(int fNum, int sNum, int mod) {
        if (coprimeNums(sNum, mod)) {
            if (sNum != 0) {
                int invNum = inverse(sNum, mod);
                int div = (fNum * invNum) % mod;
                System.out.println("> Результат деления по модулю: " + fNum + " / " + sNum +
                        " (mod " + mod + ") = " + div);
            } else
                System.out.println("! Ошибка: деление нельзя выполнить, потому что делитель является нулем");
        }
        else
            System.out.println("! Ошибка: нельзя выполнить действие деления, потому что a и mod невзаимно простые числа");
    }

    public void additiveInverse(int fNum, int sNum, int mod) {
        //здесь поиск аддитивной инверсии к числу  вычисляетсчя так: b = n - a (n - модуль),
        //что значит то же самое, что и a + b ≡ 0 (mod n)
        int firstInv = mod - fNum;
        int secondInv = mod - sNum;
        System.out.println("> Результат аддитивной инверсии первого числа: " + firstInv +
                " , результат аддитивной инверсии второго числа: " + secondInv);
    }

    public void multiplicativeInverse(int fNum, int sNum, int mod) {
        //мультипликативная инверсия - это поиск обратного числа по модулю
        if (coprimeNums(fNum, mod) | coprimeNums(sNum, mod)) {
            int fInv = inverse(fNum, mod);
            int sInv = inverse(sNum, mod);
            System.out.println("> Результат мультипликативной инверсии первого числа: " + fInv +
                    " , результат мультипликативной инверсии второго числа: " + sInv);
        }
        else System.out.println("! Ошибка: нельзя выполнить поиск мультипликативной инверсии, потому что одна из пар чисел невзаимно простые числа");
    }

    public void exponentiation(int fNum, int sNum, int mod) {
        double exp = Math.pow(fNum, sNum);
        int done = (int) exp % mod;
        System.out.println("> Результат возведения в степень по модулю: " + fNum + "^" + sNum +
                " (mod " + mod + ") = " + done);
    }

    private int inverse(int elem, int mod){
        int x = 0;
        while ((elem * x) % mod != 1) {
            x++;
        }
        return x;
    }

    private boolean coprimeNums(int first, int second) {
        while (first != 0 & second !=0 ) {
            if (first > second)
                first = first % second;
            else second = second % first;
        }
        if (first + second == 1)
            return true;
        else  return false;
    }
}