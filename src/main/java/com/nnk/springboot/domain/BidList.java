package com.nnk.springboot.domain;


import org.springframework.beans.factory.annotation.Required;

import javax.persistence.*;
import javax.validation.constraints.Digits;
import javax.validation.constraints.NotBlank;
import java.sql.Date;
import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "bidlist")
public class BidList {


    @Id
    private int BidListId;

    @Column(name= "account", length = 100, nullable= false)
    private String account;

    @Column(name= "type", length= 100, nullable= false)
    private String type;

    @Column(name= "bidQuantity", length= 100, nullable= false)
    private double bidQuantity;

    @Column(name= "askQuantity", length= 100, nullable= false)
    private double askQuantity;

    @Column(name= "bid", length= 100, nullable= false)
    private double bid;

    @Column(name= "ask", length= 100, nullable= false)
    private double ask;

    @Column(name= "benchmark", length= 100, nullable= false)
    private String benchmark;

    @Column(name= "bidListDate", length= 100, nullable= false)
    private Timestamp bidListDate;

    @Column(name= "commentary", length= 100, nullable= false)
    private String commentary;

    @Column(name= "security", length= 100, nullable= false)
    private String security;

    @Column(name= "status", length= 100, nullable= false)
    private String status;

    @Column(name= "trader", length= 100, nullable= false)
    private String trader;

    @Column(name= "book", length= 100, nullable= false)
    private String book;

    @Column(name= "creationName", length= 100, nullable= false)
    private String creationName;

    @Column(name= "creationDate", length= 100, nullable= false)
    private Timestamp creationDate;

    @Column(name= "revisionName", length= 100, nullable= false)
    private String revisionName;

    @Column(name= "revisionDate", length= 100, nullable= false)
    private Timestamp revisionDate;

    @Column(name= "dealName", length= 100, nullable= false)
    private String dealName;

    @Column(name= "dealType", length= 100, nullable= false)
    private String dealType;

    @Column(name= "sourceListId", length= 100, nullable= false)
    private String sourceListId;

    @Column(name= "side",length= 100, nullable= false)
    private String side;



    public Integer getBidListId() {
        return BidListId;
    }

    public void setBidListId(Integer bidListId) {
        this.BidListId = bidListId;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public double getBidQuantity() {
        return bidQuantity;
    }

    public void setBidQuantity(double bidQuantity) {
        this.bidQuantity = bidQuantity;
    }

    public double getAskQuantity() {
        return askQuantity;
    }

    public void setAskQuantity(double askQuantity) {
        this.askQuantity = askQuantity;
    }

    public double getBid() {
        return bid;
    }

    public void setBid(double bid) {
        this.bid = bid;
    }

    public double setAsk() {
        return ask;
    }

    public void setAsk(double ask) {
        this.ask = ask;
    }

    public String getBenchmark() {
        return benchmark;
    }

    public void setBenchmark(String benchmark) {
        this.benchmark = benchmark;
    }

    public Timestamp getBidListDate() {
        return bidListDate;
    }

    public void setBidListDate(Timestamp bidListDate) {
        this.bidListDate = bidListDate;
    }

    public String getCommentary() {
        return commentary;
    }

    public void setCommentary(String commentary) {
        this.commentary = commentary;
    }

    public String getSecurity() {
        return security;
    }

    public void setSecurity(String security) {
        this.security = security;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTrader() {
        return trader;
    }

    public void setTrader(String trader) {
        this.trader = trader;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public String getCreationName() {
        return creationName;
    }

    public void setCreationName(String creationName) {
        this.creationName = creationName;
    }

    public Timestamp getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Timestamp creationDate) {
        this.creationDate = creationDate;
    }

    public String getRevisionName() {
        return revisionName;
    }

    public void setRevisionName(String revisionName) {
        this.revisionName = revisionName;
    }

    public Timestamp getRevisionDate() {
        return revisionDate;
    }

    public void setRevisionDate(Timestamp revisionDate) {
        this.revisionDate = revisionDate;
    }

    public String getDealName() {
        return dealName;
    }

    public void setDealName(String dealName) {
        this.dealName = dealName;
    }

    public String getDealType() {
        return dealType;
    }

    public void setDealType(String dealType) {
        this.dealType = dealType;
    }

    public String getSourceListId() {
        return sourceListId;
    }

    public void setSourceListId(String sourceListId) {
        this.sourceListId = sourceListId;
    }

    public String getSide() {
        return side;
    }

    public void setSide(String side) {
        this.side = side;
    }
}
