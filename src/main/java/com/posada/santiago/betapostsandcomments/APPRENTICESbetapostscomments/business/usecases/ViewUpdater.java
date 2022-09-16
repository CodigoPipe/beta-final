package com.posada.santiago.betapostsandcomments.APPRENTICESbetapostscomments.business.usecases;


import com.posada.santiago.betapostsandcomments.APPRENTICESbetapostscomments.application.adapters.bus.RabbitMqEventBus;
import com.posada.santiago.betapostsandcomments.APPRENTICESbetapostscomments.business.gateways.DomainViewRepository;
import com.posada.santiago.betapostsandcomments.APPRENTICESbetapostscomments.business.gateways.model.CommentViewModel;
import com.posada.santiago.betapostsandcomments.APPRENTICESbetapostscomments.business.gateways.model.PostViewModel;
import com.posada.santiago.betapostsandcomments.APPRENTICESbetapostscomments.business.generic.DomainUpdater;
import com.posada.santiago.betapostsandcomments.APPRENTICESbetapostscomments.domain.events.CommentAdded;
import com.posada.santiago.betapostsandcomments.APPRENTICESbetapostscomments.domain.events.PostCreated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;


@Service
public class ViewUpdater extends DomainUpdater {

    public final DomainViewRepository repository;

    @Autowired
    RabbitMqEventBus rabbitMqEventBus;

    public  ViewUpdater(DomainViewRepository repository){
        this.repository = repository;

        listen((PostCreated event) ->{
            PostViewModel post = new PostViewModel(event.aggregateRootId(), event.getAuthor(), event.getTitle(), new ArrayList<>());
            repository.saveNewPost(post).subscribe();
            rabbitMqEventBus.publishPost(post);
        });
        listen((CommentAdded event) -> {
            CommentViewModel comment = new CommentViewModel(event.getId(), event.aggregateRootId(), event.getAuthor(), event.getContent());
            repository.addCommentToPost(comment).subscribe();
            rabbitMqEventBus.publishComment(comment);
        });

    }

}
