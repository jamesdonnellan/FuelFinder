package ie.atu.cicdproject.ffmainapp;

import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/stations")
public class FuelStationController {

    private List<FuelStationInformation> stations = new ArrayList<>();

    // Add a new fuel station
    @PostMapping("/add")
    public FuelStationInformation addStation(@Valid @RequestBody FuelStationInformation station) {
        stations.add(station);
        return station;
    }

    // Get all stations
    @GetMapping("/getAll")
    public List<FuelStationInformation> getAllStations() {
        return stations;
    }

    // Search stations by location (e.g. "Galway City")
    @GetMapping("/search")
    public List<FuelStationInformation> searchByLocation(@RequestParam String location) {
        return stations.stream()
                .filter(s -> s.getLocation().equalsIgnoreCase(location))
                .collect(Collectors.toList());
    }

    // Count total stations
    @GetMapping("/count")
    public int countStations() {
        return stations.size();
    }
}
