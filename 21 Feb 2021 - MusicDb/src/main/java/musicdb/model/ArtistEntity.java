package musicdb.model;

import musicdb.model.enums.ArtistEnum;

import javax.persistence.*;

@Entity
@Table(name = "artists")
public class ArtistEntity extends BaseEntity{
    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ArtistEnum name;
    @Column(name="career_information", columnDefinition = "Text")
    private String careerInformation;

    public ArtistEntity() {
    }

    public ArtistEntity(ArtistEnum name, String careerInformation) {
        this.name = name;
        this.careerInformation = careerInformation;
    }

    public ArtistEnum getName() {
        return name;
    }

    public void setName(ArtistEnum name) {
        this.name = name;
    }

    public String getCareerInformation() {
        return careerInformation;
    }

    public void setCareerInformation(String careerInformation) {
        this.careerInformation = careerInformation;
    }
}
