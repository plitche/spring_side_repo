# spring_batch

추후 배치 강의 수강 이후 개인 프로젝트 진행 해야할 용도

불필요 레파지토리

Spring Batch란 무엇인가?
소개
Spring Batch는 대량의 데이터 처리를 위한 경량화된 프레임워크로, 반복적인 작업을 수행하는 일괄 처리(Batch Processing) 작업을 효율적으로 처리할 수 있는 기능을 제공한다. 대용량 데이터 처리나 주기적인 업무 처리 등을 효율적으로 처리할 수 있고, 대용량 데이터 처리에 적합한 분산 방식의 처리를 지원한다.

Spring Batch의 특징
Spring Batch는 많은 양의 데이터를 효율적으로 처리할 수 있으며, 다양한 기능을 제공한다. 대용량 데이터 처리, 트랜잭션 관리, 재시도 기능 등이 이에 해당된다.

대용량 데이터 처리
Spring Batch는 방대한 양의 데이터를 처리할 수 있다. 데이터 처리 작업을 분산 처리할 수 있어서, 대용량 데이터 처리에 적합하다.

트랜잭션 관리
Spring Batch는 트랜잭션 관리를 지원한다. 데이터 처리 중 실패한 작업은 롤백하여 데이터 일관성을 유지할 수 있다.

재시도 기능
Spring Batch는 작업 중 실패한 경우, 작업을 재시도할 수 있는 기능을 제공한다. 또한, 재시도 횟수를 설정할 수 있다.

스프링 배치 용어
Job
Job은 하나 이상의 Step을 가지며, 하나의 배치 작업을 나타낸다. Job은 JobInstance로 표현되며, JobInstance는 Job의 실행에 대한 실제 인스턴스를 나타낸다.

Step
Step은 배치 처리 작업의 최소 단위다. Step은 Tasklet 혹은 Chunk 방식으로 구성된다.

Tasklet은 하나의 트랜잭션에서 수행되는 단순한 작업
Chunk는 트랜잭션 범위 내에서 Chunk 단위로 데이터를 읽어 처리하는 방식이다.
JobLauncher
Job을 실행하는 인터페이스. Job을 실행하기 위해서는 JobLauncher를 통해 Job을 실행해야 한다.

JobRepository
Job과 관련된 메타 정보를 저장하고 조회하기 위한 인터페이스다. JobInstance, JobExecution, StepExecution 등의 정보를 포함하고 있다.

JobInstance
Job의 실행을 나타내는 인스턴스다.

JobExecution
JobInstance의 실행에 대한 정보를 저장한다.

StepExecution
Step의 실행에 대한 정보를 저장한다. StepExecution은 Step안에서 Tasklet 혹은 Chunk 방식으로 실행된다.

Spring Batch 실사례
Spring Batch를 사용하면 이전에는 수동으로 처리했던 작업을 자동화할 수 있다. 예를 들어, 한 고객이 매일 수천 건의 주문을 입력하는 경우, 이러한 주문 데이터를 처리하는 일괄 처리 작업을 자동화할 수 있다. 이를 위해 Spring Batch를 사용하여 데이터를 일괄 처리하고, 처리 결과를 데이터베이스에 저장할 수 있다. 이를 통해 데이터 처리 시간과 인력 비용을 절약할 수 있다.

또한, Spring Batch를 사용하여 대용량 데이터를 처리하는 경우, 데이터 처리 작업을 분산 처리할 수 있어서 데이터 처리 시간을 대폭 줄일 수 있다. 예를 들어, 수백만 건의 데이터를 처리해야 하는 경우, 이러한 데이터를 처리하는 데에는 많은 시간이 소요된다. 그러나 Spring Batch를 사용하여 데이터 처리 작업을 분산 처리하면, 데이터 처리 시간을 대폭 줄일 수 있다.

예시
Spring Batch를 사용하여 오전 10시에 실행하는 배치작업을 구현하는 프로젝트를 만들어보자.

Spring Batch 프로젝트를 생성. 이때, Spring Boot를 사용하여 프로젝트를 생성하면 편리하다.
배치 작업을 처리하는 Step을 구현. 이때, Tasklet 혹은 Chunk 방식을 선택하여 구현할 수 있다.
Tasklet 방식은 하나의 트랜잭션에서 수행하는 단순한 작업을 의미. 예를 들어, 파일을 읽어서 데이터를 처리하는 작업을 수행할 수 있다.
Chunk 방식은 트랜잭션 범위 내에서 Chunk 단위로 데이터를 읽어 처리하는 방식이다. 예를 들어, 대량의 데이터를 처리하는 작업을 수행할 수 있다.
Step을 구현한 후에는 Job을 구현. Job은 하나 이상의 Step을 가지며, 하나의 배치 작업을 나타낸다. Job을 실행하기 위해서는 JobLauncher를 통해 Job을 실행해야 한다.
배치 작업을 실행하는 스케줄러를 구현. Spring에서는 Quartz 스케줄러를 사용하여 스케줄링 작업을 수행할 수 있다. Spring Batch 프로젝트를 사용하면, 매일 오전 10시에 배치 작업을 자동으로 실행할 수 있다.
Scheduler
Spring에서 Batch Job을 실행시키기 위해서는 Quartz, Scheduler, Jenkins 등 전용 Scheduler를 사용할 수 있다. 각각의 Scheduler는 사용 방법과 설정 방법이 다르므로, 구현하고자 하는 Batch Job에 맞는 Scheduler를 선택하여 사용하면 된다. Spring에서는 Quartz Scheduler를 지원하므로, Quartz Scheduler를 사용하여 Batch Job을 실행시키는 방법을 찾아보시는 것이 좋다.

Quartz 개념
Quartz는 스케줄링 작업을 관리하는 프레임워크다. Quartz를 사용하면, 특정 시간에 작업을 수행하거나, 주기적으로 작업을 반복하는 등의 작업을 자동으로 수행할 수 있다. Quartz는 다음과 같은 기능을 제공한다.

스케줄링 작업 관리
작업 수행 시간 설정
작업 수행 주기 설정
작업 수행 시간 제어
다양한 작업 수행 방식 제공
Quartz 사용법
Quartz를 사용하기 위해서는 다음과 같은 단계를 거쳐야 힌다.

Quartz 라이브러리 추가
Job 클래스 생성
JobDetail 생성
Trigger 생성
Scheduler 생성 및 실행
Quartz 라이브러리를 추가하는 방법은 다음과 같다.

<dependency>
    <groupId>org.quartz-scheduler</groupId>
    <artifactId>quartz</artifactId>
    <version>2.3.0</version>
</dependency>
다음으로, Job 클래스를 생성한다. Job 클래스는 실행할 작업을 정의하는 클래스다. 예를 들어, 매일 오전 10시에 실행할 배치 작업을 정의하는 클래스를 생성할 수 있다.

다음으로, JobDetail을 생성합니다. JobDetail은 Job의 실행을 관리하는 클래스다. JobDetail은 Job 이름, Job 그룹, Job 클래스 등의 정보를 포함한다.

Trigger는 작업을 실행하는 시간을 설정하는 클래스다. Trigger는 작업을 실행할 시간, 주기 등의 정보를 포함한다.

마지막으로, Scheduler를 생성하고 실행. Scheduler는 JobDetail과 Trigger를 관리하며, Job을 실행한다.

Quartz 예제
다음은 Quartz를 사용하여 매일 오전 10시에 실행되는 배치 작업을 구현하는 예제다.

public class MyJob implements Job {
    public void execute(JobExecutionContext context) throws JobExecutionException {
        // 배치 작업을 수행하는 코드
    }
}

public class QuartzScheduler {
    public static void main(String[] args) throws Exception {
        // JobDetail 생성
        JobDetail jobDetail = JobBuilder.newJob(MyJob.class)
                .withIdentity("myJob", "group1")
                .build();

        // Trigger 생성 - 매일 오전 10시에 실행
        Trigger trigger = TriggerBuilder.newTrigger()
                .withIdentity("myTrigger", "group1")
                .withSchedule(CronScheduleBuilder.cronSchedule("0 0 10 * * ?"))
                .build();

        // Scheduler 생성 및 실행
        Scheduler scheduler = new StdSchedulerFactory().getScheduler();
        scheduler.start();
        scheduler.scheduleJob(jobDetail, trigger);
    }
}
위 예제에서는 MyJob 클래스를 생성하여 배치 작업을 수행하도록 구현하였다. 이후, JobDetail과 Trigger를 생성하여 Scheduler에 등록힌다. 매일 오전 10시에 배치 작업이 실행되도록 Cron 표현식을 사용하여 Trigger를 생성한다.
