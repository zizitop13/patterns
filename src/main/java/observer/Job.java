package observer;

import observer.publisher.EventPublisher;

import java.util.Date;

import static observer.JobStatus.*;


/**
 * Example for EventPublisher client
 */
public class Job{

    private EventPublisher<JobStatus, String> jobsLogPublisher;

    public Job(EventPublisher<JobStatus, String> jobsLogPublisher){
        this.jobsLogPublisher = jobsLogPublisher;
    }

    public void start() {
        notify(STARTED, "Job started");
        try {
            doWork();
            notify(FINISHED, "Job finished");
        } catch (RuntimeException e){
            notify(FATAL_ERROR, "Job failed, cause: " + e.getMessage());
        } catch (InterruptedException e) {
            notify(STOPPED, "Job stopped");
        }
    }

    public void doWork() throws InterruptedException {
        // do something
        Thread.sleep(100);
    }

    private void notify(JobStatus status, String log){
        if(jobsLogPublisher!=null){
            jobsLogPublisher.notify(status, "[Timestamp: " + new Date().toString() + "] " + log);
        }
    }
}
