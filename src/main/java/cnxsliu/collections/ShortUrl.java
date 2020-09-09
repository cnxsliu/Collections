package cnxsliu.collections;

import java.security.MessageDigest;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author xutian
 * @create  2020/8/30
 */
public class ShortUrl {
    private static final AtomicLong ID = new AtomicLong(1000000L);
    private static final String URL_PREFIX = "https://t.cn/";
    private static final String[] CHARS = new String[] {
            "a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z",
            "1","2","3","4","5","6","7","8","9","0",
            "A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z",
            "_","."
    };

    /***
     * 给定任意的URL，生成一个全局的短链接（如，https://t.cn/aBdDeF)
     * 考察点：
     * 1、对常用的hash算法是否了解，md5算法，64进制（52个字母+10个数字+2个可见字符）算法等；
     * 2、数据唯一性的处理，一对一如何做到
     * 3、数据处理效率，如何快速生成，和快速查找
     */
    public static void main(String[] args) {
        for (long i = 0; i < 100; i++) {
            System.out.println();
        }
    }

    public static String genShortUrl(String longUrl) throws Exception {
        MessageDigest md = MessageDigest.getInstance("md5");
        byte[] bytes = md.digest(Long.toString(ID.incrementAndGet()).getBytes());
        String hashUrl = to64RadixString(bytes);
        return URL_PREFIX + hashUrl;
    }

    private static String to64RadixString(byte[] bytes) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int aByte : bytes) {
            int val = aByte;
            for (int j = 0; j < 8; j++) {
                stringBuilder.append((val & 128) == 0 ? 0 : 1);
                val <<= 1;
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < stringBuilder.length(); i++) {
            int index = 0;
            if (i + 6 > stringBuilder.length()) {
                index = Integer.parseInt(stringBuilder.substring(i, stringBuilder.length()), 2);
            } else {
                index = Integer.parseInt(stringBuilder.substring(i, i + 6), 2);
            }
            result.append(CHARS[index]);
        }
        return result.toString();
    }
}
