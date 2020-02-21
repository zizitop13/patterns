package observer;

import observer.publisher.EventPublisher;

import java.util.Date;

import static observer.JobStatus.*;

public class Job{

    private EventPublisher<JobStatus, String> jobsLogPublisher;

    public Job(EventPublisher<JobStatus, String> jobsLogPublisher){
        this.jobsLogPublisher = jobsLogPublisher;
    }

    public void start() {
        jobsLogPublisher.notify(STARTED, "Job started at time: " + new Date());
        try {
            doWork();
            jobsLogPublisher.notify(FINISHED, "Job finished at time: " + new Date());
        } catch (RuntimeException e){
            jobsLogPublisher.notify(FATAL_ERROR, "Job failed at time: " + new Date() + " cause: " + e.getMessage());
        } catch (InterruptedException e) {
            jobsLogPublisher.notify(STOPPED, "Job stopped at time: " + new Date());
        }
    }

    public void doWork() throws InterruptedException {
        // do something
        Thread.sleep(100);
    }
}
