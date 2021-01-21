package rs.uns.acs.ftn.VehicleService.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import rs.uns.acs.ftn.VehicleService.dto.ExamDTO;
import rs.uns.acs.ftn.VehicleService.model.ExamPOJO;
import rs.uns.acs.ftn.VehicleService.service.ExamService;

import javax.ws.rs.core.MediaType;
import java.util.List;

@RestController
@RequestMapping(value = "/exams/")
public class ExamController {

    @Autowired
    ExamService examService;

    @RequestMapping(value = "hello", produces = "text/html", method = RequestMethod.GET)
    public String hello() {
        System.out.println("********************************************************************************");
        System.out.println("* Neko me nadje");
        System.out.println("********************************************************************************");
        return String.format("<html>" + "<head>" + "<title>TEST</title>" + "</head>" + "<body>" + "<h1>%s</h1>"
                + "</body>" + "</html>", "VehicleService, exam controller");
    }

    @RequestMapping(value = "getAll", produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET)
    public ResponseEntity<List<ExamDTO>> getExams () {
        return new ResponseEntity<List<ExamDTO>>(examService.getExams(), HttpStatus.OK);
    }

    @RequestMapping(value = "add", consumes = MediaType.APPLICATION_JSON, produces = MediaType.APPLICATION_JSON,
                method = RequestMethod.PUT)
    public ResponseEntity<String> addExam (@RequestBody ExamDTO dto) {
        String retVal = examService.add(dto);
        return new ResponseEntity<String> (retVal, HttpStatus.OK);
    }

}
