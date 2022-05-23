package innowise.helpdesk.historyservice.model;

import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "histories")
public class History {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "histories_id_seq")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "ticket_id")
    private Long ticketId;

    @Column(name = "created", updatable = false)
    @CreationTimestamp
    private LocalDateTime created;

    @Column(name = "action")
    private String action;

    @Column(name = "user_Id")
    private Long userId;

    @Column(name = "description")
    private String description;

}