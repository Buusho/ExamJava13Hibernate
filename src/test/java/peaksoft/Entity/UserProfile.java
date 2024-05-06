package peaksoft.Entity;


import jakarta.persistence.*;
import lombok.*;
import org.checkerframework.checker.lock.qual.NewObject;

import java.time.LocalDate;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@SequenceGenerator(name = "id_gen", sequenceName = "user_seq", allocationSize = 1)
public class UserProfile extends BaseEntity {
    @Column(unique = true)
    private String user_name;
    @Column(unique = true)
    private String email;
    @Column(nullable = false)
    private LocalDate registration_date;



    @OneToOne(mappedBy = "userProfile")
    private UserDetails userDetails;
}
