package com.test.hikari;

/**
 * Created by kotu on 8/21/16.
 */


public class LambdaExpressions {
    public static void main(String[] args) {
        Converter<String, Integer> converter =  (from) -> Integer.valueOf(from);
        Integer x = converter.convert("123");
        System.out.println(x);

        Converter<String, Integer> converter1 = Integer::valueOf;
        Integer x1 = converter1.convert("456");
        System.out.println(x1);

        SomeThing someThing = new SomeThing();
        Converter<String, String> converter2 = someThing::startsWith;


    }
}

@FunctionalInterface
interface Converter<F,T>{
    T convert(F from);
}

class SomeThing {
    String startsWith(String s) {
        return String.valueOf(s.charAt(0));
    }
}



