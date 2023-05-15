/**
 * @author Ömer Faruk Sağlam
 * @date 12.05.2023
 * @description This class is used to perform database operations.
 */
package com.example.bmi_app.DataAccessLayer;

import com.example.bmi_app.Entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Integer> {
}
