class Sleep extends Thread
{
public void run()
{
try
{
for(int i=1;i<=3;i++)
{
System.out.println("i have resumed now");
}
}
catch(Exception ae)
{
System.out.println(ae);
}
}
}
public class SusRes
{
public static void main(String args[])
{
Sleep s1=new Sleep();
s1.start();
s1.suspend();
for(int j=0;j<=5;j++)
{
System.out.println("In the main thread ");
}
s1.resume();
}
}