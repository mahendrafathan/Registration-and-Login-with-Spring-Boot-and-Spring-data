# spring-boot
## Simple spring boot web application step by step

1. Buat project maven web application File -> New -> Project -> Maven Project
2. Setelah terbentuk maven biasanya akah terjadi error masalah runtime nya
    klik kanan pada project -> pilih Project Facet -> klik runtime -> pilih server
3. Masukan dependency untuk spring boot lalu update project
```
<parent>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-parent</artifactId>
	<version>1.5.4.RELEASE</version>
	<relativePath />
</parent>

<properties>
	<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
	<java.version>1.8</java.version>
</properties>

<dependencies>
	<!-- Spring Boot -->
	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-web</artifactId>
	</dependency>
	<!-- Tomcat Embed -->
	<dependency>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-tomcat</artifactId>
		<scope>provided</scope>
	</dependency>

	<!-- JSTL -->
	<dependency>
		<groupId>javax.servlet</groupId>
		<artifactId>jstl</artifactId>
	</dependency>
	<!-- To compile JSP files -->
	<dependency>
		<groupId>org.apache.tomcat.embed</groupId>
		<artifactId>tomcat-embed-jasper</artifactId>
		<scope>provided</scope>
	</dependency>
</dependencies>
```
4. Buat folder src/main/java untuk menampung package yg akan digunakan
5. Buat package di dalam folder java (terserah nama packagenya) kalo saya com.belajar
6. Buat kelas App.java sebagai entry point aplikasi spring boot
7. Buat kelas controller untuk code java com.belajar.controller
8. Buat kelas untuk tes aplikasi
9. Run aplikasi dengan spring-boot:run
> saat run saya mendapat error tentang No compiler is provided in this environment. Perhaps you are running on a JRE rather than a JDK?, cara solve klik windows -> preference -> java -> installed JREs -> Execution Environment lalu pilih salah satu, 
> jika berhasil run, maka aplikasi tersebut berjalan di port 8080, buka localhost:8080/
10. Untuk mengganti port maka harus membuat properties di resources, buat application.properties
```java
## Embedded Server Configuration
server.port = 8091
```
11. Untuk memanggil file jsp maka pada class App.java kita harus menambahkan anotasi baru
```java
@ComponentScan(basePackages={"com.belajar.controller"})
...
```
12. Buat kelas untuk memanggil ke jsp
```java
package com.belajar.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloController {

	@RequestMapping("/hello")
	private String hello(Model model, @RequestParam(value="name", required=false, defaultValue="World") String name) {
		model.addAttribute("name", name); 
		return "index.jsp";
	}
}
```
