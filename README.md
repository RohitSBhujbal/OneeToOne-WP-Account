Athor Name :Rohit Bhujbal

# Hibernate One-to-One Mapping 

This repository contains a simple example project demonstrating One-to-One mapping using Hibernate, a popular Java-based ORM framework.

## Overview

The project illustrates a one-to-one relationship between two entities: `Contact` and `Whatsapp`. Each Contact has a unique Whatsapp, and vice versa. The goal is to demonstrate how to set up and manage this relationship using Hibernate.

## Features

- **One-to-One Mapping:** Establish a one-to-one association between `Contact` and `Whatsapp` entities using Hibernate annotations.
- **Hibernate Configuration:** Proper configuration files for Hibernate to connect to a database.
- **CRUD Operations:** Basic CRUD (Create, Read, Update, Delete) operations for both entities.

## Prerequisites

Before you begin, ensure you have the following installed:

- Java JDK (version 17 or lower )
- Maven
- Your preferred IDE (IntelliJ IDEA || Eclipse)
- Database (MySQL)

## Setup

IntelliJ IDEA -> VCS -> Share Project on GITHUB

## Annotations

@Entity: Marks a class as an entity, representing a table in the database.
@Id: Designates a field as the primary key of the entity.
@GeneratedValue(strategy = GenerationType.IDENTITY): Specifies the strategy for generating primary key values (e.g., auto-increment).
@Column(name = "column_name"): Maps a field to a specific column in the database table.
@Table(name = "table_name"): Defines the name of the database table associated with the entity.
@OneToOne: Defines a one-to-one relationship between two entities.
@JoinColumn(name = "foreign_key"): Specifies the name of the foreign key column in a relationship.

## Annotations Example
In this example, the Person and Passport entities are annotated to establish a one-to-one relationship:
@Entity
@Table(name = "Contact")
public class Contact {
    // Other fields

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "address_id")
    private Whatsapp whatsapp;

    // Other methods
}


@Entity
@Table(name = "Whatsapp")
public class Whatsapp {
    // Other fields

    @OneToOne(mappedBy = "Whatsapp")
    private Contact contact;

    // Other methods
}

o Note : These annotations play crucial roles in defining the structure and behavior of entities in a Hibernate-based application.

## Important object of the hibernate file to perform task

1. To develop hibernate operation we have to use following object
a. Configuration  : Configuration object responsible to be hibernate mapping file data on configuration file data
b. SessionFactory : SessionFactory object is responsible to create database platform Session factory objects collect the metadata from the configuration file andestablish the connection with the database
c. Session        : Session object is responsible to perform persistence object
d. Transaction    : Transaction object responsible to commit and rollback DML operation


## Usage
The MainApp class contains the main method to execute the demonstration. After running the application.
check the console for the output and verify that the one-to-one mapping works as expected.

<> Note : Feel free to explore and modify the code according to your needs.



   
