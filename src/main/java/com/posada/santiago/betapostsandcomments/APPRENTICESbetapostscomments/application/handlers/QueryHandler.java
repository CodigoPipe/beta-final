package com.posada.santiago.betapostsandcomments.APPRENTICESbetapostscomments.application.handlers;


import com.posada.santiago.betapostsandcomments.APPRENTICESbetapostscomments.business.gateways.model.PostViewModel;
import com.posada.santiago.betapostsandcomments.APPRENTICESbetapostscomments.business.usecases.BringAllPostsUseCase;
import com.posada.santiago.betapostsandcomments.APPRENTICESbetapostscomments.business.usecases.BringPostByIdUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RequestPredicates.accept;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;


@Configuration
public class QueryHandler {


    @Bean
    public RouterFunction<ServerResponse> bringPostById(BringPostByIdUseCase useCase){

        return route(
                GET("/bring/post/by/id/{aggregateId}"), request -> {
                    return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                            .body(BodyInserters.fromPublisher(useCase.apply(request.pathVariable("aggregateId")),PostViewModel.class));
                }
        );
    }

    @Bean
    public RouterFunction<ServerResponse> bringAllPosts(BringAllPostsUseCase useCase){

        return route(
                GET("/bring/all/posts").and(accept(MediaType.APPLICATION_JSON)),
                request -> ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                        .body(useCase.get(), PostViewModel.class)
        );
    }
    //Create a route that allows you to make a Get Http request that brings you all the posts and also a post by its id

}
