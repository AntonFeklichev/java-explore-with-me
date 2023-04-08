package ru.practicum.ewm.stats.viewstats.projections;

public interface ViewStatsProjection {
    String getApp();

    String getUri();

    Long getHits();
}
