package com.polynation.server.dto.response;

import com.polynation.server.model.VisitPoint;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class VisitPointResponse {
    private Long id;
    private Long userId;
    private Double lat;
    private Double lon;
    private String label;
    private LocalDateTime createdAt;

    public static VisitPointResponse from(VisitPoint p) {
        VisitPointResponse r = new VisitPointResponse();
        r.id = p.getId();
        r.userId = p.getUser().getId();
        r.lat = p.getLat();
        r.lon = p.getLon();
        r.label = p.getLabel();
        r.createdAt = p.getCreatedAt();
        return r;
    }
}
