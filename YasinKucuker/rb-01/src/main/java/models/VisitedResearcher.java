package models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.Objects;
@Entity
public class VisitedResearcher extends Instructor{

    private double hourlySalary;

    public VisitedResearcher(){

    }
    public VisitedResearcher(double hourlySalary) {
        this.hourlySalary = hourlySalary;
    }

    public VisitedResearcher(String name, String address, String phoneNumber, double hourlySalary) {
        super(name, address, phoneNumber);
        this.hourlySalary = hourlySalary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        VisitedResearcher that = (VisitedResearcher) o;
        return Double.compare(hourlySalary, that.hourlySalary) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), hourlySalary);
    }

    @Override
    public String toString() {
        return "VisitedResearcher{" +
                "hourlySalary=" + hourlySalary +
                '}';
    }
}
