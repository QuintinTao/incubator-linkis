/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.linkis.rpc

import org.apache.linkis.protocol.message.RequestProtocol
import org.apache.linkis.rpc.message.method.{MessageExecutor, ReceiverMethodSearcher}

import scala.concurrent.duration.Duration
import scala.language.implicitConversions

class MessageReceiver extends Receiver {

  private val receiverMethodSearcher = new ReceiverMethodSearcher

  private val messageExecutor = new MessageExecutor

  override def receive(message: Any, sender: Sender): Unit = {
    receiveAndReply(message, sender)
  }

  override def receiveAndReply(message: Any, sender: Sender): Any = {
    message match {
      case requestProtocol: RequestProtocol => {
        val methodExecuteWrapper =
          receiverMethodSearcher.getMethodExecuteWrappers(requestProtocol)
        messageExecutor.execute(requestProtocol, methodExecuteWrapper, sender)
      }
      case _ =>
    }
  }

  // TODO
  override def receiveAndReply(message: Any, duration: Duration, sender: Sender): Any = {}

}
