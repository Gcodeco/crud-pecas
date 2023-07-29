package com.java.Desafio.aula3.controller;

import com.java.Desafio.aula3.PecasService;
import com.java.Desafio.aula3.dto.PecasDTO;
import com.java.Desafio.aula3.enums.MensagemEnum;
import com.sun.org.apache.regexp.internal.RE;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.LinkOption;
import java.util.List;

@RestController
@RequestMapping("/pecas")
public class PecasController {


    @Autowired
    private PecasService pecasService;


    @GetMapping("/listar")
    public ResponseEntity listarTodos (){
        try{
            List<PecasDTO> pecas = pecasService.listarTodos();
            return ResponseEntity.ok(pecas);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/buscar")
    public ResponseEntity buscar (@RequestParam("id")Long id){
        try {
            PecasDTO pecasDTO = pecasService.buscarPorId(id);
            return  ResponseEntity.ok(pecasDTO);
        } catch (Exception e) {
            return  ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/excluir/{id}")
    public ResponseEntity excluir (@PathVariable Long id){
        try {
            pecasService.excluir(id);
            return ResponseEntity.ok(MensagemEnum.EXCLUSAO.getValue());
        } catch (Exception e) {
            return  ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/salvar")
    public ResponseEntity salvar (@RequestBody PecasDTO pecasDTO) {
        try {
            pecasService.salvar(pecasDTO);
            return  ResponseEntity.ok(MensagemEnum.INCLUSAO.getValue());
        }catch (Exception e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @PostMapping("/atualizar")
    public ResponseEntity atualizar (@RequestBody PecasDTO pecasDTO) {
        try {
            pecasService.salvar(pecasDTO);
            return ResponseEntity.ok(MensagemEnum.ALTERACAO.getValue());
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }




    @GetMapping("/buscar-ativo")
    public List<PecasDTO> buscarTodosSemParam (){
        return pecasService.buscarTodosSemParam();
    }


}
