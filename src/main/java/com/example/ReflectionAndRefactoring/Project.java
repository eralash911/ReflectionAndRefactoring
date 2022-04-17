package com.example.ReflectionAndRefactoring;

import org.springframework.cglib.proxy.Proxy;

import org.springframework.cglib.proxy.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

class ALibBest{
    private ALibBest() {}
    public static String solve(int[]n) throws InvocationTargetException, IllegalAccessException {
        Class lib = ALib.class;
        Method ms[] = lib.getMethods();
        for (Method mi : ms)
            if (mi.getAnnotation(TheBest.class) != null)
                 return (String) mi.invoke(null, new Object[]{n});

            return (String) ms[0].invoke(null, new Object[]{n});
        }
}

//динамический прокси
class ALibExHandler implements InvocationHandler{
    private Object object;

    private ALibExHandler(Object object) {
        this.object = object;
    }
     public static ILib createProxy(Object object){
        return (ILib) Proxy.newProxyInstance(ILib.class.getClassLoader(),
                new Class[] {ILib.class},
                new ALibExHandler(object));  }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Class lib = ALibEx.class;
        Method ms[] = lib.getMethods();
        for (Method mi : ms)
            if (mi.getAnnotation(TheBest.class) != null){
                method = mi;
                break;
            }
        return "Proxy" +  method.invoke(object, args);
    }
}

public class  Project {
    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException {
     //   System.out.println(ALibBest.solve(new int[]{1, 4, 43, 43, 65}));

        ILib obj = new ALibEx();
        ILib proxy = ALibExHandler.createProxy(obj);
        System.out.println(obj.solveFirst(new int[]{1, 4, 43, 43, 65, 32, 54,76}));
        System.out.println(proxy.solveFirst(new int[]{1, 4, 43, 43, 65, 32, 54,76,43,3423,235 }));

    }
}