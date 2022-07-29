package me.dio.academia.digital.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.BadErrorClass;
import me.dio.academia.digital.entity.Matricula;
import me.dio.academia.digital.entity.form.MatriculaForm;
import me.dio.academia.digital.service.IMatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/matriculas")
@NoArgsConstructor
@AllArgsConstructor
public class MatriculaController {
    @Autowired
    private IMatriculaService service;

    @ApiOperation(value = "Salva uma nova Matrícula")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Erro no servidor"),
            @ApiResponse(code = 400, message = "Erro do usuário",
                    response = BadErrorClass.class),
            @ApiResponse(code = 404, message = "Serviço não encontrado"),
            @ApiResponse(code = 200, message = "Recuperação bem-sucedida",
                    response = AvaliacaoFisica.class, responseContainer = "Lista") })
    @PostMapping
    public Matricula create(@RequestBody @Valid MatriculaForm form){
        return service.create(form);
    }

    @ApiOperation(value = "Lista a Matrícula com o ID informado")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Erro no servidor"),
            @ApiResponse(code = 400, message = "Erro do usuário",
                    response = BadErrorClass.class),
            @ApiResponse(code = 404, message = "Serviço não encontrado"),
            @ApiResponse(code = 200, message = "Recuperação bem-sucedida",
                    response = AvaliacaoFisica.class, responseContainer = "Lista") })
    @GetMapping("/{id}")
    public Matricula get(@PathVariable Long id){
        return service.get(id);
    }

    @ApiOperation(value = "Lista todas as Matrículas, ou todas as matrículas que o aluno more no bairro informado")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Erro no servidor"),
            @ApiResponse(code = 400, message = "Erro do usuário",
                    response = BadErrorClass.class),
            @ApiResponse(code = 404, message = "Serviço não encontrado"),
            @ApiResponse(code = 200, message = "Recuperação bem-sucedida",
                    response = AvaliacaoFisica.class, responseContainer = "Lista") })
    @GetMapping
    public List<Matricula> getAll(@RequestParam(value = "bairro", required = false) String bairro){
        return service.getAll(bairro);
    }

    @ApiOperation(value = "Deleta a Matícula com o ID informado")
    @ApiResponses(value = {
            @ApiResponse(code = 500, message = "Erro no servidor"),
            @ApiResponse(code = 400, message = "Erro do usuário",
                    response = BadErrorClass.class),
            @ApiResponse(code = 404, message = "Serviço não encontrado"),
            @ApiResponse(code = 200, message = "Recuperação bem-sucedida",
                    response = AvaliacaoFisica.class, responseContainer = "Lista") })
    @DeleteMapping("/{id}")
    public void delete(Long id){
        service.delete(id);
    }
}
