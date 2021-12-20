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
import java.time.YearMonth;

/**
 * Type Handler for {@link java.time.YearMonth}.
 * <p>
 * YearMonthTypeHandler relies upon
 * {@link java.time.YearMonth#parse YearMonth.parse}. Therefore column values
 * are expected as strings. The format must be uuuu-MM. Example: "2016-08"
 *
 * @since 3.4.5
 * @author Björn Raupach
 */
public class YearMonthTypeHandler extends BaseTypeHandler<YearMonth> {

  @Override
  public void setParameter(PreparedStatement ps, int i, Object parameter) throws SQLException {
    if(parameter == null)  ps.setNull(i, Types.VARCHAR);
    else ps.setString(i, parameter.toString());
  }

  @Override
  public YearMonth getNullableResult(ResultSet rs, String columnName) throws SQLException {
    String value = rs.getString(columnName);
    return value == null ? null : YearMonth.parse(value);
  }

  @Override
  public YearMonth getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
    String value = rs.getString(columnIndex);
    return value == null ? null : YearMonth.parse(value);
  }

  @Override
  public YearMonth getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
    String value = cs.getString(columnIndex);
    return value == null ? null : YearMonth.parse(value);
  }

}
