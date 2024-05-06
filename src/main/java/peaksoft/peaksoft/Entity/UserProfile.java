package peaksoft.peaksoft.Entity;


import jakarta.persistence.*;
import lombok.*;

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


    @Override
    public String toString() {
        return "UserProfile{" +
                ",idd='" + super.getId() + '\'' +
                "user_name='" + user_name + '\'' +
                ", email='" + email + '\'' +
                ", registration_date=" + registration_date +
                '}';
    }
}
