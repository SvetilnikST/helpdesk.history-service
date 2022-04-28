package innowise.zuevsky.helpdesk.historyservice.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "historys")
public class History {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "historys_id_seq")
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "ticket_id")
    private Long ticketId;

    @Column(name = "created", updatable = false)
    @CreationTimestamp
    private LocalDateTime created;

    private String action;

    @Column(name = "user_Id")
    private Long userId;

    @Column(name = "description")
    private String description;

}