package com.youtube.database.model;

import javax.persistence.*;
import java.io.Serializable;

@MappedSuperclass
@Access(AccessType.FIELD)
public class ParentEntity implements Serializable {

    private static final long serialVersionUID = -3913004886850123205L;


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", unique = true, nullable = false)
    private long id;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

}
