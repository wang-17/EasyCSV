package test;

import com.xykj.easycsv.entity.CsvProperty;

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

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public long getTotalVaccinations() {
        return totalVaccinations;
    }

    public void setTotalVaccinations(long totalVaccinations) {
        this.totalVaccinations = totalVaccinations;
    }

    public long getPeopleVaccinated() {
        return peopleVaccinated;
    }

    public void setPeopleVaccinated(long peopleVaccinated) {
        this.peopleVaccinated = peopleVaccinated;
    }
}
