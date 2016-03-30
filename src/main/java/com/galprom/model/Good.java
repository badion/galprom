package com.galprom.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "good_table")
public class Good implements Serializable {

    private static final long serialVersionUID = 2L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "bigint")
    private Long id;

    @Column(name = "name", columnDefinition = "varchar")
    private String name;

    @Column(name = "subtitle", columnDefinition = "varchar")
    private String subtitle;

    @Column(name = "imgFN", columnDefinition = "varchar")
    private String imgFN;

    @Column(name = "price", columnDefinition = "bigint")
    private String price;

    @ManyToOne
    @JoinColumn(name="category", nullable=false)
    private Category category;

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getImgFN() {
        return imgFN;
    }

    public void setImgFN(String imgFN) {
        this.imgFN = imgFN;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Good good = (Good) o;

        if (!id.equals(good.id)) return false;
        if (!name.equals(good.name)) return false;
        if (!subtitle.equals(good.subtitle)) return false;
        if (!imgFN.equals(good.imgFN)) return false;
        if (!price.equals(good.price)) return false;
        return category.equals(good.category);

    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + subtitle.hashCode();
        result = 31 * result + imgFN.hashCode();
        result = 31 * result + price.hashCode();
        result = 31 * result + category.hashCode();
        return result;
    }
}
