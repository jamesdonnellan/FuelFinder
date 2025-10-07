package ie.atu.cicdproject.ffmainapp;
import lombok.AllArgsConstructor;
import lombok.Data;



@Data
@AllArgsConstructor

public class FuelStationInformation {

    private String stationName;
    private double petrolPrice;
    private double dieselPrice;
    private String location;



}
