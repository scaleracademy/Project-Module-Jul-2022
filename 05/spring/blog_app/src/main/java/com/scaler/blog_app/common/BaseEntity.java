package com.scaler.blog_app.common;

import lombok.Setter;
import org.hibernate.annotations.Generated;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public abstract class BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @Column(name = "id", nullable = false)
    private Long id;

    @Setter @UpdateTimestamp
    Date createdAt;

    @Setter @UpdateTimestamp
    Date updatedAt;

}
