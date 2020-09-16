public class CalculateComplement {
    public static int bitwiseComplement(int n) {
        if(n <= 0)
            return 0;
        int num = n;
        int count = 0;
        while(n > 0){
            count++;
            n = n >> 1;
        }
        int base = (int)Math.pow(2, count) - 1;
        return base ^ num;
    }

    public static void main( String args[] ) {
        System.out.println("Bitwise complement is: " + CalculateComplement.bitwiseComplement(8));
        System.out.println("Bitwise complement is: " + CalculateComplement.bitwiseComplement(10));
    }
}
