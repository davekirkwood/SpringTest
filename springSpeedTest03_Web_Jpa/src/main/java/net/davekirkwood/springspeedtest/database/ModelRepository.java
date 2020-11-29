package net.davekirkwood.springspeedtest.database;

import org.springframework.data.repository.CrudRepository;

import net.davekirkwood.springspeedtest.model.Model;

public interface ModelRepository extends CrudRepository<Model, Integer> {

}
