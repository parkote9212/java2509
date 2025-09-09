package ch03.sec09;

public class BitShiftExample2 {
    public static void main(String[] args) {
        int value = 772;

        byte byte1 = (byte)  (value >>> 24);
        int int1 = byte1 & 255;
        System.out.println("첫번재 바이트 부호없는 값 : " + int1);

        byte byte2 = (byte)  (value >>> 16);
        int int2 = Byte.toUnsignedInt(byte2);
        System.out.println("두번재 바이트 부호없는 값 : " + int2);


        byte byte3 = (byte)  (value >>> 8);
        int int3 = Byte.toUnsignedInt(byte3);
        System.out.println("세번재 바이트 부호없는 값 : " + int3);

        byte byte4 = (byte) value;
        int int4 = byte4 & 255;
        System.out.println("네번재 바이트 부호없는 값 : " + int4);

    }
}
