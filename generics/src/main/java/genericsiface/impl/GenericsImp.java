package genericsiface.impl;

import genericsiface.GenericsInteface;

public class GenericsImp implements GenericsInteface<String> {
    @Override
    public void add(String s) {

        System.out.println("设置了泛型为String类型");
    }

}
