package com.ly.mybatis.proxy;

import com.ly.mybatis.annotation.Select;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ClassName JdkMeipo
 * @description：jdk自带的Mapper动态代理实现
 * @author：liuyi
 * @Date：2020/11/13 23:36
 */
public class MapperProxy implements InvocationHandler{

    //获取处理后的被代理对象
    public static  <T> T getInstance(Class<T> tclass){
         return (T)Proxy.newProxyInstance(tclass.getClassLoader(), new Class[]{tclass}, new MapperProxy());
    }


    @Override
    public Object invoke(Object proxy, Method method, Object[] args){
        Annotation[] annotations = method.getAnnotations();
        Annotation annotation1 = annotations[0];
        System.out.println(annotation1.annotationType());
        Select annotation = method.getAnnotation(Select.class);
        System.out.println(annotation.value());
        return null;
    }


}