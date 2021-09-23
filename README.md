The example project for StringBoot service

<div align="center">
    <img src="./assets/images/spring_boot_icon.png"/>
</div>

## Getting Started

## Project structure
```
.
├── spring-boot-aop
│   ├── Dockerfile
│   ...
├── docker-compose.yaml
|
└── README.md
```

## Prerequisites
- Make sure that you have Docker and Docker Compose installed
  - Windows or macOS:
    [Install Docker Desktop](https://www.docker.com/get-started)
  - Linux: [Install Docker](https://www.docker.com/get-started) and then
    [Docker Compose](https://github.com/docker/compose)

## Start project
### Start project in local

- Install infrastructure

- Build project
```shell script
$ ./mvnw clean package
$ cd spring-boot-aop
$ ./mvnw spring-boot:run
...
```

### Start project in docker 

- Start project
```shell script
docker-compose up -d
```

- Stop project
```shell script
docker-compose down
```

## Run testing

```shell script
$ curl http://localhost:8081/greet?name=World
{"id":0,"message":"Hello World!"}
```

- See application log
```text
2021-09-22 11:29:34.623  INFO 4680 --- [nio-8081-exec-1] i.c.springbootaop.aop.TimeLoggerAspectJ  : Process [greet] in [155]
```

## Contribute

## Reference

- https://www.baeldung.com/spring-aop
- https://docs.spring.io/spring-framework/docs/4.3.15.RELEASE/spring-framework-reference/html/aop.html