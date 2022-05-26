package innowise.helpdesk.historyservice.controller;

import innowise.helpdesk.historyservice.dto.HistoryDto;
import innowise.helpdesk.historyservice.service.HistoryService;
import innowise.helpdesk.historyservice.api.IHistoryController;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/histories-service/histories")
@RequiredArgsConstructor
public class HistoryController implements IHistoryController {

    private final HistoryService historyService;

    @Override
    @GetMapping("/{historyId}")
    public HistoryDto getHistory(Long historyId) {
        return historyService.getHistory(historyId);
    }

    @Override
    @GetMapping("/historyByTicketId/{ticketId}")
    public Page<HistoryDto> getHistoriesByTicketId(@PageableDefault(size = 5) Pageable pageable, Long ticketId) {
        return historyService.getHistoriesByTicketId(ticketId,pageable);
    }

}