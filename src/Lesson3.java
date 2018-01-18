import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Lesson3 {
    public static void main(String[] args) {
        String s = "111.222.333.123 HOME - [01/Feb/1998:01:08:39 -0800] \"GET /bannerad/ad.htm HTTP/1.0\" 200 198 \"http://www.referrer.com/bannerad/ba_intro.htm\" \"Mozilla/4.01 (Macintosh; I; PPC)\"";
        String regex = "(\\d+.\\d+.\\d+.\\d+)(\\w*) (HOME|AWAY) - \\[(\\d+/\\w+/\\d+:\\d+:\\d+:\\d+) ([-|+]?\\d+)] \"(GET [\\w./]+ [\\w./]+)\" (\\d+) (\\d+) \"([\\w:./_]+)\" \"([\\w/.\\s(;)]+)\"";
        Matcher matcher = Pattern.compile(regex).matcher(s);
        while(matcher.find()) {
            for (int i = 1; i <= matcher.groupCount(); i++) {
                System.out.println(matcher.group(i));
            }
        }
    }
}
