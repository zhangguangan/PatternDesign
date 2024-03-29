import com.patternDesign.Strategy.TestStrategy;
import com.patternDesign.adapter.Adapter4Class;
import com.patternDesign.adapter.Adapter4Object;
import com.patternDesign.adapter.TypeC;
import com.patternDesign.bridge.ConcreteDbBridge;
import com.patternDesign.bridge.MysqlDBDriver;
import com.patternDesign.bridge.OracleDbDriver;
import com.patternDesign.builder.Human;
import com.patternDesign.builder.HumanDirector;
import com.patternDesign.builder.SuperManBuilder;
import com.patternDesign.chain.JingliLeader;
import com.patternDesign.chain.ZhurenLeader;
import com.patternDesign.combination.FileClient;
import com.patternDesign.combination.FolderNode;
import com.patternDesign.command.Customer;
import com.patternDesign.detector.ListBoxComponent;
import com.patternDesign.detector.ScrollBarListBoxDetecot;
import com.patternDesign.facade.ComputerFacade;
import com.patternDesign.factory.IMyMessage;
import com.patternDesign.factory.MyMessageEnum;
import com.patternDesign.factory.MyMessageFactory;
import com.patternDesign.flowWeight.Coordinates;
import com.patternDesign.flowWeight.IgoChessman;
import com.patternDesign.flowWeight.IgoChessmanFactory;
import com.patternDesign.interpret.TestInterpret;
import com.patternDesign.iterator.IteratorTest;
import com.patternDesign.mediator.MediatorTest;
import com.patternDesign.momento.TestMomento;
import com.patternDesign.observe.TestObserver;
import com.patternDesign.proxy.SingerProxyHandler;
import com.patternDesign.singleton.Singleton;
import com.patternDesign.template.TestTemplate;
import com.patternDesign.visitor.TestVisitor;

import java.util.ArrayList;
import java.util.List;

/**
 * 设计模式测试
 * 设计模式六大原则：
 * **** 1 单一职责：接口设计应符合职责单一不相互依赖
 * **** 2 开闭： 模块和功能设计要符合对扩展开放、对修改封闭
 * **** 3 里氏代换： 只要父类出现的地方子类就可以出现，如果子类不能完全代替父类则建议采用依赖、聚合或者组合方式来代替
 * **** 4 依赖倒置： 依赖抽象而不依赖具体。
 * **** 5 接口分离：高内聚和低耦合 设计时应尽量将不同职责的模块分开 减少耦合
 * **** 6 迪米特：最少知道原则，一个对象尽可能访问自身的属性和对象，尽可能少知道其他对象的方法和属性 可以降低各模块之间的耦合度
 */
public class Main {


    /**
     * ------------------------------------------------------------------------------------------------——————————————————————————————————————————————————————————
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
     * ------------------------------------------------------------------------------------------------——————————————————————————————————————————————————
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
     * 组合模式
     * 使用场景：组合模式正是应树形结构而生，所以组合模式的使用场景就是出现树形结构的地方。比如：文件目录显示，多及目录呈现等树形结构数据的操作。
     * 优点：
     * 可以清楚地定义分层次的复杂类型，表示对象的全部层次或者部分层次  ，它让客户端忽略了层次的差异，方便对整个层次经行控制。
     * 客户端可以一致的使用一个组合模式或对单个对象，不必关心处理的是单个对象还是整个组合结构，简化了客户端的代码。
     * 在组合模式种增加新的容器构件和叶子构件都很方便，无需对现有类库进行任何修改，符合开闭原则。
     * 为树形结构的面向对象实现提供了一种灵活的解决方案，通过叶子对象和容器对象的递归组合可以形成复杂的树形机构，但对树形结构的控制却很简单。
     * 缺点：
     * 在增加新的构件时就比较难。而且难以限定，有时候希望在一个容器种能有某些特定的对象，例如在某个文件夹只能有image或者gif等。这个就比较难以实现。
     */
    public static void combination() {
        FolderNode folderNode = new FolderNode("D:/需求");
        FileClient.createTree(folderNode);
        folderNode.display();
    }

    /**
     * 外观模式
     * 优点：
     * 低耦合，使得客户端和子系统之间解耦，让子系统内部的模块功能更容易扩展和维护；
     * 更好的划分访问层次
     * 场景：
     * 复杂流程当中使用的业务模块较多
     */
    public static void facade() {
        ComputerFacade computerFacade = new ComputerFacade();
        computerFacade.start();
        computerFacade.shutDown();
    }

    /**
     * 装饰者模式
     * 场景：动态地给一个对象添加一些额外的职责
     * （1）在不影响其他对象的情况下，以动态、透明的方式给单个对象添加职责。
     * （2）处理那些可以撤消的职责。
     * （3）当不能采用生成子类的方法进行扩充时。
     * 一种情况是，可能有大量独立的扩展，为支持每一种组合将产生大量的 子类，使得子类数目呈爆炸性增长。
     * 另一种情况可能是因为类定义被隐藏，或类定义不能用于生成子类。
     */
    public static void detector() {
        ListBoxComponent listBoxComponent = new ListBoxComponent();
        listBoxComponent.display();

        ScrollBarListBoxDetecot scrollBarListBoxDetecot = new ScrollBarListBoxDetecot(listBoxComponent);
        scrollBarListBoxDetecot.setScrollBar4ListBox();
    }


    /**
     * 享元模式
     * 场景：
     * 当我们项目中创建很多对象，而且这些对象存在许多相同模块
     * 我们可以将这些相同的模块提取出来采用享元模式生成单一对象，
     * 再使用这个对象与之前的诸多对象进行配合使用，这样无疑会节省很多空间。
     */
    public static void flyWeight() {
        IgoChessmanFactory factory = IgoChessmanFactory.getInstance();
        IgoChessman blackChessman = factory.getIgoChessman("black");
        IgoChessman blackChessman2 = factory.getIgoChessman("black");
        IgoChessman whiteChessman = factory.getIgoChessman("white");

        blackChessman.dispaly(new Coordinates(1, 2));
        whiteChessman.dispaly(new Coordinates(3, 4));
        System.out.println(blackChessman == blackChessman2);
    }

    /**
     * 代理模式
     * <p>
     * 符合开闭原则: 对修改关闭对扩展开放
     * spring aop使用了代理
     */
    public static void proxy() {
        SingerProxyHandler.test();
    }


    /**
     * ------------------------------------------------------------------------------------------------——————————————————————————————————————————————————
     * 行为型
     * - 责任链模式、命令模式、解释器模式、迭代模式、中介者模式、备忘录模式、
     * - 观察者模式、状态模式、策略模式、模板方法模式、访问者模式
     */

    /**
     * 责任链模式
     * <p>
     * 应用场景：职责链上的处理者负责处理请求，
     * 客户只需要将请求发送到职责链上即可，无须关心请求的处理细节和请求的传递，所以职责链将请求的发送者和请求的处理者解耦了
     * 过滤器
     */
    public static void chain() {
        JingliLeader jingliLeader = new JingliLeader();
        ZhurenLeader zhurenLeader = new ZhurenLeader();
        zhurenLeader.setNextLeader(jingliLeader);
        zhurenLeader.handleRequest(5);
    }

    /**
     * 命令模式
     * 将“请求”(命令/口令)封装成一个对象，以便使用不同的请求、队列或者日志来参数化其对象。
     * 命令模式也支持撤销操作。命令模式的目的就是达到命令的发出者和执行者之间解耦，实现请求和执行分开。
     * <p>
     * 使用场景：菜馆点餐、遥控器、队列请求、日志请求、状态机**
     */
    public static void command() {
        Customer.test();
    }


    /**
     * 解释器模式
     * 解释器模式是类的行为模式。
     * 给定一个语言之后，解释器模式可以定义出其文法的一种表示，并同时提供一个解释器。
     * 客户端可以使用这个解释器来解释这个语言中的句子。
     * <p>
     * <p>
     * （1）抽象表达式(Expression)角色：声明一个所有的具体表达式角色都需要实现的抽象接口。这个接口主要是一个interpret()方法，称做解释操作。
     * <p>
     * (2）终结符表达式(Terminal Expression)角色：实现了抽象表达式角色所要求的接口，主要是一个interpret()方法；文法中的每一个终结符都有一个具体终结表达式与之相对应。比如有一个简单的公式R=R1+R2，在里面R1和R2就是终结符，对应的解析R1和R2的解释器就是终结符表达式。
     * <p>
     * （3）非终结符表达式(Nonterminal Expression)角色：文法中的每一条规则都需要一个具体的非终结符表达式，非终结符表达式一般是文法中的运算符或者其他关键字，比如公式R=R1+R2中，“+"就是非终结符，解析“+”的解释器就是一个非终结符表达式。
     * <p>
     * （4）环境(Context)角色：这个角色的任务一般是用来存放文法中各个终结符所对应的具体值，比如R=R1+R2，我们给R1赋值100，给R2赋值200。这些信息需要存放到环境角色中，很多情况下我们使用Map来充当环境角色就足够了。
     * 适用场景： 一些对象属性随着复杂业务变化而变化的场景。例如加减乘除
     */
    public static void interpret() {
        TestInterpret.test();
    }

    /**
     * 迭代模式
     * 提供一种方法顺序访问一个聚合对象中的各种元素，而又不暴露该对象的内部表示。
     * (1)迭代器角色（Iterator）:定义遍历元素所需要的方法，一般来说会有这么三个方法：取得下一个元素的方法next()，判断是否遍历结束的方法hasNext()），移出当前对象的方法remove(),
     * <p>
     * (2)具体迭代器角色（Concrete Iterator）：实现迭代器接口中定义的方法，完成集合的迭代。
     * <p>
     * (3)容器角色(Aggregate):  一般是一个接口，提供一个iterator()方法，例如java中的Collection接口，List接口，Set接口等
     * <p>
     * (4)具体容器角色（ConcreteAggregate）：就是抽象容器的具体实现类，比如List接口的有序列表实现ArrayList，List接口的链表实现LinkList，Set接口的哈希列表的实现HashSet等。
     * <p>
     * 场景：迭代器模式是与集合共生共死的，一般来说，我们只要实现一个集合，就需要同时提供这个集合的迭代器，
     * 就像java中的Collection，List、Set、Map等，这些集合都有自己的迭代器。
     * 假如我们要实现一个这样的新的容器，当然也需要引入迭代器模式，给我们的容器实现一个迭代器。
     */
    public static void iterator() {
        IteratorTest.test();
    }

    /**
     * 中介者模式
     * 用一个中介对象来封装一系列的对象交互。
     * 中介者使各对象不需要显式地相互引用，从而使其耦合松散，而且可以独立地改变它们之间的交互。
     * 1.Mediator
     * 中介者定义一个接口用于与各同事（Colleague）对象通信。
     *
     * 2.ConcreteMediator
     * 具体中介者通过协调各同事对象实现协作行为，了解并维护它的各个同事。
     *
     * 3.Colleague:
     * 抽象同事类。
     *
     * ４.Colleagueclass
     * 具体同事类。每个具体同事类都只需要知道自己的行为即可，但是他们都需要认识中介者
     *
     * 场景：
     * 1.一组对象以定义良好但是复杂的方式进行通信，产生的相互依赖关系结构混乱且难以理解。
     * 2.一个对象引用其他很多对象并且直接与这些对象通信,导致难以复用该对象。
     * 3.想定制一个分布在多个类中的行为，但又不想生成太多的子类。
     * 例如：群发邮件
     */
    public static void mediator() {
        MediatorTest.test();
    }


    /**
     * 备忘录模式
     * 场景
     * 1、保存一个对象在某一个时刻的全部状态或部分状态，这样以后需要时它能够恢复到先前的状态，实现撤销操作。
     * 2、防止外界对象破坏一个对象历史状态的封装性，避免将对象历史状态的实现细节暴露给外界对象。
     */
    public static void momento() {
        TestMomento.test();
    }

    /**
     * 观察者模式
     * 观察者模式提供了一种对象设计,让主题和观察者之间耦合度降得很低,为什么呢?关于观察者的一切,
     * 主题只知道观察者实现了Observer接口,并不需要观察者具体的类是谁,做了什么或者其他细节.
     * 这样的话,由于松耦合,改变主题或者观察者其中一方,并不会影响另一方,只要他们之间的接口仍被遵守,就可以自由地改变它.
     * 降低对象之间的耦合度,也是面设对象设计的一个很重要的原则.　　
     * 场景： 订阅发布场景
     */
    public static void observer() {
        TestObserver.test();
    }

    /**
     * 状态模式
     * 使用场景：状态机
     */


    /**
     * 策略模式
     * 实现某一个功能有多种算法或者策略，我们可以根据应用场景的不同选择不同的算法或者策略来完成该功能。
     * 优点:
     * 　　　　1、可以动态的改变对象的行为
     * 　　缺点:
     * 　　　　1、客户端必须知道所有的策略类，并自行决定使用哪一个策略类
     * 　　　　2、策略模式将造成产生很多策略类
     * 场景：
     * 实现某一个功能有多种算法或者策略，我们可以根据应用场景的不同选择不同的算法或者策略来完成该功能。
     */
    public static void strategy() {
        TestStrategy.test();
    }

    /**
     * 模板方法模式
     * 在父类定义好应该执行算法的顺序和需要执行的方法，将可变方法延迟到子类进行加载
     * 场景：短信模板
     */
    public static void template() {
        TestTemplate.test();
    }


    /**
     * 访问者模式
     * 一个作用于某对象结构中各元素的操作，使你可以在不改变各元素类数据结构的前提下增加作用于这些元素的新操作
     * 1.Visitor 抽象访问者角色
     * 2.ConcreteVisitor.具体访问者角色
     * 3.Element 接受访问操作元素
     * 4.ConcreteElement 具体元素
     * 5.ObjectStructure 结构对象角色，这是使用访问者模式必备的角色。
     *
     * 优点：
     * 1、符合单一职责原则
     * 2、扩展性良好：元素类可以通过接受不同的访问者来实现对不同操作的扩展。
     *
     * 场景：
     * 数据结构相对稳定，把数据结构和作用与其上的其它操作解耦，使得操作相对自由。
     */
    public static void vistor() {
        TestVisitor.test();
    }

    public static void main(String[] args) {
        /**
         * 创建型
         */
        /*factoryTest();
        singletonTest();
        builderTest();*/

        /**
         * 结构型
         */
        /*adapter();
        bridge();
        combination();
        facade();
        detector();
        flyWeight();
        proxy();*/

        /**
         * 行为型
         */
        chain();
        command();
        interpret();
        iterator();
        mediator();
        momento();
        observer();
        strategy();
        template();
        vistor();
    }
}
