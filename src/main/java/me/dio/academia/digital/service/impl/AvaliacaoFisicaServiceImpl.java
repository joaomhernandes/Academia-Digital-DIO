package me.dio.academia.digital.service.impl;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaForm;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaUpdateForm;
import me.dio.academia.digital.repository.AlunoRepository;
import me.dio.academia.digital.repository.AvaliacaoFisicaRepository;
import me.dio.academia.digital.service.IAvaliacaoFisicaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class AvaliacaoFisicaServiceImpl implements IAvaliacaoFisicaService {

    @Autowired
    private AvaliacaoFisicaRepository avaliacaoFisicaRepository;
    @Autowired
    private AlunoRepository alunoRepository;

    public AvaliacaoFisica create(AvaliacaoFisicaForm form) {
        AvaliacaoFisica avaliacaoFisica = new AvaliacaoFisica();
        Aluno aluno = alunoRepository.findById(form.getAlunoId()).get();
        BeanUtils.copyProperties(form, avaliacaoFisica);
        avaliacaoFisica.setAluno(aluno);

        return avaliacaoFisicaRepository.save(avaliacaoFisica);
    }

    public Optional<AvaliacaoFisica> get(Long id) {
        return avaliacaoFisicaRepository.findById(id);
    }

    public List<AvaliacaoFisica> getAll() {
        return avaliacaoFisicaRepository.findAll();
    }

    public AvaliacaoFisica update(Long id, AvaliacaoFisicaUpdateForm formUpdate) {
        AvaliacaoFisica avaliacaoFisica = avaliacaoFisicaRepository.findById(id).get();
        BeanUtils.copyProperties(formUpdate,avaliacaoFisica);
        return avaliacaoFisicaRepository.save(avaliacaoFisica);
    }

    public void delete(Long id) {
        avaliacaoFisicaRepository.deleteById(id);

    }
}
