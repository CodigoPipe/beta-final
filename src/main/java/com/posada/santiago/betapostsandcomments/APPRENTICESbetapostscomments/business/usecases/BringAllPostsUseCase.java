package com.posada.santiago.betapostsandcomments.APPRENTICESbetapostscomments.business.usecases;



import com.posada.santiago.betapostsandcomments.APPRENTICESbetapostscomments.business.gateways.DomainViewRepository;
import com.posada.santiago.betapostsandcomments.APPRENTICESbetapostscomments.business.gateways.model.PostViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.function.Supplier;

@Service
public class BringAllPostsUseCase implements Supplier<Flux<PostViewModel>> {

    @Autowired
    DomainViewRepository viewRepository;

    @Override
    public Flux<PostViewModel> get() {
        return viewRepository.findAllPosts();
    }


    //Finish the implementation of this class using the functional interfaces
}
