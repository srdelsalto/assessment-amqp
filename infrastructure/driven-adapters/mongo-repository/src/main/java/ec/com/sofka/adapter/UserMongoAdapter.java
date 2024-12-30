package ec.com.sofka.adapter;

import ec.com.sofka.User;
import ec.com.sofka.config.UserMongoRepository;
import ec.com.sofka.entities.UserEntity;
import ec.com.sofka.gateway.UserRepository;
import ec.com.sofka.mapper.UserMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
public class UserMongoAdapter implements UserRepository {

    private final UserMongoRepository repository;

    public UserMongoAdapter(UserMongoRepository repository) {
        this.repository = repository;
    }

    @Override
    public Mono<User> create(User user) {
        UserEntity userEntity = UserMapper.toEntity(user);
        return repository.save(userEntity).map(UserMapper::fromEntity);
    }

    @Override
    public Flux<User> getAll() {
        return repository.findAll().map(UserMapper::fromEntity);
    }

    @Override
    public Mono<User> findByDocumentId(String documentId) {
        return repository.findByDocumentId(documentId).map(UserMapper::fromEntity);
    }

    @Override
    public Mono<User> findById(String id) {
        return repository.findById(id).map(UserMapper::fromEntity);
    }
}