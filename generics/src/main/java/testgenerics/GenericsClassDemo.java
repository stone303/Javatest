package testgenerics;

/**
 * @param <T> 这里解释下<T>中的T:
 *           此处的T可以随便写为任意标识，常见的有T、E等形式的参数表示泛型
 *           泛型在定义的时候不具体，使用的时候才变得具体。
 *           在使用的时候确定泛型的具体数据类型。即在创建对象的时候确定泛型。
 */
public class GenericsClassDemo<T> {
    //t这个成员变量的类型为T,T的类型由外部指定
    private T t;
    //泛型构造方法形参t的类型也为T，T的类型由外部指定
    public GenericsClassDemo(T t) {
        this.t = t;
    }
    //泛型方法getT的返回值类型为T，T的类型由外部指定
    public T getT() {
        return t;
    }

    /**
     *
     * @param t 传入泛型的参数
     * @param <T> 泛型的类型
     * @return T 返回值为T类型
     * 说明：
     *   1）public 与 返回值中间<T>非常重要，可以理解为声明此方法为泛型方法。
     *   2）只有声明了<T>的方法才是泛型方法，泛型类中的使用了泛型的成员方法并不是泛型方法。
     *   3）<T>表明该方法将使用泛型类型T，此时才可以在方法中使用泛型类型T。
     *   4）与泛型类的定义一样，此处T可以随便写为任意标识，常见的如T、E等形式的参数常用于表示泛型。
     */
    public <T> T genercMethod(T t){
        System.out.println(t.getClass());
        System.out.println(t);
        return t;
    }
}
