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
  gradleVersion = "6.2"
}


//dependencies

repositories {
  mavenCentral()
}

dependencies {

  implementation("org.springframework.boot:spring-boot-starter-data-jpa:2.0.5.RELEASE")
  implementation("org.springframework.boot:spring-boot-starter-security:2.0.5.RELEASE")
  implementation("org.springframework.boot:spring-boot-starter-thymeleaf:2.0.5.RELEASE")
  implementation("org.springframework.boot:spring-boot-starter-web:2.0.5.RELEASE")
  implementation("org.liquibase:liquibase-core:3.6.2")
  implementation("nz.net.ultraq.thymeleaf:thymeleaf-layout-dialect:2.3.0")
  implementation("org.thymeleaf.extras:thymeleaf-extras-java8time:3.0.1.RELEASE")

  implementation("org.webjars:bootstrap:4.1.1")
  implementation("org.webjars:jquery:3.3.1-1")

  compileOnly("org.projectlombok:lombok:1.18.2")

  implementation("mysql:mysql-connector-java:8.0.11")
  runtimeOnly("org.springframework.boot:spring-boot-devtools:2.0.3.RELEASE")

  testImplementation("com.h2database:h2:1.4.197")
  testImplementation("org.springframework.boot:spring-boot-starter-test:2.0.3.RELEASE")
  testImplementation("org.springframework.security:spring-security-test:5.0.6.RELEASE")
  testImplementation("org.assertj", "assertj-core", "3.15.0")
}

