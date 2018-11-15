1- instructions to build and run Evolvice-task App
	a- clone project from Git : https://github.com/AmrKhalafSaber/java-task.git .
	b- import the project into your IDE: Spring Tool Suite (STS) as maven project.
	c- build project using maven build.
	d- run EvolviceTaskApplication as Spring boot app.

2-Authentication  with (JWT)

send a POST request to http://localhost:8080/login with our user's credentials in the body: {"username":"admin","password":"password"}
and get Authentication value from headers in response then put this header to each request send to App

2- generate documentation for a Spring REST API Swagger 2 (Springfox) 
	a- after run app use open below link in your browser you will see documentation to know how to use apis  
		http://localhost:8080/swagger-ui.html .

3- metrics endpoint.
The http://localhost:8080/actuator/metrics endpoint lists all the metrics that are available for you to track.
To get the details of an individual metric, you need to pass the metric name in the URL like this -
http://localhost:8080/actuator/metrics/{MetricName}.

For example, to get the details of system.cpu.usage metric, use the URL 
http://localhost:8080/actuator/metrics/system.cpu.usage

Note: if ther is any anything not clear please back to me.

Author: Amr Khalaf Saber.
email: amr.kh.saber@gmail.com.
mobile: 201018286411. 