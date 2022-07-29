package me.dio.academia.digital.service.impl;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AlunoForm;
import me.dio.academia.digital.entity.form.AlunoUpdateForm;
import me.dio.academia.digital.infra.utils.JavaTimeUtils;
import me.dio.academia.digital.repository.AlunoRepository;
import me.dio.academia.digital.service.IAlunoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class AlunoServiceImpl implements IAlunoService {
    @Autowired
    private AlunoRepository repository;

    public Aluno create(AlunoForm form) {
        Aluno aluno = new Aluno();
        BeanUtils.copyProperties(form,aluno);

        return repository.save(aluno);
    }

    public Aluno get(Long id) {
        return null;
    }

    public List<Aluno> getAll(String dataDeNacimento) {
        if(dataDeNacimento == null){
            return repository.findAll();
        } else {
            LocalDate localDate = LocalDate.parse(dataDeNacimento, JavaTimeUtils.LOCAL_DATE_FORMATTER);
            return repository.findByDataDeNascimento(localDate);
        }
    }

    public Aluno update(Long id, AlunoUpdateForm formUpdate) {
        Aluno aluno = repository.findById(id).get();
        BeanUtils.copyProperties(formUpdate,aluno);

        return repository.save(aluno);
    }

    public void delete(Long id) {
        repository.deleteById(id);
    }

    public List<AvaliacaoFisica> getAllAvaliacaoFisicaId(Long id) {
        Aluno aluno = repository.findById(id).get();
        return aluno.getAvaliacoes();
    }
}
