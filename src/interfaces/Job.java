package interfaces;

/**
 * Created by Mihnea on 26.04.2017.
 */
public interface Job {
    class EmptyJob implements Job {
        private EmptyJob() {}
        public void runJob() {
            System.out.println("Nothing serious to run...");
        }
    }
    EmptyJob EMPTY_JOB = new EmptyJob();
    void runJob();
}

class JobTest {
    public static void main(String[] args) {
        submitJob(Job.EMPTY_JOB);
    }
    public static void submitJob(Job job) {
        job.runJob();
    }
}
