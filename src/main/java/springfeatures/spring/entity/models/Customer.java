package springfeatures.spring.entity.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Entity
@Table
public class Customer {
    @Id
    @GeneratedValue
    private Long cid;
    private String name;
    private String surname;
    private Integer age;
}
