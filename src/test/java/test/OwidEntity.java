package test;

import com.xykj.easycsv.entity.CsvProperty;
import lombok.Data;

@Data
public class OwidEntity {
    @CsvProperty("iso_code")
    String code;
    @CsvProperty("continent")
    String continent;
    @CsvProperty("location")
    String location;
    @CsvProperty("date")
    String date;
    @CsvProperty("total_vaccinations")
    long totalVaccinations;
    @CsvProperty("people_vaccinated")
    long peopleVaccinated;
}
