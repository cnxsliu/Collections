package cnxsliu.collections;

import java.util.Scanner;

/**
 * @author cnxsliu
 * @description
 * @date 2020/5/10 16:19
 * @strategy
 */
public class Main04 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int PH = sc.nextInt();
        int nor = sc.nextInt();
        int buf = sc.nextInt();
        if (nor * 2 >= buf) {
            System.out.println(PH % nor == 0 ? PH / nor : (PH / nor + 1));
        } else {
            int num1 = PH / buf;
            if (PH % buf  == 0) {
                System.out.println(num1 * 2);
            } else if(PH % buf <= nor){
                System.out.println(num1 * 2 + 1);
            } else {
                System.out.println(num1 * 2 + 2);
            }
        }
    }
}
