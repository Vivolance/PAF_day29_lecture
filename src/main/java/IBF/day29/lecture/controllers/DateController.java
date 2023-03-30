package IBF.day29.lecture.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping
public class DateController {

    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
    //Do not do this: why? -> it will be shared between all request. You are not the only person using this!
    //List<String> shoppingCart = new LinkedList<>();
    
    @GetMapping(path="/date")
    public String getDate(@RequestParam String dueDate) {


        // Date format: 2023-03-30
        // yyyy-MM-dd'T'HH:mm
        System.out.printf("----- dueDate: %s\n", dueDate);
        
        try {
        Date date = dateFormat.parse(dueDate);
        System.out.printf(">>>>> date: %s\n", date.toString());

        } catch (Exception ex) {
            ex.printStackTrace();
            return "redirect:/error.html";
        }

        return "redirect:/";
    }

    
}
