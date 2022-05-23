package innowise.helpdesk.historyservice.api;

import innowise.helpdesk.historyservice.dto.HistoryDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.PathVariable;

@Api(tags = "Histories")
public interface IHistoryController {

    @ApiOperation(value = "Get History", notes = "Get history information according to url id")
    @ApiImplicitParam(name = "historyId", value = "History ID", required = true, dataType = "Long", paramType = "path")
    HistoryDto getHistory(@PathVariable Long historyId);

    @ApiOperation(value = "Get all histories by ticketId")
    @ApiImplicitParam(name = "ticketId", value = "Ticket ID", required = true, dataType = "Long", paramType = "path")
    Page<HistoryDto> getHistoriesByTicketId(@PageableDefault(size = 5) Pageable pageable, @PathVariable Long ticketId);

}