package com.example.cathay.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name ="BPI")
@EntityListeners(AuditingEntityListener.class)
@Data
public class BPI {

    @Id
    @Column(name = "ID")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Column(name = "NAME")
    private String name;

    @Column(name = "CODE")
    private String code;

    @Column(name = "SYMBOL")
    private String symbol;

    @Column(name = "RATE")
    private String rate;

    @Column(name = "DESCRIPTION")
    private String description;

    @Column(name = "RATE_FLOAT")
    private Float rate_float;
}
