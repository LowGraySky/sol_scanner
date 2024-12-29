package web3.solana.scan.service;

import lombok.RequiredArgsConstructor;
import org.springframework.data.redis.connection.ReactiveRedisConnectionFactory;
import org.springframework.data.redis.core.ReactiveRedisOperations;

@RequiredArgsConstructor
public class RedisService {

    private final ReactiveRedisConnectionFactory connectionFactory;
    private final ReactiveRedisOperations<String, Integer> slotNumberRedisOperation;

//    public Mono<Boolean> isExists(int slotNumber) {
//        return connectionFactory.getReactiveConnection()
//                .keyCommands()
//                .exists(new ByteBuffer());
//    }

//    public save() {
//
//    }
//
//    public get() {
//        connectionFactory.getReactiveConnection().
//    }


}
