package events.mqtt


case class MqttSubscribe(uri: String, topic: String, qos: Int)

case class MqttMessage(topic: String, message: String)
