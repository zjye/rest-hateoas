package hello;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

import static java.util.Arrays.asList;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@RequestMapping("rooms")
public class ClassRoomController {

    @RequestMapping("{id}")
    public ResponseEntity<ClassRoom> get(@PathVariable String id) {

        ClassRoom room = new ClassRoom();
        room.setResourceId(id);
        room.add(linkTo(methodOn(ClassRoomController.class).get(id)).withSelfRel());

        if("science".equals(id)) {
            Student student = new Student();
            student.setResourceId(UUID.randomUUID());
            student.setName("foo");
            student.add(linkTo(methodOn(StudentController.class).get(student.getResourceId())).withSelfRel());
            student.add(linkTo(methodOn(StudentController.class).getExamResults(student.getResourceId())).withRel("examResults"));


            Teacher teacher = new Teacher();
            teacher.setResourceId(UUID.randomUUID());
            teacher.setName("bar");
            teacher.add(linkTo(methodOn(TeacherController.class).get(teacher.getResourceId())).withSelfRel());

            room.setPersons(asList(student, teacher));
        }

        return new ResponseEntity<>(room, HttpStatus.OK);
    }

}
