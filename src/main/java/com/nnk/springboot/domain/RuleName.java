package com.nnk.springboot.domain;

import org.passay.Rule;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;

@Entity
@Table(name = "rulename")
public class RuleName {

    @Id
    @GeneratedValue(strategy =  GenerationType.AUTO)
    private int id;

    @Column(name= "name", length = 125)
    private String name;

    @Column(name= "description", length = 125)
    private String description;

    @Column(name= "json", length = 125)
    private String json;

    @Column(name= "template", length = 512)
    private String template;

    @Column(name= "sqlStr", length = 125)
    private String sqlStr;

    @Column(name= "sqlPart", length = 125)
    private String sqlPart;

    public RuleName(){
    }

    public RuleName(String name, String description, String json, String template, String sqlStr, String sqlPart) {
        this.name = name;
        this.description = description;
        this.json = json;
        this.template = template;
        this.sqlStr = sqlStr;
        this.sqlPart = sqlPart;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public String getJson() {
        return json;
    }

    public void setJson(String json) {
        this.json = json;
    }

    public String getTemplate() {
        return template;
    }

    public void setTemplate(String template) {
        this.template = template;
    }

    public String getSqlStr() {
        return sqlStr;
    }

    public void setSqlStr(String sqlStr) {
        this.sqlStr = sqlStr;
    }

    public String getSqlPart() {
        return sqlPart;
    }

    public void setSqlPart(String sqlPart) {
        this.sqlPart = sqlPart;
    }

    public RuleName(RuleName ruleName) {
        this.name = ruleName.getName();
        this.description = ruleName.getDescription();
        this.json = ruleName.getJson();
        this.template = ruleName.getTemplate();
        this.sqlStr = ruleName.getSqlStr();
        this.sqlPart = ruleName.getSqlPart();
    }
}

