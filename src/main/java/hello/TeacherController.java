package hello;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@RequestMapping("teachers")
public class TeacherController {


    @RequestMapping("{id}")
    public ResponseEntity<Teacher> get(@PathVariable UUID id) {

        Teacher person = new Teacher();
        person.setResourceId(id);
        person.add(linkTo(methodOn(TeacherController.class).get(id)).withSelfRel());

        return new ResponseEntity<>(person, HttpStatus.OK);

    }

}
