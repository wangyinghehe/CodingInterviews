package code.swordOfffer;

/**
 * 单例模式
 */
public class Problem2 {
   /* //1. 饿汉式单例类
    class SingletonClass1 {
        private static final SingletonClass1 instance1 = new SingletonClass1();

        private SingletonClass1() {
        }  //私有构造函数

        public static SingletonClass1 getInstance() {
            return instance1;
        }
    }*/
}

//2. 懒汉式单例模式
class SingletonClass {
    private static volatile SingletonClass instance = null;

    private SingletonClass() {
    }  //私有构造函数

    public static SingletonClass getInstance() {
        if (instance == null) {
            synchronized (SingletonClass.class) {
                if (instance == null) {
                    instance = new SingletonClass();
                }
            }
        }
        return instance;
    }
}
