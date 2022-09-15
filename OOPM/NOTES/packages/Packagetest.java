import package1.ClassA; 
class ClassB 
{
  public void display2()
{
System.out.println("In class B");
}
}
class Packagetest
{
  public static void main(String args[])
  {
     ClassB objB=new ClassB();
     ClassA obj=new ClassA();
     obj.displayA();
     objB.display2();
    }
}