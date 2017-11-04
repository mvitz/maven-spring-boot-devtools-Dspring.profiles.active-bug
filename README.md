# Maven Spring Boot DevTools -D profiles bug

Starting this example application by running

```bash
./mvnw spring-boot:run -Dspring.profiles.active=dev
```

results in the following output:

```bash
...
[INFO] --- spring-boot-maven-plugin:1.5.8.RELEASE:run (default-cli) @ maven-devtools-profile-bug ---
2017-11-04 11:16:07.065  INFO 26314 --- [           main] d.m.m.MavenDevtoolsProfileBugApplication : Starting MavenDevtoolsProfileBugApplication on Michaels-MBP with PID 26314 (/Users/mvitz/Development/new2/maven-devtools-profile-bug/target/classes started by mvitz in /Users/mvitz/Development/new2/maven-devtools-profile-bug)
2017-11-04 11:16:07.068  INFO 26314 --- [           main] d.m.m.MavenDevtoolsProfileBugApplication : The following profiles are active: dev
2017-11-04 11:16:07.094  INFO 26314 --- [           main] s.c.a.AnnotationConfigApplicationContext : Refreshing org.springframework.context.annotation.AnnotationConfigApplicationContext@18ac62f5: startup date [Sat Nov 04 11:16:07 CET 2017]; root of context hierarchy
==========
==========
==========
dev
==========
==========
==========
2017-11-04 11:16:07.402  INFO 26314 --- [           main] o.s.j.e.a.AnnotationMBeanExporter        : Registering beans for JMX exposure on startup
2017-11-04 11:16:07.410  INFO 26314 --- [           main] d.m.m.MavenDevtoolsProfileBugApplication : Started MavenDevtoolsProfileBugApplication in 0.574 seconds (JVM running for 2.522)
...
```

However after adding Spring Boot DevTools in `pom.xml` the same call results in:

```bash
...
[INFO] --- spring-boot-maven-plugin:1.5.8.RELEASE:run (default-cli) @ maven-devtools-profile-bug ---
[INFO] Attaching agents: []
11:17:30.206 [main] DEBUG org.springframework.boot.devtools.settings.DevToolsSettings - Included patterns for restart : []
11:17:30.208 [main] DEBUG org.springframework.boot.devtools.settings.DevToolsSettings - Excluded patterns for restart : [/spring-boot-starter/target/classes/, /spring-boot-autoconfigure/target/classes/, /spring-boot-starter-[\w-]+/, /spring-boot/target/classes/, /spring-boot-actuator/target/classes/, /spring-boot-devtools/target/classes/]
11:17:30.208 [main] DEBUG org.springframework.boot.devtools.restart.ChangeableUrls - Matching URLs for reloading : [file:/Users/mvitz/Development/new2/maven-devtools-profile-bug/target/classes/]
2017-11-04 11:17:30.405  INFO 26400 --- [  restartedMain] d.m.m.MavenDevtoolsProfileBugApplication : Starting MavenDevtoolsProfileBugApplication on Michaels-MBP with PID 26400 (/Users/mvitz/Development/new2/maven-devtools-profile-bug/target/classes started by mvitz in /Users/mvitz/Development/new2/maven-devtools-profile-bug)
2017-11-04 11:17:30.407  INFO 26400 --- [  restartedMain] d.m.m.MavenDevtoolsProfileBugApplication : No active profile set, falling back to default profiles: default
2017-11-04 11:17:30.447  INFO 26400 --- [  restartedMain] s.c.a.AnnotationConfigApplicationContext : Refreshing org.springframework.context.annotation.AnnotationConfigApplicationContext@261cb53f: startup date [Sat Nov 04 11:17:30 CET 2017]; root of context hierarchy
==========
==========
==========
==========
==========
==========
2017-11-04 11:17:30.850  INFO 26400 --- [  restartedMain] o.s.b.d.a.OptionalLiveReloadServer       : LiveReload server is running on port 35729
2017-11-04 11:17:30.869  INFO 26400 --- [  restartedMain] o.s.j.e.a.AnnotationMBeanExporter        : Registering beans for JMX exposure on startup
2017-11-04 11:17:30.880  INFO 26400 --- [  restartedMain] d.m.m.MavenDevtoolsProfileBugApplication : Started MavenDevtoolsProfileBugApplication in 0.663 seconds (JVM running for 0.937)
...
```
