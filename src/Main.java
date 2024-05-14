import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class Main {
    public static void main(String[] args) {
        Method1 method1 = new Method1();
        try {
            Class cls = null;
            try {
                cls = Class.forName("Method1");
            } catch (ClassNotFoundException e) {
                throw new RuntimeException("ridi");
            }
            Field[] fields = cls.getDeclaredFields();
            for(Field field : fields){
                System.out.println(field.getName());
                int mod = field.getModifiers();
                System.out.println(Modifier.toString(mod));
            }
            System.out.println("-----");
            Method[] methlist = cls.getDeclaredMethods();
            for (int i = 0; i < methlist.length;
                 i++) {
                Method m = methlist[i];
                System.out.println(STR."name = \{m.getName()}");
                System.out.println(STR."decl class = \{m.getDeclaringClass()}");
                Class pvec[] = m.getParameterTypes();
                for (int j = 0; j < pvec.length; j++)
                    System.out.println(STR."param #\{j} \{pvec[j]}");
                Class evec[] = m.getExceptionTypes();
                for (int j = 0; j < evec.length; j++)
                    System.out.println(STR."exc #\{j} \{evec[j]}");
                System.out.println(STR."return type = \{m.getReturnType()}");
                if(methlist[i].getName().equals("add")){
                    methlist[i].invoke (method1, 22, 23);
                }
                System.out.println("-----");

            }
        }
        catch (Throwable e) {
            System.err.println(e);
        }

    }
}