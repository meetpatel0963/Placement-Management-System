package com.jobportal.articleservice.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "articles")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Article extends AuditModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String body;
    private String author;
    private String company;
    private int upvotes;

}
