package com.nnk.springboot.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;


@Entity
@Table(name = "curvepoint")
public class CurvePoint {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private int id;
    @NotNull(message = "curveId is mandatory")
    @Column(name= "curveId")
    private int curveId;
    @Column(name= "asOfDate")
    private Timestamp asOfDate;
    @NotNull(message = "term is mandatory")
    @Column(name= "term")
    private double term;
    @NotNull(message = "value is mandatory")
    @Column(name= "value")
    private double value;

    @Column(name= "creationDate")
    private Timestamp creationDate;

    public CurvePoint() {
    }

    public CurvePoint(int curveId, double term, double value) {
        this.curveId = curveId;
        this.term = term;
        this.value = value;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCurveId() {
        return curveId;
    }

    public void setCurveId(Integer curveId) {
        this.curveId = curveId;
    }

    public Timestamp getAsIfDate() {
        return asOfDate;
    }

    public void setAsOfDate(Timestamp asOfDate) {
        this.asOfDate = asOfDate;
    }

    public double getTerm() {
        return term;
    }

    public void setTerm(double term) {
        this.term = term;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

}