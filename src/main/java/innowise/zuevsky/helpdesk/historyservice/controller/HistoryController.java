package innowise.zuevsky.helpdesk.historyservice.controller;

import innowise.zuevsky.helpdesk.historyservice.api.IHistoryController;
import innowise.zuevsky.helpdesk.historyservice.dto.HistoryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/historys")
@RequiredArgsConstructor
public class HistoryController implements IHistoryController {

    @GetMapping("/message")
    public String test() {
        return "message";
    }


    @Override
    @GetMapping("/{historyId}")
    public HistoryDto getHistory(Long historyId) {
        return null;
    }

    @Override
    @GetMapping("/{ticketId}")
    public List<HistoryDto> getHistorysByTicketId() {
        return new ArrayList<>();
    }
}
