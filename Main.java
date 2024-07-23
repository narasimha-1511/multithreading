import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main{
    public static void main(String[] args) {
        
        System.out.println("Hello from thread = " + Thread.currentThread().getName());

        // HelloWorldPrinter helloWorldPrinter = new HelloWorldPrinter();
        // helloWorldPrinter.start();

        // HelloWorldPrinter helloWorldPrinter2 = new HelloWorldPrinter();
        // helloWorldPrinter2.start();

        // Print1To10 primtt = new Print1To10();
        // primtt.start();;
        
        // Print1To10 pp = new Print1To10();
        // pp.start();

        // for(int i=0;i<100;i++){
        //     SingleNumberPrinter ppp = new SingleNumberPrinter(i);

        //     ppp.start();
        // }

        // Thread th = new Thread(new singleNumberv2(169));
        // th.start();

        // for(int i=1; i<=10; i++){
        //     singleNumberv2 sst = new singleNumberv2(i);
        //     Thread th = new Thread(sst);
        //     th.start();
        // }

        ExecutorService es = Executors.newFixedThreadPool(5);
        for(int i=1;i<=50;i++){
            singleNumberv2 sst = new singleNumberv2(i);
            es.submit(sst);
        }

        es.shutdown();
    }
}

class HelloWorldPrinter extends Thread {

    @Override
    public void run() {
        
        System.out.println("HEllo From thread = " + Thread.currentThread().getName());
    }

}

//print 1 to 10
class Print1To10 extends Thread{

    @Override
    public void run(){

        
        for(int i=0; i< 10 ; i++){
            try{
                Thread.sleep(800);
    
            }catch(InterruptedException e){
    
            }
            System.out.println(i+"  ;; from thread = "+Thread.currentThread().getName());
        }
    }
}

//print numbers from 1 to 100 different thread
class numtohun extends Thread{
    @Override
    public void run(){
        for(int i=0; i<100; i++){
            System.out.println(i);
        }
    }
}

class SingleNumberPrinter extends Thread{
    
    SingleNumberPrinter(int i){
        this.i = i;
    }

    int i= 0;
    @Override
    public void run(){
        System.out.println(i+ " from thread="+Thread.currentThread().getName());
    }
}

// create a student class with the run method
class singleNumberv2 implements Runnable{
    
    int num;

    singleNumberv2(int i){
        this.num = i;
    }

    @Override
    public void run(){

        if(num==10)throw new Error("heheeh");
        System.out.println(num+"  -"+Thread.currentThread().getName());
    }
}