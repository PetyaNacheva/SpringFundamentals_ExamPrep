package musicdb.model.binding;

import musicdb.model.ArtistEntity;
import musicdb.model.UserEntity;
import musicdb.model.enums.ArtistEnum;
import musicdb.model.enums.Genre;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.time.LocalDate;

public class AlbumBindingModel {
    @NotBlank(message = "name is required")
    @Size(min = 3, max = 20, message = "name must be between 3 and 20 chars")
    private String name;
    @NotBlank(message = "img is required")
    @Size(min = 5, message = "url must be at least 5 chars")
    private String imgUrl;
    @NotBlank(message = "descriiption is requred")
    @Size(min = 5, message = "must be at least 5 chars")
    private String description;

    @Positive(message = "must be positive number")
    private int copies;
    @DecimalMin(value = "0", message = "must be positive ")
    private BigDecimal price;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @PastOrPresent(message = "date must be valid")
    private LocalDate releaseDate;

    @NotBlank(message = "producer is required")
    private String producer;
    @NotNull(message = "genre is required")
    private Genre genre;
    @NotNull(message = "artist is required")
    private ArtistEnum artist;

    public AlbumBindingModel() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getCopies() {
        return copies;
    }

    public void setCopies(int copies) {
        this.copies = copies;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public LocalDate getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDate releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public ArtistEnum getArtist() {
        return artist;
    }

    public void setArtist(ArtistEnum artist) {
        this.artist = artist;
    }
}
