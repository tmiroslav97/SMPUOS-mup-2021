package rs.uns.acs.ftn.HealthService.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/test")
public class TestController {

    @RequestMapping(value = "/hello", produces = "text/html")
    public String hello() {
        return String.format("<html>" + "<head>" + "<title>TEST</title>" + "</head>" + "<body>" + "<h1>%s</h1>"
                + "</body>" + "</html>", "HealthService");
    }

}
