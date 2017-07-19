import akka.actor.{ActorSystem, Props}
import events.mqtt.{Client, MqttMessage, MqttSubscribe}
import akka.event.{Logging, LoggingAdapter}
import akka.routing.FromConfig
import com.typesafe.config.ConfigFactory

object Main {
  def main(args: Array[String]) {
		val system = ActorSystem("meshblu-actor", ConfigFactory.load.getConfig("akka"))
		val log: LoggingAdapter = Logging.getLogger(system, this)
		log.info("Meshblu performance tools scala")
//		val client = new Client("tcp://acd25fe2-1d14-4274-992c-8ae4a7ccf076:3b28cfa03b063c1179de6a32694c05f95af35dee@localhost:1883","message", 0, log)
//		client.connect
//		client.on_subscribe("acd25fe2-1d14-4274-992c-8ae4a7ccf076")
			for (i <- 1 to 3000) {
			val actor = system.actorOf(Props[MqttActor].withRouter(FromConfig()))
			actor ! MqttSubscribe("tcp://acd25fe2-1d14-4274-992c-8ae4a7ccf076:3b28cfa03b063c1179de6a32694c05f95af35dee@localhost:1883","acd25fe2-1d14-4274-992c-8ae4a7ccf076", 0)
		}



//		client.on_publish("cd25fe2-1d14-4274-992c-8ae4a7ccf076",
//			scala.util.parsing.json.JSONObject(Map("hello" -> "world")).toString
//		)
	}
}