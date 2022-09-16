package com.posada.santiago.betapostsandcomments.APPRENTICESbetapostscomments.business.gateways;

import com.posada.santiago.betapostsandcomments.APPRENTICESbetapostscomments.business.gateways.model.CommentViewModel;
import com.posada.santiago.betapostsandcomments.APPRENTICESbetapostscomments.business.gateways.model.PostViewModel;

public interface EventBus {

    //void publish(DomainEvent event);

    void publishPost(PostViewModel post);

    void publishComment(CommentViewModel comment);

    void publishError(Throwable errorEvent);
}
