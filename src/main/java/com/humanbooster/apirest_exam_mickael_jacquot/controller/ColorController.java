package com.humanbooster.apirest_exam_mickael_jacquot.controller;

import com.humanbooster.apirest_exam_mickael_jacquot.model.Color;
import com.humanbooster.apirest_exam_mickael_jacquot.model.Color;
import com.humanbooster.apirest_exam_mickael_jacquot.repository.ColorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/colors")
public class ColorController {

    @Autowired
    private ColorRepository cr;

    @GetMapping("")
    public List<Color> getAll() {
        return this.cr.findAll();
    }

    @GetMapping(value = "{Colors}", produces = {"application/json"})
    public Color getOne(@PathVariable(name = "Colors", required = false) Color Color) {
        if (Color == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No such Color");
        }

        return Color;
    }

    @PostMapping(value="",produces = {"application/json"}, consumes = {"application/json"})
    public ResponseEntity<Color> createColor(@Valid @RequestBody Color Color) {

        this.cr.save(Color);
        return new ResponseEntity<Color>(Color, HttpStatus.CREATED);

    }

    @PutMapping(value = "{Colors}", produces = {"application/json"},consumes = {"application/json"})
    public ResponseEntity<Color> UpdateOne(@RequestBody Color ColorUpdate, @PathVariable(name = "Colors", required = false) Color Color) {
        if (Color == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No such Color");
        }

        ColorUpdate.setId(Color.getId());
        this.cr.save(ColorUpdate);

        return new ResponseEntity<Color>(Color, HttpStatus.OK);


    }

    @DeleteMapping(value = "{Colors}")
    public String deleteColor(@PathVariable(name = "Colors", required = false) Color Color) {
        if (Color == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Color not in bdd");
        } else {

            this.cr.delete(Color);
            return "delete Color " + Color.getLibelle() + " successfull";
        }
    }



}
