package com.java.Desafio.aula3;

import com.java.Desafio.aula3.dto.PecasDTO;
import com.java.Desafio.aula3.entities.Pecas;
import com.java.Desafio.aula3.repository.PecasRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PecasService {

    @Autowired
    private PecasRepository pecasRepository;

    public List<PecasDTO> listarTodos()throws Exception{
        return pecasRepository.findAll().stream().map(p ->{
            return new ModelMapper().map(p, PecasDTO.class);

        }).collect(Collectors.toList());
    }

    public PecasDTO buscarPorId (Long id)throws Exception {
        Optional<Pecas> pecas = pecasRepository.findById(id);
        PecasDTO pecasDTO = new ModelMapper().map(pecas, PecasDTO.class);
        return pecasDTO;
    }

    public void excluir (Long id)throws Exception{
        Pecas pecas = pecasRepository.findById(id).get();
        if(pecas != null){
            pecasRepository.delete(pecas);
        }
    }

    public void salvar (PecasDTO pecasDTO)throws Exception{
        Pecas pecas = new ModelMapper().map(pecasDTO, Pecas.class);
        pecasRepository.save(pecas);
    }



    public List<PecasDTO> buscarTodosSemParam() {
        List<Pecas> pecas1 = pecasRepository.buscarTodosSemParam();
        List<PecasDTO> lista = new ArrayList<>();
        for (Pecas pecas : pecas1){
            PecasDTO pecasDTO = new PecasDTO();
            pecasDTO.setId(pecas.getId());
            pecasDTO.setParteNumber(pecas.getParteNumber());
            pecasDTO.setNomeDaPeca(pecas.getNomeDaPeca());
            pecasDTO.setDescricao(pecas.getDescricao());
            pecasDTO.setAtivo(pecas.getAtivo() ? "ATIVO" : "INATIVO");
            lista.add(pecasDTO);
        }
        return lista;
    }

}

