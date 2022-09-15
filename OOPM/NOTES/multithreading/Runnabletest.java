class X implements Runnable
{
     public void run()
     {    
         for(int i=1;i<=10;i++)
        {  
               System.out.println("ThreadX" +i);
         }
    System.out.println("End of ThreadX");
    }
}

class Runnabletest
{   
    public static void main(String args[])
    {
     X runn= new X();
     Thread threadX= new Thread(runn);
     threadX.start();
       for(int i=1;i<=10;i++)
        {  
               System.out.println("main Thread" +i);
         }
    System.out.println("End of main thread");
    }
}