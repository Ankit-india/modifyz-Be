package com.modifyz.shopDetails.dto;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ChairInfo implements Serializable {
    private String chairId;
    private final boolean[] chairAvailability = new boolean[168];

    public static interface ChairIdStep {
        BuildStep withChairId(String chairId);
    }

    public static interface BuildStep {
        ChairInfo build();
    }

    public static class Builder implements ChairIdStep, BuildStep {
        private String chairId;

        private Builder() {
        }

        public static ChairIdStep chairInfo() {
            return new Builder();
        }

        @Override
        public BuildStep withChairId(String chairId) {
            this.chairId = chairId;
            return this;
        }

        @Override
        public ChairInfo build() {
            return new ChairInfo(
                this.chairId
            );
        }
    }
}
