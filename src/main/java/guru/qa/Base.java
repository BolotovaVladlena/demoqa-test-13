package guru.qa;

public class Base {
    public static void main(String[] args) {
        int result = 1 + 4;
        int result1 = 4 - 1;
        System.out.println(result);
        System.out.println(result1);
        int result3 = result + result1;
        System.out.println(result3);
        int result4 = result * result1;
        System.out.println(result4);
        int result5 = result4/result1;
        System.out.println(result5);
        int result6 = 10 % 3;
        System.out.println(result6);
        boolean result7 = 1 < 2;
        System.out.println(result7);
        boolean result8 = 1 >= 2;
        System.out.println(result8);
        boolean result9 = 1 <= 2;
        System.out.println(result9);
        boolean result10 = 1 != 2;
        System.out.println(result10);
        boolean result11 = ! (result1>result4);
        System.out.println(result11);
        boolean result12 = result7==result8;
        System.out.println(result12);
        boolean result13 = ((5>4)&(3>2));
        System.out.println(result13);
        boolean result14 = ((2>1)&&(3>5));
        System.out.println(result14);

        long l = 10;
        short s = 2;

        long l2 = l + s;
        System.out.println(l2);


        float f = 1.5F;
        double d = 1.5;
        double d2 = f+2;

        byte b = Byte.MAX_VALUE;
        System.out.println(b);
        byte b1 = (byte) (b + 1);
        System.out.println(b1);
        byte b2 = (byte) (b1 - 1);
        System.out.println(b2);

    }
}