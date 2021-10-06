public class LFSR_Runner {
    public static void main(String[] args) {
        int num = 0b11001001001;
        int tap = 8;
        int trials = 37;

        LFSR lfsr = new LFSR(num, tap, trials);
        System.out.println(lfsr.lfsrString());
        System.out.println(Long.toBinaryString(lfsr.lfsrNumber()));
    }
}
