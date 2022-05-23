package innowise.helpdesk.historyservice.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class HistoryDto {

    @ApiModelProperty(notes = "Timestamp")
    private LocalDateTime created;

    @ApiModelProperty(notes = "TicketId ")
    private Long ticketId;

    @ApiModelProperty(notes = "User created")
    private Long userId;

    @ApiModelProperty(notes = "Action")
    private String action;

    @ApiModelProperty(notes = "Description (more detailed information about an action)")
    private String description;

}