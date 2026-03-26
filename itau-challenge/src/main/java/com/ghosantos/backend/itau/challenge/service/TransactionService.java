package com.ghosantos.backend.itau.challenge.service;

import com.ghosantos.backend.itau.challenge.domain.Transaction;
import com.ghosantos.backend.itau.challenge.dto.StatisticsResponse;
import com.ghosantos.backend.itau.challenge.dto.TransactionRequest;
import com.ghosantos.backend.itau.challenge.service.validations.Validation;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.ArrayList;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

@Service
public class TransactionService {

    private final List<Transaction> transactions = new ArrayList<>();
    private final List<Validation> validations;

    public TransactionService(List<Validation> validations) {
        this.validations = validations;
    }

    public void save(TransactionRequest request){
        validations.forEach(v -> v.validate(request));
        transactions.add(new Transaction(request.value(), request.dateTime()));
    }

    public void delete(){
        transactions.clear();
    }

    public StatisticsResponse getStatistics(){
        OffsetDateTime interval = OffsetDateTime.now().minusSeconds(60);

        DoubleSummaryStatistics stats = transactions.stream()
                .filter(t -> t.getDateTime().isAfter(interval))
                .mapToDouble(Transaction::getValue)
                .summaryStatistics();

        if (stats.getCount() == 0){
            return new StatisticsResponse(0L, 0.0, 0.0, 0.0,0.0);
        }

        return new StatisticsResponse(
                stats.getCount(),
                stats.getSum(),
                stats.getAverage(),
                stats.getMin(),
                stats.getMax()
        );
    }
}
