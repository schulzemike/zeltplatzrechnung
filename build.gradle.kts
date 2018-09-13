group = "de.tollefreunde"
version = "0.0.1-SNAPSHOT"


plugins {
  java
  id("org.springframework.boot") version "2.0.5.RELEASE"
}


//configuration of plugins

java {
  sourceCompatibility = JavaVersion.VERSION_1_8
  targetCompatibility = JavaVersion.VERSION_1_8
}

springBoot {
  mainClassName = "de.tollefreunde.zeltplatzrechnung.ZeltplatzrechnungApplication"
}


tasks.getByName<Wrapper>("wrapper") {
  gradleVersion = "4.10.1"
}


//dependencies

repositories {
  mavenCentral()
}

dependencies {

  compile("org.springframework.boot:spring-boot-starter-data-jpa:2.0.5.RELEASE")
  compile("org.springframework.boot:spring-boot-starter-security:2.0.5.RELEASE")
  compile("org.springframework.boot:spring-boot-starter-thymeleaf:2.0.5.RELEASE")
  compile("org.springframework.boot:spring-boot-starter-web:2.0.5.RELEASE")
  compile("org.liquibase:liquibase-core:3.6.2")
  compile("nz.net.ultraq.thymeleaf:thymeleaf-layout-dialect:2.3.0")
  compile("org.thymeleaf.extras:thymeleaf-extras-java8time:3.0.1.RELEASE")

  compileOnly("org.projectlombok:lombok:1.18.2")

  runtime("mysql:mysql-connector-java:8.0.11")
  runtime("org.springframework.boot:spring-boot-devtools:2.0.3.RELEASE")

  testCompile("org.springframework.boot:spring-boot-starter-test:2.0.3.RELEASE")
  testCompile("org.springframework.security:spring-security-test:5.0.6.RELEASE")
}

