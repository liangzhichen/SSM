package synchronize;

import groovy.transform.Synchronized;

import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

/**
 * Created by clz on 2017/12/26.
 * 火车票示例 (Vector 是线程安全的) 第一种；第二种
 */
public class TrainTest {

    public static void main(String[] args) {
       // final Vector<String> tikets = new Vector<String>();   //第一种：通过Vector保证线程安全，锁住资源

        final List<String> tikets = new ArrayList<String>();

        for (int i = 0 ; i<=1000 ; i++){
            tikets.add("火车票" + i);
        }

        for (int i = 0 ; i<=10 ; i++){
                new Thread(){
                    public void run(){
                        synchronized (tikets) {               //第二种：通过同步关键字锁住资源
                            System.out.println(Thread.currentThread().getId() + "-----------" + tikets.remove(0));
                        }
                    }
                }.start();
//                try {
//                    Thread.sleep(Long.parseLong("3000"));
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
        }
    }

}
