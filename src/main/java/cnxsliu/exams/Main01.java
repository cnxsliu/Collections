package cnxsliu.exams;

import java.util.Scanner;

/*
 * A 国的手机号码由且仅由 N 位十进制数字(0-9)组成。
 * 一个手机号码中有至少 K 位数字相同则被定义为靓号。
 * A 国的手机号可以有前导零，比如 000123456 是一个合法的手机号。
 * 小多想花钱将自己的手机号码修改为一个靓号。
 * 修改号码中的一个数字需要花费的金额为新数字与旧数字之间的差值。
 * 比如将 1 修改为 6 或 6 修改为 1 都需要花 5 块钱。
 * 给出小多现在的手机号码，问将其修改成一个靓号，最少需要多少钱？
 *
 * 输入描述:
 * 第一行包含2个整数 N、K，分别表示手机号码数字个数以及靓号至少有 K 个数字相同。
 * 第二行包含 N 个字符，每个字符都是一个数字('0'-'9')，数字之间没有任何其他空白符。表示小多的手机号码。
 * 数据范围：2 <= K <= N <= 10000
 *
 * 输出描述:
 * 第一行包含一个整数，表示修改成一个靓号，最少需要的金额。
 * 第二行包含 N 个数字字符，表示最少花费修改的新手机号。若有多个靓号花费都最少，则输出字典序最小的靓号。
 *
 * 示例1
 * 输入
 * 6 5
 * 787585
 *
 * 输出
 * 4
 * 777577
 *
 * 说明
 * 花费为4的方案有两种：777577与777775，前者字典序更小。
 */

/*
 * 算法：最小代价优先的贪心算法
 * 数据结构：字符串
 * 字典序：
 * 1）如果手机号中数字比最佳数字大的情况就从前往后改；
 * 2）如果手机号中数字比最佳数字小的情况就从后往前改;
 * 3）1、2顺序不能颠倒
 */

/**
 * 贪心法
 */

class Main01{

    private static Scanner sc;

    public static void main(String[] args){

        sc = new Scanner(System.in);
        String[] strs = sc.nextLine().split(" ");
        int N = Integer.parseInt(strs[0]);
        int K = Integer.parseInt(strs[1]);
        char[] phoneNumber = sc.nextLine().toCharArray();
        int[] numbers = new int[10];
        for(char i:phoneNumber){
            numbers[i-'0']++;
        }
        int cost = Integer.MAX_VALUE;
        char[] beautifulNumber = new char[N];
        /*
        从 0 ~ 9 逐个数字考察,最后找到最佳的结果
        */
        for(int i = 0;i< 10;i++){
            int countdown = K-numbers[i];
            // 电话号码你本身已经是靓号，无需修改
            if(countdown <= 0){
                cost = 0;
                beautifulNumber = phoneNumber;
                break;
            }
            //新建字符数组作为电话号码的副本
            char[] evolving = new char[N];
            for(int j = 0;j<N;j++){
                evolving[j] = phoneNumber[j];
            }
            int tempCost = 0;
            int left = i-1;
            int right = i+1;
            while(countdown > 0){
                // 先尽量把电话号码改小
                if(right < 10){
                    for(int k = 0;k<N && countdown>0;k++){
                        if(evolving[k]-'0' == right){
                            tempCost += right-i;
                            evolving[k]= (char)('0'+i);
                            countdown--;
                        }
                    }
                }
                if(left >= 0){
                    for(int k = N-1;k>=0 && countdown>0;k--){
                        if(evolving[k]-'0' == left){
                            tempCost += i-left;
                            evolving[k]=(char)('0'+i);
                            countdown--;
                        }
                    }
                }
                right++;
                left--;
            }
            if(tempCost < cost){
                cost = tempCost;
                beautifulNumber = evolving;
            }

        }
        System.out.println(cost);
        System.out.println(new String(beautifulNumber));
    }
}