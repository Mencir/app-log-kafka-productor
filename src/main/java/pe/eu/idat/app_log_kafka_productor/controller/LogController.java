package pe.eu.idat.app_log_kafka_productor.controller;



import org.springframework.web.bind.annotation.*;
import pe.eu.idat.app_log_kafka_productor.dto.LogDTO;
import pe.eu.idat.app_log_kafka_productor.service.LogProducerService;

@RestController
@RequestMapping("/api")
public class LogController {

    private final LogProducerService logProducerService;

    public LogController(LogProducerService logProducerService) {
        this.logProducerService = logProducerService;
    }

    @PostMapping("/log")
    public String sendLog(@RequestBody LogDTO log) {
        String mensaje = String.format("[%s] %s - %s",
                log.getNivel(), log.getOrigen(), log.getMensaje());
        logProducerService.sendMessage(mensaje);
        return "Log enviado a Kafka: " + mensaje;
    }
}