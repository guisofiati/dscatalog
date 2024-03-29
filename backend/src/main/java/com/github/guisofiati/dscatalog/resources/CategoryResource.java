package com.github.guisofiati.dscatalog.resources;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.github.guisofiati.dscatalog.dto.CategoryDTO;
import com.github.guisofiati.dscatalog.services.CategoryService;

@RestController
@RequestMapping(value = "/categories") // rota rest 
public class CategoryResource {
	
	@Autowired
	private CategoryService service;
	
	@GetMapping
	public ResponseEntity<Page<CategoryDTO>> findAllPaged(Pageable pageable) {
		//Params: page, size, sort (sort=name,ASC/DESC)
		Page<CategoryDTO> listDto = service.findAllPaged(pageable);
		return ResponseEntity.ok().body(listDto); // returna list no corpo da res
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<CategoryDTO> findById(@PathVariable Long id) {
		CategoryDTO catDto = service.findById(id);
		return ResponseEntity.ok().body(catDto);
	}
	
	@PostMapping
	public ResponseEntity<CategoryDTO> insert(@RequestBody CategoryDTO dto) { // vai ser por json
		dto = service.insert(dto);
		
		// por boa pratica, um recurso criado retorna 201,
		// e é bom incluir tambem no header da resposta o path do novo recurso
		URI uri = ServletUriComponentsBuilder
				.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(dto.getId())
				.toUri();
		return ResponseEntity.created(uri).body(dto);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<CategoryDTO> update(@PathVariable Long id, @RequestBody CategoryDTO dto) {
		dto = service.update(id, dto);
		return ResponseEntity.ok().body(dto);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) { // como sera vazio pode usar um retorno Void
		service.delete(id);
		return ResponseEntity.noContent().build();
	}
}
