package com.SitemaRPG.SitemaRPG.Services;

import com.SitemaRPG.SitemaRPG.Models.ItensMagicoModel;
import com.SitemaRPG.SitemaRPG.Models.PersonagemModel;
import com.SitemaRPG.SitemaRPG.Models.TipoItem;
import com.SitemaRPG.SitemaRPG.Repositories.ItensMagicoRepository;
import com.SitemaRPG.SitemaRPG.Repositories.PersonagemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonagemService {

    @Autowired
    private PersonagemRepository personagemRepository;

    @Autowired
    private ItensMagicoRepository itensMagicoRepository;


    public PersonagemModel CriarPersonagem(PersonagemModel personagem) {
        if(personagem.getForca() + personagem.getDefesa() >10){
            throw new IllegalArgumentException("A soma de Força e defesa não pode ser maior que 10.");
        }
        return personagemRepository.save(personagem);
    }

    public List<PersonagemModel>listarPesonagens(){
        return personagemRepository.findAll();
    }

    public Optional<PersonagemModel> buscarPorId(Integer id){
        return personagemRepository.findById(id);
    }

    public PersonagemModel atualizarNomeAventureiro(int id, String novoNome) {
        PersonagemModel personagemModel = personagemRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Personagem não encontrado."));
        personagemModel.setNomeAventureiro(novoNome);
        return personagemRepository.save(personagemModel);
    }

    public void remover(int id){
        personagemRepository.deleteById(id);
    }

    public void adicionarItem( int personagemId, int itemId){
        PersonagemModel personagemModel = personagemRepository.findById(personagemId)
                .orElseThrow(()->  new IllegalArgumentException("Pesronagem não encontrado."));
        ItensMagicoModel item = itensMagicoRepository.findById(itemId)
                .orElseThrow(()-> new IllegalArgumentException("Item nao encontrado"));

        if (item.getTipoItem() == TipoItem.AMULETO && personagemModel.getItensMagicoModels().stream().anyMatch(i -> i.getTipoItem() == TipoItem.AMULETO)) {
            throw new IllegalArgumentException("Personagem ja possui um amuleto.");
        }
        personagemModel.getItensMagicoModels().add(item);
        personagemRepository.save(personagemModel);
    }

    public void removerItem(int personagemId, int itemId){
        PersonagemModel personagemModel = personagemRepository.findById(personagemId)
                .orElseThrow(()-> new IllegalArgumentException("Pesrsonagem nao encontrado."));
        ItensMagicoModel itensMagicoModel = itensMagicoRepository.findById(itemId)
                .orElseThrow(()-> new IllegalArgumentException("Item nao encontrado."));
        personagemModel.getItensMagicoModels().remove(itensMagicoModel);
        personagemRepository.save(personagemModel);
    }

    public List<ItensMagicoModel> listarItensMagicoModels(int personagemId) {
        PersonagemModel personagemModel= personagemRepository.findById(personagemId)
                .orElseThrow(()-> new IllegalArgumentException("Pesrsonagem nao encontrado."));
        return personagemModel.getItensMagicoModels();
    }

    public Optional<ItensMagicoModel> buscarAmuleto(int personagemId){
        PersonagemModel personagemModel =personagemRepository.findById(personagemId)
                .orElseThrow(()-> new IllegalArgumentException("Pesrsonagem nao encontrado."));
        return personagemModel.getItensMagicoModels().stream()
                .filter(i-> i.getTipoItem() == TipoItem.AMULETO).findFirst();
    }
}
