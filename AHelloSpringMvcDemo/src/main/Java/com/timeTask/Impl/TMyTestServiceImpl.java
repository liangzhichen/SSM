package com.timeTask.Impl;

import org.apache.log4j.Logger;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2018/1/10.
 */
@Component
public class TMyTestServiceImpl implements com.timeTask.TMyTestService{

    private Logger logger = Logger.getLogger(TMyTestServiceImpl.class);

    @Scheduled(cron="0/5 * *  * * ? ")   //每5秒执行一次
    public void myTest() {
        System.out.print("进入测试");
    }

    //如果你需要在特定的时间执行，就需要用到cron 了
    //这里是在每天的16点50分执行一次
    @Scheduled(cron = "0 23 14 * * ?")
    public void demo3(){
        logger.info("定时任务demo3开始.");
        long begin = System.currentTimeMillis();
        //执行你需要操作的定时任务
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        logger.info("定时任务demo3结束，共耗时：[" + (end-begin)+ "]毫秒");
    }
}
