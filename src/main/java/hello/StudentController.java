package hello;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@RequestMapping("students")
public class StudentController {


    @RequestMapping("{id}")
    public HttpEntity<Student> get(
            @PathVariable(value = "id") UUID id) {

        Student person = new Student();
        person.setResourceId(id);
        person.add(linkTo(methodOn(StudentController.class).get(id)).withSelfRel());


        return new ResponseEntity<>(person, HttpStatus.OK);
    }
}
