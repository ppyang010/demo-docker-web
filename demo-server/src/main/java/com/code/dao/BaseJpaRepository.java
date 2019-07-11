package com.code.dao;

import com.code.domain.model.BaseDomain;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


@NoRepositoryBean
public interface BaseJpaRepository<T extends BaseDomain> extends PagingAndSortingRepository<T, Integer> {

//    @Override
//    @Query("select e from #{#entityName} e where e.isDeleted = false")
//    Optional<T> findById(Integer id);

    @Query("update #{#entityName} e set e.isDeleted = true where e.id = ?1")
    @Transactional(rollbackFor = Exception.class)
    @Modifying
    void logicDelete(Integer id);

    @Transactional(rollbackFor = Exception.class)
    default void logicDelete(T entity) {
        logicDelete(entity.getId());
    }

    @Transactional(rollbackFor = Exception.class)
    default void logicDelete(Iterable<? extends T> entities) {
        entities.forEach(entity -> logicDelete(entity.getId()));
    }
}
