package com.shihu.demo.springboot.restfull.handler;

import com.shihu.demo.springboot.restfull.model.User;
import com.shihu.demo.springboot.restfull.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
public class UserHandler {
    @Autowired
    UserRepository userRepository;

    public Flux<User> findAll() {

        return Flux.create(cityFluxSink -> {
            userRepository.findAll().forEach(city -> cityFluxSink.next(city));
            cityFluxSink.complete();
        });
    }

    public Mono<Long> insertByUser(User user) {
        return Mono.create(cityMonoSink -> cityMonoSink.success(userRepository.save(user).getId()));
    }

    public Mono<Long> update(User user) {
        return Mono.create(cityMonoSink -> cityMonoSink.success(userRepository.saveAndFlush(user).getId()));
    }

    public Mono<Long> delete(Long id) {
        userRepository.deleteById(id);
        return Mono.create(cityMonoSink -> cityMonoSink.success(id));
    }

    public Mono<User> findById(Long id) {
        return Mono.create(cityMonoSink -> cityMonoSink.success(userRepository.findById(id).get()));
    }
}
