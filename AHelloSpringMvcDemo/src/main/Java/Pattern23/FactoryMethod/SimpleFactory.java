package Pattern23.FactoryMethod;

/**
 * 工厂方法模式（Factory Method Pattern）
 * 何时使用:
 *          1.用户需要一个类的子类的实例，但不希望与该类的子类形成耦合
 *          2.用户需要一个类的子类的实例，但用户不知道该类有哪些子类可用
 * 优点:
 *          1:使用工厂方法可以让用户的代码和某个特定类的子类的代码解耦
 *          2:工厂方法使用户不必知道它所使用的对象是怎样被创建的，只需知道该对象有哪些方法即可。
 */
public class SimpleFactory {
    // 简单工厂模式：简单工厂模式是不易维护的，如果需要添加新的产品，则整个系统都需要修改。
    // 如果我们需要添加诸如PRO7、PRO8等产品，直接在工程类中添加即可。
    // 但是如果这时候根部不知道还有什么产品，只有到子类实现时才知道，这时候就需要工厂方法模式（FactoryMethodPattern.java）。
    public static void main(String[] args) {
        //具体由子类的实现来控制产品的实现
        Factory factory = new Factory();
        try {
            factory.produce("Pro5").run();
            factory.produce("Pro6").run();
            factory.produce("Pro7").run();
        }catch (Exception e){
            System.out.print(e.getMessage());
        }

    }
}

//抽象产品
interface MeizuPhone{
    void run();
}

//具体产品2
class Pro5 implements MeizuPhone{

    public void run() {
        System.out.print("Pro5");
    }
}

class Pro6 implements MeizuPhone{

    public void run() {
        System.out.print("Pro6");
    }
}

//工厂
class Factory{
    MeizuPhone produce(String product)throws Exception{
        if ("Pro5".equals(product))
            return new Pro5();
        if ("Pro6".equals(product))
            return new Pro6();
        throw new Exception("No Such Class");
    }
}
