package com.SitemaRPG.SitemaRPG.Services;

import com.SitemaRPG.SitemaRPG.Models.ItensMagicoModel;
import com.SitemaRPG.SitemaRPG.Models.TipoItem;
import com.SitemaRPG.SitemaRPG.Repositories.ItensMagicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItensMagicoService {

    @Autowired
    private ItensMagicoRepository itensMagicoRepository;

    public ItensMagicoModel cadastrarItensMagicoModels(ItensMagicoModel itensMagicoModel) {
        if (itensMagicoModel.getTipoItem() == TipoItem.ARMA && itensMagicoModel.getDefesa() != 0 ){
            throw new IllegalArgumentException("Armas não podem ter defesa");
        }
        if (itensMagicoModel.getTipoItem() == TipoItem.ARMADURA && itensMagicoModel.getForca() != 0){
            throw new IllegalArgumentException("Armaduras não podem ter força");
        }
        if (itensMagicoModel.getForca() == 0 && itensMagicoModel.getDefesa() == 0){
            throw new IllegalArgumentException("Item deve ter pelo menos Força e Defesa maior que zero.");
        }
        return itensMagicoRepository.save(itensMagicoModel);
    }

    public List<ItensMagicoModel> listarItensMagicoModels() {
        return itensMagicoRepository.findAll();
    }

    public Optional<ItensMagicoModel> BuscarItensMagicoModelPorId(int id) {
        return itensMagicoRepository.findById(id);
    }
}
