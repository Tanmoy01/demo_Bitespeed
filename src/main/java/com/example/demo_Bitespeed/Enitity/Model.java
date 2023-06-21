package com.example.demo_Bitespeed.Enitity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@Entity
@Data
@Table(name = "Result")
public class Model {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int Id;

    private String email;
    @Column(name = "phoneNumber")
    private String phoneNumber;
    private String LinkedId;
    private String linkPrecedence;
    @CreationTimestamp
    @Column(name = "createdAt")
    private Date createdAt;
    @CreationTimestamp
    private Date updatedAt;
    private String  deletedAt;

}
