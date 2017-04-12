package hello;

import org.springframework.hateoas.Resource;
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

    @RequestMapping("{name}")
    public ResponseEntity<Resource<ClassRoom>> get(@PathVariable String name) {

        ClassRoom room = new ClassRoom();
        room.setName(name);
        Resource<ClassRoom> resource = new Resource<>(room);
        resource.add(linkTo(methodOn(ClassRoomController.class).get(name)).withSelfRel());

        if("science".equals(name)) {
            Student student = new Student();
            student.setResourceId(UUID.randomUUID());
            student.setName("foo");
            student.add(linkTo(methodOn(StudentController.class).get(student.getResourceId())).withRel("teacher"));


            Teacher teacher = new Teacher();
            teacher.setResourceId(UUID.randomUUID());
            teacher.setName("bar");
            teacher.add(linkTo(methodOn(TeacherController.class).get(teacher.getResourceId())).withRel("teacher"));

            room.setPersons(asList(student, teacher));
        }


        return new ResponseEntity<>(resource, HttpStatus.OK);
    }

}
