package com.galprom.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "categories")
public class Category implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", columnDefinition = "bigint")
    private Long id;

    @Column(name = "name", columnDefinition = "varchar(250) character set utf8 collate utf8_general_ci")
    private String name;

    @Column(name = "subtitle", columnDefinition = "varchar(250) character set utf8 collate utf8_general_ci")
    private String subtitle;

    @Column(name = "imgFN")
    private String imgFN;

    @Column(name = "link")
    private String link;

    @OneToMany(mappedBy = "category", fetch = FetchType.LAZY, cascade = {CascadeType.ALL}, orphanRemoval = true)
    private List<SubCategory> subCategories;

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
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

    public List<SubCategory> getSubCategories() {
        return subCategories;
    }

    public void setSubCategories(List<SubCategory> subCategories) {
        this.subCategories = subCategories;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", subtitle='" + subtitle + '\'' +
                ", imgFN='" + imgFN + '\'' +
                ", subCategories=" + subCategories +
                '}';
    }
}
