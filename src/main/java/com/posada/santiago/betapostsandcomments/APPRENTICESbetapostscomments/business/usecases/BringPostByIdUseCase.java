package com.posada.santiago.betapostsandcomments.APPRENTICESbetapostscomments.business.usecases;





import com.posada.santiago.betapostsandcomments.APPRENTICESbetapostscomments.business.gateways.DomainViewRepository;
import com.posada.santiago.betapostsandcomments.APPRENTICESbetapostscomments.business.gateways.model.PostViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.function.Function;

@Service
public class BringPostByIdUseCase implements Function<String, Mono<PostViewModel>> {


    @Autowired
    DomainViewRepository viewRepository;

    @Override
    public Mono<PostViewModel> apply(String aggregateId){
        return viewRepository.findByAggregateId(aggregateId);
    }


    // finish the implementation of this class using the functional interfaces
}
