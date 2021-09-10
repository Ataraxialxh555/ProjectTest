package Reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

public class ReflectTest08 {
    public static void main(String[] args) throws Exception{
        StringBuilder s = new StringBuilder();
//        Class className = Class.forName("java.lang.String");
        Class className = Class.forName("java.lang.Thread");
        s.append("class "+ className.getSimpleName()+"{\n");
        Field[] fields = className.getDeclaredFields();
        for (Field field:fields){
            s.append("\t");
            if(Modifier.toString(field.getModifiers()) != ""){
                s.append(Modifier.toString(field.getModifiers())+" "+field.getType().getSimpleName()+" "+field.getName());
            }else{
                s.append(field.getType().getSimpleName()+" "+field.getName());
            }

            s.append(";\n");
        }
        s.append("}");
        System.out.println(s);
    }
}
