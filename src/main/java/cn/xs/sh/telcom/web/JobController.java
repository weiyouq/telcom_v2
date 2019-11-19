package cn.xs.sh.telcom.web;//package cn.xs.telcom.web;
//
//import cn.xs.telcom.bean.Job;
//import cn.xs.telcom.config.PageRequest;
//import cn.xs.telcom.config.returndefine.ResponseBase;
//import cn.xs.telcom.service.JobService;
//import org.apache.logging.log4j.core.util.CronExpression;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.ResponseBody;
//
//import java.util.List;
//import java.util.Map;
//
///**
// * @author kenny_peng
// * @created 2019/7/26 10:58
// */
////@Controller
//public class JobController extends BaseController{
//    private Logger log = LoggerFactory.getLogger(this.getClass());
//
////    @Autowired
//    private JobService jobService;
//
//    @RequestMapping("job")
//    public String index() {
//        return "job/job/job";
//    }
//
//    @RequestMapping("job/list")
//    @ResponseBody
//    public Map<String, Object> jobList(PageRequest request, Job job) {
//        return super.selectByPageNumSize(request, () -> this.jobService.findAllJobs(job));
//    }
//
//    @RequestMapping("job/checkCron")
//    @ResponseBody
//    public boolean checkCron(String cron) {
//        try {
//            return CronExpression.isValidExpression(cron);
//        } catch (Exception e) {
//            return false;
//        }
//    }
//
//    @RequestMapping("job/add")
//    @ResponseBody
//    public ResponseBase addJob(Job job) {
//        try {
//            this.jobService.addJob(job);
//            return ResponseBase.ok("新增任务成功！");
//        } catch (Exception e) {
//            log.error("新增任务失败", e);
//            return ResponseBase.error("新增任务失败，请联系网站管理员！");
//        }
//    }
//
//    @RequestMapping("job/delete")
//    @ResponseBody
//    public ResponseBase deleteJob(String ids) {
//        try {
//            this.jobService.deleteBatch(ids);
//            return ResponseBase.ok("删除任务成功！");
//        } catch (Exception e) {
//            log.error("删除任务失败", e);
//            return ResponseBase.error("删除任务失败，请联系网站管理员！");
//        }
//    }
//
//    @RequestMapping("job/getJob")
//    @ResponseBody
//    public ResponseBase getJob(Long jobId) {
//        try {
//            Job job = this.jobService.findJob(jobId);
//            return ResponseBase.ok(job);
//        } catch (Exception e) {
//            log.error("获取任务信息失败", e);
//            return ResponseBase.error("获取任务信息失败，请联系网站管理员！");
//        }
//    }
//
//    @RequestMapping("job/update")
//    @ResponseBody
//    public ResponseBase updateJob(Job job) {
//        try {
//            this.jobService.updateJob(job);
//            return ResponseBase.ok("修改任务成功！");
//        } catch (Exception e) {
//            log.error("修改任务失败", e);
//            return ResponseBase.error("修改任务失败，请联系网站管理员！");
//        }
//    }
//
//    @RequestMapping("job/run")
//    @ResponseBody
//    public ResponseBase runJob(String jobIds) {
//        try {
//            this.jobService.run(jobIds);
//            return ResponseBase.ok("执行任务成功！");
//        } catch (Exception e) {
//            log.error("执行任务失败", e);
//            return ResponseBase.error("执行任务失败，请联系网站管理员！");
//        }
//    }
//
//    @RequestMapping("job/pause")
//    @ResponseBody
//    public ResponseBase pauseJob(String jobIds) {
//        try {
//            this.jobService.pause(jobIds);
//            return ResponseBase.ok("暂停任务成功！");
//        } catch (Exception e) {
//            log.error("暂停任务失败", e);
//            return ResponseBase.error("暂停任务失败，请联系网站管理员！");
//        }
//    }
//
//    @RequestMapping("job/resume")
//    @ResponseBody
//    public ResponseBase resumeJob(String jobIds) {
//        try {
//            this.jobService.resume(jobIds);
//            return ResponseBase.ok("恢复任务成功！");
//        } catch (Exception e) {
//            log.error("恢复任务失败", e);
//            return ResponseBase.error("恢复任务失败，请联系网站管理员！");
//        }
//    }
//
////    @RequestMapping("job/excel")
////    @ResponseBody
////    public ResponseBase jobExcel(Job job) {
////        try {
////            List<Job> list = this.jobService.findAllJobs(job);
////            return FileUtil.createExcelByPOIKit("任务表", list, Job.class);
////        } catch (Exception e) {
////            log.error("导出任务信息Excel失败", e);
////            return ResponseBase.error("导出Excel失败，请联系网站管理员！");
////        }
////    }
////
////    @RequestMapping("job/csv")
////    @ResponseBody
////    public ResponseBase jobCsv(Job job) {
////        try {
////            List<Job> list = this.jobService.findAllJobs(job);
////            return FileUtil.createCsv("任务表", list, Job.class);
////        } catch (Exception e) {
////            log.error("导出任务信息Csv失败", e);
////            return ResponseBase.error("导出Csv失败，请联系网站管理员！");
////        }
////    }
//
//    /**
//     * @param job 定时任务
//     * @return ResponseBase
//     */
//    @RequestMapping("job/getSysCronClazz")
//    @ResponseBody
//    public ResponseBase getSysCronClazz(Job job) {
//        List<Job> sysCronClazz = this.jobService.getSysCronClazz(job);
//        return ResponseBase.ok(sysCronClazz);
//    }
//}
