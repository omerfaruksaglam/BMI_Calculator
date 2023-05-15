/**
 * @author Ömer Faruk Sağlam
 * @date 12.05.2023
 * @description This class provides data access for bmi_details_view.
 */
package com.example.bmi_app.DataAccessLayer;

import com.example.bmi_app.Entity.ViewEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class ViewDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<ViewEntity> getBmiFromView(){
        return jdbcTemplate.query("select * from bmi_details_view", new ViewEntityRowMapper());
    }

    public class ViewEntityRowMapper implements RowMapper<ViewEntity> {
        @Override
        public ViewEntity mapRow(ResultSet rs, int rowNum) throws SQLException {
            ViewEntity entity = new ViewEntity();
            entity.setId(rs.getLong("id"));
            entity.setHeight(rs.getDouble("height"));
            entity.setWeight(rs.getDouble("weight"));
            return entity;
        }
    }
}
