package by.sam.apklimovich.config;

//import by.sam.apklimovich.websocket.WebSocketHandler;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.socket.config.annotation.*;

//@Configuration
//@EnableWebSocketMessageBroker
//public class WebSocketConfig
//        extends AbstractWebSocketMessageBrokerConfigurer {
//
//    @Override
//    public void registerStompEndpoints(StompEndpointRegistry registry) {
//        registry.addEndpoint("/ws").withSockJS();
//    }
//
//    @Override
//    public void configureMessageBroker(MessageBrokerRegistry registry) {
//        registry.enableSimpleBroker("/queue", "/topic");
//        registry.setApplicationDestinationPrefixes("/app");
//    }
//
//}


//@Configuration
//@EnableWebSocketMessageBroker
//public class WebSocketConfig
//        extends AbstractWebSocketMessageBrokerConfigurer {
//
//    @Override
//    public void configureMessageBroker(MessageBrokerRegistry config) {
//        config.enableSimpleBroker("/topic/", "/queue/");
//        config.setApplicationDestinationPrefixes("/app");
//    }
//
////    @Override
////    public void registerStompEndpoints(StompEndpointRegistry registry) {
////        registry.addEndpoint("/greeting");
////    }
//        @Override
//    public void registerStompEndpoints(StompEndpointRegistry registry) {
//        registry.addEndpoint("/ws").withSockJS();
//    }
//}

//@Configuration
//@EnableWebSocket
//@EnableWebMvc
//@EnableScheduling
//@EnableWebSocketMessageBroker
//public class WebSocketConfig extends
//        AbstractWebSocketMessageBrokerConfigurer {
//
//
//    //    @Override
////    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
////        registry.addHandler(new WebSocketHandler(), "/myHandler")
////                .setAllowedOrigins("*");
////    }
////
//    @Override
//    public void registerStompEndpoints(StompEndpointRegistry registry) {
//        registry.addEndpoint("/ws").withSockJS();
//    }
//
//    @Override
//    public void configureMessageBroker(MessageBrokerRegistry registry) {
//        registry.setApplicationDestinationPrefixes("/app");
//        registry.enableSimpleBroker("/topic/", "user/queue/specific-user", "/exchange/");
//        registry.setUserDestinationPrefix("/secured/user");
//    }
//}

//@Configuration
//@EnableWebSocket
//@EnableWebMvc
//@EnableScheduling
@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends
        AbstractWebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/topic/", "/queue/");
        config.setApplicationDestinationPrefixes("/app");
    }


    //    @Override
//    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
//        registry.addHandler(new WebSocketHandler(), "/myHandler")
//                .setAllowedOrigins("*");
//    }
//
    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        registry.addEndpoint("/ws").withSockJS();
    }

//    @Override
//    public void configureMessageBroker(MessageBrokerRegistry registry) {
//        registry.setApplicationDestinationPrefixes("/app");
//        registry.enableSimpleBroker("/chat.sendMessage");
//       // registry.setUserDestinationPrefix("/secured/user");
//    }
}


//import org.springframework.messaging.simp.config.MessageBrokerRegistry;
//import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
//import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
//
//public class SocketBrokerConfig extends
//        AbstractWebSocketMessageBrokerConfigurer {
//
//    @Override
//    public void configureMessageBroker(MessageBrokerRegistry config) {
//        config.enableSimpleBroker("/secured/user/queue/specific-user");
//        config.setApplicationDestinationPrefixes("/spring-security-mvc-socket");
//        config.setUserDestinationPrefix("/secured/user");
//    }
//
//    @Override
//    public void registerStompEndpoints(StompEndpointRegistry registry) {
//        registry.addEndpoint("/secured/room").withSockJS();
//    }
//}


//@Configuration
//@EnableWebSocket
//@ComponentScan("by.sam.apklimovich.websocket")
//public class WebSocketConfig implements WebSocketConfigurer {
//
//    @Autowired
//    private WebSocketHandler myWebSocketHandler;
//
//    @Override
//    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
//        registry.addHandler(myWebSocketHandler, "/socketHandler");
//    }
//
//}

//import org.springframework.context.annotation.Configuration;
//import org.springframework.messaging.simp.config.MessageBrokerRegistry;
//import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
//import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
//import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;
//
//@Configuration
//@EnableWebSocketMessageBroker
//public class WebSocketConfig implements WebSocketMessageBrokerConfigurer {
//
//    @Override
//    public void configureMessageBroker(MessageBrokerRegistry registry) {
//        registry.setApplicationDestinationPrefixes("/app");
//        registry.enableSimpleBroker("/topic");
//    }
//    @Override
//    public void registerStompEndpoints(StompEndpointRegistry registry) {
//        registry.addEndpoint("/chat");
//        registry.addEndpoint("/chat").withSockJS();
//    }
//
//}