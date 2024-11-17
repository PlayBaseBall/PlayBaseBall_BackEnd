package doubleplay.playbaseball.view.domain.sample.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sample/")
public class SampleController {

    @GetMapping("index")
    public String user(){
        return "sample";
    }
}
