package Pattern23.FactoryMethod;

/**
 * 工厂方法模式
 * 工厂方法模式去掉了简单工厂模式中工厂方法的静态属性，使得它可以被子类继承。这样在简单工厂模式里集中在工厂方法上的压力可以由工厂方法模式里不同的工厂子类来分担。
 * 针对上面的例子，如果使用工厂方法模式，即将工厂定义为一个接口，然后由具体的工厂来确定需要生成什么样的产品，为了与简单工厂比较，这里还是贴上代码：
 */
public class FactoryMethodPattern {
    public static void main(String[] args) {
        //具体由工厂类来控制实现具体的产品
        IFactory iFactory;
        iFactory = new SmallFactory();
        iFactory.produce().run();
        iFactory = new BigFactory();
        iFactory.produce().run();
    }
}

//抽象产品
interface MeiZuPhone{
    void run();
}

//具体产品*2
class Pro7 implements MeiZuPhone{

    public void run() {
        System.out.print("Pro7");
    }
}

class Pro8 implements MeiZuPhone{

    public void run() {
        System.out.print("Pro8");
    }
}

//抽象工厂
interface IFactory{
    MeiZuPhone produce();
}

//工厂*2
class BigFactory implements IFactory{

    public MeiZuPhone produce() {
        return new Pro7();
    }
}

class SmallFactory implements IFactory{

    public MeiZuPhone produce() {
        return new Pro8();
    }
}

