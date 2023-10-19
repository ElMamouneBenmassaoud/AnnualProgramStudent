package g58112.webg5.bmi.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import g58112.webg5.bmi.model.BMIResponse;
import g58112.webg5.bmi.service.BMIService;
import lombok.extern.slf4j.Slf4j;

@RestController
@Slf4j
@RequestMapping("/api/bmi")
public class BMIRest {
    @Autowired
    private BMIService bmiService;

    @GetMapping
    public BMIResponse bmi(
                            @RequestParam int height,
                            @RequestParam int weight,
                            @RequestParam String gender) {
        log.info("Rest: calcul du BMI");
        double bmi = bmiService.computeBMI(height, weight);
        String corpulence = bmiService.computeCategory(bmi, gender);
        return new BMIResponse(bmi, corpulence);
    }
}

