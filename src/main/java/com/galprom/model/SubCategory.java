package com.galprom.model;

import com.galprom.model.product.Product;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "SubCategory")
public class SubCategory implements Comparable<SubCategory> {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "bigint")
    private Long id;

    private String name;

    private String description;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @Column(name = "imgFN")
    private String imgFN;

    @Lob
    @Column(name="image", nullable=false, columnDefinition="longblob")
    private byte[] image;

    @OneToMany(mappedBy = "subcategory", fetch = FetchType.LAZY, cascade = {CascadeType.ALL}, orphanRemoval = true)
    private List<Product> products;

    public String getImgFN() {
        return imgFN;
    }

    public void setImgFN(String imgFN) {
        this.imgFN = imgFN;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "SubCategory{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    @Override
    public int compareTo(SubCategory o) {
        return name.compareTo(o.name);
    }
}
