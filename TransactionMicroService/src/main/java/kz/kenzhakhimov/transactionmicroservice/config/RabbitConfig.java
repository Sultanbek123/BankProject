package kz.kenzhakhimov.transactionmicroservice.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {
    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange("massExchange");
    }
    @Bean
    public Queue statementQueue(){
        return new Queue("statementQueue",false);
    }
    @Bean
    public Queue analiticQueue(){
        return new Queue("analiticQueue",false);
    }
    @Bean
    public Binding bindingStatement(FanoutExchange fanoutExchange, Queue statementQueue){
        return BindingBuilder.bind(statementQueue).to(fanoutExchange);
    }
    @Bean
    public Binding bindingAnalitic(FanoutExchange fanoutExchange, Queue analiticQueue){
        return BindingBuilder.bind(analiticQueue).to(fanoutExchange);
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
    @Bean
    public RabbitTemplate rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate template = new RabbitTemplate(connectionFactory);
        template.setMessageConverter(jsonMessageConverter());
        return template;
    }
}
