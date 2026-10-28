package com.example.PokemonAPI.controller;

import com.example.PokemonAPI.model.Pokemon;
import com.example.PokemonAPI.service.PokemonService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/pokemones")
public class PokemonController {

    @Autowired
    private PokemonService pokemonService;

    @GetMapping
    public List<Pokemon> listar(){
        return pokemonService.obtenerTodos();
    }

    @PostMapping
    public Pokemon crear(@Valid @RequestBody Pokemon pokemon){
        return pokemonService.crear(pokemon);
    }

    @GetMapping("/{id}")
    public Pokemon listarPorId(@PathVariable Long id){
        return pokemonService.obtenerPorId(id);
    }

    //cosas de la tarea
    //actualizar completo PUT
    @PutMapping("/{id}")
    public Pokemon actualizarCompleto(@PathVariable Long id, @Valid @RequestBody Pokemon pokemon){
        return pokemonService.actualizar(id, pokemon).orElse(null);
    }

    //actualizar parcial PATCH
    @PatchMapping("/{id}")
    public Pokemon actualizarParcial(@PathVariable Long id, @Valid @RequestBody Pokemon pokemon){
        return pokemonService.actualizarParcialmente(id, pokemon).orElse(null);
    }

    @DeleteMapping("/{id}")
    public Pokemon borrarPorId(@PathVariable Long id){
        return pokemonService.borrarPorId(id);
    }

}
