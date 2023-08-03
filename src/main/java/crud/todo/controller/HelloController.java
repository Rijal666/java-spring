package crud.todo.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
public class HelloController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String welcome(){
        return "welcome to java spring API!";
    }

}
