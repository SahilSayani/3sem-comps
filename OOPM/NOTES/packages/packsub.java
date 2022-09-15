import package2.ClassB; 
class ClassC extends ClassB 
{
  
 int n=20;
void displayC()
{
System.out.println("In class C");
System.out.println("m="+m);
System.out.println("n="+n);
}
}
class packsub
{
  public static void main(String args[])
  {
     ClassC objC=new ClassC();
     objC.displayB();
     objC.displayC();
    }
}