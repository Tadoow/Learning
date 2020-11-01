import java.io.*;
import java.util.*;
import java.nio.file.*;

public class Main {

	public static void main(String[] args) throws IOException {
		Scanner in = new Scanner(System.in);
		System.out.println("Enter 1 to encrypt message or 2 to decrypt message: ");
		int num = in.nextInt();
		if (num == 2) {
			VigenereBreaker vb = new VigenereBreaker();
			HashMap<String, HashSet<String>> hm = new HashMap<String, HashSet<String>>();
			String[] files = {"data/dictionaries/English","data/dictionaries/Dutch","data/dictionaries/French","data/dictionaries/Spanish","data/dictionaries/German"};
	        for (String f : files) {
	            BufferedReader br = new BufferedReader(new FileReader(f));
	            HashSet<String> hs = vb.readDictionary(br);
	            hm.put(f.substring(18),hs);
	            System.out.println("Loading dictionaries...");
	            System.out.println("Size of " + f.substring(18) + " dictionary " + hs.size());
	            br.close();
	        }
	        String s = new String(Files.readAllBytes(Paths.get("data/messageToDecrypt.txt")));
	        vb.breakForAllLangs(s, hm);
		}
		else if (num == 1) {
			BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter key to encrypt message (should be an array): ");
			int[] input = Arrays.stream(r.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
			System.out.println("Your key: " + Arrays.toString(input));
			VigenereCipher vc = new VigenereCipher(input);
			String s = new String(Files.readAllBytes(Paths.get("data/messageToEncrypt.txt")));
			System.out.println("Encrypted message is: " + vc.encrypt(s));
			r.close();
		}
		in.close();
	}

}
