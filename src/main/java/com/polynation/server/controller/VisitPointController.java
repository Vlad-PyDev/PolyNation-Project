package com.polynation.server.controller;

import com.polynation.server.dto.request.VisitPointRequest;
import com.polynation.server.dto.response.ApiResponse;
import com.polynation.server.dto.response.VisitPointResponse;
import com.polynation.server.service.VisitPointService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/visit-points")
@CrossOrigin(origins = "*")
@RequiredArgsConstructor
public class VisitPointController {

    private final VisitPointService visitPointService;

    // GET /api/visit-points/user/{userId}
    // Получить все точки визита пользователя
    @GetMapping("/user/{userId}")
    public ResponseEntity<ApiResponse<List<VisitPointResponse>>> getByUser(@PathVariable Long userId) {
        return ResponseEntity.ok(ApiResponse.ok(visitPointService.getByUser(userId)));
    }

    // POST /api/visit-points
    // Добавить точку визита { "userId": 1, "lat": 55.75, "lon": 37.61, "label": "Москва" }
    @PostMapping
    public ResponseEntity<ApiResponse<VisitPointResponse>> create(@Valid @RequestBody VisitPointRequest req) {
        return ResponseEntity.ok(ApiResponse.ok("Точка визита добавлена", visitPointService.create(req)));
    }

    // DELETE /api/visit-points/{id}
    // Удалить точку визита
    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Void>> delete(@PathVariable Long id) {
        visitPointService.delete(id);
        return ResponseEntity.ok(ApiResponse.ok("Точка визита удалена", null));
    }
}
