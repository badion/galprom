package com.galprom.model.product;

import com.galprom.model.SubCategory;

import javax.persistence.*;

@Entity
@Table(name="Product")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="fromClass", discriminatorType=DiscriminatorType.STRING)
public abstract class Product {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column(name = "id", columnDefinition = "bigint")
    private Long id;

    @Column(name = "name", columnDefinition = "varchar(250) character set utf8 collate utf8_general_ci")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @JoinColumn(name = "subcategory")
    private SubCategory subcategory;

    @Lob
    @Column(name="image", columnDefinition="longblob")
    private byte[] image;

    public SubCategory getSubcategory() {
        return subcategory;
    }

    public void setSubcategory(SubCategory subcategory) {
        this.subcategory = subcategory;
    }

    @Column(name = "fromClass", insertable = false, updatable = false)
    private String fromClass;

    private Double price;

    public String getApType() {
        return fromClass;
    }

    public void setFromClass(String fromClass) {
        this.fromClass = fromClass;
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

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", fromClass='" + fromClass + '\'' +
                ", price=" + price +
                '}';
    }

    public String getFromClass() {
        return fromClass;
    }
}
