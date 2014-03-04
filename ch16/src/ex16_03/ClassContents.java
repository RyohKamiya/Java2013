package ex16_03;

import java.lang.annotation.Annotation;

class ClassContents {
  public static void main(String[] args) {
    try {
        Class<?> c = Class.forName(args[0]);
      System.out.println(c);
      printAnnotations(c.getAnnotations());
    } catch (ClassNotFoundException e) {
    }
  }

  private static void printAnnotations(Annotation[] annos) {
    for (Annotation a : annos) {
      String decl = a.toString();
      System.out.println(decl.replaceAll("java.lang.", ""));
    }
  }
}
