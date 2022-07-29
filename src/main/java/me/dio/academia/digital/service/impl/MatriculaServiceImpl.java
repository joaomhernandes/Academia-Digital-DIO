package me.dio.academia.digital.service.impl;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import me.dio.academia.digital.entity.Matricula;
import me.dio.academia.digital.entity.form.MatriculaForm;
import me.dio.academia.digital.repository.MatriculaRepository;
import me.dio.academia.digital.service.IMatriculaService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@NoArgsConstructor
@AllArgsConstructor
public class MatriculaServiceImpl implements IMatriculaService {
    @Autowired
    private MatriculaRepository matriculaRepository;

    public Matricula create(MatriculaForm form) {
        Matricula matricula = new Matricula();
        BeanUtils.copyProperties(form,matricula);
        return matriculaRepository.save(matricula);
    }

    public Matricula get(Long id) {
        return matriculaRepository.getById(id);
    }

    public List<Matricula> getAll(String bairro) {
        if(bairro == null){
            return matriculaRepository.findAll();
        }else{
            return matriculaRepository.findByAlunoBairro(bairro);
        }
    }

    public void delete(Long id) {
        matriculaRepository.deleteById(id);

    }
}
