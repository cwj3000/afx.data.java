/*
 *    Copyright 2009-2021 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package com.afx.data.type;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.time.OffsetDateTime;

/**
 * @since 3.4.5
 * @author Tomas Rohovsky
 */
public class OffsetDateTimeTypeHandler extends BaseTypeHandler<OffsetDateTime> {

  @Override
  public void setParameter(PreparedStatement ps, int i, Object parameter)
          throws SQLException {
    if(parameter == null)  ps.setNull(i, Types.DATE);
    else ps.setObject(i, parameter);
  }

  @Override
  public OffsetDateTime getNullableResult(ResultSet rs, String columnName) throws SQLException {
    return rs.getObject(columnName, OffsetDateTime.class);
  }

  @Override
  public OffsetDateTime getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
    return rs.getObject(columnIndex, OffsetDateTime.class);
  }

  @Override
  public OffsetDateTime getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
    return cs.getObject(columnIndex, OffsetDateTime.class);
  }

}
