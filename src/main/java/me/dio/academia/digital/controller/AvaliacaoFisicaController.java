package me.dio.academia.digital.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.BadErrorClass;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaForm;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaUpdateForm;
import me.dio.academia.digital.service.IAvaliacaoFisicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/avaliacoes")
@NoArgsConstructor
@AllArgsConstructor
public class AvaliacaoFisicaController {
    @Autowired
    private IAvaliacaoFisicaService service;

    @ApiOperation(value = "Salva uma nova Avaliação")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Erro no servidor"),
            @ApiResponse(code = 400, message = "Erro do usuário",
                    response = BadErrorClass.class),
            @ApiResponse(code = 404, message = "Serviço não encontrado"),
            @ApiResponse(code = 200, message = "Recuperação bem-sucedida",
                    response = AvaliacaoFisica.class, responseContainer = "Lista") })
    @PostMapping
    public AvaliacaoFisica create(@RequestBody AvaliacaoFisicaForm form){
        return service.create(form);
    }

    @ApiOperation(value = "Lista todas as Avaliações")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Erro no servidor"),
            @ApiResponse(code = 400, message = "Erro do usuário",
                    response = BadErrorClass.class),
            @ApiResponse(code = 404, message = "Serviço não encontrado"),
            @ApiResponse(code = 200, message = "Recuperação bem-sucedida",
                    response = AvaliacaoFisica.class, responseContainer = "Lista") })
    @GetMapping
    public List<AvaliacaoFisica> getAll(){
        return service.getAll();
    }

    @ApiOperation(value = "Lista a Avaliação com o ID informado")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Erro no servidor"),
            @ApiResponse(code = 400, message = "Erro do usuário",
                    response = BadErrorClass.class),
            @ApiResponse(code = 404, message = "Serviço não encontrado"),
            @ApiResponse(code = 200, message = "Recuperação bem-sucedida",
                    response = AvaliacaoFisica.class, responseContainer = "Lista") })
    @GetMapping("/{id}")
    public AvaliacaoFisica get(@PathVariable Long id){
        return service.get(id).get();
    }

    @ApiOperation(value = "Deleta a Avaliação com o ID informado")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Erro no servidor"),
            @ApiResponse(code = 400, message = "Erro do usuário",
                    response = BadErrorClass.class),
            @ApiResponse(code = 404, message = "Serviço não encontrado"),
            @ApiResponse(code = 200, message = "Recuperação bem-sucedida",
                    response = AvaliacaoFisica.class, responseContainer = "Lista") })
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){ service.delete(id);}

    @ApiOperation(value = "Atualiza a Avaliação com o ID informado")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Erro no servidor"),
            @ApiResponse(code = 400, message = "Erro do usuário",
                    response = BadErrorClass.class),
            @ApiResponse(code = 404, message = "Serviço não encontrado"),
            @ApiResponse(code = 200, message = "Recuperação bem-sucedida",
                    response = AvaliacaoFisica.class, responseContainer = "Lista") })
    @PutMapping("/{id}")
    public AvaliacaoFisica update (@PathVariable Long id, @RequestBody @Valid AvaliacaoFisicaUpdateForm formUpdate){
        return service.update(id,formUpdate);
    }
}
