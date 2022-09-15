public class joinExwith {
   public static void main(String[] args) {
      Thread th1 = new Thread(new MyClass(), "th1");
      Thread th2 = new Thread(new MyClass(), "th2");
      Thread th3 = new Thread(new MyClass(), "th3");
         
      // Start first thread immediately
      th1.start();
        
      try {
          th1.join();
      } catch (InterruptedException ie) {
          ie.printStackTrace();
        }
      th2.start();
      try {
          th2.join();
      } catch (InterruptedException ie) {
           ie.printStackTrace();
        }
      th3.start();
        
      try {
          th3.join();
      } catch (InterruptedException ie) {
            ie.printStackTrace();
        }  
      System.out.println("All three threads have finished execution");
   }
}
 
class MyClass implements Runnable{
 
  
    public void run() {
    	Thread t = Thread.currentThread();
        System.out.println("Thread started: "+t.getName());
        try {
            Thread.sleep(4000);
        } catch (InterruptedException ie) {
            ie.printStackTrace();
        }
        System.out.println("Thread ended: "+t.getName());
        
    }
}