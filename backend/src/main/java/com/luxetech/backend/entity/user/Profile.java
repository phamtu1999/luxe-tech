package com.luxetech.backend.entity.user;

import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.UUID;

@Entity
@Table(name = "profiles")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Profile {

    @Id
    private UUID id; // References auth.users(id) from Supabase

    @Column(name = "full_name", length = 150)
    private String fullName;

    @Column(name = "phone_number", length = 15)
    private String phoneNumber;

    @Column(name = "avatar_url")
    private String avatarUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "tier_id")
    @Builder.Default
    private MemberTier tier = null;

    @Column(name = "total_spent")
    @Builder.Default
    private BigDecimal totalSpent = BigDecimal.ZERO;

    @Column(length = 20)
    @Builder.Default
    private String role = "CUSTOMER";

    @Column(name = "created_at", updatable = false)
    @Builder.Default
    private OffsetDateTime createdAt = OffsetDateTime.now();
}
