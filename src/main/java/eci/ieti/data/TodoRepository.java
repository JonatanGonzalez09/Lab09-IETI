package eci.ieti.data;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;

import eci.ieti.data.model.Todo;

public interface TodoRepository extends CrudRepository<Todo, String>{

    Page<Todo> findByDescriptionContaining(String description, Pageable pageable);

    Page<Todo> findByDueDateContaining(String dueDate, Pageable pageable);

    Page<Todo> findByResponsibleContaining(String Responsible, Pageable pageable);

    Page<Todo> findByPriorityContaining(String priority, Pageable pageable);

    Page<Todo> findByStatusContaining(String status, Pageable pageable);
    
}
