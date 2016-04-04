package com.galprom.model;

import javax.persistence.*;
import java.io.Serializable;


@Entity
@Table(name = "torsion")
public class Torsion implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name",columnDefinition = "varchar(250) character set utf8 collate utf8_general_ci")
    private String name;

    @Column(name = "code_left")
    private String code_left;

    @Column(name = "code_right")
    private String code_right;

    @Column(name = "price")
    private Double price;//UAH

    @Override
    public String toString() {
        return "Torsion{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", code_left='" + code_left + '\'' +
                ", code_right='" + code_right + '\'' +
                ", price=" + price +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Torsion torsion = (Torsion) o;

        if (id != null ? !id.equals(torsion.id) : torsion.id != null) return false;
        if (name != null ? !name.equals(torsion.name) : torsion.name != null) return false;
        if (code_left != null ? !code_left.equals(torsion.code_left) : torsion.code_left != null) return false;
        if (code_right != null ? !code_right.equals(torsion.code_right) : torsion.code_right != null) return false;
        return price != null ? price.equals(torsion.price) : torsion.price == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (code_left != null ? code_left.hashCode() : 0);
        result = 31 * result + (code_right != null ? code_right.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
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

    public String getCode_left() {
        return code_left;
    }

    public void setCode_left(String code_left) {
        this.code_left = code_left;
    }

    public String getCode_right() {
        return code_right;
    }

    public void setCode_right(String code_right) {
        this.code_right = code_right;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
