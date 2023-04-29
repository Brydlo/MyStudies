package ChuckNorris;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CipherEncoder {

    static String chuckNorrisCrypto(char[] charType) {
        int previous;
        String binaryFromASCII = "";
        String chuckNorrisEncrypt = "";
        System.out.println();
        System.out.println("Encoded string:");
        for (int i = 0; i < charType.length; i++) {
            int asciiCode = charType[i]; // saves all ASCII number during each iteration
            binaryFromASCII += String.format("%7s", Integer.toBinaryString(asciiCode).replaceAll(" ", "0")); // Create one String which saves all binary code from ASCII number
        }
        binaryFromASCII = binaryFromASCII.replaceAll(" ", "0");
        previous = String.valueOf(binaryFromASCII.charAt(0)).equals("1") ? 1 : 0; // sets previous number for use it in for-loop as start number
        chuckNorrisEncrypt = String.valueOf(binaryFromASCII.charAt(0)).equals("0") ? "00 0" : "0 0"; // sets first part String ifZero == 00 0 ifOne = 0 0;
        for (int i = 1; i < binaryFromASCII.length(); i++) { // this loop encode ASCII to Chuck Norris only zeros code
            char value = Character.valueOf(binaryFromASCII.charAt(i)); // to keep single number from String
            if (previous == 1 && value == '1') {
                chuckNorrisEncrypt += "0";
                previous = 1;
            } else if (previous == 1 && value == '0') {
                chuckNorrisEncrypt += " 00 0";
                previous = 0;
            } else if (previous == 0 && value == '1') {
                chuckNorrisEncrypt += " 0 0";
                previous = 1;
            } else if (previous == 0 && value == '0') {
                chuckNorrisEncrypt += "0";
                previous = 0;
            }
        }
        return chuckNorrisEncrypt;
    }
    static String removeUnnecessaryZeros(char[] charType) {
        String decodedTxt = "";
        String usesForChangeToBinary = "";
        for (char a : charType) {
            usesForChangeToBinary += a;
        }
        Scanner s = new Scanner(usesForChangeToBinary);
        while (s.hasNext()) {
            String strA = s.next();
            if (strA.equals("0")) {
                String stringOfOnes = s.next().replace("0", "1");
                decodedTxt += stringOfOnes;
            } else if (strA.equals("00")) {
                String stringOfZeros = s.next();
                decodedTxt += stringOfZeros;
            }
        }
        return decodedTxt;
    }
     static String addSpaces(String decodedTxt) {
        int a = 7;
        int b = 8;
        StringBuilder decodedTxtWithSpaces = new StringBuilder(decodedTxt);
        while (a < decodedTxtWithSpaces.length()) {
            decodedTxt = String.valueOf(decodedTxtWithSpaces.insert(a, " "));
            a = a + b;
        }
        return decodedTxt;
    }
    static String chuckNorrisDecodeToLetter(String decodedTxt) {
        StringBuilder decodedToChar = new StringBuilder();
        Scanner toAscii = new Scanner(decodedTxt);
        while (toAscii.hasNext()) {
            String blockOfDecimalNumbers = toAscii.next();
            int decimalNumber = Integer.parseInt(blockOfDecimalNumbers, 2);
            decodedToChar.append((char)decimalNumber);
        }
        decodedTxt = decodedToChar.toString();
        return decodedTxt;
    }

//    check methods !!!
    static boolean checkOddBlocks(String input) {
        String[] checksOddNumberOfBlocks = input.split(" ");
        if (checksOddNumberOfBlocks.length % 2 != 0) return false;
        return true;
    }
    static boolean checkInputStartWith(String input) {
        boolean checkMistake;
            checkMistake = input.startsWith("00 ") || input.startsWith("0 0");
        return checkMistake;
    }
    static boolean checksZerosAndSpaces(String input) {
        boolean checkMistake;
        char[] charDecode = input.toCharArray();
        for (char a : charDecode) {
            checkMistake = a == '0' || a == ' ';
            if (!checkMistake) {
                return false;
            }
        }
        return true;
    }

    static boolean matchToWord(String decodeTxt) {
        if (decodeTxt.length() % 7 != 0) {
            return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String decision = "";
        while (!decision.equals("exit")) {
            System.out.println("Please input operation (encode/decode/exit):");
            decision = scanner.nextLine();
            switch (decision) {
                case "encode" -> {
                    System.out.println("Input string:");
                    char[] charEncode = scanner.nextLine().toCharArray();
                    String chuckNorrisEncrypt = chuckNorrisCrypto(charEncode);
                    System.out.println(chuckNorrisEncrypt);
                    System.out.println();
                }
                case "decode" -> {

                    System.out.println("Input encoded string:");
                    String input = scanner.nextLine();

                    boolean startWith = checkInputStartWith(input);
                    boolean zerosAndSpaces = checksZerosAndSpaces(input);
                    boolean checkOdd = checkOddBlocks(input);
                    if (!startWith || !zerosAndSpaces || !checkOdd) {
                        System.out.println("Encoded string is not valid.");
                        break;
                    }

                    char[] charDecode = input.toCharArray();// changes Strings into Character array to take all bytes from input

                    String decodedTxt = removeUnnecessaryZeros(charDecode);
                    System.out.println(decodedTxt);
                    boolean matchToWord = matchToWord(decodedTxt);
                    if (!matchToWord) {
                        System.out.println("Encoded string is not valid.");
                        break;
                    }
                    decodedTxt = addSpaces(decodedTxt);

                    decodedTxt = chuckNorrisDecodeToLetter(decodedTxt);

                    System.out.println("Decoded string:");
                    System.out.println(decodedTxt);
                }
                case "exit" -> System.out.println("Bye!");
                default -> {
                    System.out.printf("There is no '%s' operation", decision);
                    System.out.println();
                }
            }
        }

    }
}
