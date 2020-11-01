import java.util.*;
import java.io.*;

public class VigenereBreaker {
    public String sliceString(String message, int whichSlice, int totalSlices) {
        StringBuilder slice = new StringBuilder();
        for (int i = whichSlice; i < message.length(); i = i + totalSlices) {
            char c = message.charAt(i);
            slice.append(c);
        }
        return slice.toString();
    }

    public int[] tryKeyLength(String encrypted, int klength, char mostCommon) {
        int[] key = new int[klength];
        CaesarCracker ck = new CaesarCracker(mostCommon);
        for (int i = 0; i < klength; i++)
            key[i] = ck.getKey(sliceString(encrypted, i, klength));
        return key;
    }
    
    public HashSet<String> readDictionary(BufferedReader br) throws IOException {
        HashSet<String> hs = new HashSet<String>();
        String line = "";
        while((line = br.readLine()) != null) {
            hs.add(line.toLowerCase());
        }
        return hs;
    }
    
    public int countWords(String message, HashSet<String> dictionary) {
        int count = 0;
        for (String w : message.split("\\W+")) {
            if (dictionary.contains(w.toLowerCase())) {
                count++;
            }
        }
        return count;
    }
    
    public String breakForLanguage(String encrypted, HashSet<String> dictionary) {
        int max = 0;
        int keyL = 0;
        char c = mostCommonCharIn(dictionary);
        for (int i = 1; i < 100; i++) {
            VigenereCipher vc = new VigenereCipher(tryKeyLength(encrypted, i, c));
            String m = vc.decrypt(encrypted);
            if (countWords(m, dictionary) > max) {
                max = countWords(m, dictionary);
                keyL = i;
            }
        }
        VigenereCipher fc = new VigenereCipher(tryKeyLength(encrypted, keyL,c));
        //System.out.println("KeyLength: " + keyL + " ValidWords: " + max);
        return fc.decrypt(encrypted);
    }
    
    public char mostCommonCharIn(HashSet<String> dictionary) {
        String alph = "abcdefghijklmnopqrstuvwxyz";
        int[] counts = new int[26];
        int maxDex = 0;
        for (String s : dictionary) {
            for(int k=0; k < s.length(); k++){
                int dex = alph.indexOf(Character.toLowerCase(s.charAt(k)));
                if (dex != -1){
                    counts[dex] += 1;
                }
            }
        }
        for (int i = 0; i < counts.length; i++) {
            if (counts[i] > counts[maxDex])
                maxDex = i;
        }
        return alph.charAt(maxDex);
    }
    
    public void breakForAllLangs (String encrypted, HashMap<String, HashSet<String>> languages) {
        String lang = "";
        int maxWordCount = 0;
        for (String s : languages.keySet()) {
            String dm = breakForLanguage(encrypted, languages.get(s));
            if (countWords(dm,languages.get(s)) > maxWordCount) {
                maxWordCount = countWords(dm,languages.get(s));
                lang = s;
            }
        }
        System.out.println("\n" + "Message is in " + lang + "\n" + "Decrypted message: \n" + breakForLanguage(encrypted, languages.get(lang)));
    }
}
