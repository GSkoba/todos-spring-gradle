package com.todos.model;

import org.springframework.data.repository.CrudRepository;


public interface TodoRepository extends CrudRepository<Todo,Integer> {

}
