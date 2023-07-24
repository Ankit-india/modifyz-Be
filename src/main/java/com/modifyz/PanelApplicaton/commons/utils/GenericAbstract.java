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

    // TODO -- need to make Custom unique Id and change datatype from long to String
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    // TODO -- need to find a solution to store readable dateCreate format like currentMilliSeconds
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
