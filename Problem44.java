import java.util.Arrays;

public class Problem44 {
    public static void main(String[] args) {
        int[] array = {0, 4, 6, 8, 0};
        Problem44 test = new Problem44();
        System.out.println(test.isContinuous(array));
    }

    public boolean isContinuous(int[] number) {
        if (number == null) {
            return false;
        }
        Arrays.sort(number);
        int numberZero = 0;
        int numberGap = 0;
        for (int i = 0; i < number.length && number[i] == 0; i++) {
            numberZero++;
        }
        int small = numberZero;
        int big = small + 1;
        while (big < number.length) {
            if (number[small] == number[big])
                return false;
            numberGap += number[big] - number[small] - 1;
            small = big;
            big++;
        }
        return (numberGap > numberZero) ? false : true;
    }
}
