package devdojo.reactive;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import reactor.core.publisher.Mono;
import reactor.test.StepVerifier;

@Slf4j
public class MonoTest {
    @Test
    public void monoSubscriber(){
        String testString = "test";
        Mono<String> monoTest = Mono.just(testString).log();
        monoTest.subscribe();
        StepVerifier.create(monoTest).expectNext("test").verifyComplete();
        log.info("Working as intended");
    }
    @Test
    public void monoSubscriberConsumer(){
        String testString = "test";
        Mono<String> monoTest = Mono.just(testString).log();
        monoTest.subscribe(str -> log.info(str));
        StepVerifier.create(monoTest).expectNext("test").verifyComplete();
        log.info("Working as intended");
    }
    @Test
    public void monoSubscriberConsumerError(){
        String testString = "test";
        Mono<String> monoTest = Mono.just(testString).map(str -> {throw new RuntimeException("Testing mono errors");});
        monoTest.subscribe(null,str-> log.error("expected error"));
        StepVerifier.create(monoTest).expectError(RuntimeException.class).verify();
        log.info("Working as intended");
    }
}
