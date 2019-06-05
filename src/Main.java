import com.patternDesign.factory.IMyMessage;
import com.patternDesign.factory.MyMessageEnum;
import com.patternDesign.factory.MyMessageFactory;
import com.patternDesign.singleton.Singleton;

/**
 * 设计模式测试
 * 设计模式六大原则：单一职责、开闭、里氏代换、依赖倒置、接口分离、迪米特
 */
public class Main {

    /**
     * ------------------------------------------------------------------------------------------------
     * 创建型
     * 抽象工厂模式、工厂方法、建造者模式、原型模式、单态模式、
     */
    /**
     * 工厂模式
     */
    private static void factoryTest() {
        IMyMessage message = MyMessageFactory.getInstance().createMessage(MyMessageEnum.MESSAGE_EMAIL);
        message.sendMessage();
    }

    /**
     * 单例模式
     */
    private static void singletonTest() {
        Singleton.getInstance().getDesc();
        Singleton.getInstance("带有初始化参数的").getDesc();
    }

    /**
     * ------------------------------------------------------------------------------------------------
     * 结构型
     * 适配器模式、桥接模式、组合模式、外观模式、装饰者模式、享元模式、代理模式
     */


    /**
     * ------------------------------------------------------------------------------------------------
     * 行为型
     * - 责任链模式、命令模式、解释器模式、迭代模式、中介者模式、备忘录模式、
     * - 观察者模式、状态模式、策略模式、模板方法模式、访问者模式
     */
    public static void main(String[] args) {
        factoryTest();
        singletonTest();
    }
}
