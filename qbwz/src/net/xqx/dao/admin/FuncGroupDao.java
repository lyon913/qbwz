package net.xqx.dao.admin;

import net.xqx.models.TFuncGroup;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FuncGroupDao extends JpaRepository<TFuncGroup, Long>{

}
