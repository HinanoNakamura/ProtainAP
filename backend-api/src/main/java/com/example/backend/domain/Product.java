package com.example.backend.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "products")
@Data
public class Product {

@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)

private Integer Favoriteid;

private Integer userid;

private Integer proteinid;

}