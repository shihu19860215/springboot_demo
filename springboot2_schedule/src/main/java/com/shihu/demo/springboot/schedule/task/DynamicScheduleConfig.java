package com.shihu.demo.springboot.schedule.task;

import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.CronTask;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
@EnableScheduling
public class DynamicScheduleConfig implements SchedulingConfigurer{
    // 默认每秒执行一次定时任务
    private String cron = "0/1 * * * * ?";

    public void setCron(String cron) {
        this.cron = cron;
    }

    public String getCron() {
        return cron;
    }
    @Override
    public void configureTasks(ScheduledTaskRegistrar scheduledTaskRegistrar) {
        // 定时任务一
        scheduledTaskRegistrar.addTriggerTask(new Runnable() {
            @Override
            public void run() {
                // 此处执行定时任务的业务逻辑
                System.out.println("定时任务一，当前时间：" + new Date());
            }
        }, new Trigger() {
            @Override
            public Date nextExecutionTime(TriggerContext triggerContext) {
                // 定时任务触发，可修改定时任务的执行周期
                CronTrigger trigger = new CronTrigger(cron);
                Date nextExecDate = trigger.nextExecutionTime(triggerContext);
                return nextExecDate;
            }
        });

        // 定时任务二
        scheduledTaskRegistrar.addTriggerTask(new Runnable() {
            @Override
            public void run() {
                // 此处执行定时任务的业务逻辑
                System.out.println("定时任务二，当前时间：" + new Date());
            }
        }, new Trigger() {
            @Override
            public Date nextExecutionTime(TriggerContext triggerContext) {
                // 定时任务触发，可修改定时任务的执行周期
                CronTrigger trigger = new CronTrigger(cron);
                Date nextExecDate = trigger.nextExecutionTime(triggerContext);
                return nextExecDate;
            }
        });

        // 定时任务三：此种不会因为cron的改变而改变任务执行时间
        scheduledTaskRegistrar.addCronTask(new Runnable() {
            @Override
            public void run() {
                // 此处执行定时任务的业务逻辑
                System.out.println("定时任务三，当前时间：" + new Date());
            }
        }, this.getCron());

        // 定时任务四：此种不会因为cron的改变而改变任务执行时间
        scheduledTaskRegistrar.addCronTask(new CronTask(new Runnable() {
            @Override
            public void run() {
                // 此处执行定时任务的业务逻辑
                System.out.println("定时任务四，当前时间：" + new Date());
            }
        }, new CronTrigger(this.getCron())));


    }
}
