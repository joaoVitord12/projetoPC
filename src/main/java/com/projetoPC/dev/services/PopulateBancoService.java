package com.projetoPC.dev.services;

import com.projetoPC.dev.dtos.*;
import com.projetoPC.dev.enums.Modelo;
import com.projetoPC.dev.models.SocketCPU;
import com.projetoPC.dev.repositories.SocketCpuRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@DependsOn({"usuarioService", "socketCpuService", "memoriaRamService", "gpuService", "cpuService", "gpuService", "placaMaeService", "fonteService"})
public class PopulateBancoService {

    @Autowired
    private SocketCpuRepository socketCpuRepositry;

    @Autowired
    private FonteService fonteService;

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private SocketCpuService socketCpuService;

    @Autowired
    private MemoriaRamService memoriaRamService;

    @Autowired
    private GpuService gpuService;

    @Autowired
    private CpuService cpuService;

    @Autowired
    private PlacaMaeService placaMaeService;

    @PostConstruct
    public void initializeDatabase() {
        populateUsuarios();
        populateSocketCpu();
        populateMemoriaRam();
        populateGpu();
        populatePlacaMae();
        populateCpu();
        populateFonte();
    }

    private void populateUsuarios() {
        try {
            if (usuarioService.listarUsuarios().isEmpty()) {
                UsuarioDTO usuario = new UsuarioDTO(null, "João Silva", "joao.silva@email.com", "senha123");
                usuarioService.cadastrarUsuario(usuario);

                UsuarioDTO usuario2 = new UsuarioDTO(null, "Maria Oliveira", "maria.oliveira@email.com", "segredo456");
                usuarioService.cadastrarUsuario(usuario2);

                UsuarioDTO usuario3 = new UsuarioDTO(null, "Carlos Santos", "carlos.santos@email.com", "minhasenha789");
                usuarioService.cadastrarUsuario(usuario3);

                UsuarioDTO usuario4 = new UsuarioDTO(null, "Ana Souza", "ana.souza@email.com", "pass987");
                usuarioService.cadastrarUsuario(usuario4);

                UsuarioDTO usuario5 = new UsuarioDTO(null, "Pedro Ferreira", "pedro.ferreira@email.com", "qwerty123");
                usuarioService.cadastrarUsuario(usuario5);

                UsuarioDTO usuario6 = new UsuarioDTO(null, "Juliana Mendes", "juliana.mendes@email.com", "abc12345");
                usuarioService.cadastrarUsuario(usuario6);

                UsuarioDTO usuario7 = new UsuarioDTO(null, "Marcos Lima", "marcos.lima@email.com", "senha321");
                usuarioService.cadastrarUsuario(usuario7);

                UsuarioDTO usuario8 = new UsuarioDTO(null, "Tatiane Rocha", "tatiane.rocha@email.com", "meusegredo");
                usuarioService.cadastrarUsuario(usuario8);

                UsuarioDTO usuario9 = new UsuarioDTO(null, "Rafael Costa", "rafael.costa@email.com", "c0mpl3xP@ss");
                usuarioService.cadastrarUsuario(usuario9);

                UsuarioDTO usuario10 = new UsuarioDTO(null, "Fernanda Almeida", "fernanda.almeida@email.com", "simplepass");
                usuarioService.cadastrarUsuario(usuario10);

                UsuarioDTO usuario11 = new UsuarioDTO(null, "Rodrigo Nogueira", "rodrigo.nogueira@email.com", "r0dr1g0@senha");
                usuarioService.cadastrarUsuario(usuario11);

                UsuarioDTO usuario12 = new UsuarioDTO(null, "Beatriz Martins", "beatriz.martins@email.com", "b3@pass");
                usuarioService.cadastrarUsuario(usuario12);

                UsuarioDTO usuario13 = new UsuarioDTO(null, "Daniel Teixeira", "daniel.teixeira@email.com", "d4n13l");
                usuarioService.cadastrarUsuario(usuario13);

                UsuarioDTO usuario14 = new UsuarioDTO(null, "Camila Castro", "camila.castro@email.com", "senhaSegura");
                usuarioService.cadastrarUsuario(usuario14);

                UsuarioDTO usuario15 = new UsuarioDTO(null, "Lucas Ribeiro", "lucas.ribeiro@email.com", "luc@s123");
                usuarioService.cadastrarUsuario(usuario15);

                UsuarioDTO usuario16 = new UsuarioDTO(null, "Larissa Barbosa", "larissa.barbosa@email.com", "lar1ss@pass");
                usuarioService.cadastrarUsuario(usuario16);

                UsuarioDTO usuario17 = new UsuarioDTO(null, "Vinícius Azevedo", "vinicius.azevedo@email.com", "vini_senha");
                usuarioService.cadastrarUsuario(usuario17);

                UsuarioDTO usuario18 = new UsuarioDTO(null, "Gabriela Fernandes", "gabriela.fernandes@email.com", "gabriela321");
                usuarioService.cadastrarUsuario(usuario18);

                UsuarioDTO usuario19 = new UsuarioDTO(null, "Eduardo Lima", "eduardo.lima@email.com", "edu@senha");
                usuarioService.cadastrarUsuario(usuario19);

                UsuarioDTO usuario20 = new UsuarioDTO(null, "Patrícia Duarte", "patricia.duarte@email.com", "paty_123");
                usuarioService.cadastrarUsuario(usuario20);

                UsuarioDTO usuario21 = new UsuarioDTO(null, "Fábio Monteiro", "fabio.monteiro@email.com", "fab!0_#@");
                usuarioService.cadastrarUsuario(usuario21);

                UsuarioDTO usuario22 = new UsuarioDTO(null, "Sabrina Lopes", "sabrina.lopes@email.com", "sabri321");
                usuarioService.cadastrarUsuario(usuario22);

                UsuarioDTO usuario23 = new UsuarioDTO(null, "Hugo Menezes", "hugo.menezes@email.com", "hugo987");
                usuarioService.cadastrarUsuario(usuario23);

                UsuarioDTO usuario24 = new UsuarioDTO(null, "Amanda Xavier", "amanda.xavier@email.com", "amandinha");
                usuarioService.cadastrarUsuario(usuario24);

                UsuarioDTO usuario25 = new UsuarioDTO(null, "Leonardo Peixoto", "leonardo.peixoto@email.com", "leo@pass");
                usuarioService.cadastrarUsuario(usuario25);

                UsuarioDTO usuario26 = new UsuarioDTO(null, "Vanessa Cardoso", "vanessa.cardoso@email.com", "van123");
                usuarioService.cadastrarUsuario(usuario26);

                UsuarioDTO usuario27 = new UsuarioDTO(null, "Thiago Rezende", "thiago.rezende@email.com", "thigo_rz");
                usuarioService.cadastrarUsuario(usuario27);

                UsuarioDTO usuario28 = new UsuarioDTO(null, "Mariana Duarte", "mariana.duarte@email.com", "mariduart3");
                usuarioService.cadastrarUsuario(usuario28);

                UsuarioDTO usuario29 = new UsuarioDTO(null, "Rafael Gomes", "rafael.gomes@email.com", "rafagomes");
                usuarioService.cadastrarUsuario(usuario29);

                UsuarioDTO usuario30 = new UsuarioDTO(null, "Carolina Silva", "carolina.silva@email.com", "carol_senha");
                usuarioService.cadastrarUsuario(usuario30);

                System.out.println("✅ Usuários populados com sucesso!");
            } else {
                System.out.println("⚠️ Usuários já populados.");
            }
        } catch (Exception e) {
            System.err.println("Erro ao popular usuários: " + e.getMessage());
        }
    }

    private void populateSocketCpu() {
        try {
            if (socketCpuService.listarSocketCpus().isEmpty()) {
                SocketCpuDTO socket1 = new SocketCpuDTO(null, "LGA 1700", "Socket para processadores Intel de 12ª e 13ª geração");
                socketCpuService.cadastrarSocketCpu(socket1);

                SocketCpuDTO socket2 = new SocketCpuDTO(null, "AM4", "Socket para processadores AMD Ryzen da série 1000 até 5000");
                socketCpuService.cadastrarSocketCpu(socket2);

                SocketCpuDTO socket3 = new SocketCpuDTO(null, "LGA 1200", "Socket para processadores Intel de 10ª e 11ª geração");
                socketCpuService.cadastrarSocketCpu(socket3);

                SocketCpuDTO socket4 = new SocketCpuDTO(null, "AM5", "Novo socket para processadores AMD mais recentes");
                socketCpuService.cadastrarSocketCpu(socket4);

                System.out.println("✅ SocketCPU populados com sucesso!");
            } else {
                System.out.println("⚠️ SocketCPU já populados.");
            }
        } catch (Exception e) {
            System.err.println("Erro ao popular SocketCPU: " + e.getMessage());
        }
    }

    private void populateMemoriaRam() {
        try {
            if (memoriaRamService.listarMemoriaRams().isEmpty()) {
                MemoriaRamDTO mem1 = new MemoriaRamDTO(null, "HyperX Fury", new BigDecimal("299.90"), "Kingston", 8, 3200, "DDR4");
                memoriaRamService.cadastrarMemoriaRam(mem1);

                MemoriaRamDTO mem2 = new MemoriaRamDTO(null, "Corsair Vengeance LPX", new BigDecimal("350.00"), "Corsair", 16, 3600, "DDR4");
                memoriaRamService.cadastrarMemoriaRam(mem2);

                MemoriaRamDTO mem3 = new MemoriaRamDTO(null, "Crucial Ballistix", new BigDecimal("280.50"), "Crucial", 8, 3000, "DDR4");
                memoriaRamService.cadastrarMemoriaRam(mem3);

                MemoriaRamDTO mem4 = new MemoriaRamDTO(null, "G.Skill Trident Z RGB", new BigDecimal("450.75"), "G.Skill", 16, 4000, "DDR4");
                memoriaRamService.cadastrarMemoriaRam(mem4);

                System.out.println("✅ Memórias RAM populadas com sucesso!");
            } else {
                System.out.println("⚠️ Memórias RAM já populadas.");
            }
        } catch (Exception e) {
            System.err.println("Erro ao popular Memórias RAM: " + e.getMessage());
        }
    }

    private void populateGpu() {
        try {
            if (gpuService.listarGpus().isEmpty()) {
                GpuDTO gpu1 = new GpuDTO(null, "NVIDIA GeForce RTX 3060", new BigDecimal("2499.99"), new BigDecimal("170"), "NVIDIA", 12, "PCIe 4.0", "GDDR6");
                gpuService.cadastrarGpu(gpu1);

                GpuDTO gpu2 = new GpuDTO(null, "AMD Radeon RX 6700 XT", new BigDecimal("2799.99"), new BigDecimal("230"), "AMD", 12, "PCIe 4.0", "GDDR6");
                gpuService.cadastrarGpu(gpu2);

                GpuDTO gpu3 = new GpuDTO(null, "NVIDIA GeForce RTX 4070", new BigDecimal("3499.99"), new BigDecimal("200"), "NVIDIA", 12, "PCIe 4.0", "GDDR6X");
                gpuService.cadastrarGpu(gpu3);

                GpuDTO gpu4 = new GpuDTO(null, "AMD Radeon RX 7900 XTX", new BigDecimal("5999.99"), new BigDecimal("350"), "AMD", 24, "PCIe 4.0", "GDDR6");
                gpuService.cadastrarGpu(gpu4);

                GpuDTO gpu5 = new GpuDTO(null, "NVIDIA GeForce RTX 4080", new BigDecimal("6499.99"), new BigDecimal("320"), "NVIDIA", 16, "PCIe 4.0", "GDDR6X");
                gpuService.cadastrarGpu(gpu5);

                GpuDTO gpu6 = new GpuDTO(null, "Intel Arc A770", new BigDecimal("2099.99"), new BigDecimal("225"), "Intel", 16, "PCIe 4.0", "GDDR6");
                gpuService.cadastrarGpu(gpu6);

                System.out.println("✅ GPUs populadas com sucesso!");
            } else {
                System.out.println("⚠️ GPUs já populadas.");
            }
        } catch (Exception e) {
            System.err.println("Erro ao popular GPUs: " + e.getMessage());
        }
    }

    private void populatePlacaMae() {
        try {
            if (placaMaeService.listarPlacaMaes().isEmpty()) {
                Optional<SocketCPU> socketOpt = socketCpuRepositry.findById(1L);
                if (socketOpt.isPresent()) {
                    SocketCpuDTO socketCpuDTO = socketCpuService.convertToDTO(socketOpt.get());

                    List<Modelo> modelos1 = List.of(Modelo.ATX);
                    PlacaMaeDTO placaMae1 = new PlacaMaeDTO(null, "Placa Mãe ASUS ROG", new BigDecimal("1500.00"), "ASUS", "Z690", 4, 128, "DDR4", new BigDecimal("60"), modelos1, socketCpuDTO);
                    placaMaeService.cadastrarPlacaMae(placaMae1);

                    List<Modelo> modelos2 = List.of(Modelo.MICRO_ATX);
                    PlacaMaeDTO placaMae2 = new PlacaMaeDTO(null, "Placa Mãe Gigabyte Ultra", new BigDecimal("1800.00"), "Gigabyte", "B550", 2, 64, "DDR4", new BigDecimal("50"), modelos2, socketCpuDTO);
                    placaMaeService.cadastrarPlacaMae(placaMae2);

                    System.out.println("✅ Placas Mãe populadas com sucesso!");
                } else {
                    System.out.println("⚠️ SocketCPU com id 1 não encontrado. Não foi possível popular Placas Mãe.");
                }
            } else {
                System.out.println("⚠️ Placas Mãe já populadas.");
            }
        } catch (Exception e) {
            System.err.println("Erro ao popular Placas Mãe: " + e.getMessage());
        }
    }
    private void populateCpu() {
        try {
            if (cpuService.listarCpus().isEmpty()) {
                // Busca o SocketCPU com id 1 para associar às CPUs
                Optional<SocketCPU> socketOpt = socketCpuRepositry.findById(1L);
                if (socketOpt.isPresent()) {
                    SocketCpuDTO socketCpuDTO = socketCpuService.convertToDTO(socketOpt.get());

                    CpuDTO cpu1 = new CpuDTO(
                            null,
                            "Intel Core i5-12400",
                            new BigDecimal("1200.00"),
                            new BigDecimal("65"),
                            "Intel",
                            socketCpuDTO,
                            6,
                            12
                    );
                    cpuService.cadastrarCpu(cpu1);

                    CpuDTO cpu2 = new CpuDTO(
                            null,
                            "AMD Ryzen 5 5600X",
                            new BigDecimal("1100.00"),
                            new BigDecimal("65"),
                            "AMD",
                            socketCpuDTO,
                            6,
                            12
                    );
                    cpuService.cadastrarCpu(cpu2);

                    CpuDTO cpu3 = new CpuDTO(
                            null,
                            "Intel Core i7-12700K",
                            new BigDecimal("2200.00"),
                            new BigDecimal("125"),
                            "Intel",
                            socketCpuDTO,
                            12,
                            20
                    );
                    cpuService.cadastrarCpu(cpu3);

                    System.out.println("✅ CPUs populadas com sucesso!");
                } else {
                    System.out.println("⚠️ SocketCPU com id 1 não encontrado. Não foi possível popular CPUs.");
                }
            } else {
                System.out.println("⚠️ CPUs já populadas.");
            }
        } catch (Exception e) {
            System.err.println("Erro ao popular CPUs: " + e.getMessage());
        }
    }
    private void populateFonte() {
        try {
            if (fonteService.listarFontes().isEmpty()) {
                FonteDTO fonte1 = FonteDTO.builder()
                        .id(null)
                        .preco(new BigDecimal("450.00"))
                        .fabricante("Corsair")
                        .potencia(650)
                        .efficiencyRating(80)
                        .build();
                fonteService.cadastrarFonte(fonte1);

                FonteDTO fonte2 = FonteDTO.builder()
                        .id(null)
                        .preco(new BigDecimal("500.00"))
                        .fabricante("EVGA")
                        .potencia(750)
                        .efficiencyRating(80)
                        .build();
                fonteService.cadastrarFonte(fonte2);

                FonteDTO fonte3 = FonteDTO.builder()
                        .id(null)
                        .preco(new BigDecimal("400.00"))
                        .fabricante("Seasonic")
                        .potencia(600)
                        .efficiencyRating(80)
                        .build();
                fonteService.cadastrarFonte(fonte3);

                System.out.println("✅ Fontes populadas com sucesso!");
            } else {
                System.out.println("⚠️ Fontes já populadas.");
            }
        } catch (Exception e) {
            System.err.println("Erro ao popular Fontes: " + e.getMessage());
        }
    }

}


