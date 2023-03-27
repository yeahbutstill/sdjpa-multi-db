# Spring Data JPA Multiple Database Project

This repository contains source code examples to support my course [Spring Data JPA and Hibernate Beginner to Guru](https://www.udemy.com/course/hibernate-and-spring-data-jpa-beginner-to-guru/?referralCode=251C4C865302C7B1BB8F)

## Connect with Spring Framework Guru
* Spring Framework Guru [Blog](https://springframework.guru/)
* Subscribe to Spring Framework Guru on [YouTube](https://www.youtube.com/channel/UCrXb8NaMPQCQkT8yMP_hSkw)
* Like Spring Framework Guru on [Facebook](https://www.facebook.com/springframeworkguru/)
* Follow Spring Framework Guru on [Twitter](https://twitter.com/spring_guru)
* Connect with John Thompson on [LinkedIn](http://www.linkedin.com/in/springguru)

## MySQL Docker Setup
```shell
docker run --rm \
--name=multi-db \
-e MYSQL_DATABASE=multidb \
-e MYSQL_USER=sdjpa \
-e MYSQL_PASSWORD=PNSJkxXvVNDAhePMuExTBuRR \
-e MYSQL_ROOT_PASSWORD=PNSJkxXvVNDAhePMuExTBuRR \
-e TZ=Asia/Jakarta \
-p 3306:3306 \
-v "$PWD/docker/multi-db/conf.d":/etc/mysql/conf.d \
-v "$PWD/storage/docker/multidb-data":/var/lib/mysql \
mysql:8

```

## Login MySQL
```shell
mysql -uroot -p -h127.0.0.1 -P3306 
```