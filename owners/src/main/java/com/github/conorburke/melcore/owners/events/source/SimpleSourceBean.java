package com.github.conorburke.melcore.owners.events.source;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

import com.github.conorburke.melcore.owners.events.model.OwnerChangeModel;
import com.github.conorburke.melcore.owners.utils.UserContext;

@Component
public class SimpleSourceBean {
    private Source source;

    private static final Logger logger = LoggerFactory.getLogger(SimpleSourceBean.class);

    @Autowired
    public SimpleSourceBean(Source source){
        this.source = source;
    }

    public void publishOwnerChange(String action, String ownerId){
       logger.debug("Sending Kafka message {} for Owner Id: {}", action, ownerId);
        OwnerChangeModel change =  new OwnerChangeModel(
                OwnerChangeModel.class.getTypeName(),
                action,
                ownerId,
                UserContext.getCorrelationId());

        source.output().send(MessageBuilder.withPayload(change).build());
    }
}