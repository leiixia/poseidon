package com.nnk.springboot.domain;

import javax.persistence.*;


@Entity
@Table(name = "rating")
public class Rating {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private int id;

    @Column(name= "moodysRating", length = 125)
    private String moodysRating;

    @Column(name= "sandPRating", length= 125)
    private String sandPRating;

    @Column(name= "fitchRating", length= 125)
    private String fitchRating;

    @Column(name= "orderNumber")
    private Integer orderNumber;

    public Rating(){
    }
    public Rating(String moodys_rating, String sand_pRating, String fitch_rating, int orderNumber) {
        this.moodysRating = moodys_rating;
        this.sandPRating = sand_pRating;
        this.fitchRating = fitch_rating;
        this.orderNumber = orderNumber;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getMoodysRating() {
        return moodysRating;
    }

    public void setMoodysRating(String moodysRating) {
        this.moodysRating = moodysRating;
    }

    public String getSandPRating() {
        return sandPRating;
    }

    public void setSandPRating(String sandPRating) {
        this.sandPRating = sandPRating;
    }

    public String getFitchRating() {
        return fitchRating;
    }

    public void setFitchRating(String fitchRating) {
        this.fitchRating = fitchRating;
    }

    public Integer getOrderNumber() {
        return orderNumber;
    }

    public void setOrderNumber(Integer orderNumber) {
        this.orderNumber = orderNumber;
    }

}