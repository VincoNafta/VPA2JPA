package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

@Entity
public class Auto {
    @Id
    @GeneratedValue
    private Long id;
    private String vyrobca;
    private String spz;
    private String model;

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public Auto() {
    }

    public Auto(String vyrobca, String model, String spz) {
        this.vyrobca = vyrobca;
        this.spz = spz;
        this.model = model;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVyrobca() {
        return vyrobca;
    }

    public void setVyrobca(String vyrobca) {
        this.vyrobca = vyrobca;
    }

    public String getSpz() {
        return spz;
    }

    public void setSpz(String spz) {
        this.spz = spz;
    }
}
