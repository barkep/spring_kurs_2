package com.kurs.spring.kepka.toDo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface ToDoRepository extends JpaRepository<ToDo, Integer> {

}
