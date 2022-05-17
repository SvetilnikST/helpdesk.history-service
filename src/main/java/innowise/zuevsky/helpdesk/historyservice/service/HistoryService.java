package innowise.zuevsky.helpdesk.historyservice.service;

import innowise.zuevsky.helpdesk.historyservice.dto.HistoryDto;
import innowise.zuevsky.helpdesk.historyservice.exception.HistoryNotFoundException;
import innowise.zuevsky.helpdesk.historyservice.mapper.HistoryMapper;
import innowise.zuevsky.helpdesk.historyservice.repository.HistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import static innowise.zuevsky.helpdesk.historyservice.specification.HistorySpecification.hasTicketId;
import static org.springframework.data.jpa.domain.Specification.where;

@Service
@RequiredArgsConstructor
public class HistoryService {
    private final HistoryRepository historyRepository;
    private final HistoryMapper historyMapper;

    public HistoryDto getHistory(Long historyId) {
        return historyRepository.findById(historyId).map(historyMapper::mapHistoryToSaveHistoryDto)
                .orElseThrow(() -> new HistoryNotFoundException(historyId));
    }

    public Page<HistoryDto> getHistoriesByTicketId(Long ticketId, Pageable pageable) {
        return historyRepository.findAll(where(hasTicketId(ticketId)), pageable)
                .map(historyMapper::mapHistoryToSaveHistoryDto);
    }

    @Transactional
    public void saveHistory(HistoryDto historyDto) {
        historyRepository.save(historyMapper.mapHistoryDtoToHistory(historyDto));
    }

}