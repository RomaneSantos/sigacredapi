package com.siga.cred.sigacredapi.carga;

import com.siga.cred.sigacredapi.model.*;
import com.siga.cred.sigacredapi.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

@Component
public class RepositoryTest implements ApplicationRunner{

    private static final int ID_ESTADO1 = 1;
	private static final int ID_ESTADO2 = 2;
	
	private static final int ID_CIDADE1 = 100;
	private static final int ID_CIDADE2 = 101;
    private static final int ID_CIDADE3 = 102;

    private static final Long ID_STATUS1 = 10l;
    private static final Long ID_STATUS2 = 11l;

    private static final int ID_MARCA1 = 200;
	private static final int ID_MARCA2 = 201;

    private static final int ID_TIPO1 = 300;
	private static final int ID_TIPO2 = 301;

    private static final Long ID_PROBLEMA1 = 20l;
    private static final Long ID_PROBLEMA2 = 21l;

    @Autowired
    private EstadoRepository estadoRepository;

    @Autowired
    private CidadeRepository cidadeRepository;

    @Autowired
    private StatusRepository statusRepository;

    @Autowired
    private MarcaRepository marcaRepository;

    @Autowired
    private TipoRepository tipoRepository;

    @Autowired
    private ProblemaRepository problemaRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(">> Iniciando cargas de dados...");

        Estado to = new Estado(ID_ESTADO1, "Tocantins", "TO");
        Estado pr = new Estado(ID_ESTADO2, "Paraná", "PR");

        Cidade palmas = new Cidade(ID_CIDADE1, "Palmas", to);
        Cidade xambioa = new Cidade(ID_CIDADE2, "Xambioá", to);
        Cidade curitiba = new Cidade(ID_CIDADE3, "Curitiba", pr);

        Status status1 = new Status(ID_STATUS1, "Finalizado");
        Status status2 = new Status(ID_STATUS2, "Pendente");

        Marca marca1 = new Marca(ID_MARCA1, "Positivo");
        Marca marca2 = new Marca(ID_MARCA2, "Multilaser");

        Tipo tipo1 = new Tipo(ID_TIPO1, "Notebook");
        Tipo tipo2 = new Tipo(ID_TIPO2, "Smartphone");

        Problema problema1 = new Problema(ID_PROBLEMA1, "Aparelho não inicializa");
        Problema problema2 = new Problema(ID_PROBLEMA2, "Aparelho não reproduz som");

        System.out.println("Pesistindo dados primarios...");
        estadoRepository.save(to);
        estadoRepository.save(pr);
        cidadeRepository.save(palmas);
        cidadeRepository.save(xambioa);
        cidadeRepository.save(curitiba);
        statusRepository.save(status1);
        statusRepository.save(status2);
        marcaRepository.save(marca1);
        marcaRepository.save(marca2);
        tipoRepository.save(tipo1);
        tipoRepository.save(tipo2);
        problemaRepository.save(problema1);
        problemaRepository.save(problema2);

        System.out.println("Dados Gravados...");
    }
    
}
