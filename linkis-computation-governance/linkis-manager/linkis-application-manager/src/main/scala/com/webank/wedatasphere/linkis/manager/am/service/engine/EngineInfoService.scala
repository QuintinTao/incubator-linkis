/*
 * Copyright 2019 WeBank
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.webank.wedatasphere.linkis.manager.am.service.engine

import com.webank.wedatasphere.linkis.governance.common.protocol.engineconn.{RequestEngineStatusBatch, ResponseEngineStatusBatch}
import com.webank.wedatasphere.linkis.manager.common.entity.node.{EMNode, EngineNode}

/**
 *
 */
trait EngineInfoService {
  /**
   * 通过user获取EngineNode 的基本信息，含metric
   *
   * @param user
   * @return
   */
  def listUserEngines(user: String): java.util.List[EngineNode]

  /**
   * 通过em（主要是instance信息） 获取engine的基本信息，含metric
   *
   * @param em
   * @return
   */
  def listEMEngines(em: EMNode): java.util.List[EngineNode]

  def dealBatchGetEngineStatus(request: RequestEngineStatusBatch): ResponseEngineStatusBatch = ResponseEngineStatusBatch(null, "Please implements method")
}
