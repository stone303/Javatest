package testgenerics;

import genericsiface.impl.GenericsImp;

import java.util.ArrayList;

/**
 * 1. 为什么使用泛型
 * 早期的Object类型可以接收任意的对象类型，但是在实际的使用中，会有类型转换的问题。也就存在这隐患，
 * 所以Java提供了泛型来解决这个安全问题。
 *
 * 2. 什么是泛型
 * 泛型：是一种把明确类型的工作推迟到创建对象或者调用方法的时候才去明确的特殊的类型。也就是说在泛型使用过程中，
 * 操作的数据类型被指定为一个参数，而这种参数类型可以用在类、方法和接口中，分别被称为泛型类、泛型方法、泛型接口。
 * 注意:一般在创建对象时，将未知的类型确定具体的类型。当没有指定泛型时，默认类型为Object类型。
 *
 *
 * 3. 使用泛型的好处
 * 避免了类型强转的麻烦。
 * 它提供了编译期的类型安全，确保在泛型类型（通常为泛型集合）上只能使用正确类型的对象，避免了在运行时出现ClassCastException。
 *
 * 4. 泛型的使用
 * 泛型虽然通常会被大量的使用在集合当中，但是我们也可以完整的学习泛型只是。
 * 泛型有三种使用方式，分别为：泛型类、泛型方法、泛型接口。将数据类型作为参数进行传递。
 *
 *
 */
public class GlmapperGeneric {
    public static void main(String[] args) {
        //测试一下泛型的经典案例
        ArrayList arrayList = new ArrayList();
        arrayList.add("helloWorld");
        arrayList.add("taiziyenezha");
        arrayList.add(88);//由于集合没有做任何限定，任何类型都可以给其中存放

/*
        for (int i = 0; i < arrayList.size(); i++) {
            //需求：打印每个字符串的长度,就要把对象转成String类型
            String str = (String) arrayList.get(i);
            System.out.println(str.length());
        }
 */
        GenericsClassDemo<String> genericString=new GenericsClassDemo<>("testing generics!");
        System.out.println(genericString.getT());
        genericString.genercMethod("Testing generics method");


        GenericsImp gi=new GenericsImp();
        gi.add("Testing");
    }
}
