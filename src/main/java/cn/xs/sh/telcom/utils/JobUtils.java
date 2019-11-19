package cn.xs.sh.telcom.utils;//package cn.xs.telcom.utils;
//
//import cn.xs.telcom.bean.Job;
//import org.springframework.beans.factory.annotation.Value;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * @author kenny_peng
// * @created 2019/8/7 11:21
// */
//public class JobUtils {
//
//    @Value("")
//
//    public static List<Job> queryList(String cron, String url){
//
//        List<Job> list = new ArrayList<Job>();
//        list.add(new JobUtils().getJob(cron, url));
//        return list;
//    }
//
//    private Job getJob(String cron, String url){
//        Job job = new Job();
//        job.setJobId((long) 1);
//        job.setBeanName("telcomEnrolTask");
//        job.setMethodName("post");
//        job.setParams(url);
//        //每天22点执行一次
//        job.setCronExpression(cron);
//        job.setStatus(Job.ScheduleStatus.NORMAL.getValue());
//        job.setRemark("有参任务调度");
//        return job;
//    }
//
//}
