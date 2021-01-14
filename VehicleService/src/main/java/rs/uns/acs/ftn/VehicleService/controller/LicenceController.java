package rs.uns.acs.ftn.VehicleService.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/licence")
public class LicenceController {

    @RequestMapping(value = "/hello", produces = "text/html")
    public String hello() {
        System.out.println("********************************************************************************");
        System.out.println("* Neko me nadje");
        System.out.println("********************************************************************************");
        return String.format("<html>" + "<head>" + "<title>TEST</title>" + "</head>" + "<body>" + "<h1>%s</h1>"
                + "</body>" + "</html>", "VehicleService, licence controller");
    }

}
