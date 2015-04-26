package kr.bankspring.study.step02;

public class Main {
  
  public static void main(String[] args){
    A a1 = new A();
    B1 b1 = new B1(a1);
    
    A a2 = new A();  
    B2 b2 = new B2();
    b2.setA(a2);
  }

}
