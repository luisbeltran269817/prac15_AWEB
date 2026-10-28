package com.example.PokemonAPI.service;

import com.example.PokemonAPI.exception.ResourceNotFoundException;
import com.example.PokemonAPI.model.Pokemon;
import com.example.PokemonAPI.repository.PokemonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PokemonService {

    @Autowired
    private PokemonRepository pokemonRepository;

    public List<Pokemon> obtenerTodos(){
        return pokemonRepository.findAll();
    }

    public Pokemon obtenerPorId(Long id){
        return pokemonRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("El pokemon no existe"));
    }

    public Pokemon crear(Pokemon pokemon){
        return pokemonRepository.save(pokemon);
    }

    //cosas de la tarea
    //actualizar completo PUT
    public Optional<Pokemon> actualizar(Long id, Pokemon pokemon){
        return pokemonRepository.findById(id).map(pokemonExistente ->{
            pokemonExistente.setNombre(pokemon.getNombre());
            pokemonExistente.setTipo(pokemon.getTipo());
            pokemonExistente.setNivel(pokemon.getNivel());
            pokemonExistente.setAtaque(pokemon.getAtaque());
            pokemonExistente.setDefensa(pokemon.getDefensa());
            pokemonExistente.setDescripcion(pokemon.getDescripcion());
            pokemonExistente.setImagenUrl(pokemon.getImagenUrl());

            return pokemonRepository.save(pokemonExistente);
        });
    }

    //actualizar parcial PATCH
    public Optional<Pokemon> actualizarParcialmente(Long id, Pokemon pokemon) {
        return pokemonRepository.findById(id).map(pokemonExistente -> {
            if (pokemon.getNombre() != null) pokemonExistente.setNombre(pokemon.getNombre());
            if (pokemon.getTipo() != null) pokemonExistente.setTipo(pokemon.getTipo());
            if (pokemon.getNivel() != null) pokemonExistente.setNivel(pokemon.getNivel());
            if (pokemon.getAtaque() != null) pokemonExistente.setAtaque(pokemon.getAtaque());
            if (pokemon.getDefensa() != null) pokemonExistente.setDefensa(pokemon.getDefensa());
            if (pokemon.getDescripcion() != null) pokemonExistente.setDescripcion(pokemon.getDescripcion());
            if (pokemon.getImagenUrl() != null) pokemonExistente.setImagenUrl(pokemon.getImagenUrl());

            return pokemonRepository.save(pokemonExistente);
        });
    }

    //borrar pokemon por su id
    //si no es necesario regresar el pokemon eliminado nomas se quita la primera y la ultima linea y se hace void
    public Pokemon borrarPorId(Long id){
        Pokemon borrado = obtenerPorId(id);

        pokemonRepository.deleteById(id);

        return borrado;
    }

    //    private String nombre;
//    private String tipo;
//    private Integer nivel;
//    private Integer ataque;
//    private Integer defensa;
//    private String descripcion;
//    private String imagenUrl;



}
