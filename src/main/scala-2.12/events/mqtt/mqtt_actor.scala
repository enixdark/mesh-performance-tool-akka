import akka.actor.{Actor, ActorLogging}
import akka.event.Logging
import events.mqtt.Payload

class MqttActor extends Actor with ActorLogging {

  def receive: Receive = {
    case Payload(topic, message) =>
      log.info("test")
  }

}