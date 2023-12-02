package com.modifyz.dto;

import lombok.Data;

@Data
public class TimeDetailsDto {

    private Time startTime;

    private Time endTime;

    public static interface StartTimeStep {
        EndTimeStep withStartTime(Time startTime);
    }

    public static interface EndTimeStep {
        BuildStep withEndTime(Time endTime);
    }

    public static interface BuildStep {
        TimeDetailsDto build();
    }

    public static class Builder implements StartTimeStep, EndTimeStep, BuildStep {
        private Time startTime;

        private Time endTime;

        private Builder() {
        }

        public static StartTimeStep timeDetailsDto() {
            return new Builder();
        }

        @Override
        public EndTimeStep withStartTime(Time startTime) {
            this.startTime = startTime;
            return this;
        }

        @Override
        public BuildStep withEndTime(Time endTime) {
            this.endTime = endTime;
            return this;
        }

        @Override
        public TimeDetailsDto build() {
            TimeDetailsDto timeDetailsDto = new TimeDetailsDto();
            timeDetailsDto.setStartTime(this.startTime);
            timeDetailsDto.setEndTime(this.endTime);
            return timeDetailsDto;
        }
    }

    @Data
    public class Time {
        private int hours;

        private int minutes;

        private String meridiem;
    }

}

