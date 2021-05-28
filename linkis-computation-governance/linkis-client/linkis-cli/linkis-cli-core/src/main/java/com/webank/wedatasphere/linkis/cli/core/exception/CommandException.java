/*
 * Copyright 2019 WeBank
 * Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * http://www.apache.org/licenses/LICENSE-2.0
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.webank.wedatasphere.linkis.cli.core.exception;

import com.webank.wedatasphere.linkis.cli.common.entity.command.CmdType;
import com.webank.wedatasphere.linkis.cli.common.exception.LinkisClientRuntimeException;
import com.webank.wedatasphere.linkis.cli.common.exception.error.ErrorLevel;
import com.webank.wedatasphere.linkis.cli.common.exception.error.ErrorMsg;

/**
 * @program: linkis-cli
 * @description:
 * @author: shangda
 * @create: 2020/11/10 20:01
 */
public class CommandException extends LinkisClientRuntimeException {
    private static final long serialVersionUID = 745261661L;
    private CmdType cmdType = null;

    public CommandException(String code, ErrorLevel level, ErrorMsg errMsg, String param[], String... extMsg) {
        super(code, level, errMsg, param, extMsg);
    }

    public CommandException(String code, ErrorLevel level, ErrorMsg errMsg, Object... paramsList) {
        super(code, level, errMsg, paramsList);
    }

    public CommandException(String code, ErrorLevel level, ErrorMsg errMsg, CmdType cmdType, String param[], String... extMsg) {
        super(code, level, errMsg, param, extMsg);
        this.cmdType = cmdType;
    }

    public CommandException(String code, ErrorLevel level, ErrorMsg errMsg, CmdType cmdType, Object... paramsList) {
        super(code, level, errMsg, paramsList);
        this.cmdType = cmdType;
    }

    public CmdType getCmdType() {
        return cmdType;
    }

    public boolean requireHelp() {
        return !(cmdType == null);
    }
}