package webcrud.org.control;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import webcrud.org.model.service.PrestacaoContaService;

@ManagedBean(name = "prestacaoContaBean")
@ApplicationScoped
public class PrestacaoContaController {

	@Inject
	private PrestacaoContaService prestacaoContaService;


	public PrestacaoContaController() {

	}


}
