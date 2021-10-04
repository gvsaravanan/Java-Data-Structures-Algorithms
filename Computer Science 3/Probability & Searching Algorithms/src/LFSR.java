public class LFSR {
    private int binaryNum, tapNum, trials;

    public LFSR(int bN, int tN, int t) {
        binaryNum = bN;
        tapNum = tN;
        trials = t;
    }

    public String lfsrString() {
        String binary = Integer.toBinaryString(binaryNum);

        int t = binary.length() - tapNum - 1;
        String s = "";

        for (int i = 0; i < trials; i++) {
            int first = Integer.parseInt(binary.substring(0, 1));
            int tap = Integer.parseInt(binary.substring(t, t+1));

            int xor = first ^ tap;

            binary = binary.substring(1) + xor;
            s += xor;
        }

        return s;
    }

    public long lfsrNumber() {
        int binary = binaryNum;
        int eight = 0b00100000000;
        int ten = 0b10000000000;
        long res = 0b0;
        String ans = "";

        for (int i = 0; i < trials; i++) {
            int temp1 = (binary & eight) >> 8;
            int temp2 = (binary & ten) >> 10;

            int xor = temp1 ^ temp2;
            binary = ((binary & 0b01111111111) << 1) | xor;
            res = (res << 1) | xor;
            ans += xor;
        }

        return res;
    }
}
