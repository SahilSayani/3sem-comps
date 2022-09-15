class A extends Thread
{
public void run()
{

 for(int i=1;i<=5;i++)
 {
   
  System.out.println("From thread A: i="+i);
 }
}
}
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

class FirstProg
{
public static void main(String args[]){
A t1=new A();
B t2=new B();
System.out.println("Start thread A");
t1.start();
System.out.println("Start thread B");
t2.start();
System.out.println("In main");
 try{
t1.wait();
}
catch(Exception e)
{
System.out.println(e);
}
for(int i=0;i<=10;i++)
{
   System.out.println("In main"+i);
}

t1.notify();
}
}