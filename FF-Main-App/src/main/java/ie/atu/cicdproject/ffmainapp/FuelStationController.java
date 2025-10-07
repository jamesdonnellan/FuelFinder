package ie.atu.cicdproject.ffmainapp;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping({"/FuelStationInformation", "/UserInformation"})
@RestController
public class FuelStationController {

    @GetMapping("/hello")
    private String hello()
    {
        return "hello";
    }

} // JD Test comment