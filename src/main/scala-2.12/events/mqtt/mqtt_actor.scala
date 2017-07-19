import akka.actor.{Actor, ActorLogging}
import akka.event.Logging
import events.mqtt.{Client, MqttMessage, MqttSubscribe}

//class Argument(val uri: String) extends AnyVal

class MqttActor extends Actor with ActorLogging {

  def receive: Receive = {
    case MqttSubscribe(uri, topic, qos) =>
      val client = new Client(uri, topic, 0, log)
      client.connect(true)
      client.on_subscribe(topic)
    case MqttMessage(topic, message) => ???
  }

}