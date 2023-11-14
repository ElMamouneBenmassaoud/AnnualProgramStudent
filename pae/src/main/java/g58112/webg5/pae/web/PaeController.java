package g58112.webg5.pae.web;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PaeController {

    @GetMapping("/")
    public String home(){
        return "home";
    }
}
