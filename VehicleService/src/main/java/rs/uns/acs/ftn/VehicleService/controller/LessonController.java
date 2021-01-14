package rs.uns.acs.ftn.VehicleService.controller;

import org.bouncycastle.cert.ocsp.Req;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import rs.uns.acs.ftn.VehicleService.dto.AddLessonDTO;
import rs.uns.acs.ftn.VehicleService.dto.UIDDTO;
import rs.uns.acs.ftn.VehicleService.model.LessonPOJO;
import rs.uns.acs.ftn.VehicleService.repository.LessonRepository;
import rs.uns.acs.ftn.VehicleService.service.LessonService;

import javax.ws.rs.HttpMethod;
import javax.ws.rs.core.MediaType;
import java.util.ArrayList;

@RestController
@RequestMapping(value = "/lessons/")
public class LessonController {

    @Autowired
    LessonService lessonService;

    @RequestMapping(value = "hello", produces = "text/html", method = RequestMethod.GET)
    public String hello() {
        System.out.println("********************************************************************************");
        System.out.println("* Neko me nadje");
        System.out.println("********************************************************************************");
        return String.format("<html>" + "<head>" + "<title>TEST</title>" + "</head>" + "<body>" + "<h1>%s</h1>"
                + "</body>" + "</html>", "VehicleService, lesson controller");
    }

    @RequestMapping(value = "getAll", produces = MediaType.APPLICATION_JSON, method = RequestMethod.GET)
    public ArrayList<LessonPOJO> getLessons () {
        return lessonService.getLessons();
    }

    @RequestMapping(value = "add", produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON,
                method = RequestMethod.PUT)
    public ResponseEntity<String> addLesson (@RequestBody AddLessonDTO dto) {
        String retVal = lessonService.addLesson(dto);
        return new ResponseEntity<String>(retVal, HttpStatus.OK);
    }

    @RequestMapping(value = "catTakeExam", produces = MediaType.APPLICATION_JSON, consumes = MediaType.APPLICATION_JSON,
                method = RequestMethod.GET)
    public ResponseEntity<Boolean> canTakeExam (@RequestBody UIDDTO UID) {
        boolean retVal = lessonService.canTakeExam(UID.getUID());
        return new ResponseEntity<Boolean>(retVal, HttpStatus.OK);
    }

}
