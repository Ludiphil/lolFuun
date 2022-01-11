package com.example.lolfuun.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

import com.example.lolfuun.model.Lol;
import com.example.lolfuun.payload.LolPost;
import com.example.lolfuun.repository.LolFuunRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@CrossOrigin(origins = "http://localhost:5432")
@RestController
@RequestMapping("/api")
public class LolController {
    private final LolFuunRepository lolRepository;
    @Autowired
    public LolController(LolFuunRepository lolRepository){
        this.lolRepository=lolRepository;
    }

    @GetMapping("")
    public List<Lol> getLols(){
        List<Lol> lols = new ArrayList<>();
        try{
            lols = lolRepository.findAll();
        }catch (Exception e){
            System.out.println(e);
        }
        return lols;
    }

    @PostMapping("")
    public ResponseEntity<Lol> createLol(@RequestBody LolPost lol1){
        try
        {
            Lol lol = lolRepository.save(new Lol(lol1.getIdUser(),lol1.getIdPost()));
            return new ResponseEntity<>(lol, HttpStatus.CREATED);
        }
        catch(Exception e)
        {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    @PutMapping("/{idLol},{idPost}")
    public ResponseEntity<Lol> updateLol(@PathVariable("idLol") long idLol,@PathVariable("idPost") long idPost)
    {
        Optional<Lol> lolData = lolRepository.findById(idLol);

        if(lolData.isPresent())
        {
            Lol lol_ = lolData.get();
            lol_.setIdPost((int) idPost);
            return new ResponseEntity<>(lolRepository.save(lol_), HttpStatus.OK);
        }
        else
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteLol(@PathVariable("id") long idLol)
    {
        try
        {
            lolRepository.deleteById(idLol);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }






}
