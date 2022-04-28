package innowise.zuevsky.helpdesk.historyservice.api;

import innowise.zuevsky.helpdesk.historyservice.dto.HistoryDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Api(tags = "Historys")
@Controller
public interface IHistoryController {

    @ApiOperation(value = "Get History", notes = "Get history information according to url id")
    @ApiImplicitParam(name = "historyId", value = "History ID", required = true, dataType = "Long", paramType = "path")
    HistoryDto getHistory(@PathVariable Long historyId);

    @ApiOperation(value = "Get historys by ticketId")
    List<HistoryDto> getHistorysByTicketId();


}
