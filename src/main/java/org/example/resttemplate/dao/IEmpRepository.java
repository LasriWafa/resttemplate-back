package org.example.resttemplate.dao;


import org.example.resttemplate.model.Emp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
public interface IEmpRepository extends JpaRepository<Emp, Long> {
    List<Emp> findBySalaire(Double salary);
    List<Emp> findByFonction(String designation);
    List<Emp> findBySalaireAndFonction(Double salary, String fonction);
    List<Emp> findByFirstName(String name);
    @Query("SELECT e From Emp e where e.salaire=(select MAX(ee.salaire) as salaire FROM Emp ee)")
    Emp getEmpHavaingMaxSalary();
}