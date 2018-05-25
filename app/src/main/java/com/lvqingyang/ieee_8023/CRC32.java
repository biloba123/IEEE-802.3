package com.lvqingyang.ieee_8023;

/**
 * 一句话功能描述
 * 功能详细描述
 *
 * @author Lv Qingyang
 * @date 2018/5/25
 * @email biloba12345@gamil.com
 * @github https://github.com/biloba123
 * @blog https://biloba123.github.io/
 * @see
 * @since
 */
class CRC32 {
    private static long divisor= 0x104c11db7L;
    private static String divisorStr = Long.toBinaryString(divisor);

    public static int calculate(Frame frame) {
        String data = frame.getCheckoutBinaryStr();

        int dataLen = data.length(), divLen = divisorStr.length(), totalLen = dataLen + divLen - 1;
        char[] dataChars = new char[totalLen],
                divChars = divisorStr.toCharArray(),
                resultChars = new char[divLen];

        System.arraycopy(data.toCharArray(), 0, dataChars, 0, dataLen);
        for (int i = dataLen; i < totalLen; i++) {
            dataChars[i] = '0';
        }

        for (int i = 0; i < divLen; i++) {
            resultChars[i] = '0';
        }

        for (int i = 0; i < totalLen; i++) {
            binaryDiv(resultChars, divChars, divLen);

            for (int j = 0; j < divLen - 1; j++) {
                resultChars[j] = resultChars[j + 1];
            }
            resultChars[divLen - 1] = dataChars[i];

        }

        binaryDiv(resultChars, divChars, divLen);

        int fcs=binaryStrToInt(new String(resultChars));
        frame.setCrc(fcs);
        return fcs;
    }

    private static void binaryDiv(char[] dividend, char[] divisor, int len) {
        if (dividend[0] == '1') {
            for (int i = 0; i < len; i++) {
                dividend[i] = dividend[i] == divisor[i] ? '0' : '1';
            }
        }
    }

    private static int binaryStrToInt(String s) {
        if (s == null || s.length() < 1) {
            throw new RuntimeException("format error");
        }

        int result = 0;
        int pow = 1;
        for (int i = s.length() - 1; i >= 0; i--, pow *= 2) {
            switch (s.charAt(i)) {
                case '0':
                    break;
                case '1':
                    result += pow;
                    break;
                default:
                    throw new RuntimeException("format error");
            }
        }

        return result;
    }
}
