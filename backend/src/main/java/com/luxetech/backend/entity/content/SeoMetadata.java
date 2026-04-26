package com.luxetech.backend.entity.content;

import jakarta.persistence.*;
import lombok.*;
import java.util.UUID;

@Entity
@Table(name = "seo_metadata")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SeoMetadata {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(name = "entity_type", length = 50)
    private String entityType; // product, category, blog

    @Column(name = "entity_id")
    private UUID entityId;

    @Column(length = 255)
    private String title;

    @Column(columnDefinition = "TEXT")
    private String description;

    @Column(length = 255)
    private String keywords;

    @Column(name = "og_image")
    private String ogImage;
}
