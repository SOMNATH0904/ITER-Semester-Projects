package SOMNATH_2241019426;

import java.util.*;

public class AffineChiper {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a paraphrase: ");
        String input_string = sc.nextLine();
        sc.close();
        String PlainText = input_string;

        String ChiperText = encrypt(PlainText);
        String Decrypted = decrypt(ChiperText);
        System.out.println("Ciphertext: " + ChiperText);

        System.out.println("Decrypted text: " + Decrypted);
    }

    public static String encrypt(String plaintext) { // Encryption meaning converting human-readable plaintext into incomprehensible text, which is known as ciphertext. This means taking readable data and changing it so that it appears random. Encryption involves using a cryptographic key a set of mathematical values both the sender and recipient agree on.
        int k1 = 5;
        int k2 = 7;
        char[] ChiperText = new char[plaintext.length()];
        for (int i = 0; i < plaintext.length(); i++) {
            char character_check = plaintext.charAt(i);
            if (Character.isUpperCase(character_check)) {
                int k3 = plaintext.charAt(i) - 'A';
                int encrypted = (k3 * k1 + k2) % 26;
                ChiperText[i] = (char) (encrypted + 'A');
            } else {
                int k3 = plaintext.charAt(i) - 'a';
                int encrypted = (k3 * k1 + k2) % 26;
                ChiperText[i] = (char) (encrypted + 'a');
            }
        }
        return new String(ChiperText);
    }

    public static String decrypt(String ChiperText) { // Decryption meaning conversion of encrypted data into its original form. It is generally a reverse process of encryption. It decodes the encrypted information so that an authorized user can only decrypt the data because decryption requires a secret key or password.
        int k1 = 5;
        int k2 = 7;
        char[] PlainText = new char[ChiperText.length()];
        int k1_inverse = 0;
        for (int i = 0; i < 26; i++) {
            if ((k1 * i) % 26 == 1) {
                k1_inverse = i;
                break;
            }
        }
        for (int i = 0; i < ChiperText.length(); i++) {
            char character_check = ChiperText.charAt(i);
            if (Character.isUpperCase(character_check)) {
                int k3 = ChiperText.charAt(i) - 'A';
                int decrypted = ((k3 - k2 + 26) * k1_inverse) % 26;
                PlainText[i] = (char) (decrypted + 'A');
            } else {
                int k3 = ChiperText.charAt(i) - 'a';
                int decrypted = ((k3 - k2 + 26) * k1_inverse) % 26;
                PlainText[i] = (char) (decrypted + 'a');
            }
        }
        return new String(PlainText);
    }
}
