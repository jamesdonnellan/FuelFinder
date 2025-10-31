package ie.atu.cicdproject.ffmainapp;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;



@Data
@AllArgsConstructor

public class FuelStationInformation {

    @NotBlank
    private String stationName;

    @DecimalMin(value = "1.0")
    private double petrolPrice;

    @DecimalMin(value = "1.0")
    private double dieselPrice;

    @NotBlank
    private String location;



}
