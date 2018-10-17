import java.util.Scanner;

public class Myown {
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.print("Enter word: ");
        String string = input.nextLine();
        System.out.print("Enter shift: ");
        int shift = input.nextInt();
        System.out.print("Enter group size: ");
        int groupsize = input.nextInt();
        System.out.println(encryptString(string, shift, groupsize));
    }


    // ===================================================================
    public static String encryptString(String string, int shift, int groupSize) {
        String value1 = normalizeText(string);
        String value2 = obify(value1);
        String value3 = caesarify(value2, shift);
        return groupify(value3, groupSize);
    }


    // ====================================================================
    public static String normalizeText(String string) {
        String normalizeString;
        normalizeString = string.replaceAll("\\p{Blank}", "");
        normalizeString = normalizeString.replaceAll("\\p{Punct}", "").toUpperCase();
        return normalizeString;
    }


    // ====================================================================
    public static String obify(String string) {
        StringBuilder v = new StringBuilder(string);
        int obcount = 0;
        for (int i = 0; i < v.length(); i = i + obcount + 1) {
            if (v.charAt(i) == 'A' || v.charAt(i) == 'E' || v.charAt(i) == 'I' || v.charAt(i) == 'O' || v.charAt(i) == 'U') {
                v.insert(i, "OB");
                obcount = 2;
            }
            else {
                obcount = 0;
            }
        }
        string = v.toString();
        return string;
    }


    // =====================================================================
    public static String caesarify(String string, int shift) {
        char[] letters = string.toCharArray();

        String newVal = "";
        for(char l: letters){
            int shiftedNum = (int)l + shift;
            if (shiftedNum > (int) 'Z') {
                shiftedNum = 'A' + shiftedNum - (int) 'Z' - 1;
            }
            else if (shiftedNum < (int) 'A') {
                shiftedNum = 'Z' + shiftedNum - (int) 'A' + 1;
            }
            else {
                shiftedNum = (int)l + shift;
            }
            newVal = newVal + (char) shiftedNum;
        }
        return newVal;
    }

    // =====================================================================
    public static String groupify(String string, int groupSize) {
        StringBuilder newVal1 = new StringBuilder(string);
        for (int i = groupSize; i < newVal1.length(); i = groupSize + i + 1) {
            newVal1 = newVal1.insert(i, " ");
            System.out.println(newVal1);
        }
        for (int i = 0; i < groupSize; i++){
            if ((newVal1.substring(newVal1.length() - groupSize)).contains(" ")) {
                newVal1 = newVal1.append("x");
            }
        }
        string = newVal1.toString();
        return string;
    }

    public static String Obify2(String string) {
        String emptyString = "";

        char[] obString = string.toCharArray();
        for (char l: obString) {
            if (l == 'A' || l == 'E' || l == 'I' || l == 'O' || l == 'U' || l == 'Y') {
                emptyString = emptyString + "OB" + l;
            }
            else {
                emptyString = emptyString + l;
            }
        }
        return emptyString;
    }

}



