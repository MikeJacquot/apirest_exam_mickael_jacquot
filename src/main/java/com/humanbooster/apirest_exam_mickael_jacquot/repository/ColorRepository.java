package com.humanbooster.apirest_exam_mickael_jacquot.repository;

import com.humanbooster.apirest_exam_mickael_jacquot.model.Color;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ColorRepository extends CrudRepository<Color,Long> {

    List<Color> findAll();

    Color findColorById(Long id);

    @Override
    void delete(Color color);


}
