package br.unisc.biblioteca.service;

import br.unisc.biblioteca.dto.BibliotecaDTO;
import br.unisc.biblioteca.persistence.BibliotecaPersistencia;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class BibliotecaService {

    private final BibliotecaPersistencia persistencia;

    public void create(BibliotecaDTO bibliotecaDTO) {
        persistencia.criar(bibliotecaDTO);
    }

    public Page<BibliotecaDTO> buscarBiblioteca(Pageable pageable) {
        return persistencia.buscarBiblioteca(pageable);
    }

    public void deleteBiblioteca(Long id) {
        persistencia.deleteBiblioteca(id);
    }

    public void updateBiblioteca(Long id, BibliotecaDTO bibliotecaDTO) {persistencia.updateBiblioteca(id, bibliotecaDTO);}

    public Object buscarPorId(Long id) {return persistencia.buscarPorId(id);}
}