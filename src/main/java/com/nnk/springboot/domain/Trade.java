package com.nnk.springboot.domain;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.sql.Timestamp;


@Entity
@Table(name = "trade")
public class Trade {

    @Id
    private int tradeId;

    @Column(name= "account", length = 100, nullable= false)
    private String account;

    @Column(name= "type", length = 100, nullable= false)
    private String type;

    @Column(name= "buyQuantity", length = 100, nullable= false)
    private double buyQuantity;

    @Column(name= "sellQuantity", length = 100, nullable= false)
    private double sellQuantity;

    @Column(name= "buyPrice", length = 100, nullable= false)
    private double buyPrice;

    @Column(name= "sellPrice", length = 100, nullable= false)
    private double sellPrice;

    @Column(name= "benchmark", length = 100, nullable= false)
    private String benchmark;

    @Column(name= "tradeDate", length = 100, nullable= false)
    private Timestamp tradeDate;

    @Column(name= "security", length = 100, nullable= false)
    private String security;

    @Column(name= "status", length = 100, nullable= false)
    private String status;

    @Column(name= "trader", length = 100, nullable= false)
    private String trader;

    @Column(name= "book", length = 100, nullable= false)
    private String book;

    @Column(name= "creationName", length = 100, nullable= false)
    private String creationName;

    @Column(name= "creationDate", length = 100, nullable= false)
    private Timestamp creationDate;

    @Column(name= "revisionName", length = 100, nullable= false)
    private String revisionName;

    @Column(name= "revisionDate", length = 100, nullable= false)
    private Timestamp revisionDate;

    @Column(name= "dealName", length = 100, nullable= false)
    private String dealName;

    @Column(name= "dealType", length = 100, nullable= false)
    private String dealType;

    @Column(name= "sourceListId", length = 100, nullable= false)
    private String sourceListId;

    @Column(name= "side", length = 100, nullable= false)
    private String side;




    public Integer getTradeId() {
        return tradeId;
    }

    public void setTradeId(Integer tradeId) {
        this.tradeId = tradeId;
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

    public double getBuyQuantity() {
        return buyQuantity;
    }

    public void setBuyQuantity(double buyQuantity) {
        this.buyQuantity = buyQuantity;
    }

    public double getSellQuantity() {
        return sellQuantity;
    }

    public void setSellQuantity(double sellQuantity) {
        this.sellQuantity = sellQuantity;
    }

    public double getBuyPrice() {
        return buyPrice;
    }

    public void setBuyPrice(double buyPrice) {
        this.buyPrice = buyPrice;
    }

    public double getSellPrice() {
        return sellPrice;
    }

    public void setSellPrice(double sellPrice) {
        this.sellPrice = sellPrice;
    }

    public String getBenchmark() {
        return benchmark;
    }

    public void setBenchmark(String benchmark) {
        this.benchmark = benchmark;
    }

    public Timestamp getTradeDate() {
        return tradeDate;
    }

    public void setTradeDate(Timestamp tradeDate) {
        this.tradeDate = tradeDate;
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
