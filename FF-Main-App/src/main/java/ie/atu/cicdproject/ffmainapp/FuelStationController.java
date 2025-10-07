package ie.atu.cicdproject.ffmainapp;


import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;


@RequestMapping({"/FuelStationInformation", "/UserInformation", "/api/stations"})
@RestController
public class FuelStationController
{

    List<FuelStationInformation> myList = new ArrayList<>();

    //So this would be /products/count

    @GetMapping("/count")
    public int countProducts() {
        return myList.size();
    }


    @GetMapping("/getFuelStations")
    public List<FuelStationInformation> getFuelStations()
    {
        FuelStationInformation myFuelStationInformation = new FuelStationInformation("TV", 499);
        return myList;
    }
    //with @PostMapping you can add to the other Mappings
    @PostMapping("/addFuelStationInformation")
    public FuelStationInformation addProduct(@Valid @RequestBody FuelStationInformation myFuelStationInformation)
    {
        myList.add(myFuelStationInformation);
        return myFuelStationInformation;
    }
}
//@Valid checks for errors
// JD Test comment
