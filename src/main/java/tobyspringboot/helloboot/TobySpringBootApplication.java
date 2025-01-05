package tobyspringboot.helloboot;


import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServer;
import org.springframework.boot.web.servlet.server.ServletWebServerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;

import java.io.IOException;

public class TobySpringBootApplication {

    public static void main(String[] args) {

        ServletWebServerFactory serverFactory = new TomcatServletWebServerFactory();

        WebServer webserver = serverFactory.getWebServer(servletContext -> {

            HelloController helloController = new HelloController();
            servletContext.addServlet("frontController", new HttpServlet() {
                @Override
                // 요청을 받는 object, 결과 object
                protected void service(HttpServletRequest req, HttpServletResponse resp) throws  IOException {
                    //인증, 보안, 다국어, 공통기능
                    if(req.getRequestURI().equals("/hello") && req.getMethod().equals(HttpMethod.GET.name())) {
                        String name = req.getParameter("name");


                        String result = helloController.hello(name);
                        // 요청에 필요한 3가지 결과문
                        //상태 만들기
                        //없으면 알아서 ok 됨
//                        resp.setStatus(HttpStatus.OK.value());
                        //헤더
                        resp.setHeader(HttpHeaders.CONTENT_TYPE, MediaType.TEXT_PLAIN_VALUE);
                        //헤더바디
                        resp.getWriter().println(result);
                    }
                    else if (req.getRequestURI().equals("/user")) {
                        //
                    }
                    else {
                        resp.setStatus(HttpStatus.NOT_FOUND.value());
                    }
                }
            }).addMapping("/*");


        });

        webserver.start();


    }

}
