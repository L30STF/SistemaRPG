package com.SitemaRPG.SitemaRPG.Controllers;


import com.SitemaRPG.SitemaRPG.Models.ItensMagicoModel;
import com.SitemaRPG.SitemaRPG.Models.PersonagemModel;
import com.SitemaRPG.SitemaRPG.Services.PersonagemService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/personagens")
public class PersonagemController {

    @Autowired
    private PersonagemService personagemService;

    @PostMapping("/Criar-Personagem")
    @Operation(summary = "Criar Personagem", description = "Para criar o personagem voce não precisa de itens magico, então você so precisa colocar"  +
             "nome, força, defesa, nomeAventureiro, level e classePerso. Se for colados outros itens ele dara um erro.")
    public ResponseEntity<PersonagemModel> CriarPersonagem(@RequestBody PersonagemModel personagemModel){
        return ResponseEntity.ok(personagemService.CriarPersonagem(personagemModel));
    }

    @GetMapping("/lista-Personagens")
    @Operation(summary = "Lista de Personagens", description = "Ele dara uma lista de personagens que você criou.")
    public ResponseEntity<List<PersonagemModel>> listarPersonagens(){
        return ResponseEntity.ok(personagemService.listarPesonagens());
    }

    @GetMapping("/{Id}")
    @Operation(summary = "Buscar Personagem por Id" ,description = "Você vai colocar o id do personagem que você quer buscar ")
    public ResponseEntity<PersonagemModel> BuscarporId(@PathVariable Integer Id){
        return personagemService.buscarPorId(Id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @PutMapping("/{id}/nome-aventureiro")
    @Operation(summary = "Atualizar o nome do Aventureiro", description = "Para atualizar o nome é so colocar o id do personagem que você quer trocar o nome e colocar na string.")
    public ResponseEntity<PersonagemModel>atualizarnomeAventureiro(@PathVariable int id , @RequestBody String novoNomeAventureiro){
        return ResponseEntity.ok(personagemService.atualizarNomeAventureiro(id,novoNomeAventureiro));
    }

    @DeleteMapping("/{id}")
    @Operation(summary = "Deletar por Id" ,description = "Você seleciona o id do personagem que você quer deletar")
    public ResponseEntity<PersonagemModel> remover(@PathVariable int id){
        personagemService.remover(id);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/{id}/{itensId}")
    @Operation(summary = "Adicionar o Item por id ", description = "para inserir voce deve inserir o id do personagem e colocar o id do item que voce criou")
    public ResponseEntity<Void>  adicionarItensPorId(@PathVariable int id, @PathVariable int itensId ){
        personagemService.adicionarItem(id,itensId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}/itens/{itensId}")
    @Operation(summary = "Deletar o item do personagem por id", description = "Seleciona o id do personagem e o id do item que você quer tirar do personagem")
    public ResponseEntity<Void> removerItensPorId(@PathVariable int id, @PathVariable int itensId){
        personagemService.removerItem(id,itensId);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/{id}/itens")
    @Operation(summary = "Listar os itens do personagem por Id", description = "Se o personagem tiver mais de um item ele vai listar para você o item do personagem.")
    public ResponseEntity<List<ItensMagicoModel>> listarItens(@PathVariable int id){
        return ResponseEntity.ok(personagemService.listarItensMagicoModels(id));
    }

    @GetMapping("/{id}/amuleto")
    @Operation(summary = "Buscar amuleto do personagem",description = "Você coloca o id do amuleto do personagem e  ele ira buscar")
    public ResponseEntity<ItensMagicoModel>  buscarPorAmuleto(@PathVariable int id){
        return  personagemService.buscarAmuleto(id).
                map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }

}
