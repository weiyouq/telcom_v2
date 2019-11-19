package cn.xs.sh.telcom.service.impl;//package cn.xs.telcom.service.impl;
//
//import cn.xs.telcom.bean.Job;
//import cn.xs.telcom.service.JobService;
//import cn.xs.telcom.utils.JobUtils;
//import cn.xs.telcom.utils.ScheduleUtils;
//import org.quartz.CronTrigger;
//import org.quartz.Scheduler;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.stereotype.Service;
//import org.springframework.transaction.annotation.Propagation;
//import org.springframework.transaction.annotation.Transactional;
//
//import javax.annotation.PostConstruct;
//import java.util.List;
//
//@Service("JobService")
//@Transactional(propagation = Propagation.SUPPORTS, readOnly = true, rollbackFor = Exception.class)
//public class JobServiceImpl implements JobService {
//
//    private Logger log = LoggerFactory.getLogger(this.getClass());
//
//    @Autowired
//    private Scheduler scheduler;
//
////    @Autowired
////    private IJobDao jobMapper;
//    @Value("${ua.enrol.cron}")
//    private String cron;
//    @Value("${ua.enrol.url}")
//    private String vbEnrolUrl;
//
//    /**
//     * 项目启动时，初始化定时器，在autowried注入之后执行
//     */
//    @PostConstruct
//    public void init() {
//        List<Job> scheduleJobList = JobUtils.queryList(cron, vbEnrolUrl);
//
//        // 如果不存在，则创建
//        scheduleJobList.forEach(scheduleJob -> {
//            CronTrigger cronTrigger = ScheduleUtils.getCronTrigger(scheduler, scheduleJob.getJobId());
//            if (cronTrigger == null) {
//                ScheduleUtils.createScheduleJob(scheduler, scheduleJob);
//            } else {
//                ScheduleUtils.updateScheduleJob(scheduler, scheduleJob);
//            }
//        });
//        System.out.println("-------定时任务初始化-------");
//    }

//    @Override
//    public Job findJob(Long jobId) {
//        return jobMapper.selectByPrimaryKey(jobId);
//    }
//
//    @Override
//    public List<Job> findAllJobs(Job job) {
//
////        try {
////            Example example = new Example(Job.class);
////            Criteria criteria = example.createCriteria();
////            if (StringUtils.isNotBlank(job.getBeanName())) {
////                criteria.andCondition("bean_name=", job.getBeanName());
////            }
////            if (StringUtils.isNotBlank(job.getMethodName())) {
////                criteria.andCondition("method_name=", job.getMethodName());
////            }
////            if (StringUtils.isNotBlank(job.getStatus())) {
////                criteria.andCondition("status=", Long.valueOf(job.getStatus()));
////            }
////            example.setOrderByClause("job_id");
////            return this.selectByExample(example);
////        } catch (Exception e) {
////            log.error("获取任务失败", e);
////            return new ArrayList<>();
////        }
//        return jobMapper.findAllJobs(job);
//    }
//
//    @Override
//    @Transactional
//    public void addJob(Job job) {
//        job.setCreateTime(new Date());
//        job.setStatus(Job.ScheduleStatus.PAUSE.getValue());
//        jobMapper.insertSelective(job);
//        ScheduleUtils.createScheduleJob(scheduler, job);
//    }
//
//    @Override
//    @Transactional
//    public void updateJob(Job job) {
//        ScheduleUtils.updateScheduleJob(scheduler, job);
//        jobMapper.updateByPrimaryKeySelective(job);
//    }
//
//    @Override
//    @Transactional
//    public void deleteBatch(String jobIds) {
//        List<String> list = Arrays.asList(jobIds.split(","));
//        jobMapper.deleteByList(list);
//    }
//
//    @Override
//    @Transactional
//    public int updateBatch(String jobIds, String status) {
//        List<String> list = Arrays.asList(jobIds.split(","));
////        Job job = new Job();
////        job.setStatus(status);
//        return jobMapper.updateByListIdsAndStatus(list,status);
//    }
//
//    @Override
//    @Transactional
//    public void run(String jobIds) {
//        String[] list = jobIds.split(",");
//        Arrays.stream(list).forEach(jobId -> ScheduleUtils.run(scheduler, this.findJob(Long.valueOf(jobId))));
//    }
//
//    @Override
//    @Transactional
//    public void pause(String jobIds) {
//        String[] list = jobIds.split(",");
//        Arrays.stream(list).forEach(jobId -> ScheduleUtils.pauseJob(scheduler, Long.valueOf(jobId)));
//        this.updateBatch(jobIds, Job.ScheduleStatus.PAUSE.getValue());
//    }
//
//    @Override
//    @Transactional
//    public void resume(String jobIds) {
//        String[] list = jobIds.split(",");
//        Arrays.stream(list).forEach(jobId -> ScheduleUtils.resumeJob(scheduler, Long.valueOf(jobId)));
//        this.updateBatch(jobIds, Job.ScheduleStatus.NORMAL.getValue());
//    }
//
//    @SuppressWarnings("rawtypes")
//    @Override
//    public List<Job> getSysCronClazz(Job job) {
//        Reflections reflections = new Reflections("cc.mrbird.job.task");
//        List<Job> jobList = new ArrayList<>();
//        Set<Class<?>> annotated = reflections.getTypesAnnotatedWith(CronTag.class);
//
//        for (Class cls : annotated) {
//            String clsSimpleName = cls.getSimpleName();
//            Method[] methods = cls.getDeclaredMethods();
//            for (Method method : methods) {
//                Job job1 = new Job();
//                String methodName = method.getName();
//                Parameter[] methodParameters = method.getParameters();
//                String params = String.format("%s(%s)", methodName, Arrays.stream(methodParameters).map(item -> item.getType().getSimpleName() + " " + item.getName()).collect(Collectors.joining(", ")));
//
//                job1.setBeanName(StringUtils.uncapitalize(clsSimpleName));
//                job1.setMethodName(methodName);
//                job1.setParams(params);
//                jobList.add(job1);
//            }
//        }
//        return jobList;
//    }

//}
