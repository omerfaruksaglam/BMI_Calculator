/**
 * @author Ömer Faruk Sağlam
 * @date 12.05.2023
 * @description This is an entity class for view_bmi_details.
 */
package com.example.bmi_app.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class ViewEntity {
    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "weight")
    private double weight;

    @Column(name = "height")
    private double height;

    public ViewEntity(Long id, double weight, double height) {
        this.id = id;
        this.weight = weight;
        this.height = height;
    }

    public ViewEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

// this class get only bmi with view. !
}