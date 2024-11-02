package demos.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.serialization.StringSerializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Properties;

public class ProducerDemo {
    private static final Logger log = LoggerFactory.getLogger(ProducerDemo.class.getSimpleName());
    public static void main(String[] args) {
        log.info("hello");

        //Create Producer properties
        Properties properties = new Properties();

        //connect to LocalHost
        properties.setProperty("bootstrap.servers","127.0.0.1:9092");

        properties.setProperty("key.serializer", StringSerializer.class.getName());
        properties.setProperty("value.serializer",StringSerializer.class.getName());
        //Create the producer
        KafkaProducer<String,String> producer = new KafkaProducer<>(properties);

        //Create a producer Record ->
        ProducerRecord<String, String> producerRecord = new ProducerRecord<>("demo_java","hello world");
        //send data
        producer.send(producerRecord);

        //Send all data & block until done
        //flush and close the  producer
        producer.flush();
        producer.close();
    }
}
