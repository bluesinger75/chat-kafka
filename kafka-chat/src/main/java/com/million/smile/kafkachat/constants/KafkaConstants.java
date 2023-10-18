package com.million.smile.kafkachat.constants;

public class KafkaConstants {
    //토픽생성: kafka-topics --create --topic kafka-chat --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1
    //생성확인: kafka-topics --list --bootstrap-server localhost:9092
    public static final String KAFKA_TOPIC = "kafka-chat";
    /** consumer 를 식별할 수 있는 그룹 */
    public static final String GROUP_ID = "foo";
    /** kafka 클러스터에 연결하기 위한 호스트 */
    public static final String KAFKA_BROKER = "localhost:9092";
}
