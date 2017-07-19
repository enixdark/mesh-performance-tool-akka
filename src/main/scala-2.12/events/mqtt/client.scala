package events.mqtt

import org.eclipse.paho.client.mqttv3._
import java.net.URI
import java.util
import java.util.UUID

import akka.event.Logging
import akka.event.LoggingAdapter
import com.fasterxml.jackson.annotation.ObjectIdGenerators.UUIDGenerator


class Client(uri: String, topic: String, qos: Int = 0, log: LoggingAdapter) {
  var mqtt_client: MqttClient = null //MqttAsyncClient = null


  /**
    * call a connection to mqtt with sync
    * return Client's instance
    *
    */
  def connect(random_id: Boolean = false): Client = {
    val _uri = new URI(uri)
    val username = _uri.getUserInfo().split(":")(0)
    val password = _uri.getUserInfo().split(":")(1)
    val id = if (random_id == true) util.UUID.randomUUID.toString else username
    this.mqtt_client = new MqttClient(uri, id)
    val opts: MqttConnectOptions = new MqttConnectOptions()
    opts.setCleanSession(false)
    opts.setUserName(username)
    opts.setPassword(password.toCharArray)
//    this.mqtt_client.connect(opts, new IMqttActionListener() {
//
//      override def onFailure(asyncActionToken: IMqttToken, exception: Throwable): Unit = log.info("connect success")
//
//      override def onSuccess(asyncActionToken: IMqttToken): Unit = throw new Exception("cannot connnection to mqtt")
//    })
    this.mqtt_client.connect(opts)
    this
  }

  def on_subscribe(topic: String): Client = {
    if(!is_connected) throw new Exception("cannot connnection to mqtt")
    val _topic: String = if(topic != null) topic else this.topic
    this.mqtt_client.subscribeWithResponse(_topic, qos, (topic, message) => {
      this.log.info(message.toString)
    })
    this
  }

  def on_publish(topic: String, message: String): Client = {
    if(!is_connected) throw new Exception("cannot connnection to mqtt")
    log.info(message)
//    this.mqtt_client.publish(topic, new MqttMessage(message.getBytes()))
    this
  }

  def is_connected: Boolean = {
    if(this.mqtt_client == null || !this.mqtt_client.isConnected()) {
        false
      }
      else
        true
  }

}
