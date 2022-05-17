package innowise.zuevsky.helpdesk.historyservice.controller;

import innowise.zuevsky.helpdesk.historyservice.api.IHistoryController;
import innowise.zuevsky.helpdesk.historyservice.dto.HistoryDto;
import innowise.zuevsky.helpdesk.historyservice.service.HistoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/histories")
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

    @Override
    @PostMapping
    public void saveHistory(@Valid @RequestBody HistoryDto historyDto){
        historyService.saveHistory(historyDto);
    }

}