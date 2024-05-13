import java.util.*;

/**
 * Simple password generator
 * @Author: Jameson Baker
 * @DateStarted: 05.12.2024
 */

public class simplePasswordGenerator {

    private List<String> passwords = new ArrayList<>();
    private static final char[] LOWER = "abcdefghijklmnopqrstuvwxyz".toCharArray();
    private static final char[] UPPER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
    private static final char[] SPECIAL = "!@#$%&".toCharArray();
    private int numPasswords;
    private int lenPasswords;

    private char generateChar(){
        Random rand = new Random();
        int i = rand.nextInt(0,3);
        if (i == 0){
            return LOWER[rand.nextInt(LOWER.length)];
        }
        else if (i == 1){
            return UPPER[rand.nextInt(UPPER.length)];
        }
        else if (i==2) {
            return SPECIAL[rand.nextInt(SPECIAL.length)];
        }
        else {
            return (char) (rand.nextInt(0,9));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        simplePasswordGenerator simplePasswordGenerator = new simplePasswordGenerator();
        System.out.println("Enter number of passwords: ");
        simplePasswordGenerator.numPasswords = sc.nextInt();
        System.out.println("Enter length of passwords: ");
        System.out.println("P.S. Passwords of length 12-15 tend to be strongest!");
        simplePasswordGenerator.lenPasswords = sc.nextInt();
        for (int index = 0; index< simplePasswordGenerator.numPasswords; index++){
            StringBuilder pass = new StringBuilder();
            for (int jndex = 0; jndex< simplePasswordGenerator.lenPasswords; jndex++){
                pass.append(simplePasswordGenerator.generateChar());
            }
            simplePasswordGenerator.passwords.add(String.valueOf(pass));
        }
        System.out.println(simplePasswordGenerator.numPasswords+" passwords generated of length "+ simplePasswordGenerator.lenPasswords);
        for (int i = 0; i< simplePasswordGenerator.passwords.size(); i++){
            System.out.println((i+1)+". "+ simplePasswordGenerator.passwords.get(i));
        }
    }
}