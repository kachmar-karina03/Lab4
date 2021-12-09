package lpnu.dto;

import lpnu.entity.Item;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.Objects;

public class ItemDTO {
    private Long id;
    @NotBlank
    private String name;
    @NotNull
    private Double price;

    public ItemDTO(){

    }
    public ItemDTO(final Long id, final String name, final Double price){
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Long getId() {
        return id;
    }

    public void setId(final Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(final Double price) {
        this.price = price;
    }


}
