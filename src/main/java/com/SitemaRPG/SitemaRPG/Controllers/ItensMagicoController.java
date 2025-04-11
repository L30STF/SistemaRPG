package com.SitemaRPG.SitemaRPG.Controllers;

import com.SitemaRPG.SitemaRPG.Models.ItensMagicoModel;
import com.SitemaRPG.SitemaRPG.Services.ItensMagicoService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/itens-magicos")
public class ItensMagicoController {

    @Autowired
    private ItensMagicoService itensMagicoService;

    @PostMapping
    @Operation(summary = "Criar o item do personagem",description = "Você cria o item para colocar no personagem," +
             "o AMULETO pode receber força e defesa, mas a ARMA so pode receber forca e a ARMADURA so pode receber defesa")
    public ResponseEntity<ItensMagicoModel>casdastrarItensMagicoModels( @RequestBody ItensMagicoModel itensMagicoModel){
        return ResponseEntity.ok(itensMagicoService.cadastrarItensMagicoModels(itensMagicoModel));
    }

    @GetMapping
    @Operation(summary = "Lisatr itens criados", description = "Vai lisatr os itens que você criou")
    public ResponseEntity<List<ItensMagicoModel>> listarItensMagicoModels(){
        return ResponseEntity.ok(itensMagicoService.listarItensMagicoModels());
    }

    @GetMapping("/{id}")
    @Operation(summary = "Buscar itens por id", description = "Você seleciona um id do item que você quer buscar")
    public ResponseEntity<ItensMagicoModel>  buscarPorId(@PathVariable int id){
        return itensMagicoService.BuscarItensMagicoModelPorId(id)
                .map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
}
