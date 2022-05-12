package innowise.zuevsky.helpdesk.historyservice.controller;

import innowise.zuevsky.helpdesk.historyservice.api.IHistoryController;
import innowise.zuevsky.helpdesk.historyservice.dto.HistoryDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.security.RolesAllowed;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/historys")
@RequiredArgsConstructor
public class HistoryController implements IHistoryController {

    @GetMapping("/user")
    @RolesAllowed({"USER"})
    public String getProduct(Principal principal) {
        return "Response from History Service, User Id:" + principal.getName();
    }
    @GetMapping("/employee")
    @RolesAllowed({"EMPLOYEE"})
    public String getProductOne(Principal principal) {
        return "EMPLOYEE :" + principal.getName();
    }

    @Override
    @GetMapping("/{historyId}")
    @RolesAllowed({"EMPLOYEE"})
    public HistoryDto getHistory(Long historyId) {
        return null;
    }

    @Override
    @GetMapping("/{ticketId}")
    @RolesAllowed({"EMPLOYEE"})
    public List<HistoryDto> getHistorysByTicketId() {
        return new ArrayList<>();
    }
}