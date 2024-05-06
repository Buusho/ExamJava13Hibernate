package peaksoft.Entity;

import jakarta.persistence.Entity;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "usersD")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@SequenceGenerator(name = "id_gen",sequenceName = "userD_seq",allocationSize = 1)
public class UserDetails extends BaseEntity {

private String full_name;
private LocalDate date_of_birth;
private String address;

@OneToOne
    private UserProfile userProfile;
}

