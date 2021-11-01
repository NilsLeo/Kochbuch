package htw.berlin.webtech.Kochbuch.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class KochbuchController {

    @GetMapping(path = "/")
    public ModelAndView showKochbuchPage(){
        return new ModelAndView("Kochbuch");
    }

}
