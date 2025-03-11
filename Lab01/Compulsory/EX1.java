public class EX1 {

    public static int binaryToDecimal(int n)
    {
        int num = n, dec = 0, base = 1, temp = num;
        while (temp>0) {
            int last_digit = temp % 10;
            temp = temp / 10;
            dec += last_digit * base;
            base = base * 2;
        }

        return dec;
    }
    public static int hex2decimal(String s) {
        String digits = "0123456789ABCDEF";
        s = s.toUpperCase();
        int val = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            int d = digits.indexOf(c);
            val = 16*val + d;
        }
        return val;
    }
    public static int sum(int n)
    {
        int s = 0;
        while(n!=0){
            s+=n%10;
            n/=10;
        }
        return s;
    }
    public static void main(String[] args) {
        System.out.println("Hello World!");

        String[] languages = {"C", "C++", "C#", "Python", "Go", "Rust", "JavaScript", "PHP", "Swift", "Java"};
        int n = (int) (Math.random() * 1_000_000);
        n = n * 3;
        n = n + 0b10101;
        n = n + 0xFF;
        n = n * 6;

        System.out.println(n);

        int copy = 0;
        while(n>9){
            n = sum(n);
        }
        System.out.println(n);
        System.out.println("Willy-nilly, this semester I will learn " + languages[n]);
    }
}