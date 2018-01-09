package Pattern23;

/**
 * 1.单例模式
 * 何时使用：当系统需要某个类只有一个实例的时候
 *
 * 优点：单例模式的类唯一实例由其本身控制，可以很好的控制用户何时访问它。
 */
public class Singleton {

    private static Singleton instance;

    private Singleton(){};

    public static Singleton getInstance(){
        if (instance == null){
            instance = new Singleton();
        }
        return instance;
    }

//    上例就是一个简单的单例模式实现，使用了懒加载模式。但是多线程中可能会创建多个实例。下面就介绍多线程中的使用。
//    如果直接将上面例子应用到多线程中，可以直接把getInstance()设置为同步的(synchronized)，但是并不高效，任一之后，只能有一个线程可以调用这个方法，其余的会排队等待。
//    所以整个方法做同步不是优解，那就只同步代码块就好了。这就引出了双重检验锁，即在同步块外检查一次null，然后再在同步块内检查一次。但是最终这种方式也是会有问题的，使用静态内部类是一种比较好的方式。

}
