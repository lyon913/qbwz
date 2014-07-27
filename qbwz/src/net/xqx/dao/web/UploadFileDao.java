package net.xqx.dao.web;

import net.xqx.models.TUploadFiles;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface UploadFileDao extends JpaRepository<TUploadFiles, Long> {

	
		//查通过的记录
		@Query("select a from TUploadFiles a where a.flx.id=? and a.fIsShow=1")
		public Page<TUploadFiles> getUploadFiles(Long flx,Pageable pageable);
}
