package pe.eu.idat.app_log_kafka_productor.controller;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/logs")
public class LogProducerController {

    private final KafkaTemplate<String, String> kafkaTemplate;

    public LogProducerController(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    @PostMapping
    public String sendLog(@RequestBody String message) {
        kafkaTemplate.send("logs_app", message);
        return "Log enviado: " + message;
    }
}
