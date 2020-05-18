package cnxsliu.collections;

/**
 * @author cnxsliu
 * @description
 * @date 2020/4/18 18:05
 * @strategy
 */
public class JavaVMStackSOF {

    private int stackLength = 1;

    public void stackLeak(){
        stackLength++;
        stackLeak();
    }

    public static void main(String[] args) throws Throwable{
        JavaVMStackSOF sof = new JavaVMStackSOF();
        try {
            sof.stackLeak();
        } catch (Throwable e) { //StackOverFlowError是属于Error异常，不能使用Exception来捕获
            System.out.println("stack length : " + sof.stackLength);
        }
    }
}
