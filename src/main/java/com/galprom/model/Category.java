package com.galprom.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "categories")
public class Category implements Serializable {

    private static final long serialVersionUID = 1L;

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

    @OneToMany(mappedBy = "category", fetch = FetchType.EAGER, cascade = {CascadeType.ALL}, orphanRemoval = true)
    private List<Grid> grids;

    public List<Grid> getGrids() {
        return grids;
    }

    public void setGrids(List<Grid> grids) {
        this.grids = grids;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Category category = (Category) o;
        if (grids == null) {
            if (category.grids != null)
                return false;
        } else if (!grids.equals(category.grids))
            return false;
        if (id != null ? !id.equals(category.id) : category.id != null) return false;
        if (name != null ? !name.equals(category.name) : category.name != null) return false;
        if (subtitle != null ? !subtitle.equals(category.subtitle) : category.subtitle != null) return false;
        return imgFN != null ? imgFN.equals(category.imgFN) : category.imgFN == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (subtitle != null ? subtitle.hashCode() : 0);
        result = 31 * result + (imgFN != null ? imgFN.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", subtitle='" + subtitle + '\'' +
                ", imgFN='" + imgFN + '\'' +   '}';
    }


    public String getImgFN() {
        return imgFN;
    }

    public void setImgFN(String imgFN) {
        this.imgFN = imgFN;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
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


}
