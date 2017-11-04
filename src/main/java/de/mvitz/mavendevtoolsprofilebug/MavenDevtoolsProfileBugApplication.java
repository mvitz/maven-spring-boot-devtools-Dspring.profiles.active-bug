package de.mvitz.mavendevtoolsprofilebug;

import java.util.Arrays;
import javax.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@SpringBootApplication
public class MavenDevtoolsProfileBugApplication {

    private final Environment env;

    MavenDevtoolsProfileBugApplication(Environment env) {
        this.env = env;
    }

    @PostConstruct
    public void printActiveProfiles() {
        System.out.println("==========");
        System.out.println("==========");
        System.out.println("==========");
        Arrays.stream(env.getActiveProfiles()).forEach(System.out::println);
        System.out.println("==========");
        System.out.println("==========");
        System.out.println("==========");
    }

    public static void main(String[] args) {
        SpringApplication.run(MavenDevtoolsProfileBugApplication.class, args);
    }
}
