package cnxsliu.collections;

/**
 * @author cnxsliu
 * @description
 * @date 2020/5/18 18:59
 * @strategy
 */
public class StrategyDesign {

    /**
     * Context上下文
     */
    static class Context {
        Strategy strategy;
        public Context (Strategy strategy) {
            this.strategy = strategy;
        }

        public void contextInterface () {
            strategy.algorithmInterface();
        }
    }

    /**
     * 策略角色
     */
    public interface Strategy {
        /**
         * 算法接口
         */
        public abstract void algorithmInterface();
    }

    /**
     * 具体策略角色 ： A
     */
    public static class ConcreteStrategyA implements Strategy {

        @Override
        public void algorithmInterface() {
            System.out.println("算法 A 实现");
        }
    }

    /**
     * 具体策略角色 ： B
     */
    public static class ConcreteStrategyB implements Strategy {

        @Override
        public void algorithmInterface() {
            System.out.println("算法 B 实现");
        }
    }

    /**
     * 具体策略角色 ： C
     */
    public static class ConcreteStrategyC implements Strategy {

        @Override
        public void algorithmInterface() {
            System.out.println("算法 C 实现");
        }
    }

    public static void main(String[] args) {
        StrategyDesign d = new StrategyDesign();
        Context context;
        context = new Context(new ConcreteStrategyA());
        context.contextInterface();
        context = new Context(new ConcreteStrategyB());
        context.contextInterface();
        context = new Context(new ConcreteStrategyC());
        context.contextInterface();
    }
}
