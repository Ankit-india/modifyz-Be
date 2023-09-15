package com.modifyz.commons.utils.idGenerator;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Id;
import jakarta.persistence.Column;
import jakarta.persistence.PrePersist;

@Data
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class GenericIdAbstract {

    @Id
    private String id;

    @Column(nullable = false, updatable = false)
    private Long dateCreated;

    @Column(nullable = false)
    private boolean isDeleted;

    @PrePersist
    public void prePersist() {
        EntityUniqueIdGenerator entityUniqueIdGenerator = new EntityUniqueIdGenerator();
        this.id = entityUniqueIdGenerator.generateUniqueId();
        this.dateCreated = System.currentTimeMillis();
    }
}
