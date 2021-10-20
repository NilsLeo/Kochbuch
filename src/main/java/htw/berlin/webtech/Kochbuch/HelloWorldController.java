package htw.berlin.webtech.Kochbuch;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HelloWorldController {
    @GetMapping("/hello")
    public String showHelloWorldPage(Model model){
        model.addAttribute("helloName","Hello");
        //Return muss den name/pfad der View zurückgeben(template) die man anzeigen will
        return "helloworld";
    }
}
