package com.evaluacion.andrey.config;

import com.evaluacion.andrey.entity.Servicio;
import com.evaluacion.andrey.entity.Usuario;
import com.evaluacion.andrey.repository.ServicioRepository;
import com.evaluacion.andrey.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private ServicioRepository servicioRepository;
    
    @Autowired
    private UsuarioRepository usuarioRepository;

    @Override
    public void run(String... args) throws Exception {
        // Cargar servicios de consultoría tecnológica si no existen
        if (servicioRepository.count() == 0) {
            Servicio servicio1 = new Servicio();
            servicio1.setNombre("Arquitectura Cloud AWS/Azure");
            servicio1.setDescripcion("Diseño e implementación de infraestructura cloud escalable para startups. Incluye best practices de seguridad y costos.");
            servicio1.setDuracion("4 sesiones de 2 horas");
            servicio1.setPrecio(150.0);
            servicioRepository.save(servicio1);

            Servicio servicio2 = new Servicio();
            servicio2.setNombre("Seguridad de Aplicaciones");
            servicio2.setDescripcion("Auditoría completa de seguridad para aplicaciones web y móviles. Identificación de vulnerabilidades y plan de remediación.");
            servicio2.setDuracion("Evaluación completa + reporte");
            servicio2.setPrecio(200.0);
            servicioRepository.save(servicio2);

            Servicio servicio3 = new Servicio();
            servicio3.setNombre("Estrategia Mobile-First");
            servicio3.setDescripcion("Desarrollo de aplicaciones móviles nativas y estrategias cross-platform. UX/UI optimizado para engagement.");
            servicio3.setDuracion("3 sesiones de consultoría");
            servicio3.setPrecio(120.0);
            servicioRepository.save(servicio3);

            Servicio servicio4 = new Servicio();
            servicio4.setNombre("Data Analytics & BI");
            servicio4.setDescripcion("Implementación de soluciones de Business Intelligence y análisis de datos para toma de decisiones estratégicas.");
            servicio4.setDuracion("5 sesiones + dashboard");
            servicio4.setPrecio(180.0);
            servicioRepository.save(servicio4);

            System.out.println("✅ Servicios de consultoría tecnológica cargados en la base de datos");
        }
        
        // Cargar usuario demo si no existe
        if (usuarioRepository.count() == 0) {
            Usuario usuario = new Usuario();
            usuario.setNombre("Startup Tech Solutions");
            usuario.setEmail("contacto@startuptech.com");
            usuario.setPassword("demo123");
            usuario.setTelefono("+57 300 123 4567");
            usuarioRepository.save(usuario);

            Usuario usuario2 = new Usuario();
            usuario2.setNombre("Innovation Labs");
            usuario2.setEmail("hello@innovationlabs.co");
            usuario2.setPassword("demo123");
            usuario2.setTelefono("+57 310 987 6543");
            usuarioRepository.save(usuario2);

            System.out.println("✅ Usuarios demo cargados en la base de datos");
        }
    }
}