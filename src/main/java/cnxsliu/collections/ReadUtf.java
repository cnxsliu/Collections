package cnxsliu.collections;

import java.io.*;

/**
 * @author xutian
 * @create 2020/8/30
 */
public class ReadUtf {
    /***
     * 给定一个utf-8编码的文件，要求用utf-8原生类读取其中的内容，并统计指定字符出现的次数。
     * 考察点：
     * 1、对JDK原生的类是否熟悉
     * 2、对文件编码处理是否熟悉
     * 3、对文件的打开与关闭等边界条件是否有考虑
     * 4、对字符串的常见操作是否熟悉，包括indexOf，正则等
     */
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = null;
        int count = 0;

        try {
            Reader reader = new InputStreamReader(new FileInputStream("/opt/tmp.txt"), "utf-8");
            bufferedReader = new BufferedReader(reader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] array = line.split("hello");
                if (array.length > 1) {
                    count += array.length - 1;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (bufferedReader != null) {
                bufferedReader.close();
            }
        }
        System.out.println("total count: " + count);
    }
}
