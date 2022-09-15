public class SuspendResume {
    public static void main(String[] args) throws InterruptedException {
    
           final Thread thread1=new Thread("Thread-1"){
                  public void run() {
                        System.out.println(Thread.currentThread().getName()+" has started.");
                        for(int i=0;i<5;i++){
                               try {
                                      Thread.sleep(100);
                               } catch (InterruptedException e) {
                                      e.printStackTrace();
                               }
                               
                               System.out.println("i="+i+" ,ThreadName="+
                                                           Thread.currentThread().getName());
                        }   
                        System.out.println(Thread.currentThread().getName()+" has ENDED.");
                  }
 
           };
           
           Thread thread2=new Thread("Thread-2"){
                  public void run() {
                        System.out.println(Thread.currentThread().getName()+" has started.");
                        for(int i=0;i<5;i++){
                               try {
                                      Thread.sleep(100);
                               } catch (InterruptedException e) {
                                      e.printStackTrace();
                               }
                               
                               System.out.println("i="+i+" ,ThreadName="+
                                                     Thread.currentThread().getName());
                        }   
                        System.out.println(Thread.currentThread().getName()+" has ENDED.");
                  }
 
           };
           
           thread1.start();
           Thread.sleep(10);//make main thread sleep for 10 millisec, 
                                 //This minor delay will ensure that Thread-1 starts before Thread-2.
           thread2.start();
           thread1.suspend();//suspend the thread.
           Thread.sleep(1000);
           thread1.resume();
    }
    
}
 