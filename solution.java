import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class solution {
    public static void main(String[] args) {
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            String regex1 = "(\\d+)\\[(\\D*((\\d+)\\[(\\D+)\\])*\\D*)\\](\\D*)";
            String regex2 = "\\d+\\D+(\\d+\\[(\\D*((\\d+)\\[(\\D+)\\])*\\D*)\\]\\D*)+";
            String s = br.readLine();
            if (!s.matches(regex2)) {
                System.out.println("Invalid input string");
                return;
            }
            StringBuffer sb = new StringBuffer();
            Pattern p = Pattern.compile(regex1);
            Matcher m = p.matcher(s);
            while(m.find()) {
                if (m.group(5) != null) {
                    String innerGroup = m.group(5);
                    String unpacked = innerGroup.repeat(Integer.parseInt(m.group(4)));
                    String outerGroup = m.group(2).replace(m.group(3), unpacked);
                    String result = outerGroup.repeat(Integer.parseInt(m.group(1)));
                    sb.append(result);
                } else {
                    String group = m.group(2);
                    String unpacked = group.repeat(Integer.parseInt(m.group(1)));
                    sb.append(unpacked);
                }
                if (m.group(6) != null) {
                    sb.append(m.group(6));
                }
            }
            System.out.println(sb);
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
