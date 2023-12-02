package com.modifyz.entities;

import com.modifyz.commons.utils.idGenerator.GenericIdAbstract;
import com.modifyz.constant.Meridiem;
import jakarta.persistence.AttributeOverride;
import jakarta.persistence.AttributeOverrides;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.Data;

@Entity(name = "TimeDetails")
@Table(name = "TimeDetails")
@Data
public class TimeDetails extends GenericIdAbstract {

    @Column(name = "shopId")
    private String shopId;


    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "hours", column = @Column(name = "startHours")),
        @AttributeOverride(name = "minutes", column = @Column(name = "startMinutes")),
        @AttributeOverride(name = "meridiem", column = @Column(name = "startMeridiem"))
    })
    @Enumerated(EnumType.STRING)
    private Time startTime;

    @Embedded
    @AttributeOverrides({
        @AttributeOverride(name = "hours", column = @Column(name = "endHours")),
        @AttributeOverride(name = "minutes", column = @Column(name = "endMinutes")),
        @AttributeOverride(name = "meridiem", column = @Column(name = "endMeridiem"))
    })
    @Enumerated(EnumType.STRING)
    private Time endTime;

    public static interface ShopIdStep {
        StartTimeStep withShopId(String shopId);
    }

    public static interface StartTimeStep {
        EndTimeStep withStartTime(Time startTime);
    }

    public static interface EndTimeStep {
        BuildStep withEndTime(Time endTime);
    }

    public static interface BuildStep {
        TimeDetails build();
    }

    public static class Builder implements ShopIdStep, StartTimeStep, EndTimeStep, BuildStep {
        private String shopId;

        private Time startTime;

        private Time endTime;

        private Builder() {
        }

        public static ShopIdStep timeDetails() {
            return new Builder();
        }

        @Override
        public StartTimeStep withShopId(String shopId) {
            this.shopId = shopId;
            return this;
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
        public TimeDetails build() {
            TimeDetails timeDetails = new TimeDetails();
            timeDetails.setShopId(this.shopId);
            timeDetails.setStartTime(this.startTime);
            timeDetails.setEndTime(this.endTime);
            return timeDetails;
        }
    }

    @Data
    @Embeddable
    public static class Time{

        private int hours;

        private int minutes;

        private Meridiem meridiem;

        public static interface HoursStep {
            MinutesStep withHours(int hours);
        }

        public static interface MinutesStep {
            MeridiemStep withMinutes(int minutes);
        }

        public static interface MeridiemStep {
            BuildStep withMeridiem(Meridiem meridiem);
        }

        public static interface BuildStep {
            Time build();
        }

        public static class Builder implements HoursStep, MinutesStep, MeridiemStep, BuildStep {
            private int hours;

            private int minutes;

            private Meridiem meridiem;

            private Builder() {
            }

            public static HoursStep time() {
                return new Builder();
            }

            @Override
            public MinutesStep withHours(int hours) {
                this.hours = hours;
                return this;
            }

            @Override
            public MeridiemStep withMinutes(int minutes) {
                this.minutes = minutes;
                return this;
            }

            @Override
            public BuildStep withMeridiem(Meridiem meridiem) {
                this.meridiem = meridiem;
                return this;
            }

            @Override
            public Time build() {
                Time time = new Time();
                time.setHours(this.hours);
                time.setMinutes(this.minutes);
                time.setMeridiem(this.meridiem);
                return time;
            }
        }
    }
}
