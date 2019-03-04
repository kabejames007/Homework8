package edu.dmacc.codedsm.hw8;

import java.util.Random;
import java.util.Arrays;


public class StringTester {

    public static String[] phrase = new String[5];
    public static int n = 0;


    public static void main(String[] args) {

        String geneRandom;
        while (!isFull()) {
            geneRandom = createRandomAlphaNumericString(5);
            if (checkHasNumbers(geneRandom)) {
                System.out.println(geneRandom + " Has numbers in");
            }
            if (isTheValidString(geneRandom)) {
                addStringToArray(geneRandom);
            }
        }

        System.out.println("Valid Array String => " + Arrays.toString(phrase));
    }

    public static boolean checkHasNumbers(String hasNumbers) {
        boolean digitFound = false;
        for (char ch : hasNumbers.toCharArray()) {
            if (Character.isDigit(ch)) {
                digitFound = true;
            }
            if (digitFound) {
                return true;
            }
        }
        return false;
    }

    public static String createRandomAlphaNumericString(int randomStringLength) {
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        Random random = new Random();
        StringBuilder buffer = new StringBuilder(randomStringLength);
        for (int i = 0; i < randomStringLength; i++) {
            if (random.nextInt(10) >= 9) {
                buffer.append(random.nextInt(9));
            } else {
                int randomLimitedInt = leftLimit + (int)
                        (random.nextFloat() * (rightLimit - leftLimit + 1));
                char characterForString = (char) randomLimitedInt;
                if (random.nextBoolean()) {
                    characterForString = Character.toUpperCase(characterForString);
                }
                buffer.append(characterForString);
            }
        }
        return buffer.toString();
    }

    public static boolean isFull() {
        return n == phrase.length;
    }

    public static void addStringToArray(String item) {
        phrase[n++] = item;
    }

    public static boolean isTheValidString(String done) {
        String vowels = "AEIOU";
        boolean validChars = vowels.indexOf(Character.toUpperCase(done.charAt(0))) != -1 && Character.isUpperCase(done.charAt(0));
        if (!checkHasNumbers(done) && validChars) {
            return true;
        } else {
            return false;
        }
    }
}
