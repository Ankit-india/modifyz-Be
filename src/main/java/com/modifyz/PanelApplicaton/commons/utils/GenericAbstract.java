package com.modifyz.PanelApplicaton.commons.utils;


import java.time.LocalDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class GenericAbstract {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "dateCreated")
    private LocalDateTime dateCreated;

    @Column(name = "isDeleted")
    private boolean isDeleted;

    public GenericAbstract(long id) {
    }

    @PrePersist
    public void prePersist() {
        this.dateCreated = LocalDateTime.now();
    }
}
