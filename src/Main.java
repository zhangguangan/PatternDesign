import com.patternDesign.adapter.Adapter4Class;
import com.patternDesign.adapter.Adapter4Object;
import com.patternDesign.adapter.TypeC;
import com.patternDesign.bridge.ConcreteDbBridge;
import com.patternDesign.bridge.MysqlDBDriver;
import com.patternDesign.bridge.OracleDbDriver;
import com.patternDesign.builder.Human;
import com.patternDesign.builder.HumanDirector;
import com.patternDesign.builder.SuperManBuilder;
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
     * 建造者模式：humanbuilder是真正实现了造人的方法，director只是启动造人的方法和抛出用哪种方式造人
     * 所以就达到了对复杂对象的构建分离。以后扩展只需要扩展建造者和人类
     */
    private static void builderTest() {
        Human human = HumanDirector.createHuman(new SuperManBuilder());
        System.out.println(human.getHeader());
        System.out.println(human.getBody());
        System.out.println(human.getFoot());
        System.out.println(human.getHand());
    }
    /**
     * 原型模式
     * 一个对象需要提供给其他对象访问，而且各个调用者可能都需要修改其值时，可以考虑使用原型模式拷贝多个对象供调用者使用。在实际项目中，原型模式很少单独出现，一般是和工厂方法模式一起出现，通过 clone的方法创建一个对象，然后由工厂方法提供给调用者。原型模式先产生出一个包含
     *大量共有信息的类，然后可以拷贝出副本，修正细节信息，建立了一个完整的个性对象
     *
     * cloneable接口
     */

    /**
     * 单例模式：应用系统上下文中只会存在一个实例
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
     * 适配器模式
     * 好处：便于扩展，更好的复用性
     * 使用场景：
     * （1）想要使用一个已经存在的类，但是它却不符合现有的接口规范，导致无法直接去访问，这时创建一个适配器就能间接去访问这个类中的方法。
     * （2）我们有一个类，想将其设计为可重用的类（可被多处访问），我们可以创建适配器来将这个类来适配其他没有提供合适接口的类。
     */
    public static void adapter() {
        Adapter4Class adapter4Class = new Adapter4Class();
        Adapter4Object adapter4Object = new Adapter4Object();
        adapter4Object.setTypeC(new TypeC());

        adapter4Class.typeCInterface();
        adapter4Object.getTypeC().typeCInterface();
    }

    /**
     * 桥接模式
     * 好处：将抽象化与实现化解耦，使得二者可以独立变化 ,使其拥有了更好的扩展性
     * 使用场景：使用和实现可能会发生多次变化的
     */
    public static void bridge() {
        ConcreteDbBridge concreteDbBridge = new ConcreteDbBridge();
        MysqlDBDriver mysqlDBDriver = new MysqlDBDriver();
        concreteDbBridge.setDbDriver(mysqlDBDriver);
        concreteDbBridge.connection();

        OracleDbDriver oracleDbDriver = new OracleDbDriver();
        concreteDbBridge.setDbDriver(oracleDbDriver);
        concreteDbBridge.connection();
    }


    /**
     * ------------------------------------------------------------------------------------------------
     * 行为型
     * - 责任链模式、命令模式、解释器模式、迭代模式、中介者模式、备忘录模式、
     * - 观察者模式、状态模式、策略模式、模板方法模式、访问者模式
     */
    public static void main(String[] args) {
        /**
         * 创建型
         */
        factoryTest();
        singletonTest();
        builderTest();

        /**
         * 结构型
         */
        adapter();
        bridge();

    }
}
