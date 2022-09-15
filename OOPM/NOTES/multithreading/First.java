class A extends Thread
{
public void run()
{
for(int i=1;i<=5;i++)
 {
   System.out.println("From thread A: i="+i);
}}}
class B extends Thread
{
public void run()
{  

 for(int j=1;j<=5;j++)
 {
System.out.println("From thread B: j="+j);
 }
}
}
class First
{
public static void main(String args[]){
A t1=new A();
B t2=new B();
System.out.println("Start thread A");
t1.start();
System.out.println("Start thread B");
t2.start();
System.out.println("In main");
System.out.println("in main again");
}}